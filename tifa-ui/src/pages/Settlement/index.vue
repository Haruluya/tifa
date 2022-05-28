<template>
    <div class="mainContainer"> 
        <div class="headerTitle">
            <div class="info">
                <span>中国大陆</span>
            </div>
           <div class="headerLinks">
                <el-breadcrumb :separator-icon="ArrowRight">
                    <el-breadcrumb-item :to="{ path: '/' }">我的订单</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">我的TIFA</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">网站导航</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">网站无障碍</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">TIFA</el-breadcrumb-item>
                </el-breadcrumb>
            </div> 
        </div>
        <div class="header">
            <div class="logo">
                <el-link :underline="false" class="title" href="shophome">
                  TIFA
              </el-link>
              <el-link :underline="false">
                <el-image :src="logo">
                </el-image>
              </el-link>
            </div>
            <div class="steps">
                <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="查看购物车" />
                    <el-step title="拍下商品" />
                    <el-step title="付款" />
                    <el-step title="确认收货" />
                    <el-step title="评价" /> 
                </el-steps>
            </div>
        </div>
        <div class="locations">
            <div class="label">
                选择收货地址
            </div>
            <el-divider></el-divider>
            <div class="locationCards">
            <div class="locationCard" v-for="(item,index) in locationData" @click="selectLocationCard(index)">
                <div class="border">
                    <div class="name"> 
                        <el-icon><User /></el-icon>{{userData.uname}}收
                    </div>
                    <el-divider></el-divider>
                    <div class="locationDetail" >
                        <el-icon><OfficeBuilding /></el-icon>
                        {{item.countries + '/' + item.provinces + '/' + item.city + '/' + item.detailaddress}}
                    </div>
                    <div class="modify">
                        <el-link :underline="false"  @click="deleteAdress(index)">删除地址<el-icon><ArrowRight /></el-icon></el-link>
                    </div>
                </div>
            </div>
    
  
            </div>
            <div class="addLocation">
            <el-button type=""  @click="showAddDialog()"><el-icon><Plus /></el-icon>添加新地址</el-button>
            </div>
        </div>
        <div class="goodsCar">
            <div class="label">
                确认订单消息
            </div>
            <el-divider></el-divider>
            <ShopCartContent :showButton="false"/>
        </div>
        <div class="total">
            <div class="price">
                实付款:<span>￥{{sumPrice}}</span>
            </div>
            <div class="location">
                寄送至:<span>{{selectLocation}}</span>
            </div>
            <div class="person">
                收货人:<span>{{userData.uname}} {{userData.phone}}</span>
            </div>
        </div>
        <div class="commit">
            <el-button type="" @click="commitOrder()">提交订单</el-button>
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
import ShopCartContent from '_pages/TifaShopCart/ShopCartContent'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import {ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
import logo from '../../assets/logo.png' 
import {regionData,CodeToText} from 'element-china-area-data'
export default {
    name:"settlement",
    components:{
        ShopCartContent
    },
    data() {
        return {
            logo,
            options: regionData,
            selectedOptions: [],
            addtions:{},
            addAdressVisible:false,
            detailaddress:"",
            selectLocation:""
        }
    },
    computed:{
      ...mapGetters(['userData','locationData','sumPrice']), 

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
        selectLocationCard(index){
            this.selectLocation = 
                this.locationData[index].countries + '/' + 
                this.locationData[index].provinces + '/' + 
                this.locationData[index].city + '/' + 
                this.locationData[index].detailaddress
        },
        commitOrder(){
            this.$router.push('/purchase');
            ElNotification({
                title: '请付款',
                message: '创建订单成功！',
                type: 'sucess'
            })
        },
        
    },
    mounted() {
        this.getLocationData();
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        background-color: white;
        padding-bottom: 300px;
        .header{
            width: 1200px;
            display: flex;
            margin: 0 auto;
            .steps{
                width: 800px;
                margin-left: 150px;
                .el-steps{
                    background-color: white;
                }
            }
        }
    }

    .headerTitle{
        display: flex;
        justify-content: center;
        align-content: center;
        background-color: #e3e4e5;
        
        height: 35px;
        .info{
            margin-top: 5px;
            margin-right: 100px;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            
        }
        .headerLinks{
            margin-left: 10px;
            margin-top: 10px;
        }
    }
    .header{
        .logo{
            .title{
                font-size: 45px;
                font-weight: bold;
                &:hover{
                    color: #e1251b;
                }
            }
            .el-image{
                width: 150px;
            }
        }
    }
    .label{
        text-align: left;
        font-size: 20px;
        font-weight: bold;
    }
    .locations{
        width: 1200px;
        margin: 0 auto;
        margin-top: 100px;
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
                cursor: pointer;
                transform: scale(1.01);
            }
            
            .el-icon{
                font-size: 20px;
            }
            .border{
                background-color: white;
            }
            .name{
                transform: translateY(10px) translateX(-80px);
                font-weight: bold;
                color: #666666;
            }
            .locationDetail{
                transform: translateY(-18px) translateX(-10px);
                color: #666666;
                font-size: 15px;
            }
            .modify{
                transform: translateY(-5px) translateX(-100px);
                .el-link{
                    color: #cc9977;
                }
            }
        }
        .addLocation{
            width: 100px;
            margin-top: 40px;
        }

    }
    .goodsCar{
        width: 1200px;
        margin: 0 auto;
        margin-top: 50px;

    }
    .total{
        width: 300px;
        background-color: #f2f7ff;
        margin-left: 950px;
        margin-top: 50px;
        text-align: right;
        border: 1px solid red;
        box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;        
        padding: 20px;
        .price{
            font-size: 16px;
            font-weight: bold;
            span{
                font-size: 24px;
                color: red;
            }
        }
        .person,
        .location{
            width: 300px;
            font-size: 14px;
            color:#666666;
            font-weight: bold;
            span{
                font-weight: 100;
            }
        }
   
    }
    .commit{
        width: 150px;
        margin-left: 1140px;
        margin-top: 20px;
        .el-button{
            width: 100%;
            height: 40px;
        }
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
</style>