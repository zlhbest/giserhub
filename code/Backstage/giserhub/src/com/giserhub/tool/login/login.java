package com.giserhub.tool.login;

import com.giserhub.tool.system.md5;

import java.sql.ResultSet;

public class login {
    //用于拼接sql字符串
    public static void userloginfunsql(String name, String pwd,StringBuilder sql)
    {
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    sql.append("  WHERE `user`.U_NickName =" + "\""+name+ "\"")
                            .append("    AND `user`.U_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
                case account:
                    sql.append("  WHERE `user`.U_Account =" + "\""+name+ "\"")
                            .append("    AND `user`.U_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
                case email:
                    sql.append("  WHERE `user`.U_Email =" + "\""+name+ "\"")
                            .append("    AND `user`.U_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    //用于判断sql是否返回结果与用户输入结果相同
    public static String[] userloginfunres(String name, String pwd,ResultSet rs)
    {
        String cookie[]  =new String[3];
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    if(rs.getString("U_NickName").equals(name) && rs.getString("U_PassWord").equals(md5.getMd5Code(pwd))){
                        cookie[0] = rs.getString("U_id");
                        cookie[1] =  rs.getString("U_NickName");
                        cookie[2] =  rs.getString("U_HeadIcon");
                    }
                    break;
                case account:
                    if(rs.getString("U_Account").equals(name) && rs.getString("U_PassWord").equals(md5.getMd5Code(pwd))){
                        cookie[0] = rs.getString("U_id");
                        cookie[1] =  rs.getString("U_NickName");
                        cookie[2] =  rs.getString("U_HeadIcon");
                    }
                    break;
                case email:
                    if(rs.getString("U_Email").equals(name) && rs.getString("U_PassWord").equals(md5.getMd5Code(pwd))){
                        cookie[0] = rs.getString("U_id");
                        cookie[1] =  rs.getString("U_NickName");
                        cookie[2] =  rs.getString("U_HeadIcon");
                    }
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cookie;
    }
    //用于拼接sql字符串
    public static void admloginfunsql(String name, String pwd,StringBuilder sql)
    {
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    sql.append("  WHERE `administrator`.A_NickName =" + "\""+name+ "\"")
                            .append("    AND `administrator`.A_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
                case account:
                    sql.append("  WHERE `administrator`.A_Account =" + "\""+name+ "\"")
                            .append("    AND `administrator`.A_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
                case email:
                    sql.append("  WHERE `administrator`.A_Email =" + "\""+name+ "\"")
                            .append("    AND `administrator`.A_PassWord =" + "\""+ md5.getMd5Code(pwd)+ "\"");
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    //用于判断sql是否返回结果与用户输入结果相同
    public static String admloginfunres(String name, String pwd,ResultSet rs)
    {
        String id = "";
        try {
            switch (JudgeLogin.JLogin(name))
            {
                case nick:
                    if(rs.getString("A_NickName").equals(name) && rs.getString("A_PassWord").equals(md5.getMd5Code(pwd))){
                        id = rs.getString("A_id");
                    }
                    break;
                case account:
                    if(rs.getString("A_Account").equals(name) && rs.getString("A_PassWord").equals(md5.getMd5Code(pwd))){
                        id = rs.getString("A_id");
                    }
                    break;
                case email:
                    if(rs.getString("A_Email").equals(name) && rs.getString("A_PassWord").equals(md5.getMd5Code(pwd))){
                        id = rs.getString("A_id");
                    }
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return id;
    }
}
