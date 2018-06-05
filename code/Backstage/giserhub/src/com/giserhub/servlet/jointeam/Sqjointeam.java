package com.giserhub.servlet.jointeam;

import com.giserhub.dao.impl.jointeamImpl;
import com.giserhub.dao.inf.jointeamdao;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONObject;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sqjointeam extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Head.setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int T_id = Integer.parseInt(json.getString("T_id"));
            int U_id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            int I_id = Integer.parseInt(json.getString("I_id"));
            boolean flag = false;
            jointeamdao jd = new jointeamImpl();
            flag = jd.Sqjointeam(T_id,U_id,I_id);
            if(flag)
            {
                successorfail.success(out);
            }
            else
            {
                successorfail.fail(out);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
