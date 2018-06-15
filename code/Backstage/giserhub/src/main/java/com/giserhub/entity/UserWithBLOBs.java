package com.giserhub.entity;

public class UserWithBLOBs extends User {
    private String sProfile;

    private String sHeadicon;

    private String sTeamCreateId;

    private String tUserRegisterTime;

    public String getsProfile() {
        return sProfile;
    }

    public void setsProfile(String sProfile) {
        this.sProfile = sProfile == null ? null : sProfile.trim();
    }

    public String getsHeadicon() {
        return sHeadicon;
    }

    public void setsHeadicon(String sHeadicon) {
        this.sHeadicon = sHeadicon == null ? null : sHeadicon.trim();
    }

    public String getsTeamCreateId() {
        return sTeamCreateId;
    }

    public void setsTeamCreateId(String sTeamCreateId) {
        this.sTeamCreateId = sTeamCreateId == null ? null : sTeamCreateId.trim();
    }

    public String gettUserRegisterTime() {
        return tUserRegisterTime;
    }

    public void settUserRegisterTime(String tUserRegisterTime) {
        this.tUserRegisterTime = tUserRegisterTime == null ? null : tUserRegisterTime.trim();
    }
}