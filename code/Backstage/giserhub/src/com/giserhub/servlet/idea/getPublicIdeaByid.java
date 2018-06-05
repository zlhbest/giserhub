package com.giserhub.servlet.idea;

import com.giserhub.dao.impl.IdeaImpl;
import com.giserhub.dao.inf.Ideadao;
import com.giserhub.entity.Idea;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getPublicIdeaByid extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date  = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int I_id = Integer.parseInt(json.getString("I_id"));
            Idea idea;
            Ideadao id = new IdeaImpl();
            idea = id.getPublicIdeaByid(I_id);
            if(idea!=null)
            {
                String jsonout = JSONObject.fromObject(idea).toString();
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
