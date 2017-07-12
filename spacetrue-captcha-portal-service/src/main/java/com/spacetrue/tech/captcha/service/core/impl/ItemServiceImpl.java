package com.spacetrue.tech.captcha.service.core.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.spacetrue.tech.captcha.biz.mapper.db.captcha.ItemMapper;
import com.spacetrue.tech.captcha.biz.model.Item;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by Shaw on 2017/7/9.
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemMapper itemMapper;

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        return false;
    }

    @Override
    public boolean deleteItemById(Integer id) {
        return false;
    }

    @Override
    public ItemDTO getItemById(Integer id) {
        ItemDTO dto = null;
        Item item = itemMapper.selectByPrimaryKey(id);
        if(item!= null){
            dto = new ItemDTO();
            BeanUtils.copyProperties(item,dto);
        }
        return dto;
    }

    @Override
    public List<ItemDTO> listItems() {

        List<ItemDTO> result = Lists.newArrayList();
        List<Item> items = itemMapper.selectAll();
        if( CollectionUtils.isEmpty(items) ){
            return result;
        }

        for(Item item : items){
            ItemDTO dto = new ItemDTO();
            BeanUtils.copyProperties(item,dto);
            result.add(dto);
        }
        return result;
    }
}
