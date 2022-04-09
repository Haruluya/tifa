// register模块不需要保存数据。
// 逻辑如下：
// 请求后端发送验证码，
// 获取表单数据，
// 向后端发送表单数据。

// 导入请求方法。
import {
    postRegisterConfim
} from "@/api";

const state = {
};

const mutations = {
    
}

const actions = {
    async commitRegister({ commit }, registerData) {
        let {name, code, password} = registerData;
        let result = await postRegisterConfim({
            name,
            password
        });
        console.log(result);
        if (result.statusCode == 200) {
        } else {
            return Promise.reject(new Error("faile"));
            
        }
    },
}


const getters = {};
export default {
  state,
  mutations,
  actions,
  getters,
};