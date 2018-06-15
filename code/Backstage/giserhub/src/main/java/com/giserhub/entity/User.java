package com.giserhub.entity;

public class User {
    private Integer id;

    private String sNickName;

    private String sPassword;

    private String sMobilephone;

    private String sEmail;

    private String sQq;

    private Integer sAge;

    private Boolean iSex;

    private String sRealName;

    private String sCollege;

    private String sSchool;

    private String sMajor;

    private Boolean bPerfectMark;

    private Integer iQuestionNumber;

    private Integer iQuestionAvailableNumber;

    private Integer iQuestionUnavailableNumber;

    private Integer iDataNumber;

    private Integer iDataAvailableNumber;

    private Integer iDataUnavailableNumber;

    private Integer iPublicIdeaNumber;

    private Integer iPublicIdeaAvailableNumber;

    private Integer iPublicIdeaUnavailableNumber;

    private Integer iPrivateIdeaNumber;

    private Integer iTeamCreateNumber;

    private Integer sTeamJoinId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsNickName() {
        return sNickName;
    }

    public void setsNickName(String sNickName) {
        this.sNickName = sNickName == null ? null : sNickName.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

    public String getsMobilephone() {
        return sMobilephone;
    }

    public void setsMobilephone(String sMobilephone) {
        this.sMobilephone = sMobilephone == null ? null : sMobilephone.trim();
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail == null ? null : sEmail.trim();
    }

    public String getsQq() {
        return sQq;
    }

    public void setsQq(String sQq) {
        this.sQq = sQq == null ? null : sQq.trim();
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public Boolean getiSex() {
        return iSex;
    }

    public void setiSex(Boolean iSex) {
        this.iSex = iSex;
    }

    public String getsRealName() {
        return sRealName;
    }

    public void setsRealName(String sRealName) {
        this.sRealName = sRealName == null ? null : sRealName.trim();
    }

    public String getsCollege() {
        return sCollege;
    }

    public void setsCollege(String sCollege) {
        this.sCollege = sCollege == null ? null : sCollege.trim();
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool == null ? null : sSchool.trim();
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor == null ? null : sMajor.trim();
    }

    public Boolean getbPerfectMark() {
        return bPerfectMark;
    }

    public void setbPerfectMark(Boolean bPerfectMark) {
        this.bPerfectMark = bPerfectMark;
    }

    public Integer getiQuestionNumber() {
        return iQuestionNumber;
    }

    public void setiQuestionNumber(Integer iQuestionNumber) {
        this.iQuestionNumber = iQuestionNumber;
    }

    public Integer getiQuestionAvailableNumber() {
        return iQuestionAvailableNumber;
    }

    public void setiQuestionAvailableNumber(Integer iQuestionAvailableNumber) {
        this.iQuestionAvailableNumber = iQuestionAvailableNumber;
    }

    public Integer getiQuestionUnavailableNumber() {
        return iQuestionUnavailableNumber;
    }

    public void setiQuestionUnavailableNumber(Integer iQuestionUnavailableNumber) {
        this.iQuestionUnavailableNumber = iQuestionUnavailableNumber;
    }

    public Integer getiDataNumber() {
        return iDataNumber;
    }

    public void setiDataNumber(Integer iDataNumber) {
        this.iDataNumber = iDataNumber;
    }

    public Integer getiDataAvailableNumber() {
        return iDataAvailableNumber;
    }

    public void setiDataAvailableNumber(Integer iDataAvailableNumber) {
        this.iDataAvailableNumber = iDataAvailableNumber;
    }

    public Integer getiDataUnavailableNumber() {
        return iDataUnavailableNumber;
    }

    public void setiDataUnavailableNumber(Integer iDataUnavailableNumber) {
        this.iDataUnavailableNumber = iDataUnavailableNumber;
    }

    public Integer getiPublicIdeaNumber() {
        return iPublicIdeaNumber;
    }

    public void setiPublicIdeaNumber(Integer iPublicIdeaNumber) {
        this.iPublicIdeaNumber = iPublicIdeaNumber;
    }

    public Integer getiPublicIdeaAvailableNumber() {
        return iPublicIdeaAvailableNumber;
    }

    public void setiPublicIdeaAvailableNumber(Integer iPublicIdeaAvailableNumber) {
        this.iPublicIdeaAvailableNumber = iPublicIdeaAvailableNumber;
    }

    public Integer getiPublicIdeaUnavailableNumber() {
        return iPublicIdeaUnavailableNumber;
    }

    public void setiPublicIdeaUnavailableNumber(Integer iPublicIdeaUnavailableNumber) {
        this.iPublicIdeaUnavailableNumber = iPublicIdeaUnavailableNumber;
    }

    public Integer getiPrivateIdeaNumber() {
        return iPrivateIdeaNumber;
    }

    public void setiPrivateIdeaNumber(Integer iPrivateIdeaNumber) {
        this.iPrivateIdeaNumber = iPrivateIdeaNumber;
    }

    public Integer getiTeamCreateNumber() {
        return iTeamCreateNumber;
    }

    public void setiTeamCreateNumber(Integer iTeamCreateNumber) {
        this.iTeamCreateNumber = iTeamCreateNumber;
    }

    public Integer getsTeamJoinId() {
        return sTeamJoinId;
    }

    public void setsTeamJoinId(Integer sTeamJoinId) {
        this.sTeamJoinId = sTeamJoinId;
    }
}