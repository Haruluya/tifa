export const routes = [
    {
      path: '/',
      component: () => import('../pages/ShopHome'),
      meta:{
        showFooter:true,
      },
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../pages/Center/Home'),
      meta:{
        showFooter:true,
  
      },
    },
    {
      path: '/shopHome',
      name: 'shopHome',
      component: () => import('../pages/ShopHome'),
      meta:{
        showFooter:true,
      },
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../pages/Center/Login'),
      meta:{
        showFooter:false,
      },
    },
    {
      path: '/CRUD',
      name: 'CRUD',
      component: () => import('../pages/Center/CRUD'),
      meta:{
        showFooter:false,
      },
    },
    {
      path: '/register',
      name:'register',
      component: () => import('../pages/Center/Register'),
      meta:{
        showFooter:false,
      }
    },
    {
      path: '/classNav',
      name:'classNav',
      component: () => import('_components/ClassNav'),
      meta:{
        showFooter:false,
      }
    },
    {
      path: '/search',
      name:'search',
      component: () => import('_pages/Center/Search'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/agooddetail/:goodId',
      name:'agooddetail',
      component: () => import('_pages/Center/GoodDetail'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/shopcart',
      name:'shopcart',
      component: () => import('_pages/Center/ShopCart'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/pageheader',
      name:'pageheader',
      component: () => import('_components/PageHeader'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/gooddetail',
      name:'gooddetail',
      component: () => import('_pages/GoodDetail'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/tifalogin',
      name:'tifalogin',
      component: () => import('_pages/TifaLogin'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/tifaregister',
      name:'tifaregister',
      component: () => import('_pages/TifaRegister'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/tifashopcart',
      name:'tifashopcart',
      component: () => import('_pages/TifaShopCart'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/tifasearch/:searchKey',
      name:'tifasearch',
      component: () => import('_pages/TifaSearch'),
      meta:{
        showFooter:true,
      }
    },
    {
      path: '/userinfo',
      name:'userinfo',
      component: () => import('_pages/UserInfo'),
      meta:{
        showFooter:true,
      },
      children:[
        {
          path:"",
          component:() => import('_pages/UserInfo/Outline')
        },
        {
          path:"myfocus",
          component:() => import('_pages/UserInfo/MyFocus')
        },
        {
          path:"myOrder",
          component:() => import('_pages/UserInfo/MyOrder')
        },
      ]
    },
    {
      path: '/settlement',
      name:'settlement',
      component: () => import('_pages/Settlement'),
      meta:{
        showFooter:true,
      }
    },
  ]