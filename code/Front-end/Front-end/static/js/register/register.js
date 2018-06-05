$(document).ready(function(){
    $("#register").click(function(){
        var nick = $("#nick").val();
        var pwd = $("#pwd").val();
        var repwd = $("#repwd").val();
        var sex  = $("input[name='sex']:checked").val();
        var email = $("#email").val();
        if(nick==""||pwd==""||repwd==""||sex==undefined||email==""){
            alert("不能为空")
        }
        else if(pwd!=repwd) {
            alert("输入密码不一致")
        }
        else{
            toback(nick,pwd,sex,email);
        }



    });
    function toback(nick,pwd,sex,email)
    {
        var url = "http://39.106.181.120/giserhub/Userregister";
        var jsonStr =  {"nick":nick,"pwd":pwd,"sex":sex,"email":email};//这里是object数据
        var jsonArrayFinal =JSON.stringify(jsonStr);
        jQuery.ajax({
            type:"post",
            url:url,
            async:true,
            data:{date:jsonArrayFinal},
            contentType:"application/x-www-form-urlencoded",
            success: function(data,textStatus){
                successre(data);
            },
            error: function(xhr,status,errMsg){
                alert("操作失败!");
            }
        });
    }
    function successre(data)
    {
        var datastate = jQuery.parseJSON(data);
        var state = datastate[0].state;
        alert(state)
        var UserAccount =datastate[0].UserAccount;
        if(state=="1")
        {
            alert("注册成功"+UserAccount);
            // $(window).attr('location','login.html');
            $('#registerModal').modal('hide');
            $('#loginModal').modal('show');
        }
        else if (state =="0")
        {
            alert("注册失败");
        }
    }
});