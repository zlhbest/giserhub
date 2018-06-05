$(document).ready(function () {
    //内容显示

    var pn=1;
    var pageSize=10;
    var pS=10;
    acquireQuesPage(pn,10);
    $("#nextPage").click(function () {

        if(pS<10){
            alert("已经是最后一页了！");
        }
        else{
            $("#aw-common-list").empty();
            pn=pn+1;
            acquireQuesPage(pn,pageSize)
        }
    });
    $("#prePage").click(function () {
        if(pn==1){
            alert("这已经是第一页了")  ;
        }
        else {
            $("#aw-common-list").empty();
            pn=pn-1;
            acquireQuesPage(pn,pageSize)
        }
    })
    function acquireQuesPage(pageNum,pageSize) {
        var url = "http://39.106.181.120/giserhub/geAllEnablequestion";
        var jsonStr =  {"pageNo":pageNum,"pageSize":pageSize};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){


                data=$.parseJSON(data);
                if(data[0].state==1){
                    data=$.parseJSON(data[0].date);
                    console.log(data[0].q_id);
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
        var imgSrc;//用户头像
        var questionUrl="question.html";//问题url
        var summary;//问题题目
        var replyNum; //回复数量
        var browserNum; //浏览数量
        var dateTime ;//更新日期
        console.log(data[0])
        for(var i=0;i<pageSize;i++){
            var ques=data[i];
            if(ques==undefined){
                pS=i;
                break;
            }
            imgSrc = "http://39.106.181.120/"+data[i].u_HeadIcon;
            replyNum = data[i].q_pinglun;
            browserNum=data[i].q_liulan;
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
            var l='<a href="javascript:location.href=\'question.html?\'+questionId">\'+summary+\'</a>'
            $("#aw-common-list").append(template);
        }
    }
});