package com.giserhub.tool.question;

import com.giserhub.entity.Question;
import net.sf.json.JSONObject;

public class JsonToQuestion {
    public static Question jsontoquestion(JSONObject json,String A_id)
    {
        Question question = new Question();
        question.setA_id(Integer.parseInt(A_id));
        question.setQ_Reason(json.getString("Q_Reason"));
        question.setQ_EnabledMark(json.getString("Q_EnabledMark").equals("1")?true:false);
        question.setQ_id(Integer.parseInt(json.getString("Q_id")));
        return question;
    }
    public  static Question jsontoquestinI(JSONObject json)
    {
        Question question = new Question();
        question.setQ_type(questiontype.numberToquestiontype(Integer.parseInt(json.getString("Q_type"))));
        question.setQ_Summary(json.getString("Q_Summary"));
        question.setQ_Content(json.getString("Q_Content"));
        return question;
    }
}
