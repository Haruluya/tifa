import { postPurchaseRequest,postGetOrderDataRequest } from "@/api";
const state = {
  address: [],
  orderInfo:{},
  htmlText:""
};
const mutations = {
  PURCHASE(state, result){
    state.htmlText = result;
  }
};
const actions = {
  async purchase({ commit }, orderData) {
    let result = await postPurchaseRequest(orderData);
    console.log(result);
    if (result) {
      commit("PURCHASE",result);
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async getOrderData({ commit }, data) {
    let result = await postGetOrderDataRequest(data);
    console.log(result);
    if (result) {
      commit("PURCHASE",result);
    } else {
        return Promise.reject(new Error("faile"));
    }
  },

};
const getters = {
  htmlText(state){
    return state.htmlText || ""
  }
};
export default {
  state,
  mutations,
  actions,
  getters,
};
