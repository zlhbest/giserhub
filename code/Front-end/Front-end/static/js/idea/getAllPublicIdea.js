$(document).ready(function () {
    var pn=1;
    var pageSize=10;
    var pS=10;//一页的数量
    getAllPublicIdea(pn,10);
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
    });
    function getAllPublicIdea(pageNum,pageSize) {
        var url = "http://39.106.181.120/giserhub/getAllPublicIdea";
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
                data=$.parseJSON(data[0].date);

                refreshList(data,pageSize);
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function refreshList(data,pageSize) {
        var dataTopicId; //问题分类id
        var ideaId; //问题id
        var imgSrc="static/image/user_dafult.png";//用户头像
        var questionUrl="question.html";//问题url
        var summary;//问题题目
        var replyNum=0; //回复数量
        var browserNum=0; //浏览数量
        var dateTime ;//更新日期
        console.log(data[0]);
        for(var i=0;i<pageSize;i++){
            var idea=data[i];
            if(idea==undefined){
                pS=i;
                break;
            }
            ideaId=idea.i_id;
            summary=idea.i_Summary;
            dateTime=idea.i_date;
            var template = '<div class="aw-item " data-topic-id="'+dataTopicId+'">'+
                '<a class="aw-user-name hidden-xs" data-id="'+ideaId+'" href="" rel="nofollow">'+
                '<img src="'+imgSrc+'" alt="">'+
                '</a>'+
                '<div class="aw-question-content">'+
                '<h4>'+
                '<a href="ideaDetail.html?'+ideaId+'">'+summary+'</a>'+
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
})