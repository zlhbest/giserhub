$(document).ready(function () {

    $("#createTeam").click(function () {
        if($("#user").css("display")=="block"){
            $("#createTeam").attr("data-target","#cTeam");
            $("#submit_Team").click(function () {
                var teamName=$("#teamName").val();
                var teamMaxNum=$("#teamMaxNum").val();
                createTeam(teamName,teamMaxNum);
            });
        }
        else{
            alert("请先登录账户!");
        }
    });
    function createTeam(teamName,teamMaxNum) {
        var url = "http://39.106.181.120/giserhub/insertteam";
        var jsonStr =  {"T_Name":teamName,"T_Count":teamMaxNum};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            xhrFields: {
                withCredentials: true
            },
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                data=data.substr(15)
                data=$.parseJSON(data);
                // data=$.parseJSON(data[0].date);
                if(data[0].state=="1"){
                    console.log(data);
                    alert("团队创建成功，请发布idea");
                    $("#cTeam").modal('hide');
                    var pubIdea= $("#exampleModal");
                    pubIdea.attr("data-teamID",data[0].date);
                    pubIdea.modal('show');
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