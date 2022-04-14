
import {
    getGoodDetailById,
    postUpdateShopCart
} from "@/api";

const state = {
    goodData: {}
};

const mutations = {
    GETGOODDATA(state,data){
        state.goodData = data;
    }
}

const actions = {
  //请求获取界面商品信息数据。
 async getGoodData({ commit }, goodId) {
    let result = await getGoodDetailById(goodId);
    console.log(goodId);
    if (result.code == 200) {
      commit("GETGOODDATA", result.data);
    }
  },


  //请求更新购物车。
  async updateShopCart({commit}, {goodId,goodAmount}){
    let result = await postUpdateShopCart(goodId, goodAmount);
    console.log(result);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  }
}


const getters = {
  categoryView(state) {
    return state.goodData.categoryView || {};
  },
  skuInfo(state) {
    return state.goodData.skuInfo || {};
  },
  spuSaleAttrList(state) {
    return state.goodData.spuSaleAttrList || [];
  },
};



export default {
  state,
  mutations,
  actions,
  getters,
};