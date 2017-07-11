package com.spacetrue.tech.captcha.web.control;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import com.spacetrue.tech.captcha.web.common.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Shaw on 2017/7/11.
 */
@Controller
public class PaymentController {


    //TODO
    @RequestMapping(value="/payment/toAlipay")
    public String toAlipay() throws UnsupportedEncodingException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl
                , AlipayConfig.app_id
                , AlipayConfig.merchant_private_key
                , "json"
                , AlipayConfig.charset
                , AlipayConfig.alipay_public_key
                , AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String("a".getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String("a".getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String("a".getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        String body = new String("a".getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return null;
    }
}
