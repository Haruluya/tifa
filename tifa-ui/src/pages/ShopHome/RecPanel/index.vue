<template>
    <div class="mainContainer">
        <div class="panelTitle">
            <el-icon><arrow-left-bold /></el-icon>
            {{title}}
            <el-icon><arrow-right-bold /></el-icon>
        </div>
        <div class="cardPanel">
            <el-row>
            <el-col :span="4">
                <div class="title">           
                    <img
                        src="https://img13.360buyimg.com/seckillcms/s260x260_jfs/t1/88543/19/27657/130548/6264bd11Ebe65c8ec/971fa185a7d98bd3.jpg.webp"
                        />
                </div>
            </el-col>
            <div class="centerPanel">
                <div v-for="(item,index) in recData.data.products" v-if="recData.data" :key="index" >
                    <div class="card">
                        <RecCard :pdata="item" />
                    </div>
                </div>
            </div>
            <el-col :span="4">
                <div class="swiper">
                    <CarsouelSmall :list="['https://img13.360buyimg.com/seckillcms/s260x260_jfs/t1/88543/19/27657/130548/6264bd11Ebe65c8ec/971fa185a7d98bd3.jpg.webp']" :heighty="260"/>
                </div>
            </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
import RecCard from '@/components/RecCard'
import CarsouelSmall from '@/components/CarsouelSmall'

export default {
    name:'recPanel',
    props:{
        title:String,
        recData:{
            type:Object,
            default:{}
        }
    },
    components:{
        RecCard,
        CarsouelSmall
    },
    mounted() {
    },

}
</script>
<style lang="less" scoped>



.mainContainer{
    height: 280px;
    padding: 10px;
    .panelTitle{
        text-align: center;
        font-family: "Microsoft YaHei", "Heiti SC", tahoma, arial, "Hiragino Sans GB";
        font-size: 25px;
        font-weight: bold;
        color: #747171;
        .el-icon{
            transform: translateY(4px);
            color: #e1251b;
        }
    }
    .cardPanel{
        margin-top: 30px;
        border-radius: 20px;
        background-color: white;
        .title{
            img{
                width: 100%;
            }
        }
        .centerPanel{
            display: flex;
            overflow: scroll;
            width: 920px;
            .card{
                margin-left: 10px;
            }
            &:hover{
                
            }
        }
        .swiper{
            height: 100%;
        }
    }

}
// 滚动条。
::-webkit-scrollbar {
    width: 0px;
    height: 8px;
    background-color: white;
    border-radius: 5px;
    &:hover{
        background-color: #f0f1f5;
    }
}

::-webkit-scrollbar-thumb {
    border-radius: 5px;
    background-color: #7a7d7da0;
}

</style>