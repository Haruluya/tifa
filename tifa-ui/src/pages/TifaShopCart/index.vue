<template>
    <div class="mainContainer"> 
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="shopCartContent">
            <div class="shopCartTitle">TIFA-全部商品 {{cartList.length}}</div>

                <div class="shopCartItemContainer" v-for="(item,index) in cartList.productInfo">
                    <div class="shopCartItem">
                        <div class="select">
                            <el-radio v-model="isSelect" size="large"></el-radio>
                        </div>
                        <div class="img"  @click="toGoodDetail(index)">
                            <el-image :src="cartList.imgList[index]">
                            </el-image>
                        </div>
                        <div class="title">
                            <el-tag type="danger">TIFA</el-tag>
                            {{item.pname}}
                        </div>
                        <div class="unitPrice">
                            ￥{{item.promoteprice}}
                        </div>
                        <div class="num">
                            <el-input-number v-model="cartList.numList[index]" :step="1" size="small"/>
                        </div>
                        <div class="sumPrice">
                            ￥{{item.promoteprice * cartList.numList[index]}}
                        </div>
                        <div class="delete">
                            <el-button type="danger" @click="deleteSelectItem(index)">
                                删除
                            </el-button>
                        </div>
                    </div>
                </div>
                <div class="summit">
                    <el-radio v-model="selectAll" border>全选</el-radio>
                    <el-button type="success" size="large" @click="commitOrder()">
                        提交订单
                    </el-button>
                </div>
            </div>
        </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import {ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"tifaShopCart",
    components:{
        HomeHeader,
    },
    data() {
        return {
            isSelect:"false",
            selectAll:"false",
        }
    },
    computed:{
      ...mapGetters(['cartList']), 

    },

    methods: {
        commitOrder(){
            ElMessageBox.confirm(
                '你确定要提交订单吗?',
                '询问',
                {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'Info',
                }
            )
            .then(() => {
                this.$router.push('/settlement');
                ElMessage({
                    type: 'success',
                    message: '完善订单信息',
                })
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '取消提交',
                })
            })
        },
        async getShopCartData(){
            try {
                await this.$store.dispatch("getCartListData", 
                    this.$store.getters.userData
                );
                } catch (error) {
                    ElNotification({
                        title: '获取购物车数据失败！',
                        message: error,
                        type: 'error'
                    })
                }
        },
        toGoodDetail(index){
            this.$router.push('/gooddetail/'+this.cartList.productInfo[index].pid)
        },
        deleteSelectItem(index){
            ElMessageBox.confirm(
                '你确定要删除此项吗?',
                '⚠警告',
                {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'warning',
                }
            )
            .then(() => {
                this.deleteItem(index);
                this.getShopCartData();
                ElMessage({
                    type: 'success',
                    message: '删除成功',
                })
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '取消删除',
                })
            })

        },
        async deleteItem(index){
            try {
                await this.$store.dispatch("deleteCartByGoodId",
                {
                    "sid":this.$store.getters.userData.uid, 
                    "pid":this.cartList.productInfo[index].pid
                }
                );
                } catch (error) {
                    ElNotification({
                        title: '删除购物项失败！',
                        message: error,
                        type: 'error'
                    })
                }
        }
        
    },
    mounted(){
        this.getShopCartData();
    }
}
</script>
<style lang="less">
    .mainContainer{
        .shopCartContent{
            width: 1200px;
            margin: 0 auto;
            margin-top: 50px;
            padding: 20px;
            background-color: white;
            border-radius: 20px;
        }
    }

    .shopCartTitle{
        font-size: 20px;
        font-weight: bold;
        margin-bottom: 15px;
        padding: 15px; 
        text-align: left;
        transform: translateY(15px);
        &:hover{
            color: #e31d1a;
        }
    }
    .shopCartItem{
        display: flex;
        margin: 20px;
        padding: 15px;
        border: 1px solid #eee;
        background-color: #f5f5f5;
        overflow: hidden;

        &:hover{
            cursor: pointer;
            transform: scale(1.01);
        }

        .select{
            margin-left: 5px;
        }
        .img{
            width: 150px;
            margin-left: 10px;
            border: 1px solid #eee;
        }
        .title{
            text-align: left;
            font-size: 13px;
            margin-left: 8px;
            margin-top: 5px;
        }
        .unitPrice{
            margin-left: 180px;
            margin-top: 7px;
            font-size: 14px;
            color:#e1251b;
        }
        .num{
            margin-left: 40px; 
            margin-top: 5px;
        }
        .sumPrice{
            margin-left: 60px;
            margin-top: 7px;
            font-size: 17px;
            font-weight: bold;
            color:#e1251b;
        }
        .delete{
            text-align: right;
            margin-left: 100px;
        }

    }
    .summit{
        display: flex;
        margin-left: 50px;
        .el-button{
            transform: translateX(900px);
        }
    }
</style>