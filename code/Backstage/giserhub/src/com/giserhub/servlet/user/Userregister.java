package com.giserhub.servlet.user;

import com.giserhub.dao.inf.Userdao;
import com.giserhub.dao.impl.UserDaoImpl;
import com.giserhub.entity.User;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.User.JsontoUser;
import com.giserhub.tool.system.successorfail;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Userregister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       super.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            User user ;
            PrintWriter out = resp.getWriter();//用于输出到前端
            String date = req.getParameter("date");//获取前端的json数据
            System.out.println(date);
            user = JsontoUser.jsontoUser(date);
            Userdao ud  = new UserDaoImpl();
            int mark = ud.register(user);
            if(mark==0)
            {
                success(out,user);
            }else if(mark==1)
            {
                successorfail.fail(out,"1");//昵称重复
            }else if(mark==2)
            {
                successorfail.fail(out,"2");//邮箱重复
            }
            else
            {
                successorfail.fail(out,"-1");//为止原因注册不成功
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void success(PrintWriter out,User user)
    {
        System.out.println("注册成功");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","1");
        datemapsuccess.put("UserAccount",user.getU_Account());
        JSONArray array = JSONArray.fromObject(datemapsuccess);
        System.out.println(array.toString());
        out.write(array.toString());
    }
}
