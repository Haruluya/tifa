import { createRouter, createWebHistory } from 'vue-router'
import {routes} from './routerPath.js'
import store from "@/store";
import {ElNotification} from 'element-plus'
const routerHistory = createWebHistory()
const router = createRouter({
  base:'/http/',
  history: routerHistory,

  //路由跳转后滚动到最上方。
  scrollBehavior(to, from, savedPosition) {
    return { y: 0 };
  },
  
  routes,
})

// 全局前置守卫。
router.beforeEach(async (to, from, next) => {

   let token  = store.state.login.token;
   let name = store.state.login.userData.name;
   //登录状态。
   if(token){
    // 拒绝访问login、register页面。
      if(to.path=="/tifalogin"){
        next('/');
      }else{
      if(name){
        next();
      }else{
         //登陆了且没有用户信息。
         try {
            await store.dispatch('getNowUserData',token);
            next();
         } catch (error) {
           //token失效从新登录。
           console.log(error);
           await store.dispatch('userLogout');
           next('/tifalogin')
         }
       }
     }
   }else{
      //未登录：某些组件拒绝访问。
      let toPath = to.path;
      if(toPath.indexOf('/userinfo')!=-1 || toPath.indexOf('/tifashopcart')!=-1){
        ElNotification({
          title: '请登录！',
          message: "登录用户可以访问个人信息！",
          type: 'error'
        })
        next('/tifalogin?redirect='+toPath);
      }else{
         next();
      }
      next();
   }
});

router.afterEach((to,from,next) => {
  window.scrollTo(0,0);
})

export default router
