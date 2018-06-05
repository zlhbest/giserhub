package com.giserhub.util;

import java.sql.*;
public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/giserhub?allowMultiQueries=true&useunicuee=true&characterEncoding=utf8";
    static String username = "root";
    static String password = "";
    static Connection  conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps =null;
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql,final Object...val){
        int i = 0;
        try {
             ps =  conn.prepareStatement(sql);
            //参数赋值
            int index = 1;
            for(Object param:val)
            {
                ps.setObject(index++,param);
            }
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }
    public static ResultSet selectSql(String sql,final Object...val){
        try {
            ps =  conn.prepareStatement(sql);
            //参数赋值
            int index = 1;
            for(Object param:val)
            {
                ps.setObject(index++,param);
            }
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}
