package com.giserhub.tool.system;

import net.sf.json.JSONArray;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class successorfail {
    public static void success(PrintWriter out, String jsonout)
    {
        System.out.println("获取成功");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","1");
        datemapsuccess.put("date",jsonout);
        JSONArray array = JSONArray.fromObject(datemapsuccess);
        System.out.println(array.toString());
        out.write(array.toString());
    }
    public static void success(PrintWriter out)
    {
        System.out.println("登录成功");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","1");
        JSONArray array = JSONArray.fromObject(datemapsuccess);
        System.out.println(array.toString());
        out.write(array.toString());
    }
    public static void fail(PrintWriter out)
    {
        System.out.println("失败");
        //后台向前端发送json数据
        Map<String,String> datemapfail = new HashMap<>();
        datemapfail.put("state","0");
        JSONArray array = JSONArray.fromObject(datemapfail);
        System.out.println(array.toString());
        out.write(array.toString());
    }
    public static void fail(PrintWriter out,String reason)
    {
        System.out.println("注册失败");
        //后台向前端发送json数据
        Map<String,String> datemapfail = new HashMap<>();
        datemapfail.put("state","0");
        datemapfail.put("reason",reason);
        JSONArray array = JSONArray.fromObject(datemapfail);
        System.out.println(array.toString());
        out.write(array.toString());
    }
}
