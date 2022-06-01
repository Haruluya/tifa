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
                    <el-step title="身份信息填写" v-show="!isMerchant"/>
                    <el-step title="店铺信息认证" v-show="isMerchant"/>
                    <el-step title="注册成功" />
                </el-steps>
            </div>
            <el-form   :model="firstStepFormModel" :rules="firstStepFormRules" ref="firstStepFormModel">
              <div class="inputPanel" v-if="registerStep == '1'">
                <div class="phone infoInpute">
                    <div class="loginIcon"><el-icon><Phone /></el-icon></div>
                   <el-form-item prop="phone">
                    <el-input
                    v-model="firstStepFormModel.phone"
                    size="large"
                    placeholder="输入手机号"
                    />
                   </el-form-item>
                </div>
                <div class="phoneCode">
                    <div class="loginIcon"><el-icon><DocumentRemove /></el-icon></div>
                    <el-form-item prop="code">
                        <el-input
                        v-model="firstStepFormModel.code"
                        size="large"
                        placeholder="输入验证码"
                        />
                    </el-form-item>
                    <el-button type="primary" @click="sendCode()">{{codeButtonCt}}</el-button>
                </div>
              </div>
            </el-form>
            <el-form :model="secondStepFormModel" :rules="secondStepFormRules" ref="secondStepFormModel">

            <div class="inputPanel" v-if="(registerStep == '2' && !isMerchant)">
                <div class="userName infoInpute" >
                    <div class="loginIcon"><el-icon><User /></el-icon></div>
                    <el-form-item prop="secondStepFormModel.userName">
                        <el-input
                        v-model="secondStepFormModel.userName"
                        class="w-50 m-2"
                        size="large"
                        placeholder="输入用户名"
                        />
                    </el-form-item>
                </div>
                <div class="password infoInpute" >
                    <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                    <el-form-item prop="password">
                        <el-input
                        v-model="secondStepFormModel.password"
                        class="w-50 m-2"
                        size="large"
                        type="password"
                        placeholder="输入密码"
                        />
                    </el-form-item>
                </div>
                <div class="confimPassword infoInpute" >
                    <div class="loginIcon"><el-icon><Unlock /></el-icon></div>
                     <el-form-item prop="confirmPassword">
                        <el-input
                        v-model="secondStepFormModel.confirmPassword"
                        class="w-50 m-2"
                        size="large"
                        type="password"
                        placeholder="再次输入密码"
                        />
                     </el-form-item>
                </div>
                <div class="email infoInpute" >
                    <div class="loginIcon"><el-icon><Message /></el-icon></div>
                     <el-form-item prop="email">
                        <el-input
                        v-model="secondStepFormModel.email"
                        size="large"
                        placeholder="输入邮箱"
                        />
                     </el-form-item>
                </div>
            </div>
            <div class="merchant" v-if="isMerchant && registerStep == '2' ">
                <el-form
                ref="merchantStepFormModelRef"
                :model="merchantStepFormModel"
                label-width="120px"
                :size="formSize"
            >
                <el-form-item label="店铺名称" prop="name">
                <el-input v-model="merchantStepFormModel.merchantName" />
                </el-form-item>
                <el-form-item label="开店时间" required>
                <el-col :span="11">
                    <el-form-item prop="date1">
                    <el-date-picker
                        v-model="merchantStepFormModel.openDate"
                        type="date"
                        label="Pick a date"
                        placeholder="Pick a date"
                        style="width: 100%"
                    />
                    </el-form-item>
                </el-col>
                <el-col class="text-center" :span="2">
                    <span class="text-gray-500">-</span>
                </el-col>
                <el-col :span="11">
                    <el-form-item prop="date2">
                    <el-time-picker
                        v-model="merchantStepFormModel.openTime"
                        label="Pick a time"
                        placeholder="Pick a time"
                        style="width: 100%"
                    />
                    </el-form-item>
                </el-col>
                </el-form-item>
                <el-form-item label="店铺种类" prop="type">
                <el-checkbox-group v-model="merchantStepFormModel.type">
                    <el-checkbox label="售后服务" name="type" />
                    <el-checkbox label="七天无理由退款" name="type" />
                    <el-checkbox label="只线上服务" name="type" />
                    <el-checkbox label="遵守tifa优惠政策" name="type" />
                </el-checkbox-group>
                </el-form-item>
                <el-form-item label="店铺类型" prop="resource">
                <el-radio-group v-model="merchantStepFormModel.resource">
                    <el-radio label="个人" />
                    <el-radio label="企业" />
                </el-radio-group>
                </el-form-item>
                <el-form-item label="店铺描述" prop="desc">
                <el-input v-model="merchantStepFormModel.desc" type="textarea" />
                </el-form-item>
            </el-form>
            </div>
            </el-form>
         


            <div class="inputPanel" v-if="registerStep == 3">
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
import { ElMessage, ElMessageBox,ElNotification} from 'element-plus'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
export default {
    name:"tifaregister",
    components:{
        HomeHeader,
    },
    computed:{
      ...mapGetters(['userData','code'])
    },
    data() {
        return {
            registerStep:1,
            isMerchant:false,
            codeButtonCt:"发送验证码",
            firstStepFormModel:{
                phone:'',
                code:''
            },
            secondStepFormModel:{
                userName:"",
                password:"",
                confirmPassword:"",
                email:""  
            },
            merchantStepFormModel:{
                merchantName:"",
                openDate:"",
                openTime:"",
                type:[],
                resource:"",
                desc:"",
            },
            firstStepFormRules:{
                phone:[
                    {required: true, message: '手机号不为空！', trigger: 'blur' },
                    
                    ],
                code:[
                    {required: true, message: '验证码不为空！', trigger: 'blur' },
                ]
            },
            secondStepFormRules:{
                userName:[
                    { min: 2, max: 18, message: '用户名长度在2到18个字符之间！', trigger: 'blur' },
                ],
                password: [
                      { required: true, message: '请输入密码！', trigger: 'blur' },
                      { min: 8, max: 17, message: '密码长度在8到17个字符！', trigger: 'blur' },
                      { pattern: /^(?![^a-zA-Z]+$)(?!\D+$)/, message: '密码必须包含数字和字母！', trigger: 'blur' }
                    ],
                email:[
                    { required: true, message: '请输入邮箱！', trigger: 'blur'},
                    { type: 'email', message: '邮箱格式错误！', trigger: ['blur', 'change']},
                ]
            },

        }
    },


    methods: {
        stepAdd(){
            if (this.registerStep == 1){
                this.$refs['firstStepFormModel'].validate((result) => {
                    if (result && this.code == this.firstStepFormModel.code) {
                        this.$message.success('验证通过')
                        this.registerStep++;
                    } else {

                        this.$message.error('验证码不正确！')
                    }
                })

            }
            if (this.registerStep == 2 && !this.isMerchant){
                this.$refs['secondStepFormModel'].validate((result) => {
                    if (result) {
                        ElMessageBox.confirm(
                            '提交注册申请？',
                            'info',
                            {
                                confirmButtonText: '提交',
                                cancelButtonText: '取消',
                                type: 'info',
                            }
                        )
                        .then(() => {
                            this.commitRegister();
                            this.registerStep++;
                            ElMessage({
                                type: 'success',
                                message: '提交成功',
                            })
                        })
                        .catch(() => {

                        })
                    } else {
                        this.$message.error("表单格式错误！")
                    }
                })
            }
            if (this.registerStep == 2 && this.isMerchant){
                ElMessageBox.confirm(
                    '提交店铺信息？',
                    'info',
                    {
                        confirmButtonText: '提交',
                        cancelButtonText: '取消',
                        type: 'info',
                    }
                )
                .then(() => {
                    this.$store.dispatch("registerMerchant",{uid:this.userData.uid})
                    this.registerStep++;
                    ElMessage({
                        type: 'success',
                        message: '提交成功',
                    })
                })
                .catch(() => {

                })
            }
        },
        stepReduce(){
            if (this.registerStep > 1){
                this.registerStep--;
            }
        },
        toLoginPage(){
            this.$router.push('tifalogin');
        },
        //用户注册。
        async commitRegister() {
            try {
                await this.$store.dispatch("commitRegister", {
                    "uname":this.secondStepFormModel.userName,
                    "password":this.secondStepFormModel.password,
                    "phone":this.firstStepFormModel.phone,
                    "email":this.secondStepFormModel.email,
                });
                ElNotification({
                    title: '注册成功',
                    message: '你已成为TIFA新用户！',
                    type: 'success',
                })
            } catch (error) {
                ElNotification({
                    title: '注册失败',
                    message: error,
                    type: 'error',
                })
            }
        },
        async sendCode(){
            this.codeButtonCt = "请填写验证码";
            await this.$store.dispatch('sendCode',{phone:this.firstStepFormModel.phone})
        }
    },
    mounted() {
        this.isMerchant = this.$route.query.isMerchant;
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
    .phone{
        .el-input{
            width: 400px;
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
        .el-input{
            width: 200px;
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
        .el-input{
            width: 400px;
        } 
    }
    .userName{
        width: 50%;
        transform: translateX(-80px);
    }

    .merchant{
        margin-top: 50px;
    }

    
</style>