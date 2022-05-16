<template>
    <div class="mainContainer"> 
        <div class="headerTitle">
            <div class="info">
                <span>中国大陆</span>
            </div>
           <div class="headerLinks">
                <el-breadcrumb :separator-icon="ArrowRight">
                    <el-breadcrumb-item :to="{ path: '/' }">我的订单</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">我的TIFA</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">网站导航</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">网站无障碍</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">TIFA</el-breadcrumb-item>
                </el-breadcrumb>
            </div> 
        </div>
        <div class="header">
            <div class="logo">
                <el-link :underline="false" class="title" href="shophome">
                  TIFA
              </el-link>
              <el-link :underline="false">
                <el-image :src="logo">
                </el-image>
              </el-link>
            </div>
            <div class="steps">
                <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="查看购物车" />
                    <el-step title="拍下商品" />
                    <el-step title="付款" />
                    <el-step title="确认收货" />
                    <el-step title="评价" /> 
                </el-steps>
            </div>
        </div>
        <div class="locations">
            <div class="label">
                选择收货地址
            </div>
            <el-divider></el-divider>
            <div class="locationCards">
            <div class="locationCard">
                <div class="border">
                    <div class="name"> 
                        <el-icon><User /></el-icon>Haruluya收
                    </div>
                    <el-divider></el-divider>
                    <div class="locationDetail">
                        <el-icon><OfficeBuilding /></el-icon>环翠怡园文化西路180号山东大学<br/>威海校区
                    </div>
                    <div class="modify">
                        <el-link :underline="false">修改地址<el-icon><ArrowRight /></el-icon></el-link>
                    </div>
                </div>
            </div>
            <div class="locationCard none" >
                <div class="border">
                    <div class="name"> 
                        <el-icon><User /></el-icon>Haruluya收
                    </div>
                    <el-divider></el-divider>
                    <div class="locationDetail">
                        <el-icon><OfficeBuilding /></el-icon>环翠怡园文化西路180号山东大学<br/>威海校区
                    </div>
                    <div class="modify">
                        <el-link :underline="false">修改地址<el-icon><ArrowRight /></el-icon></el-link>
                    </div>
                </div>
            </div>
  
            </div>
            <div class="addLocation">
                <el-button type=""><el-icon><Plus /></el-icon>添加新地址</el-button>
            </div>
        </div>
        <div class="goodsCar">
            <div class="label">
                确认订单消息
            </div>
            <el-divider></el-divider>
        </div>
        <div class="total">
            <div class="price">
                实付款:<span>￥99.00</span>
            </div>
            <div class="location">
                寄送至:<span>山东 威海 环翠 怡园 文化西路180号山东大学威海校区</span>
            </div>
            <div class="person">
                收货人:<span>Haruluya 18720672661</span>
            </div>
        </div>
        <div class="commit">
            <el-button type="" >提交订单</el-button>
        </div>
    </div>
</template>
<script>
import logo from '../../assets/logo.png' 
export default {
    name:"settlement",
    data() {
        return {
            logo,
        }
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        background-color: white;
        padding-bottom: 300px;
        .header{
            width: 1200px;
            display: flex;
            margin: 0 auto;
            .steps{
                width: 800px;
                margin-left: 150px;
                .el-steps{
                    background-color: white;
                }
            }
        }
    }

    .headerTitle{
        display: flex;
        justify-content: center;
        align-content: center;
        background-color: #e3e4e5;
        
        height: 35px;
        .info{
            margin-top: 5px;
            margin-right: 100px;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            
        }
        .headerLinks{
            margin-left: 10px;
            margin-top: 10px;
        }
    }
    .header{
        .logo{
            .title{
                font-size: 45px;
                font-weight: bold;
                &:hover{
                    color: #e1251b;
                }
            }
            .el-image{
                width: 150px;
            }
        }
    }
    .label{
        text-align: left;
        font-size: 20px;
        font-weight: bold;
    }
    .locations{
        width: 1200px;
        margin: 0 auto;
        margin-top: 100px;
        .locationCards{
            display: flex;
        }
        .locationCard{
            width: 300px;
            margin-top: 30px;
            padding: 8px;
            border-radius: 8px;
            margin-right: 30px;
            background-image: linear-gradient(222deg, rgb(235, 50, 47), rgb(218, 245, 45));

            .el-icon{
                font-size: 20px;
            }
            .border{
                background-color: white;
            }
            .name{
                transform: translateY(10px) translateX(-80px);
                font-weight: bold;
                color: #666666;
            }
            .locationDetail{
                transform: translateY(-18px) translateX(-10px);
                color: #666666;
                font-size: 15px;
            }
            .modify{
                transform: translateY(-5px) translateX(-100px);
                .el-link{
                    color: #cc9977;
                }
            }
        }
        .addLocation{
            width: 100px;
            margin-top: 40px;
        }

    }
    .goodsCar{
        width: 1200px;
        margin: 0 auto;
        margin-top: 50px;
    }
    .total{
        width: 300px;
        background-color: #f2f7ff;
        margin-left: 950px;
        margin-top: 50px;
        text-align: right;
        border: 1px solid red;
        box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;        
        padding: 20px;
        .price{
            font-size: 16px;
            font-weight: bold;
            span{
                font-size: 24px;
                color: red;
            }
        }
        .person,
        .location{
            width: 300px;
            font-size: 14px;
            color:#666666;
            font-weight: bold;
            span{
                font-weight: 100;
            }
        }
   
    }
    .commit{
        width: 150px;
        margin-left: 1140px;
        margin-top: 20px;
        .el-button{
            width: 100%;
            height: 40px;
        }
    }
</style>