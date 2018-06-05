package com.giserhub.servlet.user;

import com.giserhub.dao.impl.UserDaoImpl;
import com.giserhub.dao.inf.Userdao;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateHeadIcon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            boolean flag ;
            PrintWriter out = resp.getWriter();
            int id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            System.out.println(id);
            Userdao ud = new UserDaoImpl();
            flag = ud.updatetouxiang(id,req,resp);
            if(flag)
            {
                successorfail.success(out);
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
