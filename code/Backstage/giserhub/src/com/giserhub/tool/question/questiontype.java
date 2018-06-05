package com.giserhub.tool.question;

import com.giserhub.entity.other.Questiontype;

public class questiontype {
    public static Questiontype numberToquestiontype(int type)
    {
        Questiontype questionType =null;
        switch (type)
        {
            case 1:
                questionType= Questiontype.front_end;
                break;
            case 2:
                questionType= Questiontype.backgound;
                break;
            case 3:
                questionType= Questiontype.mobile;
                break;
            case 4:
                questionType= Questiontype.Esri;
                break;
            case 5:
                questionType= Questiontype.supormap;
                break;
            case 6:
                questionType= Questiontype.Qgis;
                break;
        }
        return questionType;
    }
    public static int questiontypeTonumber(Questiontype questionType)
    {
        String qtype = questionType.toString();
        int type = 0;
        switch (qtype)
        {
            case "front_end":
                type=1;
                break;
            case "backgound":
                type=2;
                break;
            case "mobile":
                type=3;
                break;
            case "Esri":
                type=4;
                break;
            case "supormap":
                type=5;
                break;
            case "Qgis":
                type=6;
                break;
        }
        return type;
    }
}
