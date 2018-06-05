package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.QuestionImpl;
import com.giserhub.dao.inf.Questiondao;
import com.giserhub.entity.Question;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static com.giserhub.tool.system.Head.setheader;

public class getAllUnauditedquestion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            System.out.println(json.toString());
            int pageNo,pageSize;
            pageNo = Integer.parseInt(json.getString("pageNo"));
            pageSize = Integer.parseInt(json.getString("pageSize"));
            ArrayList<Question> questions ;
            Questiondao qd = new QuestionImpl();
            questions = qd.getAllUnauditedquestion(pageNo,pageSize);
            if( questions.size()!=0)
            {
                String jsonout =JSONArray.fromObject(questions).toString();
                successorfail.success(out,jsonout);
            }else
            {
                successorfail.fail(out);
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);
    }
}
