package com.spacetrue.tech.captcha.service.core.impl;

import com.google.common.collect.Maps;
import com.spacetrue.tech.captcha.biz.mapper.db.captcha.ApiRequestTotalMapper;
import com.spacetrue.tech.captcha.biz.mapper.db.captcha.ItemDeliveryMapper;
import com.spacetrue.tech.captcha.biz.mapper.db.captcha.ItemMapper;
import com.spacetrue.tech.captcha.biz.model.ItemDelivery;
import com.spacetrue.tech.captcha.service.common.AlipayStatusEnum;
import com.spacetrue.tech.captcha.service.core.ItemDeliveryService;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.core.OrderService;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import com.spacetrue.tech.captcha.service.entity.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by Shaw on 2017/7/9.
 */
@Service
public class ItemDeliveryServiceImpl implements ItemDeliveryService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemDeliveryMapper itemDeliveryMapper;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ApiRequestTotalMapper apiRequestTotalMapper;

    @Override
    public Map<String, Long> countBalance(String userId) {
        Map<String, Long> result = Maps.newHashMap();
        ItemDelivery itemDelivery = itemDeliveryMapper.selectByByUserId(userId);
        if( itemDelivery == null ){
            return result;
        }
        Long balance = itemDelivery.getTotalUsedCount() - itemDelivery.getCurrentUsedCount();
        result.put("stream",balance);
        return result;
    }

    @Override
    public void deliveryItemByOrder(Integer orderId) {
        OrderDTO orderDTO = orderService.getOrderByID(orderId);
        ItemDTO itemDTO = itemService.getItemById(orderDTO.getItemId());
        Date now = new Date();

        ItemDelivery itemDeliveryFromDB = itemDeliveryMapper.selectByByUserIdAndItemId(orderDTO.getUserId(),orderDTO.getItemId());
        if(itemDeliveryFromDB == null){

            if(orderDTO.getStatus().intValue() == AlipayStatusEnum.TRADE_SUCCESS.code()){

                ItemDelivery itemDelivery = new ItemDelivery();
                itemDelivery.setActiveTime(now);
                itemDelivery.setCreatedAt(now);
                itemDelivery.setCurrentUsedCount(0l);
                itemDelivery.setItemId(orderDTO.getItemId());

                itemDelivery.setTotalUsedCount(itemDTO.getStreamLimit());
                itemDelivery.setUpdateAt(now);
                itemDelivery.setUserId(orderDTO.getUserId());
                itemDeliveryMapper.insert(itemDelivery);
            }

        } else {

            itemDeliveryFromDB.setTotalUsedCount(itemDeliveryFromDB.getTotalUsedCount() + itemDTO.getStreamLimit());
            itemDeliveryFromDB.setUpdateAt(now);
            itemDeliveryMapper.updateByPrimaryKey(itemDeliveryFromDB);
        }




    }
}
