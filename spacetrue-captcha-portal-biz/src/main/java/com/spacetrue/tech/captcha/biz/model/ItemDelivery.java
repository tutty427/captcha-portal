package com.spacetrue.tech.captcha.biz.model;

import java.util.Date;

public class ItemDelivery {
    private Long id;

    private String orderId;

    private Integer itemId;

    private String userId;

    private Date activeTime;

    private Date endTime;

    private Long totalUsedCount;

    private Long currentUsedCount;

    private Date createdAt;

    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTotalUsedCount() {
        return totalUsedCount;
    }

    public void setTotalUsedCount(Long totalUsedCount) {
        this.totalUsedCount = totalUsedCount;
    }

    public Long getCurrentUsedCount() {
        return currentUsedCount;
    }

    public void setCurrentUsedCount(Long currentUsedCount) {
        this.currentUsedCount = currentUsedCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}