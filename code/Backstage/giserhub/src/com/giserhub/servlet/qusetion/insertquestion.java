package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.QuestionImpl;
import com.giserhub.dao.inf.Questiondao;
import com.giserhub.entity.Question;
import com.giserhub.tool.question.JsonToQuestion;
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

public class insertquestion extends HttpServlet {
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
            String date = req.getParameter("date");//获取前端的json数据
            JSONObject json = JSONObject.fromObject(date);
            System.out.println(date);
            int U_id = Integer.parseInt(CookieMade.readcookie(req,"id"));
            Question question = new Question();
            question = JsonToQuestion.jsontoquestinI(json);
            Questiondao qd = new QuestionImpl();
            boolean flag = qd.insertquestion(question,U_id);
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
