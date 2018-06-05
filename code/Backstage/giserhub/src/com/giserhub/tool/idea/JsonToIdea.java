package com.giserhub.tool.idea;

import com.giserhub.entity.Idea;
import net.sf.json.JSONObject;

public class JsonToIdea {
     public static Idea jsontoidea(JSONObject json,int U_id)
     {
         Idea idea = new Idea();
         idea.setU_id(U_id);
         idea.setI_Summary(json.getString("I_Summary"));
         idea.setI_Contect(json.getString("I_Contect"));
         idea.setI_project(json.getString("I_project"));
         idea.setI_Plan(json.getString("I_Plan"));
         if(json.getString("T_id")!=null)
         {
             idea.setT_id(Integer.parseInt(json.getString("T_id")));
         }
         return idea;
     }
}
