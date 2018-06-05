package com.giserhub.dao.inf;

import com.giserhub.entity.Administrator;

public interface AdministratorDao {
    public String login(String name, String pwd);//登录
    public int register(Administrator administrator);//注册
}
