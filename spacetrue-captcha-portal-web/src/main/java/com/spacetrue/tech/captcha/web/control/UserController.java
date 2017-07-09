package com.spacetrue.tech.captcha.web.control;


import com.google.common.collect.Maps;
import com.spacetrue.tech.captcha.web.common.Constants;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class UserController {

//
//    @RequestMapping(value = "/cityName")
//    @ResponseBody
//    public Map<String,Object> getCityName(@RequestParam(required = false,defaultValue = "1") int cityId){
//
//        Map<String,Object> result = Maps.newHashMap();
//
//
//
//        return result;
//    }



    @RequestMapping(value="/user/test")
    public String test(ModelMap model){
        model.addAttribute(Constants.PAGE_TITLE, "index");
        model.addAttribute(Constants.PAGE_NAME, "index");
        model.addAttribute("loginStatus", 2);

        return LayoutNames.captchaPortalPage.name();
    }

    @RequestMapping(value="/user/center")
    public String center(ModelMap model){
        model.addAttribute(Constants.PAGE_TITLE, "index");
        model.addAttribute("loginStatus", 2);

        return LayoutNames.userCenterPage.name();
    }


    @RequestMapping(value="/user/login")
    public String login(ModelMap model){
        model.addAttribute(Constants.PAGE_TITLE, "index");
        model.addAttribute("loginStatus", 2);

        return LayoutNames.loginPage.name();
    }


}
