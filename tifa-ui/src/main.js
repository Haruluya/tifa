import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as icons from '@element-plus/icons-vue' 
import mitt from "mitt"

// 引入mockjs。
import '@/mock/index.js'
import router from './router/routers';
import store from './store/index.js';


import Header from '_components/Header';
import Footer from '_components/Footer';
import ClassNav from '_components/ClassNav';
import PageHelper from '_components/PageHelper'

const app = createApp(App);

//全局事件总线。
app.config.globalProperties.$bus = new mitt();

app.use(router).use(store).use(ElementPlus);
app.component('Header',Header)
    .component('Footer',Footer)
    .component('ClassNav',ClassNav)
    .component('PageHelper',PageHelper);



//icon组件。
Object.keys(icons).forEach(key => {
    app.component(key, icons[key])
})


app.mount('#app');

