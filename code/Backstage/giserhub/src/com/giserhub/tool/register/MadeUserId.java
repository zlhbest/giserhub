package com.giserhub.tool.register;

import com.giserhub.entity.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * 用户的账户产生操作，账户的产生是注册的时间时分秒加性别，加id号
 */
public class MadeUserId {
    public static String madeUserid(entity user)
    {
        int time = madetime();
        int sex = user.getsex()?1:0;
        int id = maderandom();
        String Userid = time+""+sex+""+id;
        return Userid;
    }
    private static int madetime()
    {
        Date now = new Date();//获取当前的系统时间
        SimpleDateFormat sdf = new  SimpleDateFormat("HH:mm:ss");//设置日期格式
        String date = sdf.format(now);// new Date()为获取当前系统时间，也可使用当前时间戳
        String[] timeString = date.split(":");
        int time = Integer.parseInt(timeString[0]+timeString[1]+timeString[2]);
        return time;
    }
    private static  int maderandom()
    {
        Random random  = new Random();
        return random.nextInt(10000);
    }
}
