import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('../pages/Center/Home'),
    meta:{
      showFooter:true
    },
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../pages/Center/Home'),
    meta:{
      showFooter:true
    },
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../pages/Center/Login'),
    meta:{
      showFooter:false
    },
  },
  {
    path: '/CRUD',
    name: 'CRUD',
    component: () => import('../pages/Center/CRUD'),
    meta:{
      showFooter:false
    },
  }
]

const routerHistory = createWebHistory()
const router = createRouter({
  base:'/http/',
  history: routerHistory,
  routes
})
export default router
