package com.giserhub.entity;

import com.giserhub.entity.other.Questiontype;

import javax.xml.crypto.Data;

public class Question extends  entity{
    private int Q_id;//问题id
    private Questiontype Q_type;
    private String Q_Summary;
    private String Q_Content;
    private String U_NickName;
    private int Q_Good;
    private boolean Q_EnabledMark;
    private String Q_Reason;
    private String  Q_datetime;
    private boolean Q_SetUp;
    private boolean Q_finish;
    private boolean Q_DelectMack;
    private int A_id;
    private boolean Q_state;
    private int Q_liulan;
    private int Q_pinglun;
    private String U_HeadIcon;

    public String getU_HeadIcon() {
        return U_HeadIcon;
    }

    public void setU_HeadIcon(String u_HeadIcon) {
        U_HeadIcon = u_HeadIcon;
    }

    public int getQ_liulan() {
        return Q_liulan;
    }

    public void setQ_liulan(int q_liulan) {
        Q_liulan = q_liulan;
    }

    public int getQ_pinglun() {
        return Q_pinglun;
    }

    public void setQ_pinglun(int q_pinglun) {
        Q_pinglun = q_pinglun;
    }

    public int getQ_id() {
        return Q_id;
    }

    public void setQ_id(int q_id) {
        Q_id = q_id;
    }

    public Questiontype getQ_type() {
        return Q_type;
    }

    public void setQ_type(Questiontype q_type) {
        Q_type = q_type;
    }

    public String getQ_Summary() {
        return Q_Summary;
    }

    public void setQ_Summary(String q_Summary) {
        Q_Summary = q_Summary;
    }

    public String getQ_Content() {
        return Q_Content;
    }

    public void setQ_Content(String q_Content) {
        Q_Content = q_Content;
    }

    public String getU_NickName() {
        return U_NickName;
    }

    public void setU_NickName(String u_NickName) {
        U_NickName = u_NickName;
    }

    public int getQ_Good() {
        return Q_Good;
    }

    public void setQ_Good(int q_Good) {
        Q_Good = q_Good;
    }

    public boolean isQ_EnabledMark() {
        return Q_EnabledMark;
    }

    public void setQ_EnabledMark(boolean q_EnabledMark) {
        Q_EnabledMark = q_EnabledMark;
    }

    public String getQ_Reason() {
        return Q_Reason;
    }

    public void setQ_Reason(String q_Reason) {
        Q_Reason = q_Reason;
    }

    public String getQ_datetime() {
        return Q_datetime;
    }

    public void setQ_datetime(String q_datetime) {
        Q_datetime = q_datetime;
    }

    public boolean isQ_SetUp() {
        return Q_SetUp;
    }

    public void setQ_SetUp(boolean q_SetUp) {
        Q_SetUp = q_SetUp;
    }

    public boolean isQ_finish() {
        return Q_finish;
    }

    public void setQ_finish(boolean q_finish) {
        Q_finish = q_finish;
    }

    public boolean isQ_DelectMack() {
        return Q_DelectMack;
    }

    public void setQ_DelectMack(boolean q_DelectMack) {
        Q_DelectMack = q_DelectMack;
    }

    public int getA_id() {
        return A_id;
    }

    public void setA_id(int a_id) {
        A_id = a_id;
    }

    public boolean isQ_state() {
        return Q_state;
    }

    public void setQ_state(boolean q_state) {
        Q_state = q_state;
    }


    @Override
    public boolean getsex() {
        return false;
    }
}
