// //先引入mockjs模块
import { options } from 'less';
import Mock from 'mockjs';
// //把JSON数据格式引入进来[JSON数据格式根本没有对外暴露，但是可以引入]
// //webpack默认对外暴露的：图片、JSON数据格式
import classData from './classData.json'
import token from './token.json';
import registerData from './registerData.json'
import logoutData from '@/mock/logoutData.json'
import userData from '@/mock/userData.json'

// //mock数据:第一个参数请求地址   第二个参数：请求数据
// Mock.mock("/mock/test",{code:200,data:test});


Mock.mock("http://localhost:8081/tifai/classNav/classData",'get',classData);
Mock.mock("http://localhost:8081/tifai/login/confirm",'post',token);
Mock.mock("http://localhost:8081/tifai/register/confirm",'post',registerData);
Mock.mock("http://localhost:8081/tifai/login/logout",'post',logoutData);
Mock.mock("http://localhost:8081/tifai/user/userData",'post',userData);