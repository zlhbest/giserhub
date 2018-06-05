package com.giserhub.tool.system;

import net.sf.json.JSONArray;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CookieMade {
    public static String readcookie(HttpServletRequest request,String name)
    {
        boolean flag;
        String namecookie="";
        switch (name)
        {
            case "id":
                namecookie= readid(request);
                break;
            case "nick":
                namecookie = readnick(request);
                break;
            case "touxiang":
                namecookie = readtouxiang(request);
                break;
        }
        if(namecookie.equals(""))
        {
            flag=false;
        }
        else
        {
            flag=true;
        }
        return namecookie;
    }
    public static String panduancookie(HttpServletRequest request,PrintWriter out,String name)
    {
        boolean flag;
        String namecookie="";
        switch (name)
        {
            case "id":
                namecookie= readid(request);
                break;
            case "nick":
                namecookie = readnick(request);
                break;
            case "touxiang":
                namecookie = readtouxiang(request);
                break;
        }
        if(namecookie.equals(""))
        {
            flag=false;
        }
        else
        {
            flag=true;
        }
        if(flag)
        {
            successorfail.success(out);
        }
        return namecookie;
    }
    private static String readid(HttpServletRequest request)
    {
        String id="";
        Cookie[] cookie = request.getCookies();
        if(cookie!=null) {
            for (Cookie cookie1 : cookie) {
                if(cookie1.getName().equals("giserhub1"))
                {
                    id= cookie1.getValue();
                }
            }
        }
        return id;
    }
    private static String readnick(HttpServletRequest request)
    {
        String nick="";
        Cookie[] cookie = request.getCookies();
        if(cookie!=null) {
            for (Cookie cookie1 : cookie) {
                if(cookie1.getName().equals("giserhub2"))
                {
                    nick= cookie1.getValue();
                }
            }
        }
        return nick;
    }
    private static String readtouxiang(HttpServletRequest request)
    {
        String touxiang="";
        Cookie[] cookie = request.getCookies();
        if(cookie!=null) {
            for (Cookie cookie1 : cookie) {
                if(cookie1.getName().equals("giserhub3"))
                {
                    touxiang= cookie1.getValue();
                }
            }
        }
        return touxiang;
    }
    /**
     * 这是记录cookie的,name,头像路径，id，
     * @param request
     * @param response
     * @param str
     */
    public static void writecookie(HttpServletRequest request, HttpServletResponse response,final String...str)
    {
        int index=1;
        for(String cookiestr:str)
        {
            if(index==3)
            {
                javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("giserhub"+index,"http://39.106.181.120/"+cookiestr);
                cookie.setMaxAge(60*60*24*30);
                cookie.setPath("/");
                cookie.setDomain("39.106.181.120");
                response.addCookie(cookie);
            }
            else {
                javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("giserhub" + index, cookiestr);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                cookie.setPath("/");
                cookie.setDomain("39.106.181.120");
                response.addCookie(cookie);
            }
            index++;
        }
    }
    public static void  writecookieHI(HttpServletResponse response,final String cookiestr)
    {
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("giserhub3","http://39.106.181.120/"+cookiestr);
        cookie.setMaxAge(60*60*24*30);
        cookie.setPath("/");
        cookie.setDomain("39.106.181.120");
        response.addCookie(cookie);
    }
}
