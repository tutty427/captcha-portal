package com.spacetrue.tech.captcha.web.restapi;

import com.spacetrue.tech.captcha.service.common.AlipayStatusEnum;
import com.spacetrue.tech.captcha.service.core.OrderService;
import com.spacetrue.tech.captcha.service.core.ThirdPaymentService;
import com.spacetrue.tech.captcha.service.core.UserService;
import com.spacetrue.tech.captcha.service.entity.UserDTO;
import com.spacetrue.tech.captcha.web.common.Constants;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Created by Shaw on 2017/7/11.
 */
@Controller
public class CommonApi {

    private final static Logger LOG = Logger.getLogger(CommonApi.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ThirdPaymentService thirdPaymentService;

    private final static String SIGN_STATUS = "signStatus";

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/api/randomAccount/{account}", produces="application/json;charset=UTF-8")
    public @ResponseBody UserDTO randomAccount(@PathVariable("account") String account ){

        return userService.getRandomAccount(account);
    }


    @RequestMapping(value = "/api/alipayReturnCallBack")
    public String alipayReturnCallBack(ModelMap model, HttpServletRequest request){
        Map<String,String[]> requestParams = request.getParameterMap();
        boolean signVerify = thirdPaymentService.checkSign(requestParams);
        model.addAttribute(SIGN_STATUS,signVerify);

        if(signVerify){
            try {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


        }

        model.addAttribute(Constants.PAGE_NAME, "paymentrecord");
        return LayoutNames.userCenterLayoutPage.name();
    }


    @RequestMapping(value = "/api/alipayNotifyCallBack")
    public @ResponseBody String alipayNotifyCallBack(ModelMap model,HttpServletRequest request ){
        Map<String,String[]> requestParams = request.getParameterMap();
        boolean signVerify = thirdPaymentService.checkSign(requestParams);
        model.addAttribute(SIGN_STATUS,signVerify);
        if(signVerify){
            try {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

                String pay_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");


                LOG.info("alipayNotifyCallBack orderId: "+out_trade_no
                        +"|trade_no: "+trade_no+"|total_amount: "+total_amount+"|pay_status: "+pay_status);
                orderService.updateOrderStatus(Integer.valueOf(out_trade_no), AlipayStatusEnum.getCodeByName(pay_status));
                thirdPaymentService.processNotifyCall(Integer.valueOf(out_trade_no),trade_no);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "failure";
            }
        }


        return "success";
    }

}
