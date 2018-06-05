package com.giserhub.servlet.user;

import com.giserhub.dao.inf.Userdao;
import com.giserhub.dao.impl.UserDaoImpl;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//实现登录功能的 需要继承HttpServlet  并重写doGet  doPost方法
public class Userlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       super.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try {
            PrintWriter out = resp.getWriter();
            String idCookie = CookieMade.panduancookie(req,out,"id");
            if(!idCookie.equals(""))
            {
                return;
            }
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            if(date==null)
            {
                successorfail.fail(out);
                return;
            }
            String name = json.getString("name");
            String pwd = json.getString("pwd");
            Userdao ud = new UserDaoImpl();
            String[] cookie  = ud.login(name,pwd);
            if (cookie[0]!=null)
            {
                successorfail.success(out);
                CookieMade.writecookie(req,resp,cookie);
            }
            else
            {
                successorfail.fail(out);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
