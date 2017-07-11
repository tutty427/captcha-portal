package com.spacetrue.tech.captcha.biz.mapper.db.captcha;

import com.spacetrue.tech.captcha.biz.model.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectAll();
}