import { postAddAdressRequest} from "@/api";


const state = {
    adressDetail:[],
}

const mutations = {
    SHOWADDADRESSDIALOG(state){
        state.addAdressVisible = true;
    }
}


const actions = {
    async addAddress({ commit }, data) {
        let result = await postAddAdressRequest(data);
        if (result.statusCode == 200) {
            return "ok";
        } else {
            return Promise.reject(new Error("faile"));
        }
    },

}


const getters = {
    addAdressVisible(state){
        return state.addAdressVisible;
    }
}

export default {
    state,
    mutations,
    actions,
    getters,
  };
  