<template>
    <div class="mainContainer">
        <div class="header">
            <div class="time">
                <el-icon><AlarmClock /></el-icon>{{orderData.ordersData[index].createdate}}
            </div>
            <div class="orderId">
                订单号: {{orderData.ordersData[index].oid}}<el-icon><Collection /></el-icon>
            </div>
            <div class="back" v-if="orderData.ordersData[index].status == 'comment' ">
                <el-button type="text" @click="dialogFormVisible=true">请求退货</el-button>
            </div>
        </div>
        <div class="content">
            <div class="goodImg">
                <el-image :src="orderData.productImgData[index].type">

                </el-image>
            </div>
            <div class="title">
                {{orderData.productData[index].pname}}
            </div>
            <div class="amount">
                <el-button type="text" @click="confirmDe()" v-if="orderData.ordersData[index].status == 'delivery'">
                    确认收货
                </el-button>
                <el-button type="text" @click="confirmDer()" v-if="orderData.ordersData[index].status == 'paid'">
                    等待发货
                </el-button>
                <el-button type="text" @click="toComment()" v-if="orderData.ordersData[index].status == 'comment' ">
                    去评价
                </el-button>
            </div>
            <el-divider direction="vertical" />
            <div class="name">
                {{userData.uname}}<el-icon><Avatar /></el-icon>
            </div>
            <el-divider direction="vertical" />
            <div class="price">
                ￥{{orderData.productData[index].promoteprice}}
            </div>
            <el-divider direction="vertical" />
            <div class="status">
                {{orderData.ordersData[index].status}}
            </div>
        </div>
        <el-dialog append-to-body v-model="dialogFormVisible" title="退货申请">
            <el-form :model="form">
            <el-form-item label="服务类型">
                <el-radio-group v-model="form.serviceType" size="large">
                    <el-radio-button label="退货" />
                    <el-radio-button label="换货" />
                    <el-radio-button label="补发商品" />
                </el-radio-group>
            </el-form-item>
            <el-form-item label="退款类型">
                <el-radio-group v-model="form.returnType" size="large">
                    <el-radio-button label="原支付方式返回" />
                    <el-radio-button label="退款至账户余额" />
                </el-radio-group>
            </el-form-item>
            <el-form-item label="提交原因">
                <el-select v-model="form.result" class="m-2" placeholder="Select" size="large">
                <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
                />
                </el-select>
            </el-form-item>
            <el-form-item label="详细描述" :label-width="formLabelWidth">
                <el-input v-model="form.des" autocomplete="off" type="textarea" />
            </el-form-item>
            </el-form>
            <template #footer>  
            <span class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="confirmReturn()"
                >确认</el-button
                >
            </span>
            </template>
        </el-dialog>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import { ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"ordercard",
    data(){
        return {
            dialogFormVisible:false,
            form:{
                serviceType:"退货",
                returnType:"原支付方式返回",
                result:"1",
                des:""
            },
            options:[
                {
                    value:"1",
                    label:"商品与页面描述不符",
                },
                {
                    value:"2",
                    label:"质量问题",
                },
                {
                    value:"3",
                    label:"卖家发错货",
                },
                {
                    value:"4",
                    label:"发票问题",
                },
                {
                    value:"5",
                    label:"其他"
                }
            ]
        }
    },
    props:{
        oData:{
            default:{}
        },
        index:{
            
        }
    },
    computed:{
      ...mapGetters(['userData','orderData']), 

    },
    methods: {
        async confirmDe(){
            ElMessageBox.confirm(
                '确认收货?',
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
                let oid = this.oData.ordersData[this.index].oid;
                await this.$store.dispatch('confirmDe',{oid});
                this.$router.push('/userinfo/myorder');
                ElMessage({
                    type: 'success',
                    message: '更新成功',
                })
            })
        },
        async confirmDer(){
            ElMessageBox.confirm(
                '确认发货?',
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
                let oid = this.orderData.ordersData[this.index].oid;
                await this.$store.dispatch('confirmDeto',{oid});
                this.$router.push('/userinfo/myorder');
                ElMessage({
                    type: 'success',
                    message: '更新成功',
                })
            })
        },
        toComment(){
            this.$router.push("/gooddetail/"+this.orderData.productData[this.index].pid+"?tifa=1");
        },
        async confirmReturn(){
            this.dialogFormVisible = false;
            ElMessageBox.confirm(
                '确认提交退货申请?',
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
                await this.$store.dispatch('returnProduct',{oid:this.orderData.ordersData[this.index].oid});
                ElMessage({
                    type: 'success',
                    message: '提交成功',
                })
            })
        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        border: 1px solid rgb(128, 128, 128);
        margin-top: 15px;
        box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;

        &:hover{
            transform: scale(1.01);
            cursor: pointer;
        }
        .header{
            display: flex;
            padding: 10px;
            padding-bottom: 5px;
            padding-top: 3px;
            background-color: #f5f5f5;
            font-size: 14px;
            color: #aaaaaa;
            .el-icon{
                font-size: 20px;
                transform: translateY(5px);
                margin-right: 10px;
                margin-left: 10px;
            }
            .time{
                margin-right: 30px;
            }
            .orderId{
                &:hover{
                    color: red;
                    cursor: pointer;
                }
            }
        }
        .content{
            display: flex;
            padding: 10px;
            .el-divider{
                height: 70px;
                margin-left: 50px;
            }
            .goodImg{
                height: 100px;
                overflow: hidden;
            }
            .el-image{
                margin-left: 10px;
                height: 100%;
            }
            .title{
                margin-left: 20px;
                margin-top: 5px;
                font-size: 14px;
                color: #333333;
                text-align: left;
            }
            .amount{
                margin-left: 80px;
                margin-right: 50px;
                margin-top: 20px;
                font-size: 20px;
                font-weight: bold;
                color: #aaaaaa;
            }
            .name{
                margin-right: 80px;
                margin-left: 10px;
                margin-top: 20px;
                color: #aaaaaa;
            }
            .price{
                margin-left: 10px;
                margin-top: 20px;
                font-weight: bold;
            }
            .status{
                margin-left: 10px;
                margin-top: 20px;
            }
        }
    }
</style>