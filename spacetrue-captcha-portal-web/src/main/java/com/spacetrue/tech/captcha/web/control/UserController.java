package com.spacetrue.tech.captcha.web.control;


import com.google.common.collect.Maps;
import com.spacetrue.tech.captcha.service.core.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    private final static String USER_NAME_KEY = "UserName";



    @RequestMapping(value="/user/toCenter")
    public String center(ModelMap model, HttpServletRequest request, HttpSession session){
        model.addAttribute(Constants.PAGE_TITLE, "index");
        String userName = request.getParameter("form-username");
        String pwd = request.getParameter("password");
        // userService.login()
        session.setAttribute(USER_NAME_KEY,userName);
        return LayoutNames.userCenterPage.name();
    }


    @RequestMapping(value="/index")
    public String test(ModelMap model){
        model.addAttribute(Constants.PAGE_TITLE, "Index");
        model.addAttribute(Constants.PAGE_NAME, "index");
        return LayoutNames.captchaPortalPage.name();
    }


    @RequestMapping(value="/toLogin")
    public String login(ModelMap model,HttpServletRequest request, HttpSession session){
        model.addAttribute(Constants.PAGE_TITLE, "login");


        return LayoutNames.loginPage.name();
    }


}
