<template>
    <div id="mainInterface">
        <!-- <h1>pppp</h1> -->
        <div id="title">
            <h1 id="title">GISerHub</h1>
            <h3>登录GISerHub，寻找想法上的同行者</h3>
        </div>
        <div id="loginForm">
            <el-form :rules="rules" :model="ruleForm" ref="ruleForm" status-icon class="demo-ruleForm">
                <el-form-item prop="userinput">
                    <el-input placeholder="昵称/手机号/邮箱" type="text" v-model="ruleForm.userinput">
                    <i slot="prefix" class="el-input__icon el-icon-mobile-phone" aria-hidden="true"></i>
                    </el-input>
                </el-form-item>
                <el-form-item  prop="passwordinput">
                    <el-input placeholder="密码" type="password" v-model="ruleForm.passwordinput">
                    <i slot="prefix" class="el-input__icon el-icon-more" aria-hidden="true"></i>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="login()">登录</el-button>
                </el-form-item>
            </el-form>
            
        </div>
        <div id="loginicon">
            <a href="#"><i class="fa fa-qq" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-weixin" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-github" aria-hidden="true"></i></a>
        </div>
        <div id="bottomdiv">
            <span>没有账号？<a href="../module/Register.html" target="_self">注册</a></span>
        </div>
    </div>
</template>

<script>

export default {
    name:"login",
    data(){
        return{
            ruleForm:{
                userinput:'',
                passwordinput:'',
            },
            rules: {
                userinput: [
                    { required: true, message: '请输入账号', trigger: 'blur' }
                ],
                passwordinput:[
                    {required:true,message:'请输入密码',trigger:'blur'}
                ]
          }
        }
    },
    methods:{
        login(){
            var user={};
            user.sNickName = this.ruleForm.userinput;
            user.sPassword = this.ruleForm.passwordinput;

            this.$http({
                method:'post',
                url:'http://www.giserhub.com/giserhub/User/Login',
                withCredentials: true,
                data:{userWithBLOBs:user}
            }).then(function(response){
                if(response.data.state==0){
                    this.$message.error('登录失败');
                }else{
                    console.log(response.data);
                    console.log(user);
                }
            }).catch(function (error) {
                // 　　this.$message({
                //     message: '登录出错！请重新输入',
                //     type: 'error'
                // });
            });
        }
    }
}
</script>

<style scoped>
#mainInterface{
    background-color: #e6e6fa;
    width: 370px;
    height: 400px;
    position:absolute; 
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border-radius:15px;
    opacity:0.9;
}
#title{
    color: #191970;
    font-family: 'Bell MT Negreta', 'Bell MT';
}
.el-form{
    margin-right: 30px;
    margin-left: 30px;
}
.el-button{
    width: 100%;
}
.el-row{
    margin-bottom: 20px;
}
#loginicon{
    font-size: 32px;
    color:gray;
    margin-bottom: -30px;
}
#loginicon i{
    padding-left: 20px;
    padding-right: 20px;
}
#bottomdiv{
    position: relative;
    width: 370px;
    height: 50px;
    background-color: #696969;
    border-radius: 0 0 15px 15px;
    transform: translate(0, 55px);
}
#bottomdiv span{
    color: #fff;
    position: relative;
    bottom: -30%;
}
#bottomdiv span a{
    text-decoration:none;
}
#bottomdiv span a:hover :active{color:#40E0D0}
#bottomdiv span a:link{color: #fff}
#bottomdiv span a:visited{color: #6495ED}
</style>


