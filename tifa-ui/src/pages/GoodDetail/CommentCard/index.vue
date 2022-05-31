<template>
    <div class="mainContainer">
        <div class="userinfo">
            <div class="avatar">
                <el-avatar size="large" src="https://ts1.cn.mm.bing.net/th?id=OIP-C.eoZPB2gfGH-1ckaL_JSZdwHaHg&w=172&h=170&c=8&rs=1&qlt=90&o=6&dpr=1.38&pid=3.1&rm=2" />
            </div>
            <div class="name">
                UID:    {{info.uid}}
            </div>
            <el-rate
                v-model="value"
                disabled
                show-score
                text-color="#ff9900"
                score-template="{value} 分"
            />
        </div>
        <div class="content">
            {{info.content}}
        </div>
    </div>
</template>
<script>
export default {
    name:'commentcard',
    data() {
        return {
            value:4
        }
    },
    props:{
        info:{
            default:[]
        }
    }
}
</script>
<style lang="less" scoped>
    .mainContainer{
        text-align: left;
        padding: 20px;
        margin-left: 15px;
        background-color: #f4f4f4;
        border-radius: 20px;
        margin-top: 20px;
        .userinfo{
            display: flex;
            margin-bottom: 10px;
            font-size: 18px;
            font-weight: bold;
            color: #47b1ff;
            .name{
                margin-left: 15px;
                transform: translateY(13px);
            }
            .el-rate{
                margin-left: 600px;
                margin-top: 5px;
            }
        }
        .content{
            font-size: 12px;
            margin-left: 20px;
        }
    }
</style>