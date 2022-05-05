<template>
  <div class="mainContainer">
    <el-carousel :interval="5000" arrow="always" height="500px" >
      <el-carousel-item v-for="item in 4" :key="item">
        <el-image src="https://imgcps.jd.com/img-cubic/creative_server_cia_jdcloud/v2/2000366/100025363858/FocusFullshop/CkRqZnMvdDEvMTg1MzM5LzIxLzIzMzYzLzE0MDg1Ni82MjY1YThjNUU2OWUxODI3Zi8yYWI5OWRiNmYzYjE2OWZhLnBuZxIJNS10eV8wXzU2MAI47ot6QhAKDOmbt-Wjq-a1tOmcuBAAQhAKDOi0qOS8mOS7t-W7iRABQhAKDOeri-WNs-aKoui0rRACQgoKBuS8mOi0qBAHWJLb58_0Ag/cr/s/q.jpg">
        </el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<style scoped>
  .el-carousel{
    background-color: #e3e4e5 ;
  }
</style>
