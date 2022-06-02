import {
    postLoginConfirm,
    postLogout,
    getUserData,
    getCode,
    isLogin,
    rePassword
  } from "_api";
import {setToken,getToken,removeToken} from "_utils/token.js";
import { ElNotification} from 'element-plus'
const state = {
    token: getToken(),
    userData:{},
    codeUrl:"",
    isLogin:false
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
    },
    SETCODEURL(state,codeUrl){
        state.codeUrl = codeUrl
    },
    ISLOGIN(state,data){
        setToken(data.token);
        state.isLogin = true;
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
        console.log(result)
        if(result.statusCode==200){
            commit("GETUSERDATA",result.data);
        }else{
            return Promise.reject(new Error('faile'));
        }
    },
    async getCode({commit},token){
        let result = await getCode();
        if(result.statusCode==200){
            commit("SETCODEURL",result.data);
        }else{
            return Promise.reject(new Error('faile'));
        }
    },
    async islogin({commit}){
        let result = await isLogin();
        if(result.statusCode==200){
            commit('ISLOGIN', result.data);

        }
    },
    async rePassword({commit},data){
        let result = await rePassword(data);
        console.log(result);
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
    },
    codeUrl(state){
        return state.codeUrl || ""
    },
    isLogin(state){
        return state.isLogin || false
    }
};

export default {
    state,
    mutations,
    actions,
    getters,
};