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
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class getMBByUserid  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);//设置请求头，用于设置cookie
        try
        {
            PrintWriter out = resp.getWriter();
            String date = req.getParameter("date");
            JSONObject json = JSONObject.fromObject(date);
            int Q_id = Integer.parseInt(json.getString("Q_id"));
            int MB_U_id = Integer.parseInt(json.getString("MB_U_id"));
            MessageBoarddao mb = new MessageBoardImpl();
            ArrayList<MessageBoard> messageBoards ;
            messageBoards = mb.getNatureIsfalse(Q_id,MB_U_id);
            if(messageBoards.size()!=0)
            {
                String jsonmd = JSONArray.fromObject(messageBoards).toString();
                successorfail.success(out,jsonmd);
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
