package com.spacetrue.tech.captcha.web.vo;

import com.spacetrue.tech.captcha.service.entity.ItemDTO;

import java.util.List;

/**
 * Created by Shaw on 2017/7/11.
 */
public class RenewVO extends BaseUserCenterVO {

    private List<ItemDTO> items;

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
