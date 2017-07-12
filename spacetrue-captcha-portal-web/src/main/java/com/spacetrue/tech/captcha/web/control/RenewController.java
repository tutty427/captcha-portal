package com.spacetrue.tech.captcha.web.control;

import com.google.common.collect.Lists;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.entity.ItemDTO;
import com.spacetrue.tech.captcha.web.common.Constants;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Shaw on 2017/7/11.
 */
@Controller
public class RenewController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/renew/listAll",produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    public @ResponseBody List<ItemDTO> listAll(){

        List<ItemDTO> dtos = itemService.listItems();
        return dtos;
    }





}
