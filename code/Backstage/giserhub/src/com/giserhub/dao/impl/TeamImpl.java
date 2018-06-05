package com.giserhub.dao.impl;

import com.giserhub.dao.inf.Teamdao;
import com.giserhub.entity.Team;
import com.giserhub.tool.idea.ideafuzhi;
import com.giserhub.tool.team.teamfuzhi;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TeamImpl implements Teamdao {
    @Override
    public int insertteam(Team team)
    {
        int T_id = 0;
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT team(T_Name,U_id,T_Count,U_ALL_id)")
                    .append("    VALUES(\""+team.getT_name()+"\","+team.getU_id()+","+team.getT_Count()+",0)");
            System.out.println(sql.toString());
            if(DBconn.addUpdDel(sql.toString())>0?true:false)
            {
                StringBuilder sqlselect = new StringBuilder()
                        .append("SELECT team.T_id")
                        .append("  FROM team")
                        .append(" WHERE team.T_Name = \""+team.getT_name()+"\"")
                        .append("   AND team.U_id="+team.getU_id())
                        .append("   AND team.T_Count = "+team.getT_Count());
                ResultSet rs = DBconn.selectSql(sqlselect.toString());
                System.out.println(sqlselect.toString());
                while (rs.next())
                {
                    T_id = Integer.parseInt(rs.getString("T_id"));
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return T_id;
    }
    //查找创建团队
    @Override
    public ArrayList<Team> selectteambyUid(int U_id)
    {
        ArrayList<Team> teams = new ArrayList<>();
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT team.*,idea.I_Summary,idea.I_T_count,idea.I_T_Count_now")
                    .append("   FROM team,idea")
                    .append("   WHERE idea.U_id =  " +U_id)
                    .append("   AND team.I_id = idea.I_id");
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                Team team = new Team();
                teamfuzhi.fuzhi(rs,team);
                teams.add(team);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return teams;
    }

    @Override
    public ArrayList<Team> selectjionteambyUid(int U_id)
    {
        ArrayList<Team> teams = new ArrayList<>();
        try
        {
            String teamlist  = "";//存储用户参与团队的表单
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                   .append(" SELECT `user`.U_T_id")
                    .append("   FROM `user` ")
                    .append("  WHERE `user`.U_id = "+U_id);
            ResultSet rs = DBconn.selectSql(sql.toString());
            while (rs.next())
            {
                teamlist = rs.getString("U_T_id");
            }
           String[] teamlistarray = teamlist.split("#");
            for(int i=0;i<teamlistarray.length;i++)
            {
                StringBuilder sqlforTid = new StringBuilder()
                        .append("SELECT team.*,idea.I_Summary,idea.I_T_count,idea.I_T_Count_now")
                        .append("   FROM team,idea")
                        .append("   WHERE idea.U_id =  " +teamlistarray[i])
                        .append("   AND team.I_id = idea.I_id");
                ResultSet rs1 = DBconn.selectSql(sqlforTid.toString());
                while (rs1.next())
                {
                    Team team = new Team();
                    teamfuzhi.fuzhi(rs1,team);
                    teams.add(team);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return teams;
    }
}
