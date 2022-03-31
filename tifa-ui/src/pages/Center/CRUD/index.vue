<template>
    <div>
        <a href="">添加</a>
        <table class="table">
            <thead>
            <tr>
                <th>用户id</th>
                <th>用户name</th>
                <th>用户password</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
                <tr v-for="el in userData.list" :key="el.id">
                    <td>{{el.id}}</td>
                    <td>{{el.name}}</td>
                    <td>{{el.password}}</td>
                    <td>
                        <a href="">更改</a> |
                        <a href="">删除</a>
                    </td>
                    <td>{{userData.PageSize}}</td>
                </tr>
            </tbody>
        </table>
        <a href="">上一页</a>
        <a href="">下一页</a>
    </div>
</template>
<script>

import {getUserPageData} from '_api/index.js'

export default {
    name: 'CRUD',
    data(){
       return {
           userData : [],
       }  
    },
    created(){
        getUserPageData().then((result) => {
            this.userData = result;
        }).catch((err) => {
            console.log(err);
        });;
    }
}
</script>
<style lang="">
    
</style>