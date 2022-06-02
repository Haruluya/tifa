
import {
    postGoodDetailById,
    postUpdateShopCart,
    postgetCommentData,
    postaddCommentData,
    getHotProducts,
    getMostRatedProducts,
    getALSRecProducts,
    getProductInfo,
    getItemCFProducts,
    getSimProductsByContent,
    getOnlineRecProducts,
    addRate
} from "@/api";
import defaultImg from '_assets/images/tifa_default_card_img.webp'
const state = {
    goodData: {},
    goodRecData:{},
    comments:[],
    highestRateData:{},
    recentlyRateData:{},
    itemcfData:{},
    onlineData:{},
    alsData:{},
    tfidfData:{}
};

const mutations = {
    GETGOODDATA(state,data){
        state.goodData = data;
    },
    SETCOMMENT(state,data){
      state.comments = data
    },
    SETRECDATA(state,data){
      state.highestRateData = data.mostResult;
      state.recentlyRateData = data.hotResult;
    },
    SETALSDATA(state,data){
      state.alsData = data;
    },
    SETGOODRECDATA(state,data){
      state.goodRecData = data;
    },
    SETITEMCFDATA(state,data){
      state.itemcfData = data;
    },
    SETCONTENTDATA(state,data){
      state.tfidfData = data;
    },
    SETONLINEDATA(state,data){
      state.onlineData = data;
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
    console.log(result)
    if (result.statusCode == 200) {
      commit("SETCOMMENT", result.data);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async addComment({commit}, data){
    let result = await postaddCommentData(data);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getRecData({commit}){
    let hotResult = await getHotProducts();
    let mostResult = await getMostRatedProducts();
    if (true) {
      commit('SETRECDATA',{hotResult,mostResult})
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getAlsData({commit},data){
    let result = await getALSRecProducts(data);
    if (result.statusCode == 200) {
      commit("SETALSDATA",result.data);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getItemcfData({commit},data){
    let result = await getItemCFProducts(data);
    console.log(result);
    if (result.statusCode == 200) {
      commit("SETITEMCFDATA",result);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async addRateD({commit},data){
    let result = await addRate(data);
    console.log(result);
    if (result.statusCode == 200) {
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getTFIDFData({commit},data){
    let result = await getSimProductsByContent(data);
    console.log(result);
    if (result.statusCode == 200) {
      commit("SETCONTENTDATA",result);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getOnlineData({commit},data){
    let result = await getOnlineRecProducts(data);
    console.log(result);
    if (result.statusCode == 200) {
      commit("SETONLINEDATA",result);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
  async getRecGoodData({commit},data){
    let result = await getProductInfo(data);
    console.log(result);
    let good = {};
    good.productCategoryInfo ={
      firstparentcname:result.data.categories.split('|')[0],
      secondparentcname:result.data.categories.split('|')[1],
      categoryname:result.data.categories.split('|')[2],
      pid:result.data.productId,
      cid:1,
    };
    good.productImageInfo = {
      pid:result.data.productId,
      id:"0",
      type:result.data.imageUrl
    };
    good.productInfo = {
      promoteprice:result.data.productId,
      createdate:"2022-05-26T08:53:38.000+00:00",
      pid:result.data.productId,
      bid:0,
      stock:999,
      orignalprice:result.data.productId,
      pname:result.data.name,
      subtitle:result.data.tags
    };
    good.merchantName= "推荐系统测试商"
    if (result.statusCode == 200) {
      commit("GETGOODDATA",good);
      return "ok";
    } else {
      return Promise.reject(new Error("faile"));
    }
  },
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
  categorysx(state){
    return state.goodData.productCategoryInfo || {}
  },
  comments(state){
    return state.comments || []
  },
  highestRateData(state){
    return state.highestRateData || {}
  },
  recentlyRateData(state){
    return state.recentlyRateData || {}
  },
  alsData(state){
    return state.alsData || {}
  },
  goodRecData(state){
    return state.goodRecData || {}
  },
  itemcfData(state){
    return state.itemcfData || {}
  },
  tfidfData(state){
    return state.tfidfData || {}
  },
  onlineData(state){
    return state.onlineData || {}
  }
};



export default {
  state,
  mutations,
  actions,
  getters,
};