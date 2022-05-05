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
                    </div>
                </el-aside>
            </el-container>
        </div>
        <div class="discountCard">
            <DiscountCard class="leftCard"/>
            <DiscountCard class="rightCard"/>
        </div>
        <div class="hotGoods">
            <HotGoodsPanel/>
        </div>
        <div class="mostRates">
            <MostRatesPanel/>
        </div>
        <div class="onlineRec">
            <OnLineRecPanel/>
        </div>
        <div class="channels">
            <div class="channel" v-for="index in 4" :key="index">
                <div class="title">title</div>
                <el-row v-for="indexx in 4" :key="index" align="middle" justify="center">
                  <el-col :span="6" v-for="indexy in 4" key="index">
                      <div class="card">
                          <ChannelCard/>
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
import HotGoodsPanel from './HotGoodsPanel'
import ChannelCard from '@/components/ChannelCard'
import MostRatesPanel from './MostRatesPanel'
import OnLineRecPanel from './OnLineRecPanel'
import HomeHeader from './HomeHeader'
import DiscountCard from '@/components/DiscountCard'

export default {
    name: 'shopHome',
    components:{    
        CarsouelCop,
        CarsouelSmall,
        HotGoodsPanel,
        ChannelCard,
        MostRatesPanel,
        OnLineRecPanel,
        HomeHeader,
        ArrowRight,
        DiscountCard
    },
    data() {
        return {
            imgList:['https://img13.360buyimg.com/babel/s380x300_jfs/t1/218488/40/5653/59138/619f5baeE41826177/b34b03472140e1a7.jpg.webp']
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
            border-radius: 3%;
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

// 频道面板。

.channels{
    width: 1400px;
    margin: 60px auto;

    .channel{
        margin: 10px;
        .title{
            font-family: 'Courier New', Courier, monospace;
            font-size: 20px;
        }
        .card{
            
        }
    }
}

</style>