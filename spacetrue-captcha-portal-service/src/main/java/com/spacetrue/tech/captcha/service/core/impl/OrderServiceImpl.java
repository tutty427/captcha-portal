package com.spacetrue.tech.captcha.service.core.impl;

import com.spacetrue.tech.captcha.biz.mapper.db.captcha.OrderRecordMapper;
import com.spacetrue.tech.captcha.biz.model.OrderRecord;
import com.spacetrue.tech.captcha.service.core.OrderService;
import com.spacetrue.tech.captcha.service.entity.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Shaw on 2017/7/13.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRecordMapper orderRecordMapper;

    @Override
    public OrderDTO createOrder(OrderDTO dto) {

        OrderRecord order = new OrderRecord();
        BeanUtils.copyProperties(dto,order);
        Date now = new Date();
        order.setUpdateAt(now);
        order.setCreatedAt(now);
        order.setOrderTime(now);

        int orderId = orderRecordMapper.insert(order);
        dto.setId(orderId);
        return dto;
    }

    @Override
    public OrderDTO updateOrderStatus(Integer orderId, Integer status) {

        OrderDTO result = null;

        OrderRecord order = orderRecordMapper.selectByPrimaryKey(orderId);
        if(order == null){
            return result;
        }

        order.setStatus(status);
        order.setUpdateAt( new Date());
        orderRecordMapper.updateByPrimaryKeySelective(order);
        result = new OrderDTO();
        BeanUtils.copyProperties(order,result);
        return result;
    }

    @Override
    public OrderDTO getOrderByID(Integer orderId) {

        OrderDTO result = null;

        OrderRecord order = orderRecordMapper.selectByPrimaryKey(orderId);
        if(order == null){
            return result;
        }

        result = new OrderDTO();
        BeanUtils.copyProperties(order,result);
        return result;
    }
}
