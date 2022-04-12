

// 导入请求方法。
import {
    postSearchDataRequest
} from "@/api";

const state = {
    searchData:{}
};

const mutations = {
    GETSEARCHDATA(state, searchData) {
        state.searchData = searchData;
      },
}

const actions = {
//获取搜索数据。请求体必须存在。
  async getSearchData({ commit }, params = {}) {
    let result = await postSearchDataRequest(params);
    console.log(result);
    if (result.code == 200) {
      commit("GETSEARCHDATA", result.data);
    }
  },
}



const getters = {

    //产品列表。
    goodsList(state){
      return state.searchData.goodsList||[];
    }
    ,
    trademarkList(state){
      return state.searchData.trademarkList||[];
    },
    attrsList(state){
      return state.searchData.attrsList||[];
    }
 };


export default {
  state,
  mutations,
  actions,
  getters,
};