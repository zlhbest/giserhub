package com.giserhub.tool.system;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Head {
    public static void setheader(HttpServletRequest req, HttpServletResponse resp)
    {
        /**设置响应头允许ajax跨域访问**/
        resp.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
        /*星号表示所有的异域请求都可以接受，*/
        resp.setHeader("Access-Control-Allow-Methods","*");
        resp.setHeader("Access-Control-Allow-Headers", "GET,POST");
        //允许跨域携带cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
