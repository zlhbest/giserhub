$(document).ready(function () {
    var url= window.location.search;
    var qId = url.substr(1);//问题id
    var firstPageSize=10;
    var secondPageSize=10;
    //一级评论显示
    getMBByQuestionid(qId,1,firstPageSize);
    function getMBByQuestionid(Q_id,pageNo,pageSize) {
        var url = "http://39.106.181.120/giserhub/getMBByQuestionid";
        var jsonStr =  {"Q_id":Q_id,"pageNo":pageNo,"pageSize":pageSize};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                data=$.parseJSON(data);
                if(data[0].state=="1"){
                    data=$.parseJSON(data[0].date);
                    firstLevelCommit(data,pageSize);
                }
                else{
                    alert("此问题还没有评论")
                }
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function firstLevelCommit(data,pageSize) {
        var a=$(".first_level_Comment").prop("outerHTML");
        $(".first_level_Comment").css("display","none");
        for(var i=0;i<pageSize;i++){
            if(data[i]==undefined){
                pageSize=i;
                break;
            }
            var Q_id=data[i].q_id;//问题的id
            var MB_id=data[i].u_id;//一级评论的id
            var u_idName=data[i].u_idName;
            $("#first_Comment").append(a);
            var fC= $("#first_Comment>div ").last();
            fC.attr('id',MB_id);
            fC.find(".markitup-box").html(data[i].MB_Content);//内容
            fC.find(".date_time").html(u_idName+" &nbsp• &nbsp"+data[i].MB_date);//时间
            fC.find(".userheadicon").attr('src',data[i].u_HeadIcon);
            getMBByUserid(Q_id,MB_id,secondPageSize);
        }
        $("#aw_Num").html(pageSize+"个回复")
    }
//二级评论显示
    function getMBByUserid(Q_id,MB_U_id,pageSize) {
        var url = "http://39.106.181.120/giserhub/getMBByUserid";
        var jsonStr =  {"Q_id":Q_id,"MB_U_id":MB_U_id};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                data=$.parseJSON(data);
                if(data[0].state=="0"){
                }
                else {
                    data=$.parseJSON(data[0].date);
                    secondLevelCommit(data,MB_U_id,pageSize)
                }
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }

    function secondLevelCommit(data,MB_U_id,pageSize) {
        var a= $("#first_Comment").find("#"+MB_U_id);
        var ul=a.find("ul");
        var smNum=a.find(".toggle_second_comment").find("span");
        for(var i=0;i<pageSize;i++){
            if(data[i]==undefined){
                pageSize=i;
                break;
            }
            var awName=data[i].MB_mbidName;
            var dateTime=data[i].MB_date;
            var MB_Content=data[i].MB_Content;
            var sedTem='<li class="second_level_Comment">' +
                '<a class="aw-user-name" href=""><img src='+data[i].u_HeadIcon+' alt=""></a>' +
                '<div>' +
                '<a href="" class="aw-user-name author">'+awName+'</a> • ' +
                dateTime +
                '<p class="clearfix">'+MB_Content+'</p>' +
                '</div>' +
                '</li>';
            ul.append(sedTem);
        }
        smNum.html(pageSize);
    }
});