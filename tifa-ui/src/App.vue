<template>
  <div class="app">
    <PageHeader v-show="showHeader" class="nav"></PageHeader>
    <Header  v-show="$route.meta.showHeader"></Header>
    <BackToTop></BackToTop>
    <div>
      <router-view></router-view> 
    </div>
    <div class="footer">
      <Footer v-show="$route.meta.showFooter"></Footer>
    </div>
  </div>
</template>

<script>


// 导入组件。


export default {
  name: 'App',
  data() {
    return {
      showHeader: false
    }
  },
  // 组件注册。
  components: {

  },
  methods: {
    isScroll(){
        const top = document.documentElement.scrollTop
        if (top > 100) {	
          this.showHeader = true
        } else {
          this.showHeader= false
        }
    }
  },

   mounted () {
    window.addEventListener('scroll', this.isScroll)
  },
  
   unmounted () {
    window.removeEventListener('scroll', this.isScroll)
  }


}



</script>

<style>
body{
  background-color: rgba(204, 198, 198, 0.352);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;


}
.footer{
  margin-top: 150px; 
}
.el-row{
  width: 100%;
  height: 100%;
}
</style>
