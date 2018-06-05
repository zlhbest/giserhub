package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.MessageBoardImpl;
import com.giserhub.dao.inf.MessageBoarddao;
import com.giserhub.entity.MessageBoard;
import com.giserhub.tool.question.JsonToMessageBoard;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateMBByQuestion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        boolean falg = false;
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            System.out.println(json.toString());
            int user = Integer.parseInt(CookieMade.readcookie(req,"id"));
            MessageBoard messageBoard = JsonToMessageBoard.jsontomessageboard(json,user);
            MessageBoarddao md = new MessageBoardImpl();
            falg = md.updateNatureIstrue(messageBoard);
            if(falg)
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
