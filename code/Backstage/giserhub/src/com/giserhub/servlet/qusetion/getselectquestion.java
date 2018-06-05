package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.QuestionImpl;
import com.giserhub.dao.inf.Questiondao;
import com.giserhub.entity.Question;
import com.giserhub.tool.system.successorfail;
import com.giserhub.tool.system.CookieMade;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.giserhub.tool.system.Head.setheader;

public class getselectquestion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            System.out.println(json.toString());
            int questionid = Integer.parseInt(json.getString("questionid"));
            Question question;
            Questiondao qd = new QuestionImpl();
            question = qd.getselectquestion(questionid);
            if (question != null) {
                String jsonout = JSONArray.fromObject(question).toString();
                successorfail.success(out, jsonout);
            } else {
                successorfail.fail(out);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
