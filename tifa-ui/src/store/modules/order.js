import { postPurchaseRequest,
  postreturnProductRequest,postconfirmDerRequest,postdeleteProductRequest,postconfirmDetoRequest,postSetPaidRequest,postMerchantOrderRequest,postGetOrderDataRequest,postConfirmDeRequest } from "@/api";
import defaultImg from '_assets/images/tifa_default_card_img.webp'
const state = {
  address: [],
  orderInfo:{},
  htmlText:"",
  merchantOrderData:{},
};
const mutations = {
  PURCHASE(state, result){
    state.htmlText = result;
  },
  ORDERDATA(state,data){
    state.orderData = data
  },
  MERCHANTORDERDATA(state,data){
    state.merchantOrderData = data;
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
      commit("ORDERDATA",result.data);
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async confirmDe({ commit }, data) {
    let result = await postConfirmDeRequest(data);
    console.log(result);
    if (result) {
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async setPaid({ commit }) {
    let result = await postSetPaidRequest();
    console.log(result);
    if (result) {
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async getMerchantOrderData({ commit },data) {
    let result = await postMerchantOrderRequest(data);
    console.log(result);
    if (result) {
      commit("MERCHANTORDERDATA",result.data);
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async confirmDeto({ commit }, data) {
    let result = await postconfirmDetoRequest(data);
    console.log(result);
    if (result) {
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async returnProduct({ commit }, data) {
    let result = await postreturnProductRequest(data);
    console.log(result);
    if (result) {
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
  async deleteProduct({ commit }, data) {
    let result = await postdeleteProductRequest(data);
    console.log(result);
    if (result) {
    } else {
        return Promise.reject(new Error("faile"));
    }
  },
};
const getters = {
  htmlText(state){
    return state.htmlText || ""
  },
  orderData(state){
    if (state.orderData){
      state.orderData.productImgData.forEach(element => {
        if (element.type == "images/model/guan/url_none.png"){
          element.type = defaultImg;
        }
      });
    }
    return state.orderData || {}
  },
  merchantOrderData(state){
    return state.merchantOrderData ||{}
  }
};
export default {
  state,
  mutations,
  actions,
  getters,
};
