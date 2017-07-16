package com.spacetrue.tech.captcha.biz.mapper.db.captcha;

import com.spacetrue.tech.captcha.biz.model.ApiRequestTotal;

public interface ApiRequestTotalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApiRequestTotal record);

    int insertSelective(ApiRequestTotal record);

    ApiRequestTotal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApiRequestTotal record);

    int updateByPrimaryKey(ApiRequestTotal record);

    ApiRequestTotal selectByAppId(String id);
}