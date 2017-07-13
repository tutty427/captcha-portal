package com.spacetrue.tech.captcha.biz.mapper.db.captcha;

import com.spacetrue.tech.captcha.biz.model.ApiRequestHourly;

public interface ApiRequestHourlyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApiRequestHourly record);

    int insertSelective(ApiRequestHourly record);

    ApiRequestHourly selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApiRequestHourly record);

    int updateByPrimaryKey(ApiRequestHourly record);
}