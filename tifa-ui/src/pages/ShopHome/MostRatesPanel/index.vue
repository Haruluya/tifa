<template>
    <div class="mainContainer">
        <div class="panelTitle">
            基于Spark SQL的最多评分推荐。
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
            <el-col :span="4" v-for="index in 4" :key="index" >
                <div class="card">
                    <RecCard />
                </div>
            </el-col>
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
    name:'mostRatesPanel',
    components:{
        RecCard,
        CarsouelSmall
    }
}
</script>
<style lang="less" scoped>



.mainContainer{
    height: 260px;
    .panelTitle{
        text-align: left;
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        font-size: 30px;
    }
    .cardPanel{
        background-color: white;

        .title{
            img{
                width: 100%;
            }
        }
        .card{
            margin-left: 10px;
            
        }
        .swiper{
            height: 100%;
        }
    }

}
</style>