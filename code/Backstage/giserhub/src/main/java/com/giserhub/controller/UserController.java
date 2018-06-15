package com.giserhub.controller;

import com.giserhub.entity.UserWithBLOBs;
import com.giserhub.entity.unityentity.userall;
import com.giserhub.service.UserService;
import com.giserhub.utils.cookies.CookieUtils;
import com.giserhub.utils.json.booljson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/User")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public void userLogin(@RequestBody userall userall,HttpServletResponse response)
    {
        try {
            PrintWriter out = response.getWriter();
            UserWithBLOBs userWithBLOBs = userall.getUserWithBLOBs();
            UserWithBLOBs user = userService.userLogin(userWithBLOBs);
            if (user != null) {
                int id = user.getId();
                String name = user.getsNickName();
                CookieUtils.addCookie(response,"USERID",id+"","www.giserhub.com");
                CookieUtils.addCookie(response,"NICKNAME",name,"www.giserhub.com");
                booljson.success(out);
            } else {
                booljson.fail(out);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public void insertSelective(@RequestBody userall userall, HttpServletResponse response)
    {
        try {
            PrintWriter out = response.getWriter();
            UserWithBLOBs userWithBLOBs = userall.getUserWithBLOBs();
           if(userService.insertSelective(userWithBLOBs)>0)
           {
               booljson.success(out);
           }else
           {
               booljson.fail(out);
           }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @RequestMapping(value = "/InformationPerfection",method = RequestMethod.POST)
    public void updateUserInformation(@RequestBody userall userall,
                                       HttpServletResponse response,
                                       @CookieValue(value ="USERID")String id)
    {
        try {
            PrintWriter out = response.getWriter();
            UserWithBLOBs userWithBLOBs = userall.getUserWithBLOBs();
            userWithBLOBs.setId(Integer.parseInt(id));
            if (userService.updateUserinf(userWithBLOBs) > 0) {
                booljson.success(out);
            } else {
                booljson.fail(out);
            }
        }
        catch (Exception ex)

        {
            ex.printStackTrace();
        }
    }
}
