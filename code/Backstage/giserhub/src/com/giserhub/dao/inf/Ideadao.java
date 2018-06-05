package com.giserhub.dao.inf;

import com.giserhub.entity.Idea;

import java.util.ArrayList;
/**
 * idea功能
 */
public interface Ideadao {
    public ArrayList<Idea> getAllPublicIdea(int pageNo,int pageSize);//获取所有的Publicideari
    public ArrayList<Idea> getAllPrivateIdea(int pageNo,int pageSize,int U_id);//获取所有的PrivateIdea,只有用户自己可以看到】
    public boolean insertPrivateIdea(Idea idea);//用于上传idea的私有状态，上传后仅用户自己可见
    public boolean insertPublicIdea(Idea idea);//用于上传用户的公用idea,上传后用户的公用id将会
    public boolean PrivateToPublic(Idea idea);//私有的用户idea仓库放入公有的idea论坛中
    //管理员实现接口，拥有查询虽有ideda的信息，更改审核和可用状态
    public ArrayList<Idea> getALLPublicIdeafoeadm(int pageNo,int pageSize);//获取到所有的idea信息
    public Idea getPublicIdeaByid(int I_id);//用户用于查询单个idea
    public boolean UpdatePublicIdeashenhe(int I_id,int I_EnableMark,String reason);
}
