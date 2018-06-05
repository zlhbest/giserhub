package com.giserhub.tool.question;

import com.giserhub.entity.MessageBoard;
import net.sf.json.JSONObject;

public class JsonToMessageBoard {
    public static MessageBoard jsontomessageboard(JSONObject json,int user)
    {
        MessageBoard messageBoard = new MessageBoard();
        try
        {
            messageBoard.setU_id(user);
            messageBoard.setQ_id(Integer.parseInt(json.getString("Q_id")));
            messageBoard.setMB_Content(json.getString("MB_Content"));
            messageBoard.setMB_mbid(Integer.parseInt(json.getString("MB_mbid")));
            messageBoard.setMB_U_id(Integer.parseInt(json.getString("MB_U_id")));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return messageBoard;
    }
}
