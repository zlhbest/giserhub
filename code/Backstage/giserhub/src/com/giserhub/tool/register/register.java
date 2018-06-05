package com.giserhub.tool.register;

import com.giserhub.entity.Administrator;
import com.giserhub.entity.User;
import com.giserhub.tool.login.JudgeLogin;
import com.giserhub.tool.system.md5;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;

public class register {
    /*
   返回值有1，2,3,0  0代表无重复，1代表昵称重复，2代表邮箱重复
    */
    public static int userregisterIsrepace(User user)
    {
        int mark = -1;
        boolean flagnick ;
        boolean flagemail;
        try {
            flagnick= userregistersql(user.getU_NickName());
            flagemail=userregistersql(user.getU_Email());
            if(flagnick)
            {
                mark = 1;
            }else if(flagemail)
            {
                mark = 2;
            }else
            {
                mark = 0;
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mark;
    }
    private static boolean userregistersql(String name)
    {
        boolean flag = false;
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT *")
                    .append("  FROM user");
            userloginfunsql(name,sql);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                if(rs.getString("U_NickName")!=null || rs.getString("U_Email")!=null)
                {
                    flag = true;
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    //用于拼接sql字符串
    private static void userloginfunsql(String name,StringBuilder sql)
    {
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    sql.append("  WHERE `user`.U_NickName =" + "\""+name+ "\"");
                    break;
                case email:
                    sql.append("  WHERE `user`.U_Email =" + "\""+name+ "\"");
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    /*
  返回值有1，2,3,0  0代表无重复，1代表昵称重复，2代表邮箱重复
   */
    public static int admregisterIsrepace(Administrator administrator)
    {
        int mark = -1;
        boolean flagnick ;
        boolean flagemail;
        try {
            flagnick= userregistersql(administrator.getA_NickName());
            flagemail=userregistersql(administrator.getA_Email());
            if(flagnick)
            {
                mark = 1;
            }else if(flagemail)
            {
                mark = 2;
            }else
            {
                mark = 0;
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mark;
    }
    private static boolean admregistersql(String name)
    {
        boolean flag = false;
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT *")
                    .append("  FROM administrator");
            userloginfunsql(name,sql);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                if(rs.getString("A_NickName")!=null || rs.getString("A_Email")!=null)
                {
                    flag = true;
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    //用于拼接sql字符串
    private static void admloginfunsql(String name,StringBuilder sql)
    {
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    sql.append("  WHERE `administrator`.A_NickName =" + "\""+name+ "\"");
                    break;
                case email:
                    sql.append("  WHERE `administrator`.A_Email =" + "\""+name+ "\"");
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
