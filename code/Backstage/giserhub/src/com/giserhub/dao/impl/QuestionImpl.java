package com.giserhub.dao.impl;

import com.giserhub.dao.inf.Questiondao;
import com.giserhub.entity.Question;
import com.giserhub.entity.other.QuestioncInt;
import com.giserhub.tool.question.Questiontool;
import com.giserhub.tool.question.questiontype;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuestionImpl implements Questiondao {
    @Override
    public ArrayList<Question> getAllEnablequestion(int pageNo,int pageSize) {
        ArrayList<Question> questions = new ArrayList<>();
        try
        {
            int limitno = (pageNo-1)*pageSize;
            int limitSize = pageSize;
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append(" SELECT q.Q_id,q.Q_type,q.Q_Summary,q.Q_Good,q.Q_SetUp,q.U_id,q.Q_finish,u.U_NickName,q.Q_datetime,q.Q_liulan,q.Q_pinglun,u.U_HeadIcon" )
                    .append("   FROM question q,user u" )
                    .append("  WHERE q.Q_EnabledMark=1 ")
                    .append("    AND q.Q_DelectMack=0" )
                    .append("    AND q.Q_state=1 " )
                    .append("    AND u.U_id = q.U_id" )
                    .append("    ORDER BY q.Q_datetime DESC")
                    .append("    limit " +limitno+","+limitSize);
            System.out.println(sql);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Question question = new Question();
                Questiontool.fuzhi(rs,question,QuestioncInt.geAllEnablequestion);
                questions.add(question);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return questions;
    }
    @Override
    public ArrayList<Question> getAllUnauditedquestion(int pageNo, int pageSize) {
        ArrayList<Question> questions = new ArrayList<>();
        try
        {
            int limitno = (pageNo-1)*pageSize;
            int limitSize = pageSize;
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append(" SELECT u.U_NickName,q.*" )
                    .append("   FROM question q ,`user` u" )
                    .append("  WHERE u.U_id = q.U_id")
                    .append("    ORDER BY q.Q_datetime DESC")
                    .append("    limit " +limitno+","+limitSize);
            System.out.println(sql);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Question question = new Question();
                Questiontool.fuzhi(rs,question,QuestioncInt.getAllUnauditedquestion);
                questions.add(question);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return questions;
    }
    @Override
    public Question getselectquestion(int questionid) {
        Question question = new Question();
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT q.*,u.U_NickName,u.U_HeadIcon")
                    .append("  FROM question q,user u")
                    .append(" WHERE q.Q_id="+questionid)
                    .append("   AND u.U_id=q.U_id");
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Questiontool.fuzhi(rs,question,QuestioncInt.getselectquestion);
            }
            StringBuilder sqlfuzhi = new StringBuilder()
                    .append("UPDATE question")
                    .append("      SET question.Q_liulan = question.Q_liulan+1")
                    .append("  WHERE question.Q_id = "+questionid);
            DBconn.addUpdDel(sqlfuzhi.toString());
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return question;
    }
    @Override
    public boolean updatequestion(Question question) {
        boolean flag = false;
        String isQ_EnabledMark = question.isQ_EnabledMark()?"1":"0";
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("UPDATE question q")
                    .append("   SET q.Q_state= 1")
                    .append("	 ,q.Q_Reason = "+"\""+question.getQ_Reason()+"\"")
                    .append("	 ,q.Q_EnabledMark="+isQ_EnabledMark)
                    .append("   ,q.A_id = "+question.getA_id())
                    .append(" WHERE q.Q_id = "+question.getQ_id());
            System.out.println(sql.toString());
           int result =  DBconn.addUpdDel(sql.toString());
            if(result>0)
            {
                flag = true;
            }else
            {
                flag = false;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    @Override
    public boolean updatequestionGood(int Q_id) {
        boolean flag = false;
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("UPDATE question q")
                    .append("   SET q.Q_Good = q.Q_Good+1")
                    .append(" WHERE q.Q_id = "+Q_id);
            System.out.println(sql.toString());
            int result =  DBconn.addUpdDel(sql.toString());
            if(result>0)
            {
                flag = true;
            }else
            {
                flag = false;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    @Override
    public boolean insertquestion(Question question,int U_id) {
        boolean flag = false;
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO question(Q_type,Q_Summary,Q_Content,")
                    .append("						U_id,Q_Good,Q_EnabledMark,Q_Reason,")
                    .append("						Q_datetime,Q_SetUp,Q_finish,Q_DelectMack,")
                    .append("						A_id,Q_state)")
                    .append("     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            Object[] val = {
                    questiontype.questiontypeTonumber(question.getQ_type()),question.getQ_Summary(),question.getQ_Content(),
              U_id,0,0,"", date,0,0,0,0,0
            };
            flag = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
}
