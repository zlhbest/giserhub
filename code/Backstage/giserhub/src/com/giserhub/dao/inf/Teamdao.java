package com.giserhub.dao.inf;

import com.giserhub.entity.Team;

import java.util.ArrayList;

public interface Teamdao {
    public int insertteam(Team team);//创建团队
    public ArrayList<Team> selectteambyUid(int U_id);//通过Uid来查找该人所有创建的团队
    public ArrayList<Team> selectjionteambyUid(int U_id);//通过Uid来查找该人加入的团队
}
