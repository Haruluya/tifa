import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('../pages/Center/Home'),
    meta:{
      showHeader:true
    },
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../pages/Center/Home'),
    meta:{
      showHeader:true
    },
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../pages/Center/Login'),
    meta:{
      showHeader:false
    },
  },
  {
    path: '/CRUD',
    name: 'CRUD',
    component: () => import('../pages/Center/CRUD'),
    meta:{
      showHeader:false
    },
  },
  {
    path: '/register',
    name:'register',
    component: () => import('../pages/Center/Register'),
    meta:{
      showHeader:false
    }
  }
]

const routerHistory = createWebHistory()
const router = createRouter({
  base:'/http/',
  mode:'history',
  history: routerHistory,
  routes
})
export default router
