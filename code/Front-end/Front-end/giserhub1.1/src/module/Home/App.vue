<template>
    <div id="home">
        <el-container>
            <el-header>
                <!-- <head></head> -->
                <table id="head">
                    <tr>
                        <th id="iconth"><a href="#"><img id="iconGISerHub" src="./images/logo_blue.png" alt="GISerHub"></a></th>
                        <th id="searchth">
                            <div>
                                <el-input id="searchinput" placeholder="搜索问题、话题或人" prefix-icon="el-icon-search"></el-input>
                            </div>
                        </th>
                        <th id="tableth">
                            <el-tabs>
                                <el-tab-pane>
                                    <span slot="label">&nbsp;&nbsp;&nbsp;<i class="fa fa-question-circle" aria-hidden="true"></i> 问题&nbsp;&nbsp;&nbsp;</span>
                                </el-tab-pane>
                                <el-tab-pane>
                                    <span slot="label">&nbsp;&nbsp;&nbsp;<i class="fa fa-lightbulb-o" aria-hidden="true"></i> IDEA&nbsp;&nbsp;&nbsp;</span>
                                </el-tab-pane>
                                <el-tab-pane>
                                    <span slot="label">&nbsp;&nbsp;&nbsp;<i class="fa fa-book" aria-hidden="true"></i> 资料&nbsp;&nbsp;&nbsp;</span>
                                </el-tab-pane>
                            </el-tabs>
                        </th>
                        <th id="loginlabel"><div><a href="./Login.html">登录</a></div></th>
                        <th id="registerlabel"><div><a href="./Register.html">注册</a></div></th>
                    </tr>
                </table>
            </el-header>
            <el-main></el-main>
        </el-container>
    </div>
</template>

<script>
import 'common/css/reset.css';
import Head from 'components/Home/Head'
export default {
    name: 'home',
    components:{
        Head
    }
}
</script>

<style scoped>
/* #home{background-image: url(./images/bg.jpg);widows: 100%; height: 100%;background-size: cover;background-position: center center;z-index: -999;} */
.el-header{background-color: #fff; border-bottom: solid 1px #fafafa; box-shadow: 2px 2px 10px 1px #ccc;}
#iconGISerHub{width: 200px; height: 50px; margin-bottom: 10px;margin-left: 50px;margin-right: 30px;}
#iconth{width: 250px; height: 50px;}
#searchth{width: 300px; height: 50px; vertical-align: middle;}
#searchth div{margin-bottom: 4px; margin-right: 30px;}
.el-tab-pane span{font-size: 20px;}
#loginlabel a{text-decoration:none;margin-left: 170px;margin-right: 20px;color: #0066FF;font-size: 15px;}
#registerlabel a{text-decoration:none;color: #0066FF;font-size:15px; }
#loginlabel div{margin-bottom: 10px;}
#registerlabel div{margin-bottom: 10px;}
</style>


