package com.giserhub.dao.inf;

import com.giserhub.entity.Question;

import java.util.ArrayList;

public interface Questiondao {
    public ArrayList<Question> getAllEnablequestion(int pageNo,int pageSize);
    public ArrayList<Question> getAllUnauditedquestion(int pageNo,int pageSize);
    public Question getselectquestion(int questionid);
    public boolean updatequestion(Question question);//前端传送要修改的问题参数，将参数修改到数据库中
    public boolean updatequestionGood(int Q_id);
    public boolean insertquestion(Question question,int U_id);
}
