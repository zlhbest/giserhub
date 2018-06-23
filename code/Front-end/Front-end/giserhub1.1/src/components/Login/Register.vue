<template>
    <div id="mainInterface">
        <!-- <h1>pppp</h1> -->
        <div id="title">
            <h1 id="title">GISerHub</h1>
            <h3>注册GISerHub，寻找想法上的同行者</h3>
        </div>
        <div id="RegisterForm">
            <el-form :label-position="right" label-width="80px" :rules="rules" :model="ruleForm" ref="ruleForm" status-icon class="demo-ruleForm">
                <el-row :gutter="5">
                    <el-col :span="12">
                        <el-form-item label="昵称" prop="nickname">
                            <el-input type="text" v-model="ruleForm.nickname"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="手机号" prop="telephonenumber">
                            <el-input type="text" v-model="ruleForm.telephonenumber"></el-input>
                        </el-form-item>
                        
                    </el-col>
                </el-row>

                <el-row :gutter="5">
                    <el-col :span="12">
                        <el-form-item label="密码" prop="password">
                            <el-input type="password" v-model="ruleForm.password"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="重复密码" prop="repassword">
                            <el-input type="password" v-model="ruleForm.repassword"></el-input>
                        </el-form-item>
                    </el-col>
                    
                </el-row>
                
                <el-row :gutter="5">
                    <el-col :span="24">
                        <el-form-item label="邮箱" prop="email">
                            <el-input type="text" v-model="ruleForm.email"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                
                
                
            </el-form>
            <el-row :gutter="24">
                <el-col :span="24">
                    <el-button type="primary" @click="register()">注册</el-button>
                </el-col>
            </el-row>
        </div>
        <div id="GISerHubprotocol">
            <span>注册即代表同意<a href="#" target="_blank">《GISerHub协议》</a><a href="#" target="_blank">《隐私政策》</a></span>
        </div>
        <div id="bottomdiv">
            <span>已有账号？<a href="../module/Login.html" target="_self">登录</a></span>
        </div>
    </div>
</template>

<script>
export default {
    name:"register",
    data(){
        return{
            ruleForm:{
                nickname:'',
                telephonenumber:'',
                password:'',
                repassword:'',
                email:''
            },
            rules: {
                nickname: [
                    { required: true, message: '请输入昵称', trigger: 'blur' }
                ],
                telephonenumber:[
                    {required:true,message:'请输入手机号',trigger:'blur'}
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' }
                ],
                repassword:[
                    {required:true,message:'请重复输入密码',trigger:'blur'}
                ],
                email:[
                    { required: true, message: '请输入邮箱', trigger: 'blur' }
                ]
          }
        }
    },
    methods:{
        register(){
            var registeruser = {};
            registeruser.sNickName = this.ruleForm.nickname;
            registeruser.sPassword = this.ruleForm.password;
            registeruser.sMobilephone = this.ruleForm.telephonenumber;
            registeruser.sEmail = this.ruleForm.email;
            console.log(registeruser);
            
            this.$http({
                method:'post',
                url:'http://www.giserhub.com/giserhub//User/Register',
                withCredentials: true,
                data:{userWithBLOBs:registeruser}
            }).then(function(response){
                console.log(response.data);
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
    width: 600px;
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
#RegisterForm{
    margin-left: 20px;
    margin-right: 20px;
}
#GISerHubprotocol{
    /* background-color: #FFF; */
    margin-top: 15px;
    font-size: 10px;
}
.el-button{
    width: 100%;
}
#bottomdiv{
    position: relative;
    width: 100%;
    height: 50px;
    background-color: #696969;
    border-radius: 0 0 15px 15px;
    transform: translate(0, 20px);
}
#bottomdiv span{
    color: #fff;
    position: relative;
    bottom: -30%;
}
a{
    text-decoration:none;
}
a:hover :active{color:#40E0D0}
a:link{color: #fff}
a:visited{color: #6495ED}
</style>


