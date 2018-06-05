$(document).ready(function () {

    $("#question_pubish").click(function () {
        if($("#user").css("display")=="block"){
            $("#question_pubish").attr("data-target","#exampleModal");
            $("#submit_Question").click(function () {
                var summ=$("#q_Summary").val();
                var content=$("#q1_Content").val();
                var type=$("#q_Type").val();
                insertQuestion(type,summ,content);
            });
        }
        else{
            alert("请先登录账户!");
        }

    });


    function insertQuestion(Q_type,Q_Summary,Q_Content) {
        var url = "http://39.106.181.120/giserhub/insertquestion";
        var jsonStr =  {"Q_type":Q_type,"Q_Summary":Q_Summary,"Q_Content":Q_Content};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                data=$.parseJSON(data);
                // data=$.parseJSON(data[0].date);
                if(data[0].state=="1"){
                    console.log(data);
                    alert("提交成功,请等待审核！");
                    $('#exampleModal').modal('hide');
                }
                else{
                    alert("提交失败");
                }
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
});