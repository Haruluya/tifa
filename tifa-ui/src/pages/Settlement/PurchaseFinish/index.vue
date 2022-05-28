<template>
    <div class="mainContainer">
        <el-icon>
            <el-icon><CircleCheck /></el-icon>
        </el-icon>
        <div class="text">
            恭喜完成支付，请回到个人中心查看订单状态！
        </div>
        <el-button type="success" size="large" @click="this.$router.push('/userinfo')">
            查看个人中心</el-button>
    </div>
</template>
<script>
export default {
    name:"purchasefinish",

}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin-top: 200px;
    }
    .el-icon{
        font-size: 100px;
        color: #4ba3fe;
    }
    .text{
        font-size: 25px;
        font-weight: bold;
        margin-top: 50px;
    }
    .el-button{
        margin-top: 50px;
    }
</style>