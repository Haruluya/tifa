<template>
  <div class="mainContainer">
    <el-carousel :interval="5000" arrow="always" height="500px">
      <el-carousel-item v-for="item in 4" :key="item">
        <el-image src="https://img11.360buyimg.com/pop/s1180x940_jfs/t1/134808/21/21405/93557/62678dedEa54e482a/5094b9f2f1eab83e.jpg.webp">

        </el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<style scoped>

</style>
