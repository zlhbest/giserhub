package com.giserhub.entity;

import javax.xml.crypto.Data;

public class MessageBoard extends  entity{
    private int MB_id;
    private int U_id;
    private int Q_id;
    private String MB_Content;
    private int MB_mbid;
    private String U_idName;//返回的是这条留言的用户昵称
    private String MB_mbidName;//返回该用户评论的用户昵称
    private boolean MB_Nature;
    private String MB_date;
    private String U_HeadIcon;

    public String getU_HeadIcon() {
        return U_HeadIcon;
    }

    public void setU_HeadIcon(String u_HeadIcon) {
        U_HeadIcon = u_HeadIcon;
    }

    public String getMB_date() {
        return MB_date;
    }

    public void setMB_date(String MB_date) {
        this.MB_date = MB_date;
    }

    public String getMB_mbidName() {
        return MB_mbidName;
    }

    public void setMB_mbidName(String MB_mbidName) {
        this.MB_mbidName = MB_mbidName;
    }

    public int getMB_U_id() {
        return MB_U_id;
    }

    public void setMB_U_id(int MB_U_id) {
        this.MB_U_id = MB_U_id;
    }

    private int MB_U_id;

    public String getU_idName() {
        return U_idName;
    }

    public void setU_idName(String u_NickName) {
        U_idName = u_NickName;
    }

    private boolean MB_DelectMack;

    public int getMB_id() {
        return MB_id;
    }

    public void setMB_id(int MB_id) {
        this.MB_id = MB_id;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public int getQ_id() {
        return Q_id;
    }

    public void setQ_id(int q_id) {
        Q_id = q_id;
    }

    public String getMB_Content() {
        return MB_Content;
    }

    public void setMB_Content(String MB_Content) {
        this.MB_Content = MB_Content;
    }


    public int getMB_mbid() {
        return MB_mbid;
    }

    public void setMB_mbid(int MB_mbid) {
        this.MB_mbid = MB_mbid;
    }

    public boolean isMB_Nature() {
        return MB_Nature;
    }

    public void setMB_Nature(boolean MB_Nature) {
        this.MB_Nature = MB_Nature;
    }

    public boolean isMB_DelectMack() {
        return MB_DelectMack;
    }

    public void setMB_DelectMack(boolean MB_DelectMack) {
        this.MB_DelectMack = MB_DelectMack;
    }

    @Override
    public boolean getsex() {
        return false;
    }


}
