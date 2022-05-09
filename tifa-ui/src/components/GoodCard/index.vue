<template>
    <div class="mainContainer">
        <div class="titleImg">
            <el-image src="https://img14.360buyimg.com/n7/jfs/t1/69468/27/17416/141766/626baaecE202ac55d/d65dd608458c8c0b.jpg">
            </el-image>
        </div>
        <div class="info">
            <div class="price">
                ￥3899.00
            </div>
            <div class="title">
                华为笔记本电脑MateBook
            </div>
            <div class="des">
                【华为笔记本MateBookD14SE高清版】
            </div>
            <div class="tags">
                <el-tag type="danger">
                    自营
                </el-tag>
            </div>
            <div class="buttons">
                <el-button>收藏</el-button>
                <el-button>加入购物车</el-button>
                <el-image :src="logo"></el-image>
            </div>
        </div>
    </div>
</template>
<script>
import logo from "../../assets/logo.png"
export default {
    name:"goodcard",
    data() {
        return {
            logo,
        }
    },
}
</script>
<style lang="less" scoped>
.mainContainer{
    display: flex;
    flex-direction: column;
    background-color: white;
    padding: 10px;
    &:hover{
        box-shadow: rgba(18, 18, 18, 0.195) 0px 1px 3px 0px;
        transform: scale(1.01);
    }
    .titleImg{
        margin: 0 auto;
        width: 200px;
    }
    .info{
        margin-left: 20px;
        text-align: left;
        .price{
            font-size: 18px;
            font-weight: bold;
            color: #e1251b;
        }
        .title{
            font-size: 16px;
        }
        .des{
            font-size: 14px;
            color: #666666;
        }
        .tags{
            margin: 10px 0;
        }
        .buttons{
            .el-image{
                width: 50px;
                transform: translateX(10px) translateY(10px);
            }
        }
    }
}
</style>