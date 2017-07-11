package com.spacetrue.tech.captcha.service.core;

import com.spacetrue.tech.captcha.service.entity.ItemDTO;

import java.util.List;

/**
 * Created by Shaw on 2017/7/9.
 */
public interface ItemService {

    boolean addItem(ItemDTO itemDTO);

    boolean deleteItemById(Integer id);

    ItemDTO getItemById(Integer id);

    List<ItemDTO> listItems();

}
