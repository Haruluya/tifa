<template>
    <el-container class="headerContainer">
        <el-row class="headerRow" :gutter="20">
            <el-col :span="8">
                <div  class="leftGroup">
                    <el-row :gutter="10" class="leftRow">
                    <el-col :span="6">
                        <el-image class="logo" src="https://img.zcool.cn/community/015db75b0542dda801209a85db25ba.png@1280w_1l_2o_100sh.png"> </el-image>
                    </el-col>
                    <el-col :span="18 / leftItemList.length" class="leftItem" v-for="(item,index) in leftItemList" :key="index">
                        <div><span>{{leftItemList[index]}}</span></div>
                    </el-col>
                    </el-row>
                </div>
            </el-col>
            <el-col :span="8" >
                <div class="centerGroup">
                    <el-input
                    v-model="input3"
                    placeholder="Please input"
                    class="input-with-select"
                    size="large"
                    :suffix-icon="search"
                    >
                    <template #append>
                        <el-button :icon="Search" />
                    </template>
                    </el-input>
                </div>
            </el-col>
            <el-col :span="8" >
                <div class="rightGroup"></div>
            </el-col>
        </el-row>
    </el-container>
</template>
<script>
export default {
    name: 'pageheader',
    data() {
        return {
            leftItemList:['a','b','c']
        }
    },
}
</script>
<style lang="less" scoped>
// .el-row{
//     width: 100%;
//     height: 100%;
// }
// .el-col{
//     height: 100%;
// }
.headerContainer{
    height: 100px;
    background-color: gray;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-content: center;
    .headerRow{
        .leftGroup{
            background-color: blue;
            .leftItem div{
                background-color: green;
                border: 2px solid;
            }
        }
        .centerGroup{
            background-color: red;
        }
        .rightGroup{
            background-color: beige;
        }
    }
    .centerGroup{
        .search{
            display: flex;
            justify-content: center;
            align-content: center;
        }
    }
}
</style>