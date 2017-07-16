package com.spacetrue.tech.captcha.service.core;

import java.util.Map;

/**
 * Created by Shaw on 2017/7/9.
 */
public interface ItemDeliveryService {

    Map<String,Long> countBalance(String userId);

    void deliveryItemByOrder(Integer orderId);


}
