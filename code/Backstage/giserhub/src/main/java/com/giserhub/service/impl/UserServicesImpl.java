package com.giserhub.service.impl;

import com.giserhub.dao.model.UserMapper;
import com.giserhub.entity.User;
import com.giserhub.entity.UserWithBLOBs;
import com.giserhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServicesImpl implements UserService {
    //注入dao对象
    @Autowired//它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    private UserMapper userMapper;
    @Override
    public int insertSelective(UserWithBLOBs userWithBLOBs) {
        return userMapper.insertSelective(userWithBLOBs);
    }

    @Override
    public int updateUserinf(UserWithBLOBs userWithBLOBs) {
        return userMapper.updateUserinf(userWithBLOBs);
    }

    @Override
    public UserWithBLOBs userLogin(UserWithBLOBs userWithBLOBs) {
        return userMapper.userSelective(userWithBLOBs);
    }
}
