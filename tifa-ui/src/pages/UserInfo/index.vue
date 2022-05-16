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
                            <el-link :underline="false" :href="item.path">
                                {{item.label}}
                            </el-link>
                        </div>
                    </div>
                </el-aside>
                <el-main>
                    <router-view></router-view>
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
            navList:[
                {
                    label:'我的信息',
                    path:'myinfo'
                },
                {
                    label:'我的订单',
                    path:'myorder'
                },
                {
                    label:'我的收藏',
                    path:'myfocus'
                },
                {
                    label:'生活服务',
                    path:'liveserver'
                },
                {
                    label:'关于TIFA',
                    path:'abouttifa'
                },
                {
                    label:'退出登录',
                    path:'logout'
                }
            ]
        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        .infoContent{
            transform: scale(0.9) translateY(-80px);
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
                .el-link{
                    font-weight: bold;
                }
            }
        }

    }
    .el-main{
        transform: translateY(-20px);
        width: 1100px;
        overflow: hidden;
    }

</style>