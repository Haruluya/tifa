<template>
    <div class="mainContainer">
        <div class="tifaBackgroundImg">
            <img src="https://images6.alphacoders.com/106/1061312.jpg" />
        </div>
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="loginContainer">
            <div class="loginPanel">
                <el-tabs v-model="loginActiveTab"  @tab-click="handleClick">
                    <el-tab-pane label="账号密码登录" name="inputeLogin">    
                        <div class="title">
                            TIFA登录
                        </div>

                        <div class="username">
                            <div class="loginIcon"><el-icon><UserFilled /></el-icon></div>
                            <el-input
                            v-model="username"
                            size="large"
                            placeholder="Please Input"
                            />
                        </div>
                        <div class="password">
                            <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                            <el-input
                            v-model="password"
                            size="large"
                            placeholder="Please Input"
                            />
                        </div>
                        <div class="forgetPassword">
                            <el-link :underline="false">忘记密码</el-link>
                        </div>
                        <div class="commit">
                            登 录
                        </div>
                        <el-divider></el-divider>
                        <div class="register">
                            <div class="wechat">
                                <el-icon><ChatDotRound /></el-icon>
                                微信登录
                            </div>
                            <div class="registerLink">
                                <el-icon><DArrowRight /></el-icon>
                                <el-link :underline="false" href="tifaregister">立即注册</el-link>
                            </div>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="扫码登录" name="codeLogin">Config</el-tab-pane>
                </el-tabs>
            </div>
        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
export default {
    name:"tifalogin",
    components:{
        HomeHeader,
    },
    data() {
        return {
            loginActiveTab:"inputeLogin"
        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin: 0 auto;
        margin-bottom: 250px;
        .tifaBackgroundImg{
            position: absolute;
            z-index: -1;
            overflow: hidden;
            img{
                opacity: 0.8;
                width: 1800px;
                transform: rotateY(180deg) translateX(100px);
            }
        } 
        .loginContainer{
            height: 500px;
            margin-top: 80px;
            transform: translateY(-180px);
            .loginPanel{
                width: 400px;
                margin-left: 1000px;
                border-radius: 10px;
                padding: 20px;
                background-color: white;
                opacity: 0.9;
            }
        }
    }

    .title{
        font-size: 25px;
        font-weight: bold;
        margin-top: 10px;
        color: #e4393c;
    }
    .username{
        display: flex;
        margin-top: 50px;
        margin-left: 20px;
        width: 350px;
        border: 1px solid #bdbdbd;
        .el-icon{
            font-size: 30px;
            margin-left: 20px;
            margin-right: 20px;
            transform: translateY(5px);
        }
    }
    .password{
        display: flex;
        margin-top: 30px;
        width: 350px;
        margin-left: 20px;
        border: 1px solid #bdbdbd;
        .el-icon{
            font-size: 30px;
            margin-left: 20px;
            margin-right: 20px; 
            transform: translateY(5px);
        }
    }
    .forgetPassword{
        text-align: right;
        font-size: 16px;
        margin-right: 30px;
        margin-top: 20px;
        color: #f3f3f3;
    }
    .commit{
        margin: 0 auto;
        margin-top: 40px;
        margin-bottom: 30px;
        background-color: #e4393c;
        border-radius: 3px;
        width: 90%;
        padding: 5px;
        font-size: 25px;
        font-weight: bold;
        color: white;
        &:hover{
            cursor: pointer;
        }
        &:active{
            transform: scale(1.02);
        }
    }
    .register{
        display: flex;
        .el-icon{
            transform: translateY(5px);
        }
        .registerLink{
            transform: translateX(220px);
        }
        
    }
</style>