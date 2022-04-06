import axios from "axios";
import requests from "./axios";



//@date 2022/3/30 
// INFO: ajax请求定义。
// 根据表名获取数据库表所有数据。
export const getTableDataByName = (tableName)=>
    requests({
        method:'GET',
        url:`/CRUD/${tableName.toLowerCase()}Data`,
    })

// 根据用户信息确认是否可注册。
export const postRegisterConfim = (data)=>
    requests({
        method:'POST',
        url:`/register/confirm`,
        data
    })

// 根据表名和页数查询当页数据。
export const getTableDataByNameAndPage = (pageNum,tableName)=>
    requests({
        method:'GET',
        url:`/CRUD/${tableName.toLowerCase()}Data`,
        params:{'pageNum':pageNum}
    })

