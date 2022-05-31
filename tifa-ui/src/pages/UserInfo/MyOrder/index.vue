<template>
    <div class="mainContainer">
        <div class="title">
            我的订单
            <el-divider/>
        </div>
        <div class="tabs"> 
            <el-tabs v-model="activeTab" @tab-click="handleClick">
                <el-tab-pane label="全部订单" name="all">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="待付款" name="create">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="待发货" name="paid">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="待收货" name="delivery">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="待评价" name="comment">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="退货处理" name="back">
                    <div class="ordercardItem" v-for="(item,index) in orderData.ordersData">
                        <OrderCard :oData="orderData" :index="index"/>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
        <div class="pageHelper">
            
        </div>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import OrderCard from './OrderCard'

export default {
    name:"myorder",
    components:{
        OrderCard
    },
    computed:{
      ...mapGetters(['orderData','userData']), 

    },
    data() {
        return {
            activeTab:"all",
        }
    },
    methods: {
        async getOrderData(statu){
            await this.$store.dispatch('getOrderData',{uid:this.userData.uid,statu})
        },
        handleClick(){
            console.log(this.activeTab)
            this.getOrderData(this.activeTab);
        }
    },
    mounted() {
        this.getOrderData("create");
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
    }
    .title{
        background-color: white;
        border-radius: 10px;
        padding: 20px;
        text-align: left;
        font-size: 20px;
        font-weight: bold;
        color:#e6251b;
        .el-divider{
            margin: 0;
            margin-top: 10px;
        }
    }
    .tabs{
        background-color: white;
        border-radius: 10px;
        padding: 20px;
        margin-top: 20px;

    }
</style>