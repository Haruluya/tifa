<template>
    <div class="mainContainer">
        <div class="title">
            我的订单
            <el-divider/>
        </div>
        <div class="tabs"> 
            <el-tabs v-model="activeTab" @tab-click="handleClick">
                <el-tab-pane label="全部订单" name="order">
                    <div class="ordercardItem" v-for="index in 5">
                        <OrderCard/>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="待付款" name="pay">

                </el-tab-pane>
                <el-tab-pane label="待收货" name="delivery">

                </el-tab-pane>
                <el-tab-pane label="待评价" name="comment">

                </el-tab-pane>
            </el-tabs>
        </div>
        <div class="pageHelper">
            
        </div>
    </div>
</template>
<script>
import OrderCard from './OrderCard'
export default {
    name:"myorder",
    components:{
        OrderCard
    },
    data() {
        return {
            activeTab:"order",
        }
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