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
              <el-menu-item  v-for="name in tableNames" @click="getTableData(name)" >{{name}}</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 20px; margin: 10px 0">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 6px"
              ><setting/></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span >Modify table</span>
        </div>
      </el-header>

      <el-main>
        <el-scrollbar>
          <el-table :data="tableItems">
            <el-table-column prop="id" label="id" width="140" />
            <el-table-column prop="name" label="name" width="120" />
            <el-table-column prop="password" label="password" />
          </el-table>
          
        </el-scrollbar>
      </el-main>

      <el-footer>
          <div height = "100%" style="font-size: 10px; display: flex; justify-content: center; position:absolute" >
            <span>当前为第[{{currentPage}}]页，共[{{tablePageNums}}]页。</span>
          </div>
          <el-button-group size="small" >
            <el-button type="success" icon="ArrowLeft" >Previous</el-button>
                <el-button style="margin: 0px 4px;"  v-for="count in tablePageNums" @click="changePage(count,$event)">
                  {{count}}
                </el-button>
            <el-button type="success">Next
              <el-icon class="el-icon--right"><ArrowRight /></el-icon>
            </el-button>
          </el-button-group>
      </el-footer>


    </el-container>
  </el-container>
</template>
<script>
import { result } from 'lodash-es';
import {getTableDataByName} from '_api/index.js'
import { ref } from 'vue'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'


export default {
    name: 'CRUD',
    data(){
       return {
           currentPage: 1,
           tableName:'user',
       }  
    },
    computed:{
      ...mapState({
        tableNames: state=>state.CRUD.tableNames,
      }),
	    ...mapGetters(['tableItems','tablePageNums'])
    },
    methods: {
      async getTableNames(){
            try {
              await this.$store.dispatch('getTableNames');
            } catch (error) {
              alert("请求失败！");
            }
        },
      async getTableData(tableName){
            try {
              this.tableName = tableName;
              await this.$store.dispatch('getTableData',tableName)
            } catch (error) {
              alert("请求失败！");
            }
        },
      async changePage(count,event){
          // 发送请求。
          let pageData = {'pageIndex':count,'tableName':this.tableName};
          try {
            await this.$store.dispatch('changePage',pageData);
          } catch (error) {
            alert("请求失败！");
          }
        },

    },
    mounted(){
        this.getTableNames();
        this.getTableData('User');
        
    }
}
</script>
<style lang="css">


</style>