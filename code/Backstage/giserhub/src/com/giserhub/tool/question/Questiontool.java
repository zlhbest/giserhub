package com.giserhub.tool.question;

import com.giserhub.entity.Question;
import com.giserhub.entity.other.QuestioncInt;

import java.sql.ResultSet;

public class Questiontool {
    public static void fuzhi(ResultSet rs, Question question, QuestioncInt questioncInt)
    {
        try {
            switch (questioncInt.toString())
            {
                case "geAllEnablequestion":
                    question.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    question.setQ_type(questiontype.numberToquestiontype(Integer.parseInt(rs.getString("Q_type"))));
                    question.setQ_Summary(rs.getString("Q_Summary"));
                    question.setQ_Good(Integer.parseInt(rs.getString("Q_Good")));
                    question.setQ_SetUp(rs.getString("Q_SetUp").equals("1")?true:false);
                    question.setU_NickName(rs.getString("U_NickName"));
                    question.setQ_finish(rs.getString("Q_finish").equals("1")?true:false);
                    question.setQ_datetime(rs.getString("Q_datetime"));
                    question.setU_HeadIcon(rs.getString("U_HeadIcon"));
                    question.setQ_liulan(Integer.parseInt(rs.getString("Q_liulan")));
                    question.setQ_pinglun(Integer.parseInt(rs.getString("Q_pinglun")));
                    break;
                case "getAllUnauditedquestion":
                    question.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    question.setQ_type(questiontype.numberToquestiontype(Integer.parseInt(rs.getString("Q_type"))));
                    question.setQ_Summary(rs.getString("Q_Summary"));
                    question.setU_NickName(rs.getString("U_NickName"));
                    question.setQ_datetime(rs.getString("Q_datetime"));
                    question.setQ_Content(rs.getString("Q_Content"));
                    question.setQ_Reason(rs.getString("Q_Reason"));
                    question.setQ_finish(rs.getString("Q_finish").equals("1")?true:false);
                    question.setQ_EnabledMark(rs.getString("Q_EnabledMark").equals("1")?true:false);
                    question.setQ_state(rs.getString("Q_state").equals("1")?true:false);
                    break;
                case "getselectquestion":
                    question.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    question.setQ_type(questiontype.numberToquestiontype(Integer.parseInt(rs.getString("Q_type"))));
                    question.setQ_Summary(rs.getString("Q_Summary"));
                    question.setQ_Content(rs.getString("Q_Content"));
                    question.setQ_Reason(rs.getString("Q_Reason"));
                    question.setQ_Good(Integer.parseInt(rs.getString("Q_Good")));
                    question.setQ_SetUp(rs.getString("Q_SetUp").equals("1")?true:false);
                    question.setU_NickName(rs.getString("U_NickName"));
                    question.setQ_finish(rs.getString("Q_finish").equals("1")?true:false);
                    question.setQ_datetime(rs.getString("Q_datetime"));
                    question.setA_id(Integer.parseInt(rs.getString("A_id")));
                    question.setQ_EnabledMark(rs.getString("Q_EnabledMark").equals("1")?true:false);
                    question.setQ_state(rs.getString("Q_state").equals("1")?true:false);
                    question.setU_HeadIcon(rs.getString("U_HeadIcon"));
                    break;
                case "selectquestionbyid":
                    question.setQ_id(Integer.parseInt(rs.getString("Q_id")));
                    question.setQ_type(questiontype.numberToquestiontype(Integer.parseInt(rs.getString("Q_type"))));
                    question.setQ_Summary(rs.getString("Q_Summary"));
                    question.setQ_Good(Integer.parseInt(rs.getString("Q_Good")));
                    question.setQ_SetUp(rs.getString("Q_SetUp").equals("1")?true:false);
                    question.setQ_EnabledMark(rs.getString("Q_EnabledMark").equals("1")?true:false);
                    question.setQ_finish(rs.getString("Q_finish").equals("1")?true:false);
                    question.setQ_datetime(rs.getString("Q_datetime"));
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
