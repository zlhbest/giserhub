package com.giserhub.dao.impl;
import java.io.File;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.giserhub.dao.inf.Userdao;
import com.giserhub.entity.Question;
import com.giserhub.entity.User;
import com.giserhub.entity.other.QuestioncInt;
import com.giserhub.tool.login.login;
import com.giserhub.tool.question.Questiontool;
import com.giserhub.tool.register.MadeUserId;
import com.giserhub.tool.register.register;
import com.giserhub.tool.system.CookieMade;
import com.giserhub.util.DBconn;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDaoImpl implements Userdao {
    //登录功能实现
    @Override
    public String[] login(String name, String pwd) {
        String cookie[]  =new String[3];
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT *")
                    .append("  FROM user");
            login.userloginfunsql(name,pwd,sql);
            System.out.println(sql.toString());
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                if(rs.getString("U_id")!=null) {
                    cookie = login.userloginfunres(name, pwd, rs);
                }
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cookie;
    }
    //注册功能实现
    @Override
    public int register(User user) {
        int mark = -1;
        try
        {
            SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
            String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            DBconn.init();
            if(register.userregisterIsrepace(user)==1)
            {
                System.out.println("nick有重复");
                mark = 1;
            }
            else if(register.userregisterIsrepace(user)==2)
            {
                System.out.println("email重复");
                mark = 2;
            }
            else if(register.userregisterIsrepace(user)==0){
                StringBuilder sql = new StringBuilder()
                        .append("INSERT INTO user(U_Account,U_NickName,U_PassWord,U_HeadIcon,")
                        .append("                   U_Gender,U_Email,U_DeleteMark,U_CreatorTime,")
                        .append("                   U_Q_count,U_LDS_count,U_I_count,U_T_count,U_passwordforback)")
                        .append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                user.setU_Account(MadeUserId.madeUserid(user));
                Object[] val = {
                        user.getU_Account(), user.getU_NickName(), user.getU_PassWor(),"wu",
                        user.getU_Gender(), user.getU_Email(), 0, date, 0, 0, 0, 0, user.getU_passwordforback()
                };
                int result = DBconn.addUpdDel(sql.toString(), val);
                if (result > 0) {
                    System.out.println("添加成功");
                   mark = 0;
                } else {
                    System.out.println("添加失败");
                    mark = -1;
                }
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mark;
    }

    @Override
    public boolean updatetouxiang(int id, HttpServletRequest request, HttpServletResponse response) {
        boolean flag =false;
        try
        {
            DBconn.init();
            DiskFileItemFactory dff = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dff);
            List<FileItem> items = sfu.parseRequest(request);
            for(FileItem item:items)
            {
                if(item.isFormField()){}
                else {
                    String filename = item.getName();
                    if(filename !=null)
                    {
                        filename = UserDaoImpl.generateGUID() + "." + FilenameUtils.getExtension(filename);
                    }
                    // 生成存储路径
                    String storeDirectory = "C:/Tomcat 8.5/webapps/files/images/";
                    File file = new File(storeDirectory);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    String path = genericPath(filename, storeDirectory);
                    // 处理文件的上传
                    try
                    {
                        item.write(new File(storeDirectory + path, filename));
                        String sqlHeadIcon = "SELECT `user`.U_HeadIcon   FROM `user`    WHERE `user`.U_id = "+id;
                        ResultSet rs=DBconn.selectSql(sqlHeadIcon);
                        String HeafIcon="";
                        while (rs.next())
                        {
                            HeafIcon = rs.getString("U_HeadIcon");
                        }
                        if(!HeafIcon.equals("")) {
                            String PathName = "C:/Tomcat 8.5/webapps/" + HeafIcon;
                            deleteFile(PathName);
                        }
                        String filePath = "files/images" + path +"/"+ filename;
                        String sql = "UPDATE `user`    SET `user`.U_HeadIcon = \""+filePath+"\"   WHERE `user`.U_id =  "+id;
                        flag = DBconn.addUpdDel(sql)>0?true:false;
                        if(flag)
                        {
                            CookieMade.writecookieHI(response,filePath);
                        }
                    }catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }

    /**
     * 这是通过用户显示id操作的，查出此用户的问题信息
     * @param id
     * @param pageno
     * @param pagesize
     * @return
     */
    @Override
    public ArrayList<Question> selectquestionbyid(int id, int pageno, int pagesize) {
        ArrayList<Question> questions = new ArrayList<>();
        try
        {
            int limitno = (pageno-1)*pagesize;
            int limitSize = pagesize;
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append(" SELECT q.Q_id,q.Q_type,q.Q_Summary,q.Q_Good,q.Q_SetUp,q.Q_finish,q.Q_datetime" )
                    .append("   FROM question q " )
                    .append("  WHERE q.Q_EnabledMark=1 ")
                    .append("    AND q.Q_DelectMack=0" )
                    .append("    AND q.Q_state=1 " )
                    .append("    AND q.U_id="+id)
                    .append("    limit " +limitno+","+limitSize);
            System.out.println(sql);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Question question = new Question();
                Questiontool.fuzhi(rs,question,QuestioncInt.selectquestionbyid);
                questions.add(question);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return questions;
    }

    /**
     * 生成UUID
     *
     * @return UUID
     */
    public static String generateGUID() {
        return new BigInteger(165, new Random()).toString(36).toUpperCase();
    }
    // 计算文件的存放目录
    private String genericPath(String filename, String storeDirectory) {
        int hashCode = filename.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>4;

        String dir = "/"+dir1+"/"+dir2;

        File file = new File(storeDirectory,dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
    public boolean deleteFile(String fileName){
        File file = new File(fileName);
        if(file.isFile() && file.exists()){
            Boolean succeedDelete = file.delete();
            if(succeedDelete){
                System.out.println("删除单个文件"+fileName+"成功！");
                return true;
            }
            else{
                System.out.println("删除单个文件"+fileName+"失败！");
                return true;
            }
        }else{
            System.out.println("删除单个文件"+fileName+"失败！");
            return false;
        }
    }
}
