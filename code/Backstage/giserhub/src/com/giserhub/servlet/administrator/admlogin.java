package com.giserhub.servlet.administrator;

import com.giserhub.dao.impl.AdministratorImpl;
import com.giserhub.dao.inf.AdministratorDao;
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

public class admlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try {
            PrintWriter out = resp.getWriter();
            String Aid = CookieMade.panduancookie(req,out,"id");
            System.out.println(Aid);
            if(!Aid.equals(""))
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
            AdministratorDao ad = new AdministratorImpl();
            String id  = ad.login(name,pwd);
            if (!id.equals(""))
            {
                successorfail.success(out);
               CookieMade.writecookie(req,resp,id);
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
