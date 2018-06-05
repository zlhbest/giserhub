package com.giserhub.servlet.administrator;

import com.giserhub.dao.impl.AdministratorImpl;
import com.giserhub.dao.inf.AdministratorDao;
import com.giserhub.entity.Administrator;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.tool.system.Head;
import com.giserhub.tool.Adm.JsontoAdm;
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

public class admregister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Head.setheader(req,resp);
        try
        {
            Administrator administrator ;
            PrintWriter out = resp.getWriter();//用于输出到前端
            String date = req.getParameter("date");//获取前端的json数据
            System.out.println(date);
            administrator = JsontoAdm.jsontoadm(date);
            AdministratorDao ad  = new AdministratorImpl();
            int mark = ad.register(administrator);
            if(mark==0)
            {
                success(out,administrator);
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
    private void success(PrintWriter out,Administrator administrator)
    {
        System.out.println("注册成功");
        //后台向前端发送json数据
        Map<String,String> datemapsuccess = new HashMap<>();
        datemapsuccess.put("state","1");
        datemapsuccess.put("UserAccount",administrator.getA_Account());
        JSONArray array = JSONArray.fromObject(datemapsuccess);
        System.out.println(array.toString());
        out.write(array.toString());
    }

}
