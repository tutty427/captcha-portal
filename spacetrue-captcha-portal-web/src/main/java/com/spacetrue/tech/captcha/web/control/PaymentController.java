package com.spacetrue.tech.captcha.web.control;


import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.spacetrue.tech.captcha.service.common.AlipayStatusEnum;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.core.OrderService;
import com.spacetrue.tech.captcha.service.core.ThirdPaymentService;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import com.spacetrue.tech.captcha.service.entity.OrderDTO;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Shaw on 2017/7/11.
 */
@Controller
public class PaymentController extends BaseController{

    private final static Logger LOG = Logger.getLogger(PaymentController.class);

    @Autowired
    private ThirdPaymentService thirdPaymentService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    private final static String ITEM_TO_PAY = "itemToPay";

    @RequestMapping(value="/payment/toAlipay")
    public ModelAndView toAlipay(ModelMap model, HttpServletRequest request, String itemId) throws UnsupportedEncodingException {

        ModelAndView mav = new ModelAndView();
        mav.setViewName(LayoutNames.userCenterLayoutPage.name());
        if(Strings.isNullOrEmpty(itemId)){
            LOG.error("ItemId is empty with userId => "+request.getSession().getAttribute(USER_NAME_KEY));
            return mav;
        }
        ItemDTO dto = itemService.getItemById(Integer.valueOf(itemId));
        if(dto == null){
            LOG.error("Item ["+itemId+"] doesn't existed with userId => "+request.getSession().getAttribute(USER_NAME_KEY));
            return mav;
        }


        //创建订单
        OrderDTO order = new OrderDTO();
        order.setItemId(Integer.valueOf(itemId));
        order.setOrderPrice(dto.getItemPrice());
        order.setPayWay(1);    //1 alipay  2 wechatpay 目前仅支持alipay
        order.setStatus(AlipayStatusEnum.WAIT_BUYER_PAY.code());
        order.setUserId((String)request.getSession().getAttribute(USER_NAME_KEY));
        orderService.createOrder(order);


        mav.addObject(ITEM_TO_PAY, StringEscapeUtils.escapeHtml(JSONObject.toJSONString(order)));
        mav.setViewName(LayoutNames.thirdPartyPayPage.name());



        return mav;
    }

    @RequestMapping(value="/payment/getPageContent",produces="text/html;charset=UTF-8")
    public @ResponseBody String getPageContent(ModelMap model, HttpServletRequest request,@RequestParam String itemDTO) throws UnsupportedEncodingException {

        String result = null;
        if(Strings.isNullOrEmpty(itemDTO)){
            LOG.error("itemDTO is empty with userId => "+request.getSession().getAttribute(USER_NAME_KEY));
            return result;
        }
        OrderDTO dto = JSONObject.parseObject(StringEscapeUtils.unescapeHtml(itemDTO),OrderDTO.class);
        ItemDTO item = itemService.getItemById(dto.getItemId());
        result = thirdPaymentService.generateAlipayPageInfo(dto.getId(),"0.01",item.getItemName(),item.getItemDescribe());
        return result;
    }



}
