
import {
    postGoodDetailById,
    postUpdateShopCart,
    postgetCommentData
    
} from "@/api";
import defaultImg from '_assets/images/tifa_default_card_img.webp'
const state = {
    goodData: {},
    comments:[]
};

const mutations = {
    GETGOODDATA(state,data){
        state.goodData = data;
    },
    SETCOMMENT(state,data){
      state.comments = data
    }
}

const actions = {
  //请求获取界面商品信息数据。
 async getGoodData({ commit }, pid) {
    let result = await postGoodDetailById(pid);
    console.log(result);
    if (result.statusCode == 200) {
      commit("GETGOODDATA", result.data);
    }else{
      return Promise.reject(new Error("faile"));
    }
  },


  //请求更新购物车。
  async addGoddToShopCart({commit}, {sid,pid, num}){
    let result = await postUpdateShopCart({sid,pid, num});
    console.log(result);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },

  async getCommentData({commit}, data){
    let result = await postgetCommentData(data);
    console.log(result);
    if (result.statusCode == 200) {
      commit("SETCOMMENT", result.data);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  }


}


const getters = {
  goodData(state){
    return state.goodData || "";
  },
  goodDetailInfo(state) {
    return state.goodData.productInfo || ""
  },  
  goodImg(state){
    if (state.goodData.productImageInfo){
      if (state.goodData.productImageInfo.type == "images/model/guan/url_none.png"){
        state.goodData.productImageInfo.type = defaultImg;
      }
    }
    return state.goodData.productImageInfo || ""
  },
  categorys(state){
    return state.goodData.productCategoryInfo || ""
  },
  comments(state){
    return state.comments || []
  }
};



export default {
  state,
  mutations,
  actions,
  getters,
};