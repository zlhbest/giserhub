package com.giserhub.servlet.user;

import com.giserhub.dao.impl.UserDaoImpl;
import com.giserhub.dao.inf.Userdao;
import com.giserhub.entity.Question;
import com.giserhub.tool.system.successorfail;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class selectquestionbyid extends HttpServlet {
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
            String id = CookieMade.readcookie(req,"id");
            if(id.equals(""))
            {
                successorfail.fail(out,"cookie未获取");
            }
            else
            {
                String date = req.getParameter("date");
                JSONObject json = JSONObject.fromObject(date);
                if(date==null)
                {
                    successorfail.fail(out,"前端数据未获取");
                    return;
                }else
                {
                    int pageNo,pageSize;
                    pageNo = Integer.parseInt(json.getString("pageNo"));
                    pageSize = Integer.parseInt(json.getString("pageSize"));
                    ArrayList<Question> questions ;
                    Userdao user = new UserDaoImpl();
                    questions = user.selectquestionbyid(Integer.parseInt(id),pageNo,pageSize);
                    if( questions.size()!=0)
                    {
                        String jsonout =JSONArray.fromObject(questions).toString();
                        successorfail.success(out,jsonout);
                    }else
                    {
                        successorfail.fail(out);
                    }
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
