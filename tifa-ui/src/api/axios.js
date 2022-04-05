import axios from "axios";
import nprogress from "nprogress";
import "nprogress/nprogress.css";


//@date 2022/3/30 
// INFO:axios配置文件。

// axios全局配置。
axios.defaults.method = 'GET';//设置默认的请求类型为 GET
axios.defaults.baseURL = 'http://localhost:8081/tifai';//设置基础 URL
axios.defaults.timeout = 5000;


let requests = axios.create();


//请求拦截器配置。
requests.interceptors.request.use((config) => {
    // if(store.state.detail.uuid_token){
    //     //请求头添加一个字段(userTempId):7
    //     config.headers.userTempId = store.state.detail.uuid_token;
    // }
    // //需要携带token带给服务器
    // if(store.state.user.token){
    //     config.headers.token = store.state.user.token;
    // }
    // 开始进度条。
    nprogress.start();
    return config;
});
  
  //响应拦截器配置。
requests.interceptors.response.use(
    (res) => {
      //进度条结束
      nprogress.done();

      return res.data;
    },
    // 处理所有err。
    (err) => {
      alert("服务器响应数据失败");
    }
);

export default requests;
