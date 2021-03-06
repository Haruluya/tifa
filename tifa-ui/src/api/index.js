import axios from "axios";
import requests from "./axios";



//@date 2022/3/30 
// INFO: ajax请求定义。
// 根据表名获取数据库表所有数据。
export const getTableDataByName = (tableName)=>
    requests({
        method:'GET',
        url:`/${tableName}/pageData`,
    })

// 根据用户信息确认是否可注册。
export const postRegisterConfim = (data)=>
    requests({
        method:'POST',
        url:`/user/registerConfirm`,
        data
    })

// 根据表名和页数查询当页数据。
export const getTableDataByNameAndPage = (tableName,pageIndex)=>
    requests({
        method:'GET',
        url:`/${tableName}/pageData`,
        params:{'pageIndex':pageIndex}
    })


//  查询数据库中所有表名。
export const getAllTableNames = ()=>
    requests({
        method:'GET',
        url:`/user/tableNames`,
    })


// 查询三级分类表数据。
export const getClassNavData = ()=>
    requests({
        method:'GET',
        url:`/classNav/classData`,
    })

// 获取登录信息。
export const postLoginConfirm = (data)=>
    requests({
        method:'POST',
        url:`/user/loginConfirm`,
        data
    })

// 退出登录请求。
export const postLogout = ()=>
    requests({
        method:'POST',
        url:`/user/logout`,
    })

// 获取用户信息。
export const getUserData = (token)=>
    requests({
        method:'POST',
        url:`/user/userData`,
        data:token
    })

// 获取搜索信息。
export const postSearchDataRequest= (data)=>
    requests({
        method:'POST',
        url:`/product/searchGoods`,
        data
    })

// 通过商品id获取商品详细信息。
export const postGoodDetailById= (data)=>
    requests({
        method:'post',
        url:`/product/detailData`,
        data
    })

// 添加、更新购物车。
export const postUpdateShopCart= (data)=>
    requests({
        method:'post',
        url:`/product/updateShopCart`,
        data
    })

//  获取购物车数据。
export const getShopCartData= (data)=>
    requests({
        method:'post',
        url:`/product/getShopCartData`,
        data
    })
    
//  删除购物车某商品。
export const postDeleteCartByGoodId= (data)=>
    requests({
        method:'post',
        url:`/product/deleteCart`,
        data
    })



//添加收货地址。
export const postAddAdressRequest= (data)=>
    requests({
        method:'post',
        url:`/user/addAdress`,
        data
    })


export const postLocationDataRequest = (data)=>
    requests({
        method:'post',
        url:`/user/locationData`,
        data
    })

export const postDeleteAdrDataRequest = (data)=>
    requests({
        method:'post',
        url:`/user/deleteAdress`,
        data
    })

export const postUpdateUserInfoRequest = (data)=>
    requests({
        method:'post',
        url:`/user/updateUserInfo`,
        data
    })

export const postPurchaseRequest = (data)=>
    requests({
        method:'post',
        url:`/pay/confirm`,
        data
    })

export const postClearCartRequest = (data)=>
    requests({
        method:'post',
        url:`/product/clearCart`,
        data
    })



export const postGetOrderDataRequest = (data)=>
    requests({
        method:'post',
        url:`/order_/orderData`,
        data
    })

export const postConfirmDeRequest = (data)=>
    requests({
        method:'post',
        url:`/order_/confimDe`,
        data
    })
export const postSetPaidRequest = (data)=>
    requests({
        method:'post',
        url:`/pay/fallback`,
        data
    })
export const postMerchantProductDataRequest = (data)=>
    requests({
        method:'post',
        url:`/product/getMerchantProductData`,
        data
    })


export const postAddProductRequest = (data)=>
    requests({
        method:'post',
        url:`/product/addProduct`,
        data
    })

export const postMerchantOrderRequest = (data)=>
    requests({
        method:'post',
        url:`/order_/merchantOrders`,
        data
    })

export const postconfirmDetoRequest = (data)=>
    requests({
        method:'post',
        url:`/order_/confirmDeto`,
        data
    })
export const postdeleteProductRequest = (data)=>
    requests({
        method:'post',
        url:`/product/deleteMeProduct`,
        data
    })
    
export const postregisterMerchantConfim= (data)=>
    requests({
        method:'post',
        url:`/user/registerMerchantConfim`,
        data
    })
export const getCode= (data)=>
    requests({
        method:'post',
        url:`/wx/login`,
        data
    })
export const isLogin= (data)=>
    requests({
        method:'post',
        url:`/wx/islogin`,
        data
    })
export const postSendCodeConfim= (data)=>
    requests({
        method:'get',
        url:`/code/fitness`,
        params:data
    })
export const rePassword= (data)=>
    requests({
        method:'post',
        url:`/user/rePassword`,
        data
    })

export const postgetCommentData= (data)=>
    requests({
        method:'post',
        url:`/review/getReviewData`,
        data
    })

export const postreturnProductRequest= (data)=>
    requests({
        method:'post',
        url:`/order_/backProduct`,
        data
    })

export const postaddCommentData= (data)=>
    requests({
        method:'post',
        url:`/review/addReview`,
        data
    })

export const getHotProducts= ()=>
    requests({
        method:'get',
        url:`/rec/hotrec`,
    })
export const getMostRatedProducts= ()=>
    requests({
        method:'get',
        url:`/rec/mostrate`,
    })

export const getSimProductsByContent= (data)=>
    requests({
        method:'get',
        url:`/rec/contentrec/${data.id}`,
    })

export const getALSRecProducts= (data)=>
    requests({
        method:'get',
        url:`/rec/alsrec`,
        params:data
    })

export const getOnlineRecProducts= (data)=>
    requests({
        method:'get',
        url:`/rec/onlinerec`,
        params:data
    })

export const getItemCFProducts= (data)=>
    requests({
        method:'get',
        url:`/rec/itemcf/${data.id}`,
    })

export const getProductInfo= (data)=>
    requests({
        method:'get',
        url:`/rec/info/${data.productid}`,
    })

export const addRate= (data)=>
    requests({
        method:'get',
        url:`/rec/rate/${data.productid}`,
        params:{score:data.score,userid:data.userid}
    })