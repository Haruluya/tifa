<template>
    <div class="mainContainer">
        <div class="tifaBackgroundImg">
            <img src="https://images5.alphacoders.com/111/1110463.jpg" />
        </div>
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="registerContainer">
            <div class="steps">
                <el-steps :active="registerStep" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="手机号绑定" />
                    <el-step title="身份信息填写" />
                    <el-step title="注册成功" />
                </el-steps>
            </div>
            <div class="inputPanel" v-if="registerStep == '1'">
                <div class="phone infoInpute">
                    <div class="loginIcon"><el-icon><Phone /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="输入手机号"
                    />
                </div>
                <div class="phoneCode">
                    <div class="loginIcon"><el-icon><DocumentRemove /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="输入验证码"
                    />
                    <el-button type="primary">发送验证码</el-button>
                </div>
            </div>
            <div class="inputPanel" v-if="registerStep == '2'">
                <div class="userName infoInpute" >
                    <div class="loginIcon"><el-icon><User /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="输入用户名"
                    />
                </div>
                <div class="password infoInpute" >
                    <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="输入密码"
                    />
                </div>
                <div class="confimPassword infoInpute" >
                    <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="再次输入密码"
                    />
                </div>
                <div class="email infoInpute" >
                    <div class="loginIcon"><el-icon><Message /></el-icon></div>
                    <el-input
                    v-model="input1"
                    class="w-50 m-2"
                    size="large"
                    placeholder="输入邮箱"
                    />
                </div>
            </div>
            <div class="inputPanel" v-if="registerStep == '3'">
                <el-result
                    icon="success"
                    title="注册成功！"
                    sub-title="你的账号：Haruluya注册成功！"
                >
                    <template #extra>
                    <el-button type="primary" @click="toLoginPage()">去登录</el-button>
                    </template>
                </el-result>
            </div>
            <div class="stepButton">
                <div class="lastStep" v-show="registerStep == 2">
                    <el-icon><DArrowLeft /></el-icon>
                    <el-link :underline="false" @click="stepReduce">上一步</el-link>
                </div>
                <div class="nextStep" v-show="registerStep != 3">
                    <el-icon><DArrowRight /></el-icon>
                    <el-link :underline="false" @click="stepAdd">下一步</el-link>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
export default {
    name:"tifaregister",
    components:{
        HomeHeader,
    },
    data() {
        return {
            registerStep:1,

        }
    },
    methods: {
        stepAdd(){
            if (this.registerStep < 3){
                this.registerStep++;
            }
        },
        stepReduce(){
            if (this.registerStep > 1){
                this.registerStep--;
            }
        },
        toLoginPage(){
            this.$router.push('tifalogin');
        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin: 0 auto;
        margin-bottom: 300px;
         .tifaBackgroundImg{
            position: absolute;
            opacity: 0.8;
            z-index: -1;
            overflow: hidden;
            img{
                width: 1800px;
            }
        }
        .registerContainer{
            margin: 0 auto;
            transform: translateY(-150px);
            width: 800px;
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            opacity: 0.9;
        } 
    }
    .steps{

    }

    .phoneCode{
        display: flex;
        margin: 0 auto;
        margin-top: 50px;
        width: 70%;
         .el-icon{
            font-size: 30px;
            margin-left: 20px;
            margin-right: 20px;
            transform: translateY(5px);
        } 
        .el-button{
            margin-left: 20px;
            height: 40px;
        } 
    }
    .stepButton{
        display: flex;
    }
    .lastStep,
    .nextStep{
        margin-top: 40px;
        .el-icon{
            font-size: 24px;
            margin-right: 5px;
            transform: translateY(10px);
        }
        .el-link{
            font-size: 20px;
            font-weight: bold;
            color:#606266;
            &:hover{
               color: red;   
            }
        }
        &:hover{
            color: red;
        }

    }
    .lastStep{
        transform: translateX(30px);
    }
    .nextStep{
        transform: translateX(550px);
    }

    .infoInpute{
        display: flex;
        margin: 0 auto;
        margin-top: 40px;
        width: 70%;
         .el-icon{
            font-size: 30px;
            margin-left: 20px;
            margin-right: 20px;
            transform: translateY(5px);
        }   
    }
    .userName{
        width: 50%;
        transform: translateX(-80px);
    }

    
</style>