$(document).ready(function(){
    $(document).on('click',"#login",function(){
        var name = $("#inputAccount").val();
        var pwd = $("#inputPassword").val();
        if(name==""||pwd=="")
        {
            alert("账号或密码不能为空")
        }
        else
        {
            toback(name,pwd);
        }
    });
    function toback(name,pwd)
    {
        var url = "http://39.106.181.120/giserhub/Userlogin";
        var jsonStr =  {"name":name,"pwd":pwd};
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            xhrFields: {
                withCredentials: true
            },
            type:"post",
            url:url,
            async:true,
            crossDomain: true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                success(data);
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!"+errMsg);
            }
        });
    }
    function success(data)
    {
        var datastate = jQuery.parseJSON(data);
        var state = datastate[0].state;
        if(state=="1")
        {
            alert("登陆成功");
            $('#loginModal').modal('hide');
            $("#guests").css("display","none");
            $("#user").css("display","block");
            var touxiang =$.cookie('giserhub3');
            var nickname = $.cookie('giserhub2');
            $("#user").find("img").attr('src',touxiang);
            $("#user").find("span").html(nickname);
        }
        else
        {
            alert("登录失败");
        }
    }
    $(document).on('click',"#log_off",function () {
        $.removeCookie('giserhub1',{ path: '/'});
        $.removeCookie('giserhub2',{ path: '/'});
        $.removeCookie('giserhub3',{ path: '/'});
        window.location.reload()
    });
});