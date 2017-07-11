package com.spacetrue.tech.captcha.web.vo;

import com.spacetrue.tech.captcha.service.entity.OrderDTO;

import java.util.List;

/**
 * Created by Shaw on 2017/7/11.
 */
public class PaymentRecordVO extends BaseUserCenterVO {

    private List<OrderDTO> orders;

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
