$(document).ready(function () {
    var url = "http://39.106.181.120/giserhub/Userlogin";
    jQuery.ajax({
        xhrFields: {
            withCredentials: true
        },
        type:"post",
        url:url,
        async:true,
        contentType:"application/x-www-form-urlencoded",
        success: function(data,textStatus){
            data=$.parseJSON(data);
            if(data[0].state=="0"){
            }
            else {
                $("#guests").hide();
                $("#user").show();
                var touxiang =$.cookie('giserhub3');
                var nickname = $.cookie('giserhub2');
                $("#user").find("img").attr('src',touxiang);
                $("#user").find("span").html(nickname);
            }
        },
        error: function(xhr,status,errMsg){
            alert("cookie操作失败!");
        }
    });
});