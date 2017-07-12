package com.spacetrue.tech.captcha.service.core;

import com.alipay.api.AlipayApiException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Shaw on 2017/7/12.
 */
public interface PaymentService {


    public boolean checkSign(Map<String,String[]> params);

    public String generateAlipayPageInfo(Integer orderId,String amount,String subject,String itemDescribe);

    public boolean processReturnCall();

    public boolean processNotifyCall();
}
