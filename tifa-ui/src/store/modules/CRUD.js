

// 导入请求方法。
import {
    getTableDataByName,
    getTableDataByNameAndPage,
    getAllTableNames
} from "@/api";

const state = {
    tableData: {},
    tableNames: [],
};

const mutations = {
    GETTABLEDATA(state,tableData){
        state.tableData = tableData;
    },
    GETTABLENAMES(state,tableNames){
        state.tableNames = tableNames;
    }
}

const actions = {
    async getTableData({ commit }, tableName) {
        let result = await getTableDataByName(tableName);
        if (result) {
            commit("GETTABLEDATA", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async changePage({ commit }, pageData) {
        let result = await getTableDataByNameAndPage(pageData.tableName, pageData.pageIndex);
        if (result) {
            commit("GETTABLEDATA", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
    async getTableNames({ commit }){
        let result = await getAllTableNames();
        if (result) {
            commit("GETTABLENAMES", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
    }
}


const getters = {
    // 返回所有表项。
    tableItems(state){
        return state.tableData.records;
    },

    // 返回当前表的页数。
    tablePageNums(state){
        let pageNums = parseInt(state.tableData.total / state.tableData.size) + 1;
        if (pageNums >= 6){
            pageNums = 5;
        }
        return pageNums || 1
    },

    // 返回当前表的列名。
    // tableCowNames(state){

    // }
};
export default {
  state,
  mutations,
  actions,
  getters,
};