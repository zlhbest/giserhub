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
import java.util.ArrayList;

public class selectteambyUid extends HttpServlet
{
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
            int U_id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            ArrayList<Team> teams = new ArrayList<>();
            Teamdao td = new TeamImpl();
            teams =  td.selectteambyUid(U_id);
            if(teams.size()!=0)
            {
                String  jsonout = JSONObject.fromObject(teams).toString();
                successorfail.success(out,jsonout);
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
