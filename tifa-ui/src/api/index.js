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
export const getGoodDetailById= (id)=>
    requests({
        method:'get',
        url:`/product/detailData`,
    })


// 添加、更新购物车。
export const postUpdateShopCart= (goodId,goodAmount)=>
    requests({
        method:'post',
        url:`/product/updateShopCart`,
    })

//  获取购物车数据。
export const getShopCartData= ()=>
    requests({
        method:'get',
        url:`/product/getShopCartData`,
    })
    
//  删除购物车某商品。
export const postDeleteCartByGoodId= (goodId)=>
    requests({
        method:'post',
        url:`/product/deleteCart`,
        data:{goodId}
    })


