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
                            <CarsouelSmall  :list="imgList[index-1]" :heighty="160"/>
                        </div>
                    </div>
                    <div class="sideRight">
                        <el-avatar :size="100" :src="userData.headpicture" >
                        </el-avatar>
                        <div class="name">
                            <el-link :underline="false" href="userinfo">
                                {{userName}}
                            </el-link>
                        </div>
                        <div class="buttons">
                            <div v-if="userName == '未登录'" class="loginButtons">
                                <el-button type="warning" size="large" round="true" @click="toRegister()">注册</el-button>
                                <el-button type="warning" size="large" round="true" @click="toLogin()">登录</el-button>
                            </div>
                            <div v-else class="logoutButton"> 
                                <el-button type="danger" size="large" round="true" @click="logout()">退出登录</el-button>
                            </div>
                            <el-button type="warning" size="large" round="true" @click="rigisterMerchant()"  v-if="userData.bid == 0">开店</el-button>
                            <el-button type="warning" size="large" round="true" @click="toMyMerchant()" v-if="userData.bid == 1">我的店铺</el-button>
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
import { ElMessage } from 'element-plus'
import {setToken,getToken,removeToken} from "_utils/token.js";
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
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
            imgList:[
                ['https://img30.360buyimg.com/babel/s380x300_jfs/t1/103723/16/29112/51630/628b7875Efc4c213c/d7424fb6e69a4bf1.jpg.webp',
            'https://img14.360buyimg.com/pop/s380x300_jfs/t1/131225/12/22254/35823/627b8fedE0d4083ce/d8b18935f5e5bef4.jpg.webp',],
                ['https://img10.360buyimg.com/babel/s380x300_jfs/t1/199340/37/14735/61658/6177b8feE39d10d2d/f8e14e3933664a77.jpg.webp',
                'https://img12.360buyimg.com/babel/s380x300_jfs/t1/152314/13/19839/57522/603e118dE941f0ce9/fdff58457adbef3e.jpg.webp'],
                ['https://img11.360buyimg.com/da/s380x300_jfs/t1/113365/25/5075/43154/5eb198d2Eb7072325/c683b2d423b69d94.png.webp',
                'https://img10.360buyimg.com/da/s380x300_jfs/t1/54919/6/5487/49135/5d31b9c1E616887be/986d66adc9133205.png.webp']
            ],
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
                        ],
        }
    },

    methods: {
        toLogin(){
            this.$router.push('tifalogin');
        },
        toRegister(){
            this.$router.push('tifaregister');
        },
        async logout(){
            try{
                await this.$store.dispatch("userLogout");
                ElMessage({
                    message: '退出登录成功！',
                    type: 'success',
                })
            }catch(error){
                ElMessage.error(error);
            }
        },
        rigisterMerchant(){
            this.$router.push({name:"tifaregister",query:{isMerchant:true}})
        },
        toMyMerchant(){
            this.$router.push('/mymerchant');
        }
    },
    computed:{
      ...mapState({

        }),
      ...mapGetters(['userName','userData','token'])
    },
    mounted() {
        if (getToken()){
            this.$store.dispatch('getNowUserData',getToken());
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
            box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
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
                div{
                    display: inline-block;
                    margin-right: 10px;
                }
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