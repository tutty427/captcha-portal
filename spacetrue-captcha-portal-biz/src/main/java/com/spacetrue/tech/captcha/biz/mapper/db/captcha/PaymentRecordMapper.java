package com.spacetrue.tech.captcha.biz.mapper.db.captcha;

import com.spacetrue.tech.captcha.biz.model.PaymentRecord;

public interface PaymentRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentRecord record);

    int insertSelective(PaymentRecord record);

    PaymentRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentRecord record);

    int updateByPrimaryKey(PaymentRecord record);
}