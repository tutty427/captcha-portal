package com.spacetrue.tech.captcha.web.control;


import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.core.PaymentService;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import com.spacetrue.tech.captcha.web.common.Constants;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by Shaw on 2017/7/11.
 */
@Controller
public class PaymentController extends BaseController{

    private final static Logger LOG = Logger.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ItemService itemService;

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
        mav.addObject(ITEM_TO_PAY, JSONObject.toJSONString(dto));
        mav.setViewName(LayoutNames.thirdPartyPayPage.name());
        return mav;
    }

    @RequestMapping(value="/payment/getPageContent",consumes = "application/json;charset=UTF-8",produces="text/html;charset=UTF-8")
    public @ResponseBody String getPageContent(ModelMap model, HttpServletRequest request,String itemDTO) throws UnsupportedEncodingException {

        String result = null;
        if(Strings.isNullOrEmpty(itemDTO)){
            LOG.error("itemDTO is empty with userId => "+request.getSession().getAttribute(USER_NAME_KEY));
            return result;
        }
        ItemDTO dto = (ItemDTO) JSONObject.parse(itemDTO);
        result = paymentService.generateAlipayPageInfo(dto.getId(),"0.01",dto.getItemName(),dto.getItemDescribe());
        return result;
    }
}
