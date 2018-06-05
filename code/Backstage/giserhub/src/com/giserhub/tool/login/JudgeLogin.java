package com.giserhub.tool.login;

import com.giserhub.entity.other.loginfun;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JudgeLogin {
    public static loginfun JLogin(String name)
    {
        if(checkEmail(name))
        {
            return loginfun.email;
        }
        else if(checkAccount(name))
        {
            return loginfun.account;
        }else
        {
            return loginfun.nick;
        }
    }
    private static boolean checkEmail(String email)
    {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    private static boolean checkAccount(String sccount)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(sccount);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
