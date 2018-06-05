package com.giserhub.servlet.idea;

import com.giserhub.dao.impl.IdeaImpl;
import com.giserhub.dao.inf.Ideadao;
import com.giserhub.entity.Idea;
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
import java.util.ArrayList;

/**
 * 用于个人查看个人的隐私idea，需要上传的就是用户的id，这个可以通过cookie获取
 */
public class getAllPrivateIdea extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int U_id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            int pageNo, pageSize;
            pageNo = Integer.parseInt(json.getString("pageNo"));
            pageSize = Integer.parseInt(json.getString("pageSize"));
            ArrayList<Idea> ideas;
            Ideadao id = new IdeaImpl();
            ideas = id.getAllPrivateIdea(pageNo,pageSize,U_id);
            if(ideas.size()!=0)
            {
                String jsonout = JSONObject.fromObject(ideas).toString();
                successorfail.success(out,jsonout);
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
