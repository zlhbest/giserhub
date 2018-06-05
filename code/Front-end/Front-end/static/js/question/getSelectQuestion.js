$(document).ready(function () {
    var url= window.location.search;
    var qId = url.substr(1);//问题id
    getSelectQuestion(qId);
    function getSelectQuestion(questionID) {
        var url = "http://39.106.181.120/giserhub/getselectquestion";
        var jsonStr =  {"questionid":questionID};//这里是object数据
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
                data=data[0];
                questionDetail(data);
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function questionDetail(data) {
        $("#q_Summary").html(data.q_Summary);
        $("#userheadicon").attr('src',"http://39.10.181.120/"+data.u_HeadIcon)
        $("#q_Content").html(data.q_Content);
        $("#q_datetime").html(data.q_datetime);
        $("#u_NickName").html(data.u_NickName);
    }

});