package com.giserhub.dao.inf;

import com.giserhub.entity.Question;
import com.giserhub.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public interface Userdao {
    public String[] login(String name, String pwd);//登录
    public int register(User user);//注册
    public boolean updatetouxiang(int id, HttpServletRequest request, HttpServletResponse response) ;//更新用户信息
    public ArrayList<Question> selectquestionbyid(int id, int pageno, int pagesize);
}
