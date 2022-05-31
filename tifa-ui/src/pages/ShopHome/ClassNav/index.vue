<template>
    <div class="mainContainer">
        <div v-for="(item, index) in classList" class="firstClass" @click="this.$router.push('/tifasearch/'+item)">
            <el-icon><ArrowRightBold /></el-icon>
            <span>
                {{item}}
            </span>
        </div>
    </div>
</template>
<script>
export default {
    name:"classnav",
    data() {
        return {
            classList:["安莉芳","时尚外穿","淑女睡裙","趣味图案",
                            "法语","财富","日语能力考试","男鞋","房产",
                            "玩具乐器","食品","艺术","医药保健","图书","机票",
                            "理财","安装","工业品"],

        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        padding-top: 15px;
        .firstClass{
            text-align: left;
            padding-top: 5px;
            padding-left: 20px;
            font-family: tahoma, arial, 宋体;
            color: #333333;
            &:hover{
                color: red;
                background-color: #d9d9d9;
            }
        }

    }
</style>