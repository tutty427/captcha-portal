package com.spacetrue.tech.captcha.service.core;

import com.spacetrue.tech.captcha.service.entity.OrderDTO;

/**
 * Created by Shaw on 2017/7/9.
 */
public interface OrderService {

    public OrderDTO createOrder(OrderDTO dto);

    public OrderDTO updateOrderStatus(Integer orderId,Integer status);

    public OrderDTO getOrderByID(Integer orderId);
}
