<template>
    <div class="mainContainer">
        <div class="info">
            <div class="userInfo">
                <el-avatar :size="100" :src="userData.headpicture">
                </el-avatar>
                <div class="name">
                    <el-link :underline="false" href="\">
                        {{userData.uname}}
                    </el-link>
                </div>
            </div>
            <div>
                <div class="myMoney">
                    
                </div>
            </div>
        </div>
        <div class="panel">
            <div class="nickname">
                昵称：<el-input v-model="nickname" :placeholder="userData.nickname" clearable size="large" />
            </div>
            <div class="persignature">
                <div class="plabel">个性签名：</div>
                  <el-input
                    v-model="persignature"
                    :autosize="{ minRows: 4, maxRows: 8 }"
                    type="textarea"
                    :placeholder="userData.persignature"
                />
            </div>
            <div class="phone">
                头像:
                <el-input v-model="headpicture" :placeholder="userData.headpicture" clearable size="large" />
            </div>
            <div class="headImg">
                <el-image v-if="userData.headpicture" :src="userData.headpicture"></el-image>
            </div>
            <div class="email">
                邮箱:
                <el-input v-model="email" :placeholder="userData.email" clearable size="large" />
            </div>
            <div class="locationCards">
            <div class="locationCard" v-for="(item,index) in locationData">
                <div class="border">
                    <div class="name"> 
                        <el-icon><User /></el-icon>{{userData.uname}}收
                    </div>
                    <el-divider></el-divider>
                    <div class="locationDetail" >
                        <el-icon><OfficeBuilding /></el-icon>
                        {{item.countries + '/' + item.provinces + '/' + item.city + '/' + item.detailaddress}}<br/>
                    </div>
                    <div class="modify">
                        <el-link :underline="false" @click="deleteAdress(index)">删除地址<el-icon><ArrowRight /></el-icon></el-link>
                    </div>
                </div>
            </div>
            <div class="addButton">
                <el-button type="text"  size="large" @click="showAddDialog()">
                    添加地址
                </el-button>
            </div>
            </div>
        </div>
        <div class="commiteButton">
            <el-button type="success" size="large" @click="updateUserInfo()">
                更新个人信息
            </el-button>
        </div>

        <el-dialog title="添加地址" v-model="addAdressVisible" width="30%"  append-to-body>
            <div class="detailAdress">
                详细地址：<el-input v-model="detailaddress" size="large" placeholder="请输入详细信息。" clearable />
            </div>
            <div class="cityLabel">
                城市：
            </div>
            <el-cascader
                size="large"
                :options="options"
                v-model="selectedOptions"
                @change="handleChange">
            </el-cascader>
        <span slot="footer" class="dialog-footer">
            <el-button @click="addAdressVisible = false">取 消</el-button>
            <el-button type="primary" @click="addLocation()">确 定</el-button>
        </span>
        </el-dialog>
    </div>
</template>
<script>

import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import {ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
import {regionData,CodeToText} from 'element-china-area-data'
export default {



    name:"myinfo",
    data() {
        return {
            persignature:"",
            options: regionData,
            selectedOptions: [],
            addtions:{},
            addAdressVisible:false,
            detailaddress:"",

            nickname:this.userData ? this.userData.nickname : "",
            persignature:this.userData ?this.userData.persignature:"",
            headpicture:this.userData?this.userData.headpicture:"",
            email:this.userData?this.userData.email:"",

        }
    },
    computed:{
      ...mapGetters(['userData','locationData','token']), 

    },
    methods: {
        handleChange (value) {
            this.addtions.selectedOptions = value
        },
        showAddDialog(){
            this.addAdressVisible = true;
        },
        async addLocation(){
            try {
                this.addAdressVisible = false;
                let countries = CodeToText[this.selectedOptions['0']];
                let provinces = CodeToText[this.selectedOptions['1']];
                let city = CodeToText[this.selectedOptions['2']];
                let detailaddress = this.detailaddress;
                await this.$store.dispatch("addAddress", {
                    name:this.$store.getters.userData.uname,
                    phone:this.$store.getters.userData.phone,
                    countries,
                    provinces,
                    city,
                    detailaddress,
                });
                this.getLocationData();
                ElNotification({
                    title: '添加收货地址成功！',
                    message: countries+'/'+provinces+'/'+city+'/'+detailAddress,
                    type: 'success'
                })
                } catch (error) {
                    ElNotification({
                        title: '添加收货地址失败！',
                        message: error,
                        type: 'error'
                    })
                }
        },
        async getLocationData(){
          try {
              await this.$store.dispatch("getLocationData", {
                phone:this.$store.getters.userData.phone,
              });
            } catch (error) {
                ElNotification({
                    title: '获取地址数据失败！',
                    message: error,
                    type: 'error'
                })
            }
        },
        deleteAdress(index){
            try {
                ElMessageBox.confirm(
                    '你确定要删除此收货地址吗?',
                    '询问',
                    {
                    confirmButtonText: '确认',
                    cancelButtonText: '取消',
                    type: 'Info',
                    }
                )
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        message: '取消提交',
                    })
                })
                .then(async () => {
                    await this.$store.dispatch("deleteAdress", {
                        aid:this.locationData[index].aid
                    });
                    this.getLocationData();
                    ElMessage({
                        type: 'success',
                        message: '删除成功',
                    })
                })
            } catch (error) {
                ElNotification({
                    title: '获取地址数据失败！',
                    message: error,
                    type: 'error'
                })
            }
        },
        async updateUserInfo(){
            try {
                ElMessageBox.confirm(
                    '你确定要更新用户信息吗?',
                    '询问',
                    {
                    confirmButtonText: '确认',
                    cancelButtonText: '取消',
                    type: 'Info',
                    }
                )
                .then(async () => {
                    await this.$store.dispatch("updateUserInfo", {
                        uid:this.userData.uid,
                        nickname:this.nickname,
                        persignature:this.persignature,
                        headpicture:this.headpicture,
                        email:this.email
                    });
                    await this.$store.dispatch('getNowUserData',this.token);
                    await this.getLocationData()
                    ElNotification({
                        type: 'success',
                        message: '更新用户信息成功！',
                        title:'更新成功'
                    })
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        message: '取消提交',
                    })
                })
               
            } catch (error) {
                ElNotification({
                    title: '获取地址数据失败！',
                    message: error,
                    type: 'error'
                })
            }
        }

    },

    mounted() {
        this.getLocationData();
    },
}
</script>
<style lang="less" scoped>
    .info{
        background-color: white;
        border-radius: 10px;
        padding: 20px;
        display: flex;
        .userInfo{
            display: flex;
            .el-link{
                font-size: 25px;
                margin-left: 20px;
                margin-top: 40px;
                font-weight: bold;
            }
        }
    }
    .panel{
        background-color: white;
        margin-top: 50px;
        padding: 30px;
        border-radius: 20px;
        text-align: left;
        font-size: 20px;
        color: #52a6fd;
        font-weight: bold;
        .nickname{
            display: flex;
            margin-top: 20px;
            .el-input{
                width: 200px;
                transform: translateY(-5px);
            }
        }
        .persignature{
            margin-top: 30px;
            .plabel{
                margin-bottom: 20px;
            }
        }
        .phone{
            margin-top: 20px;
            .el-input{
                display: block;
                width: 300px;
                margin-top: 20px;
            }
        }
        .email{
            margin-top: 20px;
            .el-input{
                display: block;
                width: 300px;
                margin-top: 20px;
            }
        }
        .locationCards{

            display: flex;
        }
        .locationCard{
            width: 300px;
            margin-top: 30px;
            padding: 8px;
            border-radius: 8px;
            margin-right: 30px;
            background-image: linear-gradient(222deg, rgb(235, 50, 47), rgb(218, 245, 45));
            &:hover{
                transform: scale(1.01);
                cursor: pointer;
            }
            .el-icon{
                font-size: 20px;
            }
            .border{
                background-color: white;
            }
            .name{
                transform: translateX(10px) translateY(5px);
                font-weight: bold;
                color: #666666;
            }
            .locationDetail{
                transform: translateX(10px) translateY(-5px);
                color: #666666;
                font-size: 15px;
            }
            .modify{
                transform: translateX(10px) translateY(-5px);
                .el-link{
                    color: #cc9977;
                }
            }
        }
        .addButton{
            font-size: 20px;
            transform: translateY(20px);
        }

    }
    .commiteButton{
        width: 150px;
        margin-left: 500px;
        transform: scale(1.3) translateX(330px) translateY(-55px);
    }
    .el-dialog{
        .detailAdress{
            font-size: 18px;
            font-weight: bold;
            color: #666666;
            margin-bottom: 30px;
            .el-input{
                display: block;
                margin-top: 15px;
                width: 300px;
            }
        }
        .cityLabel{
            font-size: 18px;
            font-weight: bold;
            color: #666666;
            margin-bottom: 15px;
        }
        .elcascader{
            display: block;
        }
        .dialog-footer{
            display: block;
            margin-top: 20px;
            margin-left: 250px;
        }

    }
    .headImg{
        margin-top: 15px;
        width: 100px;
    }
</style>