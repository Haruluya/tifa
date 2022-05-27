import {
    postLoginConfirm,
    postLogout,
    getUserData 
  } from "_api";
import {setToken,getToken,removeToken} from "_utils/token.js";

const state = {
    token: getToken(),
    userData:{},
};

const mutations = {
    CONFIRMLOGIN(state,result){
        state.token = getToken();
    },
    GETUSERDATA(state,userData){
        state.userData = userData
    },
    USERLOGOUT(state){
        state.token = '';
        state.userData={};
        //本地存储数据清空
        removeToken();
    }

};

const actions = {

    // 登录验证。
    async confirmLogin({commit},loginData){
        let result = await postLoginConfirm(loginData);
        console.log(result);
        if (result.statusCode == 200) {
            // 持久化token。
            setToken(result.data.token);
            commit("CONFIRMLOGIN", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
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
    // 获取用户信息。
    async getNowUserData({commit},token){
        let result = await getUserData(token);
        //action里面不能操作state，提交mutation修改state
        if(result.statusCode==200){
            commit("GETUSERDATA",result.data);
        }else{
            return Promise.reject(new Error('faile'));
        }
    },

};

const getters = {
    userName(state){
        return !state.userData.uname ? "未登录" :state.userData.uname;
    },
    userData(state){
        return state.userData || {};
    },
    token(state){
        return state.token || "";
    }
};

export default {
    state,
    mutations,
    actions,
    getters,
};