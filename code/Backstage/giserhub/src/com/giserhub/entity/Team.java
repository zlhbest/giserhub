package com.giserhub.entity;

public class Team {
    private int T_id;
    private String T_name;
    private int U_id;
    private int T_Count;
    private int U_ALL_id;
    private int I_id;
    private int I_T_Count_now;
    private String I_Summary;

    public int getI_T_Count_now() {
        return I_T_Count_now;
    }

    public void setI_T_Count_now(int i_T_Count_now) {
        I_T_Count_now = i_T_Count_now;
    }

    public String getI_Summary() {
        return I_Summary;
    }

    public void setI_Summary(String i_Summary) {
        I_Summary = i_Summary;
    }

    public int getI_id() {
        return I_id;
    }

    public void setI_id(int i_id) {
        I_id = i_id;
    }

    public int getU_ALL_id() {
        return U_ALL_id;
    }

    public void setU_ALL_id(int u_ALL_id) {
        U_ALL_id = u_ALL_id;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    public String getT_name() {
        return T_name;
    }

    public void setT_name(String t_name) {
        T_name = t_name;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public int getT_Count() {
        return T_Count;
    }

    public void setT_Count(int t_Count) {
        T_Count = t_Count;
    }
}
