package com.giserhub.dao.inf;

public interface jointeamdao  {
    public boolean Sqjointeam(int T_id,int U_id,int I_id);
    public boolean panduanjointeam(int SQ_EnableMark,String reason,int SQ_id,int U_id,int T_id);
    //还需要两个接口，用于申请者获取自己的申请，用于团队发起者审核
}
