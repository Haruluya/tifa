<template>
    <div class="mainContainer" @click="toGoodDetail()">
        <div class="goodImg">
            <el-image :src="goodImg.type">
            </el-image>
        </div>
        <div class="searchContent">
            <div class="price">
                ￥{{goodInfo.orignalprice}}
            </div>
            <div class="tags">
                <el-tag class="ml-2" type="danger" effect="plain">自营</el-tag>
                <el-tag class="ml-2" type="danger" effect="plain">官方</el-tag>
            </div>
            <div class="title">
               {{goodInfo.pname}}
            </div>
            <div class="commentCount">
                {{goodInfo.stock}}评论
            </div>
            <div class="merchant">
                {{category.categoryname}}<el-icon><Present /></el-icon>
            </div>

            <div class="operations">
                <el-button type="" plain>收藏<el-icon><Star /></el-icon></el-button>
                <el-button type="" plain>加入购物车<el-icon><ShoppingCartFull /></el-icon></el-button>
            </div>
        </div>
    </div>
</template>
<script>
import goodDefaultImg from '_assets/images/tifa_default_card_img.webp'

export default {
    name:"searchgoodcard",
    data() {
        return {
        }
    },
    methods: {
        toGoodDetail(){
            this.$router.push('/gooddetail/'+this.goodInfo.pid);
        }
    },
    props:{
        goodInfo:{
            type:Object,
            default:{}
        },
        goodImg:{
            type:Object,
            default:{}
        },
        category:{
            type:Object,
            default:{}
        }
    },
    mounted(){
        if (this.goodImg.type == "images/model/guan/url_none.png"){
            this.goodImg.type = goodDefaultImg
        }
    },

    updated() {
        if (this.goodImg.type == "images/model/guan/url_none.png"){
            this.goodImg.type = goodDefaultImg
        }
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        width: 250px;
        text-align: left;
        padding: 15px;
        background-color: white;
        margin-top: 10px;
        &:hover{
            transform: scale(1.005);
            border: 1px solid #e4393c;
            cursor: pointer;
        }
        .goodImg{

        }
        .searchContent{
            .price{
                margin-top: 5px;
                font-size: 22px;
                color: #e4393c;
                &:hover{
                    font-weight: bold;
                }
            }
            .title{
                margin-top: 10px;
                font-size: 13px;
                color: #666666;
                &:hover{
                    font-weight: bold;
                }
            }
            .commentCount{
                margin-top: 10px;
                color: #646fb0;
                font-weight: bold;
            }
            .merchant{
                margin-top: 5px;
                font-size: 14px;
                color: #999999;
            }
            .tags{
                margin-top: 5px;
                .el-tag{
                    margin-right: 10px;
                }
            }
            .operations{
                margin-top: 10px;

                .el-icon{
                    margin-left: 3px;
                    font-size: 20px !important;
                }
            }
        }
    }
</style>