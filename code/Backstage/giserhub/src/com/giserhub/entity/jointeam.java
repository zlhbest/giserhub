package com.giserhub.entity;

public class jointeam
{
    private int SQ_id;
    private int T_id;
    private int U_id;
    private boolean SQ_state;
    private int I_id;

    public int getSQ_id() {
        return SQ_id;
    }

    public void setSQ_id(int SQ_id) {
        this.SQ_id = SQ_id;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public boolean isSQ_state() {
        return SQ_state;
    }

    public void setSQ_state(boolean SQ_state) {
        this.SQ_state = SQ_state;
    }

    public int getI_id() {
        return I_id;
    }

    public void setI_id(int i_id) {
        I_id = i_id;
    }
}
