<template lang="">
    <div class="main">
     <el-row>
    <el-col
      v-for="(o, index) in 2"
      :key="o"
      :span="8"
      :offset="index > 0 ? 2 : 0"
    >
      <el-card :body-style="{ padding: '0px' }">
        <el-image fit="fill" :src="'https://img12.360buyimg.com/n7/jfs/t1/93891/9/25964/224579/62318648E772f793b/8250cc814aacfd49.jpg'" class="image"/>
        <div>
            <span>￥159</span>
            <span style="margin-left: 5px">hamburger</span>
            <div>
                <el-rate/>
            </div>
            <el-space :size="20">
                <el-tag class="ml-2" type="danger" hit effect="plain">放心购</el-tag>
                <el-tag class="ml-2" type="" hit effect="plain">卷999</el-tag>
                <el-tag class="ml-2" type="" hit effect="plain">8折</el-tag>
            </el-space>
        </div>
              <span>
              暖男厨房 安格斯牛肉饼汉堡肉饼半成品儿童早餐国产 冷冻 牛肉饼80g*10（800g）
          </span>
        <div style="padding: 14px">
    
          <div class="bottom">
            <el-button type="danger" plain >加入购物车</el-button>  
            <el-button type="danger" plain >收藏</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>   
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    .main{
        background-color: gainsboro;
    }
</style>