package com.giserhub.dao.impl;

import com.giserhub.dao.inf.MessageBoarddao;
import com.giserhub.entity.MessageBoard;
import com.giserhub.entity.other.MessageBoardtype;
import com.giserhub.tool.question.MessageBoardTools;
import com.giserhub.util.DBconn;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageBoardImpl implements MessageBoarddao {
    @Override
    public ArrayList<MessageBoard> getNatureIstrue(int Q_id,int pageNo,int pageSize) {
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        int limitno = (pageNo-1)*pageSize;
        int limitSize = pageSize;
        try{
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT m.*,u.U_NickName,u.U_HeadIcon")
                    .append("   FROM messageboard m,`user` u")
                    .append(" WHERE m.Q_id = "+Q_id)
                    .append("   AND m.MB_Nature=1")
                    .append("   AND m.MB_DelectMack = 0")
                    .append("   AND u.U_id = m.U_id")
                     .append("    ORDER BY m.MB_date DESC")
                    .append("    limit " +limitno+","+limitSize);
            ResultSet rs = DBconn.selectSql(sql.toString());
            System.out.println(sql.toString());
            while (rs.next())
            {
                MessageBoard  messageBoard= new MessageBoard();
                MessageBoardTools.fuzhi(rs,messageBoard,MessageBoardtype.getNatureIstrue);
                messageBoards.add(messageBoard);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return messageBoards;
    }
    /**
     * 用于获取某个问题中某个评论的留言
     * @param Q_id 问题id
     * @param MB_U_id 留言域
     * @return
     */
    @Override
    public ArrayList<MessageBoard> getNatureIsfalse(int Q_id, int MB_U_id) {
        ArrayList<MessageBoard> messageBoards = new ArrayList<>();
        try{
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("SELECT m.*,u.U_NickName U_idName,us.U_NickName MB_mbidName,u.U_HeadIcon")
                    .append("   FROM messageboard m,`user` u,`user` us")
                    .append(" WHERE m.Q_id = "+Q_id)
                    .append(" AND m.MB_Nature=0")
                    .append(" AND m.MB_DelectMack = 0")
                    .append(" AND u.U_id = m.U_id")
                    .append("  AND m.MB_U_id="+MB_U_id)
                    .append("  AND us.U_id= m.MB_mbid")
                    .append("    ORDER BY m.MB_date DESC");
            ResultSet rs = DBconn.selectSql(sql.toString());
            System.out.println(sql.toString());
            while (rs.next())
            {
                MessageBoard  messageBoard= new MessageBoard();
                MessageBoardTools.fuzhi(rs,messageBoard,MessageBoardtype.getNatureIsfalse);
                messageBoards.add(messageBoard);
            }
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return messageBoards;
    }

    @Override
    public boolean updateNatureIstrue(MessageBoard messageBoard) {
        boolean flag = false;
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO messageboard(U_id,Q_id,MB_Content,MB_mbid,MB_Nature,MB_DelectMack,MB_date,MB_U_id)")
                    .append("   VALUES (?,?,?,?,?,?,?,?)");
            Object[] val = {
                    messageBoard.getU_id(),
                    messageBoard.getQ_id(),
                    messageBoard.getMB_Content(),
                    messageBoard.getMB_mbid(),
                    1,
                    0,
                    date,
                    messageBoard.getMB_U_id()
            };
            System.out.println(sql.toString());
            flag = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
            StringBuilder sqlfuzhi = new StringBuilder()
                    .append("UPDATE question")
                    .append("     SET question.Q_pinglun= question.Q_pinglun+1")
                    .append("   WHERE question.Q_id =  "+ messageBoard.getQ_id());
            DBconn.addUpdDel(sqlfuzhi.toString());
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }

    /**
     * 用于上传不是评论问题而是用户的评论
     * @param messageBoard
     * @return
     */
    @Override
    public boolean updateNatureIsfalse(MessageBoard messageBoard) {
        boolean flag = false;
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String date = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try
        {
            DBconn.init();
            StringBuilder sql = new StringBuilder()
                    .append("INSERT INTO messageboard(U_id,Q_id,MB_Content,MB_mbid,MB_Nature,MB_DelectMack,MB_U_id,MB_date)")
                    .append("   VALUES (?,?,?,?,?,?,?,?)");
            Object[] val = {
                    messageBoard.getU_id(),
                    messageBoard.getQ_id(),
                    messageBoard.getMB_Content(),
                    messageBoard.getMB_mbid(),
                    0,
                    0,
                    messageBoard.getMB_U_id(),
                    date
            } ;
            System.out.println(sql.toString());
            flag = DBconn.addUpdDel(sql.toString(),val)>0?true:false;
            DBconn.closeConn();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
}
