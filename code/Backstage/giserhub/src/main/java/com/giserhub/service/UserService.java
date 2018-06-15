package com.giserhub.service;

import com.giserhub.entity.UserWithBLOBs;

public interface UserService
{
    //向数据库中写入一个用户基本信息，及用户注册
    public int insertSelective(UserWithBLOBs userWithBLOBs);
    //注册完成后写入完整信息，S_QQ，S_AGE，I_SEX，S_REAL_NAME，S_COLLEGE，S_SCHOOL，S_MAJOR，只有当信息完善时才出现更新B_PERFECT_MARK
    public int updateUserinf(UserWithBLOBs userWithBLOBs);
    //登录功能实现,用于实现登录注册功能
    public UserWithBLOBs userLogin(UserWithBLOBs userWithBLOBs);
}
