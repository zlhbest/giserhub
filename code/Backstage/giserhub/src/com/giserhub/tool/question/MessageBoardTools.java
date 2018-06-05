package com.giserhub.tool.question;

import com.giserhub.entity.MessageBoard;
import com.giserhub.entity.other.MessageBoardtype;


import javax.xml.crypto.Data;
import java.sql.ResultSet;

public class MessageBoardTools {
    public static MessageBoard fuzhi(ResultSet rs,MessageBoard messageBoard, MessageBoardtype messageBoardtype)
    {
        String message = messageBoardtype.toString();
        try {
            switch (message) {
                case "getNatureIstrue":
                    messageBoard.setMB_id(Integer.parseInt(rs.getString("MB_id")));
                    messageBoard.setU_id(Integer.parseInt(rs.getString("U_id")));
                    messageBoard.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    messageBoard.setMB_Content(rs.getString("MB_Content"));
                    messageBoard.setMB_U_id(Integer.parseInt(rs.getString("MB_U_id")));
                    messageBoard.setMB_mbid(Integer.parseInt(rs.getString("MB_mbid")));
                    messageBoard.setMB_Nature(rs.getString("MB_Nature").equals("1")?true:false);
                    messageBoard.setU_idName(rs.getString("U_NickName"));
                    messageBoard.setMB_date(rs.getString("MB_date"));
                    messageBoard.setU_HeadIcon("Http://39.106.181.120/"+rs.getString("U_HeadIcon"));
                    break;
                case "getNatureIsfalse":
                    messageBoard.setMB_id(Integer.parseInt(rs.getString("MB_id")));
                    messageBoard.setU_id(Integer.parseInt(rs.getString("U_id")));
                    messageBoard.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    messageBoard.setMB_Content(rs.getString("MB_Content"));
                    messageBoard.setMB_U_id(Integer.parseInt(rs.getString("MB_U_id")));
                    messageBoard.setMB_mbid(Integer.parseInt(rs.getString("MB_mbid")));
                    messageBoard.setMB_Nature(rs.getString("MB_Nature").equals("1")?true:false);
                    messageBoard.setU_idName(rs.getString("U_idName"));
                    messageBoard.setMB_mbidName(rs.getString("MB_mbidName"));
                    messageBoard.setMB_date(rs.getString("MB_date"));
                    messageBoard.setU_HeadIcon("Http://39.106.181.120/"+rs.getString("U_HeadIcon"));
                    break;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return messageBoard;
    }
}
