<template>
  <Header  v-show="$route.meta.showHeader"></Header>
  <div>
    <router-view></router-view> 
  </div>
  <Footer v-show="$route.meta.showFooter"></Footer>
</template>

<script>

// 导入组件。
import Header from "./components/Header"
import Footer from "./components/Footer"

export default {
  name: 'App',
  // 组件注册。
  components: {
    Header,
    Footer
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
