$(document).ready(function () {
    //内容显示

    var touxiang =$.cookie('giserhub3');
    var name = $.cookie('giserhub2');
    $("#userimg").attr("src",touxiang);
    $("#username").html(name);
    var pn=1;
    var pageSize=10;
    var pS=10;
    acquireQuesPage(pn,10);

    function acquireQuesPage(pageNum,pageSize) {
        var url = "http://localhost:8080/selectquestionbyid";
        var jsonStr =  {"pageNo":pageNum,"pageSize":pageSize};//这里是object数据
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


                data=$.parseJSON(data);
                if(data[0].state==1){
                    data=$.parseJSON(data[0].date);

                     refreshList(data,pageSize);
                }else{
                    alert("获取问题失败" );

                }


            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function refreshList(data,pageSize) {
        var dataTopicId; //问题分类id
        var questionId; //问题id
        var imgSrc="static/image/user_dafult.png";//用户头像
        var questionUrl="question.html";//问题url
        var summary;//问题题目
        var replyNum=0; //回复数量
        var browserNum=0; //浏览数量
        var dateTime ;//更新日期
        console.log(data[0])
        for(var i=0;i<pageSize;i++){
            var ques=data[i];
            if(ques==undefined){
                pS=i;
                break;
            }
            imgSrc=$.cookie('giserhub3');
            questionId=ques.q_id;
            summary=ques.q_Summary;
            dateTime=ques.q_datetime;
            var template = '<div class="aw-item " data-topic-id="'+dataTopicId+'">'+
                '<a class="aw-user-name hidden-xs" data-id="'+questionId+'" href="" rel="nofollow">'+
                '<img src="'+imgSrc+'" alt="">'+
                '</a>'+
                '<div class="aw-question-content">'+
                '<h4>'+
                '<a href="question.html?'+questionId+'">'+summary+'</a>'+
                '</h4>'+
                '<p>'+
                '<span class="text-color-999">'+replyNum+'个回复 • '+browserNum+' 次浏览 • '+dateTime+'</span>'+
                '</p>'+
                '</div>'+
                '</div>';
            var l='<a href="javascript:location.href=\'question.html?\'+questionId">\'+summary+\'</a>';
            var q=$("#questions").find(".aw-mod-body");
            q.append(template);
        }
    }
});