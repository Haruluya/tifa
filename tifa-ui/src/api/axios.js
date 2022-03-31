import axios from "axios";
import nprogress from "nprogress";
import "nprogress/nprogress.css";


axios.defaults.method = 'GET';//设置默认的请求类型为 GET
axios.defaults.baseURL = 'http://localhost:8081/api';//设置基础 URL
axios.defaults.timeout = 5000;


let requests = axios.create();

// requests.test = function(e){
//     e.preventDefault();
//     axios.request({
//         method:'GET',
//         url:'/api'
//     }).then(response=>{
//         console.log(response);
//     }).catch(error=>{
//         console.log(error);                               
//     })
// }






//请求拦截器----在项目中发请求（请求没有发出去）可以做一些事情
requests.interceptors.request.use((config) => {
    // if(store.state.detail.uuid_token){
    //     //请求头添加一个字段(userTempId):和后台老师商量好了
    //     config.headers.userTempId = store.state.detail.uuid_token;
    // }
    // //需要携带token带给服务器
    // if(store.state.user.token){
    //     config.headers.token = store.state.user.token;
    // }
    nprogress.start();
    return config;
});
  
  //响应拦截器----当服务器手动请求之后，做出响应（相应成功）会执行的
requests.interceptors.response.use(
    (res) => {
      //进度条结束
      nprogress.done();
      //相应成功做的事情
      return res.data;
    },
    (err) => {
      alert("服务器响应数据失败");
    }
);

export default requests;
