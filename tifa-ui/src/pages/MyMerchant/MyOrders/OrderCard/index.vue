<template>
    <div class="mainContainer">
        <div class="header">
            <div class="time">
                <el-icon><AlarmClock /></el-icon>{{merchantOrderData.ordersData[index].createDate}}
            </div>
            <div class="orderId">
                订单号: {{merchantOrderData.ordersData[index].oid}}<el-icon><Collection /></el-icon>
            </div>
        </div>
        <div class="content">
            <div class="goodImg">
                <el-image :src="merchantOrderData.productImgData[index].type">

                </el-image>
            </div>
            <div class="title">
                {{merchantOrderData.productData[index].pname}}
            </div>
            <div class="amount">
                <el-button type="text" @click="confirmDe()" v-if="merchantOrderData.ordersData[index].status != 'delivery'">
                    确认发货
                </el-button>
            </div>
            <el-divider direction="vertical" />
            <div class="name">
                {{merchantOrderData.ordersData[index].uid}}<el-icon><Avatar /></el-icon>
            </div>
            <el-divider direction="vertical" />
            <div class="price">
                ￥{{merchantOrderData.productData[index].promoteprice}}
            </div>
            <el-divider direction="vertical" />
            <div class="status">
                {{merchantOrderData.ordersData[index].status}}
            </div>
        </div>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import { ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"ordercard",
    props:{
        
        index:{
            
        }
    },
    computed:{
      ...mapGetters(['userData','merchantOrderData']), 

    },
    methods: {
        async confirmDe(){
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
                let oid = this.merchantOrderData.ordersData[this.index].oid;
                await this.$store.dispatch('confirmDeto',{oid});
                ElMessage({
                    type: 'success',
                    message: '更新成功',
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
        height: 150px !important;

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