<template>
    <div class="mainContainer">
        <div class="header">
            <div class="time">
                <el-icon><AlarmClock /></el-icon>{{merchantProductsData.products[index].createDate}}
            </div>
            <div class="orderId">
                店铺号: {{merchantProductsData.products[index].bid}}<el-icon><Collection /></el-icon>
            </div>
        </div>
        <div class="content">
            <div class="goodImg">
                <el-image :src="merchantProductsData.productImgs[index].type">

                </el-image>
            </div>
            <div class="title">
                {{merchantProductsData.products[index].pname}}
            </div>
            <div class="amount">

            </div>
            <el-divider direction="vertical" />
            <div class="name">
                {{userData.uname}}<el-icon><Avatar /></el-icon>
            </div>
            <el-divider direction="vertical" />
            <div class="price">
                ￥{{merchantProductsData.products[index].orignalprice}}
            </div>
            <el-divider direction="vertical" />
            <div class="status">
                {{merchantProductsData.products[index].stock}}
            </div>
            <div class="delete">
                <el-button type="text" @click="undercarriage()">下架商品</el-button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import { ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"merchantcard",
    props:{
        index:{
            default:0
        }
    },
    computed:{
      ...mapGetters(['userData','merchantProductsData']), 

    },
    methods: {
        async undercarriage(){
            ElMessageBox.confirm(
                '确认下架商品?',
                '询问',
                {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'Info',
                }
            )
             .then(async () => {
                let pid = this.merchantProductsData.products[this.index].pid;
                await this.$store.dispatch('deleteProduct',{pid});
                await this.$store.dispatch('getMerchantProductData',{uid:this.userData.uid});
                ElMessage({
                    type: 'success',
                    message: '更新成功',
                })
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '取消提交',
                })
            })
           
        }
    },
    mounted() {
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
        .delete{
            margin-top: 20px;
            margin-left: 15px;
        }
    }
</style>