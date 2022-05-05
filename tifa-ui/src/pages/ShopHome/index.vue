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
        <div class="showPart">
            <HomeHeader/>
            <el-container class="centerElContainer">
                <el-main>
                    <el-row :gutter="10">
                        <el-col :span="6">
                        <div class="leftClassNav">
                            <ClassNav/>
                        </div>
                        </el-col>
                        <el-col :span="18">
                        <div class="mainSwiper">
                            <CarsouelCop :list="imgList" />
                        </div>
                        </el-col>
                    </el-row>
                </el-main>
                <el-aside>
                    <div class="sideLeft">
                        <div v-for="index in 3" :key="index" class="swiperItem">
                            <CarsouelSmall  :list="imgList" :heighty="160"/>
                        </div>
                    </div>
                    <div class="sideRight">
                        <el-avatar :size="100" :src="avatar">
                        </el-avatar>
                        <div class="name">
                            <el-link :underline="false">
                                Haruluya
                            </el-link>
                        </div>
                        <div class="buttons">
                            <el-button type="warning" size="large" round="true">注册</el-button>
                            <el-button type="warning" size="large" round="true">登录</el-button>
                            <el-button type="warning" size="large" round="true">开店</el-button>
                        </div>
                        <el-divider/>
                        <div class="messages">
                            <div v-for="(item,index) in messages" :key="index" class="message">
                                <el-tag type="warning">
                                    资讯
                                </el-tag>
                                <span>{{item}}</span>
                            </div>
                        </div>
                        <div>
                            
                        </div>
                    </div>
                </el-aside>
            </el-container>
        </div>
        <div class="discountCard">
            <DiscountCard class="leftCard"/>
            <DiscountCard class="rightCard"/>
        </div>
        <div class="hotGoods">
            <RecPanel :title="recTitle[0]"/>
        </div>
        <div class="mostRates">
            <RecPanel :title="recTitle[1]"/>
        </div>
        <div class="onlineRec">
            <RecPanel :title="recTitle[2]"/>
        </div>
        <div class="ALSRec">
            <div class="title">
                <el-icon><arrow-left-bold /></el-icon>
                基于ALS的用户商品推荐
                <el-icon><arrow-right-bold /></el-icon>
            </div>
            <div class="channel" v-for="index in 4" :key="index">
                <el-row v-for="indexx in 4" :key="index" align="middle" justify="center">
                  <el-col :span="4" v-for="indexy in 5" key="index">
                      <div class="card">
                         <GoodCard/>
                      </div>
                  </el-col> 
                </el-row>
            </div>
        </div>
    </div>
</template>

<script>

import { ArrowRight } from '@element-plus/icons-vue'


import CarsouelCop from '@/components/CarsouelCop'
import CarsouelSmall from '@/components/CarsouelSmall'
import GoodCard from '@/components/GoodCard'
import HomeHeader from './HomeHeader'
import DiscountCard from '@/components/DiscountCard'
import RecPanel from './RecPanel'
import ClassNav from './ClassNav'

export default {
    name: 'shopHome',
    components:{    
        CarsouelCop,
        CarsouelSmall,
        HomeHeader,
        ArrowRight,
        DiscountCard,
        RecPanel,
        GoodCard,
        ClassNav
    },
    data() {
        return {
            imgList:['https://img13.360buyimg.com/babel/s380x300_jfs/t1/218488/40/5653/59138/619f5baeE41826177/b34b03472140e1a7.jpg.webp'],
            avatar:'https://avatars.githubusercontent.com/u/91101915?v=4',
            messages:['中华老字号同仁堂：“同修仁德，济世养生”',
                        '全自动化正当道，传统坐便器已经out啦！',
                        '夏日里一个清凉的机会都不要错过，就连吃也是一样',
                        '教科书般的网游小说，《斗破苍穹》的大热原因',
                        '一只狗的自述：我可不想陪主子贴秋膘',
                        '猫王霹雳唱机，带你穿越回80年代',
                        '秋季养生正当时，顺季食补滋阴养肺'],
            recTitle:["基于Spark SQL的最近热点商品推荐",
                        "基于Spark SQL的最多评分推荐",
                        "基于kafka,spark stream的实时推荐",
                        ]
        }
    },
}
</script>
<style lang="less" scoped>
// !!!
.el-row{
    height: 100%;
}

.mainContainer{
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

    .showPart{
        .centerElContainer{
            width: 1400px;
            height: 550px;
            margin: 0 auto;
            margin-top: 20px;

        }
    }
}
// 中间部分。
.centerElContainer{
    .el-main{
        .leftClassNav{
            height: 100%;
            width: 220px;
            background-color: white;
            border-radius: 10px;
        }
        .mainSwiper{
            margin-left: 25px;
            overflow: hidden;
            border-radius: 10px;
        }
    }
    .el-aside{
        width: 550px;
        display: flex;
        padding: 20px;
        transform: translateX(-35px);  
        .sideLeft{
            width: 230px;
            transform: translateY(-10px);
            .swiperItem{
                margin-top: 10px;
            }

        }   
        .sideRight{
            width: 320px;
            margin-left: 15px;
            background-color: white;
            padding: 20px;
            border-radius: 3%;
            box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
            .name{
                margin-top: 10px;
                .el-link{
                    font-size: 20px;
                    font-weight: bold;
                    color: #53585c;
                    &:hover{
                        color: #e1251b;
                    }
                }
            }
            .buttons{
                margin-top: 10px;
            }
            .messages{
                display: flex;
                flex-direction: column;
                text-align: left;
                .message{
                    font-size: 13px;
                    height: 25px;
                    overflow: hidden;
                    margin-bottom: 10px;
                    color: #666666; 
                    span{
                        margin-left: 8px;
                    }
                    &:hover{
                        color: #e1251b;
                    }
                }
            }
        }
    } 
}

// 打折面板。
.discountCard{
    margin: 0 auto;
    display: flex;
    margin-top: 50px;
    width: 1400px;
    .leftCard{
        margin-right: 30px;
    }
}


// 热点商品面板。
.hotGoods{
    width: 1400px;
    margin: 60px auto;
}


// 最多评分商品面板。
.mostRates{
    width: 1400px;
    margin: 100px auto;

}

// 实施推荐面板。
.onlineRec{
    width: 1400px;
    margin: 100px auto;
}

// als推荐面板。

.ALSRec{
    margin: 10px;
    .title{
        text-align: center;
        font-family: "Microsoft YaHei", "Heiti SC", tahoma, arial, "Hiragino Sans GB";
        font-size: 25px;
        font-weight: bold;
        color: #747171;
        margin: 30px 0;
        .el-icon{
            transform: translateY(4px);
            color: #e1251b;
        }
    }
    .card{
        
    }
}


</style>