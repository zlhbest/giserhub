package com.giserhub.tool.team;

import com.giserhub.entity.Team;
import net.sf.json.JSONObject;

import java.sql.ResultSet;

public class teamfuzhi {
    public  static void fuzhi(JSONObject json, int U_id, Team team)
    {
        team.setT_name(json.getString("T_Name"));
        team.setU_id(U_id);
        team.setT_Count(Integer.parseInt(json.getString("T_Count")));
    }
    public static void fuzhi(ResultSet rs,Team team)throws Exception
    {
        team.setI_id(Integer.parseInt(rs.getString("T_id")));
    }
}
