<template>
    <div class="mainContainer">
        <div class="tifaBackgroundImg">
            <img src="https://images6.alphacoders.com/106/1061312.jpg" />
        </div>
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="registerContainer">
            <div class="steps">
                <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="手机号绑定" />
                    <el-step title="身份信息填写" />
                    <el-step title="注册成功" />
                </el-steps>
            </div>
            <div class="phone">
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
            <div class="nextStep">
                <el-icon><DArrowRight /></el-icon>
                <el-link :underline="false">下一步</el-link>
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
}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin: 0 auto;
         .tifaBackgroundImg{
            display: none;
            position: absolute;
            z-index: -1;
            overflow: hidden;
            img{
                width: 1800px;
                transform: rotateY(180deg) translateX(100px);
            }
        }
        .registerContainer{
            margin: 0 auto;
            margin-top: 50px;
            width: 800px;
            background-color: white;
            padding: 20px;
        } 
    }
    .steps{

    }
    .phone{
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
    .nextStep{
        margin-top: 40px;
        text-align: right;
        margin-right: 120px;
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
</style>