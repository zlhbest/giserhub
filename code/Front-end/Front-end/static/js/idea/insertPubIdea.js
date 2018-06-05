$(document).ready(function () {

        // $("#idea_pubish").attr("data-target","#exampleModal");
        $("#submit_Idea").click(function () {
            var summ=$("#I_Summary").val();
            var content=$("#I_Content").val();
            var pro=$("#I_Project").val();
            var plan=$("#I_Plan").val();

            var tid=$("#exampleModal").attr("data-teamID");
            if(tid==0){
                tid=null;
            }
            insertPublicIdea(summ,content,pro,plan,tid)
            });


    function insertPublicIdea(Q_Summary,Q_Content,I_Project,I_Plan,tId) {
        var url = "http://39.106.181.120/giserhub/insertPublicIdea";
        var jsonStr =  {"I_Summary":Q_Summary,"I_Content":Q_Content,"I_project":I_Project,"I_Plan":I_Plan,"T_id":tId};//这里是object数据
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