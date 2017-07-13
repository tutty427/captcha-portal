package com.spacetrue.tech.captcha.service.core;

import java.util.Map;

/**
 * Created by Shaw on 2017/7/12.
 */
public interface ThirdPaymentService {

    public boolean checkSign(Map<String,String[]> params);

    public String generateAlipayPageInfo(Integer orderId,String amount,String subject,String itemDescribe);

    public boolean processReturnCall();

    public boolean processNotifyCall(Integer orderId, String userId, Integer itemId,String outTradeId );
}
