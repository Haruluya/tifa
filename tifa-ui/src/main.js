import { createApp } from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import router from './router';
import store from './store/index.js';



const app = createApp(App);


app.use(router).use(store).use(ElementUI);
app.mount('#app');

export default app;