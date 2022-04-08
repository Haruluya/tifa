
import { getUserData } from "_api";

const state = {
    userData:{}
};

const mutations = {
    GETUSERDATA(state,userData){
        state.userData = userData
    },
    USERLOGOUT(state,userData){
        
    }
};

const actions = {
    // 获取用户信息。
    async getUserData({commit}){
        let result = await getUserData();
        //action里面不能操作state，提交mutation修改state
        if(result.statusCode==200){
            commit("GETUSERDATA",result.data);
        }else{
            return Promise.reject(new Error('faile'));
        }
    },
}



const getters = {

};

export default {
    state,
    mutations,
    actions,
    getters,
};