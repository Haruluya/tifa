// register模块不需要保存数据。
// 逻辑如下：
// 请求后端发送验证码，
// 获取表单数据，
// 向后端发送表单数据。

// 导入请求方法。
import {
    getTableDataByName,
    getTableDataByNameAndPage
} from "@/api";

const state = {
    tableDate: {},
};

const mutations = {
    GETTABLEDATA(state,tableDate){
        this.tableDate = tableDate;
    }
}

const actions = {
    async getTableData({ commit }, tableName) {
        let result = await getTableDataByName(tableName);
        if (result) {
            console.log(result.records);
            commit("GETTABLEDATA", result)
        } else {
            return Promise.reject(new Error("faile"));
        }
    },
}


const getters = {
    // 返回所有表项。
    tableItems(state){
        return state.tableDate.records;
    },
    // 返回当前表的页数。
    tablePageNums(state){
        let pageNums = parseInt(state.tableDate.total / state.tableDate.size) + 1;
        if (pageNums >= 6){
            pageNums = 5;
        }
        return pageNums;
    }
};
export default {
  state,
  mutations,
  actions,
  getters,
};