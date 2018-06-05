package com.giserhub.servlet.qusetion;

import com.giserhub.dao.impl.MessageBoardImpl;
import com.giserhub.dao.inf.MessageBoarddao;
import com.giserhub.entity.MessageBoard;
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
import java.util.ArrayList;

public class getMBByQuestionid extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            System.out.println(json.toString());
            int Q_id, pageNo, pageSize;
            Q_id = Integer.parseInt(json.getString("Q_id"));
            if((json.getString("pageNo")!=null&&json.getString("pageNo").equals(""))||
                    (json.getString("pageSize")!=null&&json.getString("pageSize").equals(""))) {
                pageNo = Integer.parseInt(json.getString("pageNo"));
                pageSize = Integer.parseInt(json.getString("pageSize"));
            }else
            {
                pageNo = 1;
                pageSize =10;
            }
            ArrayList<MessageBoard> messageBoards;
            MessageBoarddao md = new MessageBoardImpl();
            messageBoards = md.getNatureIstrue(Q_id,pageNo,pageSize);
            if(messageBoards.size()!=0)
            {
                String jsonmd = JSONArray.fromObject(messageBoards).toString();
                successorfail.success(out,jsonmd);
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
        super.doGet(req, resp);
    }
}
