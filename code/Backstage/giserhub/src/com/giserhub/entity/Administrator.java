package com.giserhub.entity;

import javax.xml.crypto.Data;

public class Administrator extends entity{
    private int A_id;
    private String A_Account;
    private String A_NickName;
    private String A_PassWord;
    private boolean A_Gender;
    private String A_HeadIcon;
    private String A_Email;
    private boolean A_DelectMark;
    private String A_CreatorTime;
    private String A_PassWordforback;
    public int getA_id() {
        return A_id;
    }

    public String getA_PassWordforback() {
        return A_PassWordforback;
    }

    public void setA_PassWordforback(String a_PassWordforback) {
        A_PassWordforback = a_PassWordforback;
    }

    public void setA_id(int a_id) {
        A_id = a_id;
    }

    public String getA_Account() {
        return A_Account;
    }

    public void setA_Account(String a_Account) {
        A_Account = a_Account;
    }

    public String getA_NickName() {
        return A_NickName;
    }

    public void setA_NickName(String a_NickName) {
        A_NickName = a_NickName;
    }

    public String getA_PassWord() {
        return A_PassWord;
    }

    public void setA_PassWord(String a_PassWord) {
        A_PassWord = a_PassWord;
    }

    public boolean isA_Gender() {
        return A_Gender;
    }

    public void setA_Gender(boolean a_Gender) {
        A_Gender = a_Gender;
    }

    public String getA_HeadIcon() {
        return A_HeadIcon;
    }

    public void setA_HeadIcon(String a_HeadIcon) {
        A_HeadIcon = a_HeadIcon;
    }

    public String getA_Email() {
        return A_Email;
    }

    public void setA_Email(String a_Email) {
        A_Email = a_Email;
    }

    public boolean isA_DelectMark() {
        return A_DelectMark;
    }

    public void setA_DelectMark(boolean a_DelectMark) {
        A_DelectMark = a_DelectMark;
    }

    public String getA_CreatorTime() {
        return A_CreatorTime;
    }

    public void setA_CreatorTime(String a_CreatorTime) {
        A_CreatorTime = a_CreatorTime;
    }
    @Override
    public boolean getsex() {
        return this.isA_Gender();
    }


}
