<template>
  <el-container
    class="layout-container-demo"
    style="height: 500px; border: 1px solid #eee"
  >
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><setting /></el-icon>DataBase_tmall
            </template>
            <el-menu-item-group>
              <template #title>table</template>
              <el-menu-item index="1-1" @click="getTableData('User')">User</el-menu-item>
              <el-menu-item index="1-2" @click="getTableData('category')">category</el-menu-item>
              <el-menu-item index="1-3" @click="getTableData('property')">property</el-menu-item>
              <el-menu-item index="1-4" @click="getTableData('product')">product</el-menu-item>
              <el-menu-item index="1-5" @click="getTableData('propertyvalue')">propertyvalue</el-menu-item>
              <el-menu-item index="1-6" @click="getTableData('productimage')">productimage</el-menu-item> 
              <el-menu-item index="1-7" @click="getTableData('review')">review</el-menu-item>
              <el-menu-item index="1-8" @click="getTableData('order_')">order_</el-menu-item>
              <el-menu-item index="1-9" @click="getTableData('orderitem')">orderitem</el-menu-item> 
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px"
              ><setting/></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>Setting</span>
        </div>
      </el-header>

      <el-main>
        <el-scrollbar>
          <el-table :data="tableData">
            <el-table-column prop="id" label="id" width="140" />
            <el-table-column prop="name" label="name" width="120" />
            <el-table-column prop="password" label="password" />

          </el-table>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
import { result } from 'lodash-es';

import {getTableDataByName} from '_api/index.js'
import { ref } from 'vue'

const item = {
  date: '2016-05-02',
  name: 'Tom',
  address: 'No. 189, Grove St, Los Angeles',
}

// const tableData = ref(Array.from({ length: 20 }).fill(item))

export default {
    name: 'CRUD',
    data(){
       return {
           tableData : []
       }  
    },
    methods: {
        getTableData(tableName){
            getTableDataByName(tableName).then((result) => {
                this.tableData = result.list
                console.log(result);
            }).catch((err) => {
                console.log(err);
            });;
        }
    },
    mounted(){
        this.getTableData('User');
    }
}
</script>
<style lang="">
    
</style>