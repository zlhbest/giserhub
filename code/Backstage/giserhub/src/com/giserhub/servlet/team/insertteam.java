package com.giserhub.servlet.team;

import com.giserhub.dao.impl.TeamImpl;
import com.giserhub.dao.inf.Teamdao;
import com.giserhub.entity.Team;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import com.giserhub.tool.team.teamfuzhi;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class insertteam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Head.setheader(req,resp);
        try
        {
            boolean flag ;
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int U_id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            Team team  = new Team();
            teamfuzhi.fuzhi(json,U_id,team);
            Teamdao td = new TeamImpl();
            int T_id = td.insertteam(team);
            if(T_id!=0)
            {
                successorfail.success(out,T_id+"");
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
}
