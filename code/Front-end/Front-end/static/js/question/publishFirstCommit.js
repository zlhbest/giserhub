$(document).ready(function () {
    var url= window.location.search;
    var qId = url.substr(1);//问题id


    //发表一级评论
    $("#updateMBByQuestion").click(function () {
        var uId=0;
        var mBCont=$("#MB_Content").val();

        var Qid=qId;
        updateMBByQuestion(Qid,mBCont,0,0)
    });
    function updateMBByQuestion(Q_id,MB_Content,MB_mbid,MB_U_id) {
        var url = "http://39.106.181.120/giserhub/updateMBByQuestion";
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
                // data=
                data=$.parseJSON(data);

                // console.log("一级："+data)
                // console.log(data[11])
                if(data[0].state=="1"){
                    alert("评论成功")
                    window.location.reload()
                }
                else {
                    alert("评论失败")
                }

            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });

    }

});