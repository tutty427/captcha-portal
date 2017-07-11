package com.spacetrue.tech.captcha.web.restapi;

import com.spacetrue.tech.captcha.service.core.UserService;
import com.spacetrue.tech.captcha.service.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by Shaw on 2017/7/11.
 */
@RestController
public class CommonApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/randomAccount/{account}", produces="application/json;charset=UTF-8")
    public UserDTO randomAccount(@PathVariable("account") String account ){

        return userService.getRandomAccount(account);
    }

}
