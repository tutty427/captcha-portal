package com.spacetrue.tech.captcha.service.entity;

import java.util.Date;

public class ItemDeliveryDTO {

    private String orderId;

    private Integer itemId;

    private String userId;

    private Date activeTime;

    private Date endTime;

    private Long totalUsedCount;

    private Long currentUsedCount;

}