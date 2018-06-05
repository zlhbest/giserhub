package com.giserhub.tool.User;

import com.giserhub.entity.User;
import com.giserhub.tool.system.md5;
import net.sf.json.JSONObject;

public class JsontoUser {
    public static User jsontoUser(String json)
    {
        User user = new User();
        try {
            JSONObject jsonobject = JSONObject.fromObject(json);//将json字符串转换为数组
            user.setU_NickName(jsonobject.getString("nick"));//昵称
            user.setU_PassWor(md5.getMd5Code(jsonobject.getString("pwd")));
            user.setU_Gender(sex(jsonobject.getString("sex")));
            user.setU_Email(jsonobject.getString("email"));
            user.setU_passwordforback(jsonobject.getString("pwd"));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return user;
    }
    private static boolean sex(String sex)
    {
        boolean flag = false;
        if(sex.equals("1"))
        {
            flag = true;
        }
        else if(sex.equals("0"))
        {
            flag = false;
        }
        return  flag;
    }
}
