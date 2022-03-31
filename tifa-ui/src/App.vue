<template>
  <Header  v-show="$route.meta.showFooter"></Header>
  <div>
    <router-view></router-view> 
  </div>
</template>

<script>

// 导入组件。
import Header from "./components/Header"

export default {
  name: 'App',
  // 组件注册。
  components: {
    Header,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
