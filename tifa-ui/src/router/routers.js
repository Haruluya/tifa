import { createRouter, createWebHistory } from 'vue-router'
import {routes} from './routerPath.js'
import store from "@/store";

const routerHistory = createWebHistory()
const router = createRouter({
  base:'/http/',
  mode:'history',
  history: routerHistory,
  routes
})

// 全局前置守卫。
router.beforeEach(async (to, from, next) => {

   let token  = store.state.login.token;
   let name = store.state.login.userData.name;
   //登录状态。
   if(token){
    // 拒绝访问login、register页面。
      if(to.path=="/login"||to.path=='/register'){
        next('/');
      }else{
      if(name){
        next();
      }else{
         //登陆了且没有用户信息。
         try {
            await store.dispatch('getUserData');
            next();
         } catch (error) {
           //token失效从新登录。
           await store.dispatch('userLogout');
           next('/login')
         }
       }
     }
   }else{
      //未登录：某些组件拒绝访问。
      let toPath = to.path;
      if(toPath.indexOf('/CRUD')!=-1 || toPath.indexOf('/classNav')!=-1){
        alert("请登录！");
        next('/login?redirect='+toPath);
      }else{
         next();
      }
   }
});



export default router