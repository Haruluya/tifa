import {
    postLoginConfirm,
    postLogout
  } from "_api";
import {setToken,getToken,removeToken} from "_utils/token.js";

const state = {
    token: getToken(),
};

const mutations = {
    CONFIRMLOGIN(state,result){
        state.token = result.token;
    },
    //退出登录
    async userLogout({commit}) {
        let result = await postLogout();
        //action里面不能操作state，提交mutation修改state
        if(result.statusCode==200){
            commit("USERLOGOUT");
        }else{
            return Promise.reject(new Error('faile'));
        }
    },
};

const actions = {

    // 登录验证。
    async confirmLogin({commit},loginData){
        let result = await postLoginConfirm(loginData);

        // 简单前端模拟登录验证。
        if (loginData.email != 'tifa_admin' || loginData.password != '123456'){
            return Promise.reject(new Error("faile"));
        }
        // 持久化token。
        setToken(result.token);
        if (result) {
            commit("CONFIRMLOGIN", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },


};

const getters = {

};

export default {
    state,
    mutations,
    actions,
    getters,
};