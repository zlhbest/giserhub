package com.giserhub.servlet.idea;

import com.giserhub.dao.impl.IdeaImpl;
import com.giserhub.dao.inf.Ideadao;
import com.giserhub.entity.Idea;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class getALLPublicIdeafoeadm extends HttpServlet {
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
            String date  = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int pageNo, pageSize;
            pageNo = Integer.parseInt(json.getString("pageNo"));
            pageSize = Integer.parseInt(json.getString("pageSize"));
            ArrayList<Idea> ideas;
            Ideadao id = new IdeaImpl();
            ideas = id.getALLPublicIdeafoeadm(pageNo,pageSize);
            if(ideas.size()!=0)
            {
                String jsonout = JSONObject.fromObject(ideas).toString();
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
