package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.QuestionImpl;
import com.giserhub.dao.inf.Questiondao;
import com.giserhub.entity.Question;
import com.giserhub.tool.question.JsonToQuestion;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.giserhub.tool.system.Head.setheader;

public class updatequestionGood extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setheader(req,resp);
        try {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int Good = Integer.parseInt(json.getString("Q_id"));
            Questiondao qd = new QuestionImpl();
            if(qd.updatequestionGood(Good))
            {
                successorfail.success(out);
            }else {
                successorfail.fail(out);
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
