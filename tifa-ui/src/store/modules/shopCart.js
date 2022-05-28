import { getShopCartData, postDeleteCartByGoodId,postClearCartRequest} from "@/api";
import defaultImg from '_assets/images/tifa_default_card_img.webp'


const state = {
  cartList: {},
  sumPrice:0,
  pids:""
};
const mutations = {
  GETCARTLIST(state, cartList) {
    state.cartList = cartList;
  },
  SETSUMPRICE(state, sumPrice){
    state.sumPrice = sumPrice
  },
  SETPIDS(state,data){
    state.pids = data
  }

};
const actions = {
  //获取购物车列表数据
  async getCartListData({ commit }, userData) {
    let result = await getShopCartData(userData);
    if (result.statusCode == 200) {
      commit("GETCARTLIST", result.data);
    }
  },

  //删除购物车某一个产品
  async deleteCartByGoodId({ commit }, data) {
    let result = await postDeleteCartByGoodId(data);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },

  async clearCart({ commit }, data) {
    let result = await postClearCartRequest(data);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },

  setSumPrice({ commit }, data){
    commit('SETSUMPRICE', data)
  },
  setPids({ commit }, data){
    commit('SETPIDS', data)
  }
};
const getters = {
  cartList(state) {
    if (state.cartList && state.cartList.imgList){
        state.cartList.imgList.forEach((item,index)=>{
        if (item == 'images/model/guan/url_none.png'){
          state.cartList.imgList[index] = defaultImg
        }
      })
    }
    return state.cartList || {};
  },
  sumPrice(state){
    return state.sumPrice || 0;
  },
  pids(state){
    return state.pids || "";
  }
};
export default {
  state,
  mutations,
  actions,
  getters,
};
