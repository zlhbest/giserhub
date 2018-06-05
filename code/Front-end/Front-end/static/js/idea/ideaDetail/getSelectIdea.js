$(document).ready(function () {
    var url= window.location.search;
    var ideaId = url.substr(1);//问题id
    getSelectIdea(2);

    function getSelectIdea(ideaId) {
        var url = "http://39.106.181.120/giserhub/getPublicIdeaByid";
        var jsonStr =  {"I_id":ideaId}//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                data=$.parseJSON(data);
                data=$.parseJSON(data[0].date);


                IdeaDetail(data);
                // console.log(data)
                //
                // for(var i=0;i<10;i++){
                //     console.log(data[i].q_Summary)
                // }
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function IdeaDetail(data) {
        // console.log(data.q_Summary);
        // console.log(data.q_Content);
        // $("#q_Summary").html(data.q_Summary);
        //
        // $("#q_Content").html(data.q_Content);
        // $("#q_datetime").html(data.q_datetime);
        // $("#u_NickName").html(data.u_NickName);
        $("#I_Summary").html(data.i_Summary);
        $("#I_Content").html(data.i_Contect);
        $("#I_plan").html(data.i_Plan);
        $("#I_pro").html(data.i_project)

        $("#I_datetime").html(data.i_date);
        $("#updateTime").html(data.i_date);
        $("#u_NickName").html(data.u_id_name);
        $("#teamName").html(data.t_id_name);
        $("#teamCount").html(data.i_T_Count_now);
    }

});