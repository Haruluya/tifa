import { v4 as uuid } from 'uuid';
//存储token
export const setToken = (token) => {
    localStorage.setItem("TOKEN", token);
  };
//获取token
export const getToken = () => {
    return localStorage.getItem("TOKEN");
};

//清除本地存储的token
export const removeToken=()=>{
    localStorage.removeItem("TOKEN");
}
  

//获取游客的uuid。
export const getUserUUID = ()=>{
   let uuid = localStorage.getItem('UUID');
   if(!uuid){
      uuid = uuid();
      localStorage.setItem('UUID',uuid);
   }
   return uuid;
}
