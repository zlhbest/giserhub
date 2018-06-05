package com.giserhub.entity;

import javax.xml.crypto.Data;

public class Idea extends entity{
    private int I_id;
    private int U_id;
    private String U_id_name;
    private boolean I_state;//私有还是公有
    private String I_Summary;
    private String I_Contect;
    private String I_project;
    private String I_Plan;
    private int T_id;
    private String T_id_name;
    private int I_T_Count;
    private int I_T_Count_now;
    private int I_Good;
    private String I_date;
    private boolean I_EnableMark;
    private boolean PI_Finish;
    private String PI_Reason;
    private boolean I_DelectMark;
    private boolean I_shenhe;
    public boolean isI_shenhe() {
        return I_shenhe;
    }

    public String getU_id_name() {
        return U_id_name;
    }

    public void setU_id_name(String u_id_name) {
        U_id_name = u_id_name;
    }

    public String getT_id_name() {
        return T_id_name;
    }

    public void setT_id_name(String t_id_name) {
        T_id_name = t_id_name;
    }

    public void setI_shenhe(boolean i_shenhe) {
        I_shenhe = i_shenhe;
    }

    public int getI_id() {
        return I_id;
    }

    public void setI_id(int i_id) {
        I_id = i_id;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public boolean isI_state() {
        return I_state;
    }

    public void setI_state(boolean i_state) {
        I_state = i_state;
    }

    public String getI_Summary() {
        return I_Summary;
    }

    public void setI_Summary(String i_Summary) {
        I_Summary = i_Summary;
    }

    public String getI_Contect() {
        return I_Contect;
    }

    public void setI_Contect(String i_Contect) {
        I_Contect = i_Contect;
    }

    public String getI_project() {
        return I_project;
    }

    public void setI_project(String i_project) {
        I_project = i_project;
    }

    public String getI_Plan() {
        return I_Plan;
    }

    public void setI_Plan(String i_Plan) {
        I_Plan = i_Plan;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    public int getI_T_Count() {
        return I_T_Count;
    }

    public void setI_T_Count(int i_T_Count) {
        I_T_Count = i_T_Count;
    }

    public int getI_Good() {
        return I_Good;
    }

    public void setI_Good(int i_Good) {
        I_Good = i_Good;
    }

    public String getI_date() {
        return I_date;
    }

    public void setI_date(String i_date) {
        I_date = i_date;
    }

    public boolean isI_EnableMark() {
        return I_EnableMark;
    }

    public void setI_EnableMark(boolean i_EnableMark) {
        I_EnableMark = i_EnableMark;
    }

    public boolean isPI_Finish() {
        return PI_Finish;
    }

    public void setPI_Finish(boolean PI_Finish) {
        this.PI_Finish = PI_Finish;
    }

    public String getPI_Reason() {
        return PI_Reason;
    }

    public void setPI_Reason(String PI_Reason) {
        this.PI_Reason = PI_Reason;
    }

    public boolean isI_DelectMark() {
        return I_DelectMark;
    }

    public void setI_DelectMark(boolean i_DelectMark) {
        I_DelectMark = i_DelectMark;
    }

    public int getI_T_Count_now() {
        return I_T_Count_now;
    }

    public void setI_T_Count_now(int i_T_Count_now) {
        I_T_Count_now = i_T_Count_now;
    }

    @Override
    public boolean getsex() {
        return false;
    }
}
