package com.spacetrue.tech.captcha.service.core;

import com.spacetrue.tech.captcha.service.entity.UserDTO;

/**
 * Created by Shaw on 2017/7/9.
 */
public interface UserService {

     boolean register(String userAccount,String pwd);

    UserDTO login(String userAccount,String pwd);

     boolean changePwd(Integer id,String newPwd);

     UserDTO loadUserProfilebyUserId(String userId);

    UserDTO loadUserProfilebyUserAccount(String userAccount);
}
