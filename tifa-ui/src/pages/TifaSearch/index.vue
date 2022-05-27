<template>
    <div class="mainContainer">
        <div class="homeHeader"><HomeHeader/></div> 
        <div class="searchContent">
            <el-container>
                <el-main>
                    <div class="searchTabs">
                        <div class="orders">
                            <el-icon><DCaret /></el-icon>
                            <el-radio-group v-model="radio1" size="large">
                                <el-radio-button label="综合" />
                                <el-radio-button label="销量" />
                                <el-radio-button label="信用" />
                            </el-radio-group>
                            <div class="priceSelect">
                                <el-select v-model="value" placeholder="价格区间">
                                    <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>   
                            </div>
                        </div>
                        <div class="locations">
                            <el-select v-model="value" class="locationSelect" placeholder="发货地">
                                <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value"
                                />
                            </el-select>
                        </div>
                        <div class="tifa">
                            TIFA
                        </div>

                    </div>
                    <div class="goodCards" >
                        <el-row v-for="indexRow in searchGoodsList.length / 4" :key="indexRow">
                        <template v-for="indexCol in 4" :key="indexCol">
                          <el-col :span="6" >
                              <SearchGoodCard 
                              :goodImg='searchGoodsImg[(indexRow-1) * 4 + indexCol - 1]' 
                              :goodInfo= 'searchGoodsList[(indexRow-1) * 4 + indexCol - 1]'/>
                          </el-col>
                        </template>

                        </el-row>
                    </div>
                </el-main>
                <el-aside width="300px" class="aside">
                    <div class="title">
                        <el-icon><Discount /></el-icon>
                        广告推送
                    </div>
                    <div class="adImgs">
                        <el-image v-for="index in 8" src="https://img.alicdn.com/imgextra/i4/28808769/O1CN01VgPzqb2EeFqv56n5u_!!0-saturn_solar.jpg_270x270.jpg">

                        </el-image>
                    </div>
                </el-aside>
            </el-container>
        </div>
        <div class="pageHelper">
           <el-pagination
            background
            v-model:currentPage="currentPage"
            page-size="20"
            layout="prev, pager, next, jumper"
            :total="searchTotalItem"
            @current-change="handleCurrentChange"
            />
        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
import SearchGoodCard from '_components/SearchGoodCard'
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import { ElNotification} from 'element-plus'

export default {
    name:"tifasearch",
    components:{
        HomeHeader,
        SearchGoodCard,

    },
    data() {
        return {
          currentPage:1,
        }
    },
    computed:{
      ...mapState([]),
      ...mapGetters(['pageIndex','searchGoodsList','searchGoodsImg','searchTotalItem']),
    },
    methods: {
        async getSearchData(){
            try {
                await this.$store.dispatch("getSearchData", {
                    'searchKey':this.$route.params.searchKey,
                    'pageIndex':this.pageIndex
                });
            } catch (error) {
                ElNotification({
                    title: '获取搜索数据失败',
                    message: error,
                    type: 'error',
                })
            }
        },
        handleCurrentChange(){
            this.$store.dispatch("changeCurrentPage", this.currentPage);
            this.getSearchData();
        }
    },
    mounted() {
        this.getSearchData();
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        .searchContent{
            width: 1500px;
            margin: 0 auto;
        }
    }
    .searchTabs{
        padding: 10px;
        display: flex;
        background-color: white;
        margin-bottom: 20px;    
        border-bottom: 20px solid #e3e4e5;
        border-radius: 10px;
        .orders{
            .el-icon{
                font-size: 25px;
                margin-top: 10px;
            }
            display: flex;
        }
        .priceSelect{
            margin-left: 30px;
            margin-top: 5px;
            width: 120px;
        }
        .locations{
            margin-left: 500px;
            margin-top: 5px;
            width: 100px;
        }
        .tifa{
            font-size: 30px;
            font-weight: bold;
            color: #ff4400;
            margin-top: 5px;
            margin-left: 60px;
            &:hover{
                color: #e6251b;
            }
        }
    }
    .goodCards{
        background-color: white;
    }
    .aside{
        
        .title{
            font-size: 20px;
            margin-top: 20px;
            padding: 10px;
            background-color: white;
            border-bottom: 15px solid #e3e4e5;
            border-radius: 5px;
            color: #555555;
            font-family: tahoma, arial, 宋体;
            font-weight: bold;
            .el-icon{
                font-size: 25px;
                transform: translateY(5px);
            }
        }
        .adImgs{
            background-color: white;
            padding: 10px;
            border-radius: 10px;
            margin-top: 40px;
        }
    }
    .pageHelper{
        width: 600px;
        margin: 0 auto;
        margin-top: 100px;
    }
    
</style>