package com.spacetrue.tech.captcha.biz.mapper.db.captcha;

import com.spacetrue.tech.captcha.biz.model.ItemDelivery;

public interface ItemDeliveryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemDelivery record);

    int insertSelective(ItemDelivery record);

    ItemDelivery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemDelivery record);

    int updateByPrimaryKey(ItemDelivery record);
}