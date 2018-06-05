$(document).ready(function () {

    var url= window.location.search;
    var qId = url.substr(1);//问题id

//回复一级级评论
    $(document).on('click','.second_commit_submitBtn',function () {
        var MB_U_id= $(this).parents(".first_level_Comment").attr('id');
        var content=$(this).parents(".aw-comment-box-main").find("textarea").val();

        if(content==""){
            alert("评论内容不能为空")
        }
        else{
            updateMBByUserid(qId,content,MB_U_id,MB_U_id);
        }


    });


    function updateMBByUserid(Q_id,MB_Content,MB_mbid,MB_U_id) {

        var url = "http://39.106.181.120/giserhub/updateMBByUserid";
        var jsonStr =  {"Q_id":Q_id,"MB_Content":MB_Content,"MB_mbid":MB_mbid,"MB_U_id":MB_U_id};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                // console.log("aa")
                data=$.parseJSON(data);
                if(data[0].state=="1"){
                    alert("评论成功");
                    window.location.reload()
                }
                else {
                    alert("评论失败")
                }
                console.log(data)

            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });

    }
});