package com.spacetrue.tech.captcha.service.core.impl;

import com.spacetrue.tech.captcha.service.core.OrderService;
import com.spacetrue.tech.captcha.service.entity.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * Created by Shaw on 2017/7/13.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        return null;
    }

    @Override
    public OrderDTO updateOrderStatus(Integer orderId, Integer status) {
        return null;
    }

    @Override
    public OrderDTO getOrderByID(Integer orderId) {
        return null;
    }
}
