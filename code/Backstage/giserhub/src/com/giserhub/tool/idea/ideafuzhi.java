package com.giserhub.tool.idea;

import com.giserhub.entity.Idea;
import com.giserhub.entity.other.Ideainterface;

import java.sql.ResultSet;

public class ideafuzhi {
    public static void fuzhi(ResultSet rs, Idea idea, Ideainterface ideainterface)
    {
        try {
            switch (ideainterface.toString())
            {
                case "getAllPublicIdea":
                    fuzhiall(rs,idea);
                    break;
                case "getAllPrivateIdea":
                    fuzhiall(rs,idea);
                    break;
                case "getALLPublicIdeafoeadm":
                    getALLPublicIdeafoeadm(rs,idea);
                    break;
                case "getPublicIdeaforadm":
                    getPublicIdeaforadmoruser(rs,idea);
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private static void fuzhiall(ResultSet rs, Idea idea) throws Exception
    {
        idea.setI_id(Integer.parseInt(rs.getString("I_id")));
        idea.setI_Summary(rs.getString("I_Summary"));
        idea.setU_id_name(rs.getString("U_NickName"));
        idea.setI_date(rs.getString("I_date"));
        idea.setT_id_name(rs.getString("T_Name"));
    }
    private static void getALLPublicIdeafoeadm(ResultSet rs, Idea idea) throws Exception
    {
        idea.setI_id(Integer.parseInt(rs.getString("I_id")));
        idea.setI_Summary(rs.getString("I_Summary"));
        idea.setU_id_name(rs.getString("U_NickName"));
        idea.setI_date(rs.getString("I_date"));
        idea.setI_shenhe(rs.getString("I_shenhe").equals("1")?true:false);
        idea.setI_EnableMark(rs.getString("I_EnableMark").equals("1")?true:false);
    }
    private static void getPublicIdeaforadmoruser(ResultSet rs, Idea idea)throws Exception
    {
        idea.setI_id(Integer.parseInt(rs.getString("I_id")));
        idea.setU_id(Integer.parseInt(rs.getString("U_id")));
        idea.setI_state(rs.getString("I_state").equals("1")?true:false);
        idea.setI_Summary(rs.getString("I_Summary"));
        idea.setI_Contect(rs.getString("I_Contect"));
        idea.setI_project(rs.getString("I_project"));
        idea.setI_Plan(rs.getString("I_Plan"));
        idea.setT_id(Integer.parseInt(rs.getString("T_id")));
        idea.setI_T_Count(Integer.parseInt(rs.getString("I_T_Count")));
        idea.setI_Good(Integer.parseInt(rs.getString("I_Good")));
        idea.setI_date(rs.getString("I_date"));
        idea.setI_EnableMark(rs.getString("I_EnableMark").equals("1")?true:false);
        idea.setPI_Finish(rs.getString("PI_FinishMark").equals("1")?true:false);
        idea.setPI_Reason(rs.getString("PI_Reason"));
        idea.setI_DelectMark(rs.getString("I_DelectMark").equals("1")?true:false);
        idea.setI_shenhe(rs.getString("I_shenhe").equals("1")?true:false);
        idea.setI_T_Count_now(Integer.parseInt(rs.getString("I_T_Count_now")));
        idea.setU_id_name(rs.getString("U_id_name"));
        idea.setT_id_name(rs.getString("T_id_name"));
    }
}
