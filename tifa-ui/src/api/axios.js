import axios from "axios";

axios.defaults.method = 'GET';//设置默认的请求类型为 GET
axios.defaults.baseURL = 'http://localhost:8081';//设置基础 URL
axios.defaults.timeout = 3000;


let config = {};
let requests = axios.create(config);

requests.test = function(e){
    e.preventDefault();
    axios.request({
        method:'GET',
        url:'/api'
    }).then(response=>{
        console.log(response);
    }).catch(error=>{
        console.log(error);                               
    })
}

export default requests;
