import { postAddAdressRequest,
    postLocationDataRequest,
    postDeleteAdrDataRequest,
    postUpdateUserInfoRequest,
    postMerchantProductDataRequest,
    postAddProductRequest} from "@/api";


const state = {
    locationData:[],
    merchantProductsData:{}
}

const mutations = {
    GETLOCATIONDATA(state,data){
        state.locationData = data;
    },
    GETMERCHANTPRODUCTSDATA(state,data){
        state.merchantProductsData = data;
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
    async getLocationData({ commit }, data) {
        let result = await postLocationDataRequest(data);
        if (result.statusCode == 200) {
            commit("GETLOCATIONDATA", result.data);
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async deleteAdress({ commit }, data) {
        let result = await postDeleteAdrDataRequest(data);
        if (result.statusCode == 200) {
            commit("GETLOCATIONDATA", result.data);
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async updateUserInfo({ commit }, data) {
        let result = await postUpdateUserInfoRequest(data);
        if (result.statusCode == 200) {
            commit("GETLOCATIONDATA", result.data);
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async getMerchantProductData({ commit }, data) {
        let result = await postMerchantProductDataRequest(data);
        if (result.statusCode == 200) {
            commit("GETMERCHANTPRODUCTSDATA", result.data);
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async addProduct({ commit }, data) {
        let result = await postAddProductRequest(data);
        if (result.statusCode == 200) {
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
}


const getters = {
    locationData(state){
        return state.locationData || [];
    },
    merchantProductsData(state){
        return state.merchantProductsData || {}
    }
}

export default {
    state,
    mutations,
    actions,
    getters,
  };
  