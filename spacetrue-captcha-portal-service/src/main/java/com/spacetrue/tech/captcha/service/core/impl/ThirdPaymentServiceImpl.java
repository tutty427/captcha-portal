package com.spacetrue.tech.captcha.service.core.impl;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.spacetrue.tech.captcha.service.common.AlipayConfig;
import com.spacetrue.tech.captcha.service.core.ThirdPaymentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Shaw on 2017/7/12.
 */
@Service
public class ThirdPaymentServiceImpl implements ThirdPaymentService {

    private final static Logger LOG = Logger.getLogger(ThirdPaymentServiceImpl.class);


    @Override
    public boolean checkSign(Map<String, String[]> requestParams)  {

        boolean result = false;
        try {
            Map<String, String> params = new HashMap<String, String>();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        }catch(UnsupportedEncodingException e){
            LOG.error("Fail to get bytes",e);
        }catch(AlipayApiException e){
            LOG.error("Fail to verify sign",e);
        }
        return result;
    }

    @Override
    public String generateAlipayPageInfo(Integer orderId, String amount, String subject, String itemDescribe) {

        String result = null;

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        try{
            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = new String((orderId.toString()).getBytes("ISO-8859-1"),"UTF-8");
            //付款金额，必填
            String total_amount = new String(amount.getBytes("ISO-8859-1"),"UTF-8");
            //订单名称，必填
            String itemSubject = new String(subject.getBytes("ISO-8859-1"),"UTF-8");
            //商品描述，可空
            String body = new String(itemDescribe.getBytes("ISO-8859-1"),"UTF-8");

            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ itemSubject +"\","
                    + "\"body\":\""+ body +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //请求
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            LOG.error("Fail to pageExecute",e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("Fail to get bytes",e);
        }


        return result;
    }

    @Override
    public boolean processReturnCall() {
        return false;
    }

    @Override
    public boolean processNotifyCall() {
        return false;
    }
}
