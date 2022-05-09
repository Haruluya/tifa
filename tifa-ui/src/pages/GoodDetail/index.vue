<template>
    <div class="mainContainer">
        <div class="homeHeader"><HomeHeader/></div>
        <div class="topInfo">
            <div class="leftInfo">
                <el-image src="https://img12.360buyimg.com/n1/s450x450_jfs/t1/92268/16/25934/75321/62592d7cEa8474210/94e9750d0719ff07.jpg"></el-image>
                <el-carousel :interval="4000" type="card" height="100px">
                    <el-carousel-item v-for="item in 6" :key="item">
                    <h3 text="2xl" justify="center">
                        <img src="https://img12.360buyimg.com/n5/s54x54_jfs/t1/92268/16/25934/75321/62592d7cEa8474210/94e9750d0719ff07.jpg"/>
                    </h3>
                    </el-carousel-item>
                </el-carousel>
            </div>
            <div class="rightOpration">
                <div class="classBread">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item :to="{ path: '/' }">数码</el-breadcrumb-item>
                        <el-breadcrumb-item
                        ><a href="/">智能设备</a></el-breadcrumb-item
                        >
                        <el-breadcrumb-item>智能手表</el-breadcrumb-item>
                        <el-breadcrumb-item>ZeppOs</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="title">
                    <el-tag type="danger" effect="dark">TIFA</el-tag>
                    <span>Amazfit 跃我 GTR 3 Pro 曜石黑 血压筛查研究 150种运动模式 50米防水 心率监测 智能运动手表华米科技出品</span>
                </div>
                <div class="des">
                    <span>【超值单品，数量有限，先到先得】 【ZeppOS系统丨12天超长续航丨150+运动模式】 【白条6期免息】更多福利戳此</span>
                </div>
                <div class="pricePanel">
                    <div class="header"><el-icon><shopping-bag /></el-icon>TIFA限购</div>
                    <div class="content">
                        <div class="labels">
                            <div class="label">
                                原价格：
                            </div>
                            <div class="label">
                                现价格：
                            </div>
                        </div>
                        <div class="price">                    
                            <div class="prePrice">￥9999</div>
                            <div class="prePrice">￥9999</div>
                        </div>
                    </div>
                </div>
                <div class="color"> </div>
                <div class="color"> </div>
                <div class="amount"></div>
                <div class="addShopCart"></div>
            </div>
        </div>
        <div class="simRec">

        </div>
        <div class="goodImgs">

        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
export default {
    name: 'gooddetail',
    components:{
        HomeHeader,
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin: 0 auto; 
    }
    .topInfo{
        width: 1200px;
        height: 600px;
        // background-color: white;
        margin: 0 auto; 
        display: flex;
        .leftInfo{
            margin-top: 20px;
            height: 100%;
            width: 500px;
            .el-image{
                width: 500px;
                border-radius: 20px;
                box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
                &:hover{
                    transform: scale(1.01);
                    cursor: pointer;
                }
            }
        }
        .rightOpration{
            width: 700px;
            margin-top: 20px;
            margin-left: 30px;
            padding: 20px;
            background-color: white;
            .classBread{
                margin-top: 5px;
                span{
                    font-size: 16px;
                    color: #c8c8c8;
                }
            }
            .title{
                color: #666666;
                font-size: 18px;
                font-weight: bold;
                margin-top: 20px;
                .el-tag{
                    font-size: 18px;
                    padding: 12px;
                    margin-right: 10px;
                }
            }
            .des{
                margin-top: 15px;
                font-size: 12px;
                color: red;
                cursor: pointer;
            }
            .pricePanel{
                margin-top: 30px;
                .header{
                    text-align: left;
                    padding: 5px;
                    padding-left: 20px;
                    background-color: #fb1c77;
                    font-size: 20px;
                    border-radius: 3px;
                    color: white;
                }
                .content{
                    background-color: #f3f3f3;
                    display: flex;
                    padding: 10px;
                    padding-left: 20px;
                    .label{
                        font-size: 18px;
                        .labels{
                            margin-top: 10px;
                        }
                    }
                }
            }
        }
    }
</style>