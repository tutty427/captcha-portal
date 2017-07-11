package com.spacetrue.tech.captcha.service.entity;

/**
 * Created by Shaw on 2017/7/9.
 */
public class ItemDTO {

    private Integer id;

    private String itemName;

    private String itemDescribe;

    private Integer itemDiscount;

    private Long timeLimit;

    private Long streamLimit;

    private String itemAvailablePayway;


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
        this.itemName = itemName;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
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
        this.itemAvailablePayway = itemAvailablePayway;
    }
}
