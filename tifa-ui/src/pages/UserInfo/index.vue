<template>
    <div class="mainContainer">
        <div class="homeHeader"><HomeHeader/></div>
        <div class="infoContent">
            <el-container>
                <el-aside width="250px">
                    <div class="navList">
                        <div class="tifa">
                            TIFA
                        </div>
                        <el-divider></el-divider>
                        <div class="nav" v-for="(item,index) in navList" :key="index">
                            <el-link :underline="false">
                                {{item}}
                            </el-link>
                        </div>
                    </div>
                </el-aside>
                <el-main>
                    <div class="info">
                        <div>
                            
                        </div>
                        <div>
                            <div class="myMoney">

                            </div>
                        </div>
                    </div>
                    <div class="panels">
                        <div class="myorder">
                            <div class="title">
                                我的订单
                            </div>
                            <el-divider></el-divider>
                            <div class="options">

                            </div>
                        </div>
                        <div class="sidePanel">
                            <div class="myfocus">
                                <div class="title">
                                    我的关注
                                </div>
                                <div class="options">

                                </div>
                            </div>
                            <div class="service">
                                <div class="title">
                                    生活服务
                                </div>
                                <div class="options">

                                </div>
                            </div>
                        </div>
                    </div>
                </el-main>
            </el-container>
        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
export default {
    name:"userInfo",
    components:{
        HomeHeader,
    },
    data() {
        return {
            navList:['我的信息','我的订单','我的收藏','生活服务','退出登录']
        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        .infoContent{
            width: 1400px;
            margin: 0 auto;
            margin-top: 100px;
        }
    }
    .tifa{
        font-size: 30px;
        font-weight: bold;
        color: #ff4400;
        margin-top: 5px;
        &:hover{
            color: #e6251b;
        }
    }
    .navList{
        padding: 15px;
        border-radius: 10px;
        background-color: white;
        .nav{
            margin-top: 20px;
            .el-link{
                font-size: 20px;
            }
            &:hover{
                background-color: #e3e4e5;
            }
        }
    }
</style>