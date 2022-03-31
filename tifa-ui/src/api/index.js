import axios from "axios";
import requests from "./axios";




export const getUserPageData = ()=>
    requests({
        method:'GET',
        url:'/userData'
    })
