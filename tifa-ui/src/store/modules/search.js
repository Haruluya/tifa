

// 导入请求方法。
import {
    postSearchDataRequest,
} from "@/api";

const state = {
    searchData:{},
    pageIndex:1
};

const mutations = {
    GETSEARCHDATA(state, searchData) {
        state.searchData = searchData;
        console.log(searchData);
      },
    CHANGECURRENTPAGE(state, pageIndex){
      state.pageIndex = pageIndex;
    }
}

const actions = {
//获取搜索数据。请求体必须存在。
  async getSearchData({ commit }, params) {
    let result = await postSearchDataRequest(params);
    console.log(result);
    if (result.statusCode == 200) {
      commit("GETSEARCHDATA", result.data);
    }
  },
  
  changeCurrentPage({commit}, pageIndex){
    commit("CHANGECURRENTPAGE", pageIndex);
  }
}



const getters = {

    //产品列表。
    goodsList(state){
      return state.searchData.goodsList||[];
    },

    pageIndex(state){
      return state.pageIndex;
    },
    searchTotalItem(state){
      if (state.searchData.pageData){
        return state.searchData.pageData.total || 0;
      }
      return {};
    },
    searchGoodsList(state){
      if (state.searchData.pageData){
        return state.searchData.pageData.records || [];
      }
      return {};
    },
    categorys(state){
      if (state.searchData.categorys){
        return state.searchData.categorys || [];
      }
      return {};
    },
    searchGoodsImg(state){
      if (state.searchData.imgData){
        return state.searchData.imgData || [];
      }
      return {};
    }
    // trademarkList(state){
    //   return state.searchData.trademarkList||[];
    // },
    // attrsList(state){
    //   return state.searchData.attrsList||[];
    // }
 };


export default {
  state,
  mutations,
  actions,
  getters,
};