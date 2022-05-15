<template>
    <div class="mainContainer"> 
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="shopCartContent">
            <div class="shopCartTitle">TIFA-全部商品 3</div>

                <div class="shopCartItemContainer" v-for="index in 3">
                    <div class="shopCartItem">
                        <div class="select">
                            <el-radio v-model="isSelect" size="large"></el-radio>
                        </div>
                        <div class="img">
                            <el-image src="https://img30.360buyimg.com/n0/s80x80_jfs/t1/96412/28/25770/102064/62563f21E4ab91643/7a7b78edf7fe81f2.jpg.dpg">
                            </el-image>
                        </div>
                        <div class="title">
                            <el-tag type="danger">TIFA</el-tag>
                            Amazfit 跃我 GTR 3 Pro 曜石黑<br/>
                            血压筛查研究 150种运动模式 <br/>
                            50米防水 心率监测 品
                        </div>
                        <div class="unitPrice">
                            ￥999.00
                        </div>
                        <div class="num">
                            <el-input-number v-model="num" :step="1" size="small"/>
                        </div>
                        <div class="sumPrice">
                            ￥999.00
                        </div>
                        <div class="delete">
                            <el-button type="danger">
                                删除
                            </el-button>
                        </div>
                    </div>
                </div>
                <div class="summit">
                    <el-radio v-model="selectAll" border>全选</el-radio>
                    <el-button type="success" size="large">
                        提交订单
                    </el-button>
                </div>
            </div>
        </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
export default {
    name:"tifaShopCart",
    components:{
        HomeHeader,
    },
    data() {
        return {
            isSelect:"false",
            selectAll:"false"
        }
    },
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