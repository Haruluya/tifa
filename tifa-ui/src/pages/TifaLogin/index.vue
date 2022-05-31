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
                            v-model="uname"
                            size="large"
                            placeholder="Please Input"
                            />
                        </div>
                        <div class="password">
                            <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                            <el-input
                            v-model="password"
                            size="large"
                            type="password"
                            placeholder="Please Input"
                            />
                        </div>
                        <div class="forgetPassword">
                            <el-link :underline="false" @click="this.dialogFormVisible = true">忘记密码</el-link>
                        </div>
                        <div class="commit" @click="confirmLogin()">
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
                    <el-tab-pane label="扫码登录" name="codeLogin">
                        <div class="title">
                            扫描微信二维码登录TIFA
                        </div>
                        <div class="wxImg">
                            <el-image :src="imgUrl"></el-image>
                        </div>
                        <div class="footer">
                            未注册用户扫码将使用微信用户信息自动注册
                        </div>
                    </el-tab-pane>
                </el-tabs>
                
            </div>
        </div>
        <el-dialog v-model="dialogFormVisible" title="找回密码">
        <el-form :model="form" class="form">
        <el-form-item label="手机号" :label-width="formLabelWidth" class="fphone" size="large">
            <el-input v-model="form.phone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" class="fpassword" size="large">
            <el-input v-model="form.password" autocomplete="off" />
        </el-form-item>
        <el-form-item label="验证码" :label-width="formLabelWidth" class="fcode" size="large">
            <el-input v-model="form.code" autocomplete="off" />
            <el-button type="success" @click="getRCode()">{{codeButtonCt}}</el-button>
        </el-form-item>
        </el-form>
        <template #footer>
        <span class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="rePassword()"
            >确认</el-button
            >
        </span>
        </template>
        </el-dialog>
    </div>
</template>
<script>
import { ElMessage } from 'element-plus'
import HomeHeader from '../ShopHome/HomeHeader'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import { ElNotification,ElMessageBox} from 'element-plus'
import QRCode from 'qrcode'
export default {
    name:"tifalogin",
    components:{
        HomeHeader,
    },
    computed:{
      ...mapGetters(['codeUrl','isLogin'])
    },
    data() {
        return {
            loginActiveTab:"inputeLogin",
            uname:"",
            password:"",
            imgUrl:"",
            codeButtonCt:"获取验证码",
            dialogFormVisible:false,
            form:{
                phone:"",
                password:"",
                code:"",
            }
        }
    },
    methods: {
      async confirmLogin(){
        try {
          //登录成功
          const { uname, password } = this;
          uname&&password&&(await this.$store.dispatch("confirmLogin", { uname, password }));
            ElMessage({
                message: '登陆成功！',
                type: 'success',
            })
          let toPath = this.$route.query.redirect||"/shophome";
          this.$router.push(toPath);
        } catch (error) {
          ElMessage.error(error);
        }
      },
      async sendCode(){
            this.codeButtonCt = "请填写验证码";
            await this.$store.dispatch('sendCode',{phone:this.form.phone})
        },

      async getCode(){
          await this.$store.dispatch('getCode');
          QRCode.toDataURL(this.codeUrl.url)
            .then(url => {
                this.imgUrl=url;
            })
            .catch(err => {
                console.error(err,"XXX")
            })
      },
      async isLogin(){
          await this.$store.dispatch('islogin');
      },
      async rePassword(){

            ElMessageBox.confirm(
                '你确定要重置密码吗?',
                '⚠警告',
                {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'warning',
                }
            )
            .then(async () => {
                await this.$store.dispatch('rePassword',this.form);
                this.dialogFormVisible = false;
                ElMessage({
                    type: 'success',
                    message: '重置成功',
                })
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '取消重置',
                })
            })
      }
    },
    mounted() {
        this.getCode();
        this.timer = setInterval(()=>{
            this.$store.dispatch('islogin');
            if (this.isLogin){
                clearInterval(this.timer);
                this.$router.push('/shophome');
                ElNotification({
                    title: '扫码登录成功！',
                    message: '已自动导入微信号用户信息！',
                    type: 'success',
                })
            }
        },3000)
    },
    unmounted() {
        clearInterval(this.timer);
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
    .footer,
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
    .wxImg{
        margin-top: 50px;
    }
    .footer{

    }
    .form{
        margin-left: 50px;
        font-size: 20px;
        font-weight: bold;
        .fphone{
            width: 400px;
        }
        .fpassword{
            width: 385px;
            margin-left: 15px;
        }
        .fcode{
            width: 200px;
            display: flex;
            .el-button{
                margin-top: 15px;
                transform: translateX(180px) translateY(-55px);
            }
        }
    }
</style>