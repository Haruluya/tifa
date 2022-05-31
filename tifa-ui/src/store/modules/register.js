// register模块不需要保存数据。
// 逻辑如下：
// 请求后端发送验证码，
// 获取表单数据，
// 向后端发送表单数据。
import { ElNotification} from 'element-plus'
// 导入请求方法。
import {
    postRegisterConfim,
    postregisterMerchantConfim,
    postSendCodeConfim
} from "@/api";

const state = {
    code:0
};

const mutations = {
    SETCODE(state,code){
        state.code = code;
    }
}

const actions = {
    async commitRegister({ commit }, registerData) {
        let result = await postRegisterConfim(registerData);
        console.log(result);
        if (result.statusCode == 200) {
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async registerMerchant({ commit }, registerData) {
        let result = await postregisterMerchantConfim(registerData);
        console.log(result);
        if (result.statusCode == 200) {
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async sendCode({ commit },phone) {
        let result = await postSendCodeConfim(phone);

        if (result.statusCode == 200) {
            commit("SETCODE",result.data.code)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
}


const getters = {
    code(state){
        return state.code;
    }
};
export default {
  state,
  mutations,
  actions,
  getters,
};