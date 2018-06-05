package com.giserhub.dao.impl;

import com.giserhub.dao.inf.jointeamdao;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;

public class jointeamImpl implements jointeamdao {
    @Override
    public boolean Sqjointeam(int T_id, int U_id, int I_id)
    {
        boolean flag = false;
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO jointeam(T_id,U_id,SQ_state,I_id,SQ_EnableMark)")
                    .append("      VALUES(?,?,?,?,?)");
            Object[] val ={
                    T_id,U_id,0,I_id,0
            };
            flag = DBconn.addUpdDel(sql.toString(),val)>0;
            DBconn.closeConn();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean panduanjointeam(int SQ_EnableMark, String reason, int SQ_id,int U_id,int T_id)
    {
        boolean flag = false;
        try
        {
            DBconn.init();
            if(SQ_EnableMark==0) {
                StringBuilder sql = new StringBuilder()
                        .append("UPDATE jointeam")
                        .append("   SET jointeam.SQ_state = 1")
                        .append("     , jointeam.SQ_reason = \"" + reason + "\"")
                        .append("     , jointeam.SQ_EnableMark = 0")
                        .append(" WHERE jointeam.SQ_id = " + SQ_id);
                flag = DBconn.addUpdDel(sql.toString()) > 0;
            }
            //如果用户同意，jointeam修改状态，
            // 那么将申请用户的id添加到user的U_T_id添加用户加入的团队id字符串，更新用户的加入队伍数量，
            //team表更新U_ALL_id的字符串，
            //idea表的I_T_Count_now修改加一
            else if(SQ_EnableMark==1)
            {
                String U_T_id = "";//用于方便用户查询加入了多少的idea团队
                String U_ALL_id = "";//用于修改team中的团队成员
                StringBuilder sqljointeam = new StringBuilder()
                        .append("UPDATE jointeam")
                        .append("   SET jointeam.SQ_state = 1")
                        .append("     , jointeam.SQ_EnableMark = 1")
                        .append(" WHERE jointeam.SQ_id = " + SQ_id);
                boolean one = DBconn.addUpdDel(sqljointeam.toString())>0;
                //通过用户的id获取到用户参与的队伍字符串
                StringBuilder sqlU_T_id = new StringBuilder()
                        .append(" SELECT user.U_T_id")
                        .append("  FROM   user" )
                        .append(" WHERE user.U_id = " + U_id);
                ResultSet rs = DBconn.selectSql(sqlU_T_id.toString());
                while (rs.next())
                {
                    U_T_id = rs.getString("U_T_id");
                    U_T_id = U_T_id+T_id+"#";
                }
                //user中已经改掉了加入的团队id和加入的院队数
                StringBuilder sqluser = new StringBuilder()
                        .append("UPDATE user")
                        .append("   SET user.U_T_id = "+U_T_id)
                        .append("        ,`user`.U_T_count = `user`.U_T_count +1")
                        .append(" WHERE user.U_id = " + U_id);
               boolean two= DBconn.addUpdDel(sqluser.toString())>0;
                //用于修改team中的院队成员
                //首先获取到U_ALL_id
                StringBuilder sqlU_ALL_id = new StringBuilder()
                        .append(" SELECT team.U_ALL_id")
                        .append("   FROM team" )
                        .append("  WHERE team.T_id = " + T_id);
                ResultSet rsU_ALL_id = DBconn.selectSql(sqlU_ALL_id.toString());
                while (rsU_ALL_id.next())
                {
                    U_ALL_id = rs.getString("U_ALL_id");
                    U_ALL_id = U_ALL_id+U_id+"#";
                }
                //将U_ALL_id写入数据库
                StringBuilder sqlU_ALL_id1 = new StringBuilder()
                        .append("UPDATE team")
                        .append("   SET team.U_ALL_id = "+U_ALL_id)
                        .append(" WHERE team.U_id = " + U_id);
               boolean three =  DBconn.addUpdDel(sqlU_ALL_id1.toString())>0;
                //将idea的I_T_Count_now加一
                int I_id = 0;
                StringBuilder sqlfindI_id = new StringBuilder()
                        .append("SELECT jointeam.I_id")
                        .append("   FROM jointeam ")
                        .append("   WHERE jointeam.SQ_id = "+SQ_id);
                ResultSet rsfindI_id = DBconn.selectSql(sqlfindI_id.toString());
                while (rsfindI_id.next())
                {
                    I_id = Integer.parseInt(rsfindI_id.getString("I_id"));
                }
                StringBuilder sqlI_T_Count_now = new StringBuilder()
                        .append("UPDATE idea")
                        .append("   SET idea.I_T_Count_now = idea.I_T_Count_now+1")
                        .append("  WHERE idea.I_id = "+I_id);
               boolean four =  DBconn.addUpdDel(sqlI_T_Count_now.toString())>0;
                if(one && two && three && four)
                {
                    flag = true;
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  flag;
    }
}
