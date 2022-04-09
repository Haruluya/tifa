import {
    getClassNavData,
} from "@/api";


const state = {
    classNavData: {}
};

const mutations = {
    GETCLASSNAVDATA(state,classNavData){
        state.classNavData = classNavData;
    }
};

const actions = {
    async getClassData({commit}){
        let result = await getClassNavData();
        if (result) {
            commit("GETCLASSNAVDATA", result.data)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
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
};

const getters = {
    
};

export default {
    state,
    mutations,
    actions,
    getters,
};