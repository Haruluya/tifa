import axios from "axios";
import requests from "./axios";




export const getTableDataByName = (tableName)=>
    requests({
        method:'GET',
        url:`/${tableName.toLowerCase()}Data`,
    })
