package com.giserhub.dao.impl;

import com.giserhub.dao.inf.AdministratorDao;
import com.giserhub.entity.Administrator;
import com.giserhub.tool.login.login;
import com.giserhub.tool.register.MadeUserId;
import com.giserhub.tool.register.register;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdministratorImpl implements AdministratorDao {
    @Override
    public String login(String name, String pwd) {
        String id ="";
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT *")
                    .append("  FROM administrator");
            login.admloginfunsql(name,pwd,sql);
            System.out.println(sql.toString());
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                id= login.admloginfunres(name,pwd,rs);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return id;
    }
    //注册功能实现
    @Override
    public int register(Administrator administrator) {
        int mark = -1;
        try
        {
            SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
            String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            DBconn.init();
            if(register.admregisterIsrepace(administrator)==1)
            {
                System.out.println("nick有重复");
                mark = 1;
            }
            else if(register.admregisterIsrepace(administrator)==2)
            {
                System.out.println("email重复");
                mark = 2;
            }
            else if(register.admregisterIsrepace(administrator)==0){
                StringBuilder sql = new StringBuilder()
                        .append("INSERT INTO user(A_Account,A_NickName,A_PassWord,")
                        .append("                   A_Gender,A_Email,A_DeleteMark,A_CreatorTime,")
                        .append("                   A_passwordforback)")
                        .append(" VALUES(?,?,?,?,?,?,?,?)");
                administrator.setA_Account(MadeUserId.madeUserid(administrator));
                Object[] val = {
                        administrator.getA_Account(), administrator.getA_NickName(), administrator.getA_PassWord(),
                        administrator.isA_Gender(), administrator.getA_Email(), 0, date, administrator.getA_PassWordforback()
                };
                int result = DBconn.addUpdDel(sql.toString(), val);
                if (result > 0) {
                    System.out.println("添加成功");
                    mark = 0;
                } else {
                    System.out.println("添加失败");
                    mark = -1;
                }
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mark;
    }
}
