package com.spacetrue.tech.captcha.biz.model;

import java.util.Date;

public class Item {
    private Integer id;

    private String itemName;

    private String itemDescribe;

    private Integer itemDiscount;

    private Long timeLimit;

    private Long streamLimit;

    private String itemAvailablePayway;

    private Date createdAt;

    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe == null ? null : itemDescribe.trim();
    }

    public Integer getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(Integer itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public Long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Long getStreamLimit() {
        return streamLimit;
    }

    public void setStreamLimit(Long streamLimit) {
        this.streamLimit = streamLimit;
    }

    public String getItemAvailablePayway() {
        return itemAvailablePayway;
    }

    public void setItemAvailablePayway(String itemAvailablePayway) {
        this.itemAvailablePayway = itemAvailablePayway == null ? null : itemAvailablePayway.trim();
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