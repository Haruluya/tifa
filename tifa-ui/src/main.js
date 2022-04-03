import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as icons from '@element-plus/icons-vue' 

import router from './router';
import store from './store/index.js';



const app = createApp(App);


app.use(router).use(store).use(ElementPlus);
Object.keys(icons).forEach(key => {
    app.component(key, icons[key])
})
app.mount('#app');

export default app;