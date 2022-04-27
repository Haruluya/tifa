<template>
  <div class="mainContainer">
    <el-carousel :height="heighty + 'px'" pause-on-hover>
      <el-carousel-item v-for="item in 2" :key="item">
        <el-image :src="list[0]">
        </el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>

export default {
  name: "carsouselSmall",
  props: ["list","heighty"]


}

</script>

<style scoped lang="less">
.mainContainer{
  border-radius: 10px;
  overflow: hidden;
}

</style>
