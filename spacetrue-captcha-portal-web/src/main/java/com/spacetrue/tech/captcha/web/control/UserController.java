package com.spacetrue.tech.captcha.web.control;


import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.spacetrue.tech.captcha.service.core.ItemDeliveryService;
import com.spacetrue.tech.captcha.service.core.ItemService;
import com.spacetrue.tech.captcha.service.core.UserService;
import com.spacetrue.tech.captcha.service.entity.UserDTO;
import com.spacetrue.tech.captcha.web.common.Constants;
import com.spacetrue.tech.captcha.web.common.LayoutNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemDeliveryService itemDeliveryService;


    @RequestMapping(value="/user/toUsageLog")
    public String usageLog(ModelMap model, HttpServletRequest request, HttpSession session){
        model.addAttribute(Constants.PAGE_NAME, "usagelog");
        return LayoutNames.userCenterLayoutPage.name();
    }


    @RequestMapping(value="/user/paymentRecord")
    public String paymentRecord(ModelMap model, HttpServletRequest request, HttpSession session){
        model.addAttribute(Constants.PAGE_NAME, "paymentrecord");
        return LayoutNames.userCenterLayoutPage.name();
    }


    @RequestMapping(value="/user/logout")
    public String logout(ModelMap model,HttpServletRequest request, HttpSession session){
        session.invalidate();
        return index(model);
    }



    @RequestMapping(value="/index")
    public String index(ModelMap model){
        model.addAttribute(Constants.PAGE_NAME, "index");
        return LayoutNames.captchaPortalPage.name();
    }


    @RequestMapping(value="/toLogin")
    public String login(ModelMap model,HttpServletRequest request, HttpSession session){
        return LayoutNames.loginPage.name();
    }

    @RequestMapping(value="/toCenter")
    public String center(ModelMap model, HttpServletRequest request, HttpSession session){
        model.addAttribute(Constants.PAGE_TITLE, "Home");
        model.addAttribute(Constants.PAGE_NAME, "renew");


        if(!Strings.isNullOrEmpty((String)session.getAttribute(USER_NAME_KEY))){
            Map<String,Long> balanceMap = itemDeliveryService.countBalance((String)session.getAttribute(USER_ID_KEY));
            if(balanceMap.isEmpty()){
                model.addAttribute(Constants.STREAM_BALANCE, "--");
            }else{
                model.addAttribute(Constants.STREAM_BALANCE, balanceMap.get("stream"));
            }
            return LayoutNames.userCenterLayoutPage.name();
        }

        String userName = request.getParameter("form-username");
        String pwd = request.getParameter("form-password");
        UserDTO dto = userService.login(userName,pwd);
        if(dto == null){
            return LayoutNames.loginPage.name();
        }
        session.setAttribute(USER_NAME_KEY,userName);
        session.setAttribute(USER_ID_KEY,dto.getUserId());

        Map<String,Long> balanceMap = itemDeliveryService.countBalance(dto.getUserId());
        if(balanceMap.isEmpty()){
            model.addAttribute(Constants.STREAM_BALANCE, "--");
        }else{
            model.addAttribute(Constants.STREAM_BALANCE, balanceMap.get("stream"));
        }

        return LayoutNames.userCenterLayoutPage.name();
    }


}
