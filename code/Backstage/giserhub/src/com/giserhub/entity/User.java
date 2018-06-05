package com.giserhub.entity;

import javax.xml.crypto.Data;

public class User extends entity {
    private int U_id;//用户的id
    private String U_Account;//用户的账号
    private String U_NickName;//用户的昵称
    private String U_PassWor;//用户的密码
    private Boolean U_Gender;//用户性别
    private String U_HeadIcon;//用户的头像
    private String U_Email;//用户的电子邮件
    private Boolean U_CDelectMark;//用户是否删除的标志位
    private Data U_CreatorTime;//用户创建的时间
    private int U_Q_count;//用户的问题数目；
    private int U_LDS_count;//用户的学习资料数
    private int U_I_count;//用户的idea数目；
    private int U_T_count;//加入的队伍数
    private String U_T_id;//加入的团队,存的是问题的id，这样用来找到团队与idea挂接

    public String getU_T_id() {
        return U_T_id;
    }

    public void setU_T_id(String u_T_id) {
        U_T_id = u_T_id;
    }

    public String getU_passwordforback() {
        return U_passwordforback;
    }

    public void setU_passwordforback(String u_passwordforback) {
        U_passwordforback = u_passwordforback;
    }

    private String U_passwordforback;//为了找回密码

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getU_Account() {
        return U_Account;
    }

    public void setU_Account(String u_Account) {
        U_Account = u_Account;
    }

    public String getU_NickName() {
        return U_NickName;
    }

    public void setU_NickName(String u_NickName) {
        U_NickName = u_NickName;
    }

    public String getU_PassWor() {
        return U_PassWor;
    }

    public void setU_PassWor(String u_PassWor) {
        U_PassWor = u_PassWor;
    }

    public Boolean getU_Gender() {
        return U_Gender;
    }

    public void setU_Gender(Boolean u_Gender) {
        U_Gender = u_Gender;
    }

    public String getU_HeadIcon() {
        return U_HeadIcon;
    }

    public void setU_HeadIcon(String u_HeadIcon) {
        U_HeadIcon = u_HeadIcon;
    }

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }

    public Boolean getU_CDelectMark() {
        return U_CDelectMark;
    }

    public void setU_CDelectMark(Boolean u_CDelectMark) {
        U_CDelectMark = u_CDelectMark;
    }

    public Data getU_CreatorTime() {
        return U_CreatorTime;
    }

    public void setU_CreatorTime(Data u_CreatorTime) {
        U_CreatorTime = u_CreatorTime;
    }

    public int getU_Q_count() {
        return U_Q_count;
    }

    public void setU_Q_count(int u_Q_count) {
        U_Q_count = u_Q_count;
    }

    public int getU_LDS_count() {
        return U_LDS_count;
    }

    public void setU_LDS_count(int u_LDS_count) {
        U_LDS_count = u_LDS_count;
    }

    public int getU_I_count() {
        return U_I_count;
    }

    public void setU_I_count(int u_I_count) {
        U_I_count = u_I_count;
    }

    public int getU_T_count() {
        return U_T_count;
    }

    public void setU_T_count(int u_T_count) {
        U_T_count = u_T_count;
    }

    @Override
    public boolean getsex() {
        return this.getU_Gender();
    }
}


