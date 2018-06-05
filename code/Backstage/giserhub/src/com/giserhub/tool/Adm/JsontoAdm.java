package com.giserhub.tool.Adm;

import com.giserhub.entity.Administrator;
import com.giserhub.entity.User;
import com.giserhub.tool.system.md5;
import net.sf.json.JSONObject;

public class JsontoAdm {
    public static Administrator jsontoadm(String json)
    {
        Administrator administrator = new Administrator();
        try {
            JSONObject jsonobject = JSONObject.fromObject(json);//将json字符串转换为数组
            administrator.setA_NickName(jsonobject.getString("nick"));//昵称
            administrator.setA_PassWord(md5.getMd5Code(jsonobject.getString("pwd")));
            administrator.setA_Gender(sex(jsonobject.getString("sex"))) ;
            administrator.setA_Email(jsonobject.getString("email"));
            administrator.setA_PassWordforback(jsonobject.getString("pwd"));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return administrator;
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
