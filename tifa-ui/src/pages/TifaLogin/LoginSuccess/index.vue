<template>
    <div>
        <div class="inputPanel">
                <el-result
                    icon="success"
                    title="登录成功！"
                    sub-title="恭喜，TIFA扫码登录成功！"
                >
                    <template #extra>
                    <el-button type="primary" @click="toLoginPage()">去登录</el-button>
                    </template>
                </el-result>
        </div>
    </div>
</template>
<script>
export default {
    name:'loginsuccess'
}
</script>
<style lang="less" scoped>
    .inputPanel{
        margin-top: 100px;
        transform: scale(2);
    }
</style>