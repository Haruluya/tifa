<template>
  <div>
    <Header></Header>
    <Footer></Footer>
  </div>
</template>

<script>

// 导入组件。
import Header from "./components/Header/Header.Vue"
import Footer from "./components/Footer/Footer.Vue"

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
  margin-top: 60px;
}
</style>
