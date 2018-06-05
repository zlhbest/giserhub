package com.giserhub.dao.inf;

import com.giserhub.entity.MessageBoard;

import java.util.ArrayList;

public interface MessageBoarddao {
    public ArrayList<MessageBoard> getNatureIstrue(int Q_id,int pageNO,int PagetSize);//用于查询此问题的回复的留言
    public ArrayList<MessageBoard> getNatureIsfalse(int Q_id,int MB_U_id);//获取回复这个留言的域
    public  boolean updateNatureIstrue(MessageBoard messageBoard);//上传评论
    public  boolean updateNatureIsfalse(MessageBoard messageBoard);;//上传用户评论
}
