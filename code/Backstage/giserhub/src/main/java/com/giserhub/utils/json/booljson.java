package com.giserhub.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class booljson {
    public static void success(PrintWriter out) throws Exception
    {
        System.out.println("成功");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","1");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(datemapsuccess);
        System.out.println(json);
        out.write(json);
    }
    public static void fail(PrintWriter out) throws Exception
    {
        System.out.println("失败");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","0");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(datemapsuccess);
        System.out.println(json);
        out.write(json);
    }
}
