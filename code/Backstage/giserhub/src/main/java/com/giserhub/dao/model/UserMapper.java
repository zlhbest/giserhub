package com.giserhub.dao.model;

import com.giserhub.entity.User;
import com.giserhub.entity.UserWithBLOBs;

public interface UserMapper {
    //注册实现
    int insertSelective(UserWithBLOBs record);
    //注入信息，注册信息除外
    int updateUserinf(UserWithBLOBs userWithBLOBs);
    //用户登录信息
    UserWithBLOBs userSelective(UserWithBLOBs userWithBLOBs);
}