package com.spacetrue.tech.captcha.service.core.impl;

import com.google.common.base.Strings;
import com.spacetrue.tech.captcha.biz.mapper.db.captcha.UserMapper;
import com.spacetrue.tech.captcha.biz.model.User;
import com.spacetrue.tech.captcha.service.core.UserService;
import com.spacetrue.tech.captcha.service.entity.UserDTO;
import com.spacetrue.tech.captcha.service.util.SecurityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Shaw on 2017/7/9.
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOG = Logger.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String userAccount, String pwd) {
        User user = userMapper.selectByUserAccount(userAccount);
        if(user != null){
            LOG.warn("Duplicate acount ==> "+ userAccount);
            return false;
        }

        user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(SecurityUtils.sha256(pwd));

        Date now = new Date();
        user.setCreatedAt(now);
        user.setUpdateAt(now);
        user.setLastLoginAt(now);

        String accessId = SecurityUtils.generateAccessId(userAccount,now.getTime());
        if(Strings.isNullOrEmpty(accessId)){
            LOG.warn("Fail to generate accessId");
            return false;
        }
        user.setAccessId(accessId);
        userMapper.insert(user);
        return true;
    }

    @Override
    public UserDTO login(String userAccount, String pwd) {

        UserDTO dto = null;
        User user = userMapper.selectByUserAccount(userAccount);
        if(user != null && user.getUserPassword().equalsIgnoreCase(SecurityUtils.sha256(pwd))){
            dto = new UserDTO();
            BeanUtils.copyProperties(user,dto);

            //更新登陸時間
            User userForUpdate = new User();
            userForUpdate.setId(user.getId());
            userForUpdate.setLastLoginAt(new Date());
            userMapper.updateByPrimaryKey(userForUpdate);
            return dto;
        }
        LOG.warn("Account/Pwd can't be matched");
        return dto;
    }

    @Override
    public boolean changePwd(Integer id, String newPwd) {

        User userForUpdate = new User();
        userForUpdate.setId(id);
        userForUpdate.setUserPassword(SecurityUtils.sha256(newPwd));
        userForUpdate.setUpdateAt(new Date());
        userMapper.updateByPrimaryKey(userForUpdate);
        return true;
    }

    @Override
    public UserDTO loadUserProfilebyUserId(String userId) {

        UserDTO dto = new UserDTO();
        User user = userMapper.selectByUserId(userId);
        if(user != null){
            BeanUtils.copyProperties(user,dto);
        }
        return dto;
    }

    @Override
    public UserDTO loadUserProfilebyUserAccount(String userAccount) {
        UserDTO dto = new UserDTO();
        User user = userMapper.selectByUserAccount(userAccount);
        if(user != null){
            BeanUtils.copyProperties(user,dto);
        }
        return dto;
    }
}
