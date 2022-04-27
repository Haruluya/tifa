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
            <el-container class="mainElContainer">
                <el-header style="margin: 0; padding: 0">
                    <HomeHeader/>
                </el-header>
                <el-container class="centerElContainer">
                    <el-main>
                        <el-row :gutter="20">
                          <el-col :span="7">
                            <div class="leftClassNav">
                            </div>
                          </el-col>
                          <el-col :span="17">
                            <div class="mainSwiper">
                                <CarsouelCop :list="imgList" />
                            </div>
                          </el-col>
                        </el-row>
                    </el-main>
                    <el-aside width="450px">
                        <div class="sideLeft">
                            <div v-for="index in 3" :key="index" class="swiperItem">
                                <CarsouelSmall  :list="imgList" :heighty="160"/>
                            </div>
                        </div>
                        <div class="sideRight">
                        </div>
                    </el-aside>
                </el-container>
            </el-container>
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
        ArrowRight 
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
        background-color: #f5f5f5;
        
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
        margin-top: 10px;
        .mainElContainer{
            width: 1400px;
            // !
            height: 650px;
            margin: 0 auto;


            .el-header{
                height: 150px;
                background-color: white;
                border-radius: 10px;
            }
        }
    }
}

.centerElContainer{
    margin-top: 20px;
    .el-main{

        .leftClassNav{
            height: 100%;
            width: 220px;
            background-color: white;
        }
    }
    .el-aside{
        display: flex;  
        .sideLeft{
            width: 50%;
            margin-left: 15px;
            .swiperItem{
                margin-top: 10px;
            }

        }   
        .sideRight{
            width: 50%;
            margin-left: 15px;
            background-color: white;
            border-radius: 3%;
        }
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
    margin: 60px auto;

}

// 实施推荐面板。
.onlineRec{
    width: 1400px;
    margin: 60px auto;
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