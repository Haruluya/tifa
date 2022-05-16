<template>
    <div class="mainContainer">
        <div class="info">
            <div class="userInfo">
                <el-avatar :size="100" :src="avatar">
                </el-avatar>
                <div class="name">
                    <el-link :underline="false" href="userinfo">
                    未登录
                    </el-link>
                </div>
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
                    <div class="option">
                        <el-icon><CreditCard /></el-icon>
                        待付款
                    </div>
                    <div class="option">
                        <el-icon><Box /></el-icon>
                        待收货
                    </div>
                    <div class="option">
                        <el-icon><ChatLineRound /></el-icon>
                        待评价
                    </div>
                    <div class="option">
                        <el-icon><MessageBox /></el-icon>
                        退还/售后
                    </div>
                    <div class="option">
                        <el-icon><DArrowRight /></el-icon>
                        全部订单
                    </div>
                </div>
            </div>
            <div class="sidePanel">
                <div class="myfocus">
                    <div class="title">
                        我的关注
                    </div>
                    <el-divider></el-divider>
                    <div class="options">
                        <div class="focus">
                            <div class="focusCount">
                                0
                            </div>
                            <div>商家关注</div>
                        </div>
                        <div class="focus">
                            <div class="focusCount">
                                0
                            </div>
                            <div>商品关注</div>
                        </div>
                    </div>
                </div>
                <div class="service">
                    <div class="title">
                        生活服务
                    </div>
                    <el-divider></el-divider>
                    <div class="options">
                        <el-row>
                        <el-col :span="8">
                            <div class="option">
                                <el-icon><CreditCard /></el-icon>
                                话费
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="option">
                                <el-icon><AddLocation /></el-icon>
                                送货到门
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="option">
                                <el-icon><CollectionTag /></el-icon>
                                白条
                            </div>
                        </el-col>
                        </el-row>
                        <el-row>
                        <el-col :span="8">
                            <div class="option">   
                                <el-icon><Film /></el-icon>
                                电影
                            </div>  
                        </el-col>
                        <el-col :span="8">
                            <div class="option">
                                <el-icon><FirstAidKit /></el-icon>
                                医疗
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="option">
                                <el-icon><GobletFull /></el-icon>
                                饮品
                            </div>
                        </el-col>
                        </el-row>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name:"outline",

}
</script>
<style lang="less" scoped>
    .info{
        background-color: white;
        border-radius: 10px;
        padding: 20px;
        display: flex;
        .userInfo{
            display: flex;
            .el-link{
                font-size: 25px;
                margin-left: 20px;
                margin-top: 40px;
                font-weight: bold;
            }
        }
    }
    .panels{
        margin-top: 20px;
        display: flex;
        .myorder{
            width: 650px;
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            .title{
                text-align: left;
                font-size: 20px;
                font-weight: bold;
                color:#e6251b;
            }
            .options{
                display: flex;
                .option{
                    margin-left: 50px;
                    display: flex;
                    flex-direction: column;
                    font-size: 18px;
                    color: #a8a8a8;
                    .el-icon{
                        font-size: 60px;
                    }

                    &:hover{
                        color: #e6251b;
                        cursor: pointer;
                    }
                }
            }
        }
        .sidePanel{
            margin-left: 20px;
            .myfocus{
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                .title{
                    text-align: left;
                    font-size: 20px;
                    font-weight: bold;
                    color:#e6251b;
                }
                .options{
                    display: flex;
                    .focus{
                        margin-left: 60px;
                        margin-right: 60px;
                        font-size: 18px;
                        color: #a8a8a8;
                        width: 80px;
                        .focusCount{
                            font-size: 25px;
                            color: black;
                        }
                    }
                }
            }
            .service{
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                margin-top: 50px;
                .title{
                    text-align: left;
                    font-size: 20px;
                    font-weight: bold;
                    color:#e6251b;
                }
                .options{
                    font-size: 18px;
                    color:#a8a8a8;
                    margin-bottom: 30px;
                    .option{
                        display: flex;
                        flex-direction: column;
                        margin-top: 30px;
                        .el-icon{
                            font-size: 50px;
                            margin-left: 40px;
                            color: #e1d5c9;
                        }
                        &:hover{
                            color:#e6251b;
                            cursor: pointer;
                            box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
                            .el-icon{
                                color:#e6251b;
                            }
                        }
                    }
                }
            }
        }
    }
</style>