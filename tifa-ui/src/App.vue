<template>
  <div class="app">
    <PageHeader v-if="showHeader" class="nav"></PageHeader>
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
        if (top > 100 && this.$route.path != '/' && this.$route.path != '/home') {	
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

<style lang="less">
body{
  background-color: #f4f4f4;
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
/* 全局taps字体样式 */
.el-tabs__item {
    font-size: 18px !important;
    color:#999999 !important;
    &:hover{
      color: #e6251b !important;
    }
}

// radio字体全局设置。
.el-radio-button__inner{
  font-size: 18px !important;
  font-weight: bold !important;
  font-family: tahoma, arial, 宋体 !important;
}

.el-col{
  min-height: 1px;
}
</style>
