package com.giserhub.dao.impl;

import com.giserhub.dao.inf.Ideadao;
import com.giserhub.entity.Idea;
import com.giserhub.entity.Team;
import com.giserhub.entity.other.Ideainterface;
import com.giserhub.tool.idea.ideafuzhi;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IdeaImpl implements Ideadao {
    @Override
    public ArrayList<Idea> getAllPublicIdea(int pageNo, int pageSize)
    {
        ArrayList<Idea> ideas = new ArrayList<>();
        int limitno = (pageNo-1)*pageSize;
        int limitSize = pageSize;
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT idea.I_id,idea.I_Summary,idea.I_date,`user`.U_NickName,team.T_Name")
                    .append("	FROM idea,`user`,team")
                    .append(" WHERE idea.I_state = 1")
                    .append("	 AND idea.I_EnableMark = 1")
                    .append("   AND idea.I_shenhe = 1")
                    .append("   AND `user`.U_id = idea.U_id")
                    .append("   AND team.T_id = idea.T_id")
                    .append("    ORDER BY idea.I_date DESC")
                    .append("   limit " +limitno+","+limitSize);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Idea idea = new Idea();
                ideafuzhi.fuzhi(rs,idea,Ideainterface.getAllPublicIdea);
                ideas.add(idea);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return ideas;
    }
    @Override
    public ArrayList<Idea> getAllPrivateIdea(int pageNo, int pageSize,int U_id)
    {
        ArrayList<Idea> ideas = new ArrayList<>();
        int limitno = (pageNo-1)*pageSize;
        int limitSize = pageSize;
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT idea.I_id,idea.I_Summary,idea.I_date,`user`.U_NickName,team.T_Name")
                    .append("	FROM idea,`user`,team")
                    .append(" WHERE idea.I_state = 0")
                    .append("	 AND idea.I_EnableMark = 1")
                    .append("   AND idea.I_shenhe = 1")
                    .append("   AND `user`.U_id = "+U_id)
                    .append("   AND team.T_id = idea.T_id")
                    .append("   AND idea.U_id = "+U_id)
                    .append("    ORDER BY idea.I_date DESC")
                    .append("   limit " +limitno+","+limitSize);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Idea idea = new Idea();
                ideafuzhi.fuzhi(rs,idea,Ideainterface.getAllPrivateIdea);
                ideas.add(idea);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return ideas;
    }
    @Override
    public boolean insertPrivateIdea(Idea idea)
    {
        boolean flag = false;
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO idea(U_id,I_state,I_Summary,")
                    .append("					  I_Contect,I_project,I_Plan,")
                    .append("						T_id,I_T_count,I_Good,I_date,")
                    .append("						I_EnableMark,PI_FinishMark,")
                    .append("						PI_Reason,I_DelectMark,I_shenhe)")
                    .append("     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            Object[] val = {
                    idea.getU_id(),0,idea.getI_Summary(),idea.getI_Contect(),idea.getI_project(),
                    idea.getI_Plan(),0,0,0,date,1,0,"",0,0
            };
            flag = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    @Override
    public boolean insertPublicIdea(Idea idea) {
        boolean flag = false;
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try
        {
            DBconn.init();
            String sqlteam = "SELECT team.*  FROM team   WHERE team.T_id = "+idea.getT_id();
            Team team = new Team();
            ResultSet rsteam =  DBconn.selectSql(sqlteam);
            while (rsteam.next())
            {
                team.setT_Count(Integer.parseInt(rsteam.getString("T_Count")));
            }
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO idea(U_id,I_state,I_Summary,")
                    .append("					  I_Contect,I_project,I_Plan,")
                    .append("						T_id,I_T_count,I_Good,I_date,")
                    .append("						I_EnableMark,PI_FinishMark,")
                    .append("						PI_Reason,I_DelectMark,I_shenhe)")
                    .append("     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            Object[] val = {
                    idea.getU_id(),1,idea.getI_Summary(),idea.getI_Contect(),idea.getI_project(),
                    idea.getI_Plan(),idea.getI_id(),team.getT_Count(),0,date,1,0,"",0,0
            };
            flag = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
            if (flag)
            {
                String sql1 = "UPDATE team    SET team.I_id =  "+idea.getI_id()+"   WHERE team.T_id ="+idea.getT_id();
                DBconn.addUpdDel(sql1);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    //用于用户将私有的idea转成公有的idea
    @Override
    public boolean PrivateToPublic(Idea idea) {
        boolean falg=false;
        try
        {
            DBconn.init();
            String sqlteam = "SELECT team.*  FROM team   WHERE team.T_id = "+idea.getT_id();
            Team team = new Team();
            ResultSet rsteam =  DBconn.selectSql(sqlteam);
            while (rsteam.next())
            {
                team.setT_Count(Integer.parseInt(rsteam.getString("T_Count")));
            }
            StringBuilder sql = new StringBuilder()
                    .append("UPDATE idea")
                    .append("   SET idea.I_state = 1")
                    .append("      ,idea.I_Summary = ?")
                    .append("      ,idea.I_Contect = ?")
                    .append("      ,idea.I_project = ?")
                    .append("      ,idea.I_Plan = ?")
                    .append("      ,idea.T_id = ?")
                    .append("      ,idea.I_T_count = ?")
                    .append(" WHERE idea.I_id = ?");
            Object[] val = {
                    idea.getI_Summary(),
                    idea.getI_Contect(),
                    idea.getI_project(),
                    idea.getI_Plan(),
                    idea.getT_id(),
                    team.getT_Count(),
                    idea.getI_id()
            };
            falg = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
            if (falg)
            {
                String sql1 = "UPDATE team    SET team.I_id =  "+idea.getI_id()+"   WHERE team.T_id ="+idea.getT_id();
                DBconn.addUpdDel(sql1);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  falg;
    }
    @Override
    public ArrayList<Idea> getALLPublicIdeafoeadm(int pageNo, int pageSize)
    {
        ArrayList<Idea> ideas = new ArrayList<>();
        int limitno = (pageNo-1)*pageSize;
        int limitSize = pageSize;
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT idea.I_id,idea.I_Summary,u.U_NickName,idea.I_date,idea.I_shenhe,idea.I_EnableMark")
                    .append("  FROM idea,`user` u")
                    .append(" WHERE idea.I_state = 1")
                    .append("   AND u.U_id = idea.U_id")
                    .append(" ORDER BY idea.I_date DESC")
                    .append(" LIMIT "+limitno+","+limitSize);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Idea idea = new Idea();
                ideafuzhi.fuzhi(rs,idea,Ideainterface.getALLPublicIdeafoeadm);
                ideas.add(idea);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return ideas;
    }

    @Override
    public Idea getPublicIdeaByid(int I_id)
    {
        Idea idea = new Idea();
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT idea.*,`user`.U_NickName,team.T_Name")
                    .append("  FROM idea,`user`,team")
                    .append(" WHERE idea.I_id = "+I_id)
                    .append("   AND `user`.U_id = idea.U_id")
                    .append("   AND team.T_id = idea.U_id");
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                ideafuzhi.fuzhi(rs,idea,Ideainterface.getPublicIdeaforadm);
            }
            DBconn.closeConn();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return idea;
    }

    @Override
    public boolean UpdatePublicIdeashenhe(int I_id,int I_EnableMark,String reason)
    {
        boolean flag = false;
        try
        {
            DBconn.init();
            StringBuilder sql  = new StringBuilder()
                    .append("UPDATE idea ")
                    .append("   SET idea.I_EnableMark = "+I_EnableMark+",idea.I_shenhe = 1 ,idea.PI_Reason"+reason)
                    .append("  WHERE idea.I_id="+I_id);
            flag = DBconn.addUpdDel(sql.toString())>0?true:false;
            DBconn.closeConn();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
}
