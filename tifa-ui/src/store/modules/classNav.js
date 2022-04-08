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
    
};

const getters = {

};

export default {
    state,
    mutations,
    actions,
    getters,
};