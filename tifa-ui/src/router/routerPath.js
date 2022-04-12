export const routes = [
    {
      path: '/',
      component: () => import('../pages/Center/Home'),
      meta:{
        showHeader:true,
        showFooter:true,
      },
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../pages/Center/Home'),
      meta:{
        showHeader:true,
        showFooter:true,
      },
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../pages/Center/Login'),
      meta:{
        showHeader:false,
        showFooter:false,
      },
    },
    {
      path: '/CRUD',
      name: 'CRUD',
      component: () => import('../pages/Center/CRUD'),
      meta:{
        showHeader:false,
        showFooter:false,
      },
    },
    {
      path: '/register',
      name:'register',
      component: () => import('../pages/Center/Register'),
      meta:{
        showHeader:false,
        showFooter:false,
      }
    },
    {
      path: '/classNav',
      name:'classNav',
      component: () => import('_components/ClassNav'),
      meta:{
        showHeader:false,
        showFooter:false,
      }
    },
    {
      path: '/search',
      name:'search',
      component: () => import('_pages/Center/Search'),
      meta:{
        showHeader:false
      }
    }
  ]