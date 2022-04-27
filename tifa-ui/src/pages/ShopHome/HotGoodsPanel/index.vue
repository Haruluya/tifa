<template>
    <div class="mainContainer">
        <div class="panelTitle">
            基于Spark SQL的最近热点商品推荐。
        </div>
        <el-row>
          <el-col :span="4">
            <div class="title">
                 <el-card shadow="never" :body-style="{ padding: '0px'}">
                     <img
                        src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                        class="image"
                        />
                 </el-card>
            </div>
          </el-col>
          <el-col :span="4" v-for="index in 4" :key="index" >
            <div class="card">
                <RecCard/>
            </div>
          </el-col>
          <el-col :span="4">
             <div class="swiper">
                <CarsouelSmall :list="['https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png']"/>
             </div>
          </el-col>
        </el-row>
    </div>
</template>
<script>
import RecCard from '@/components/RecCard'
import CarsouelSmall from '@/components/CarsouelSmall'

export default {
    name:'hotGoodsPanel',
    components:{
        RecCard,
        CarsouelSmall
    }
}
</script>
<style lang="less" scoped>



.mainContainer{
    .panelTitle{
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        font-size: 30px;
    }
    .title{
        img{
            width: 130%;
        }
    }
    .card{
        margin-left: 10px;
    }
    .swiper{
        height: 100%;
    }
}
</style>