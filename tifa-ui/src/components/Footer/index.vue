<template>
    <el-container class="backgroudSpilt">
        <el-row :gutter="20">
            <el-col :span="6" :push="2" v-for="(colItem,index) in footerTIFALinkList" :key="index">
                <div class="TIFALinkContainer">
                    <span class="TIFALinkTitle">{{colItem.title}}</span>
                    <div>
                        <el-space wrap spacer="|">
                            <el-link v-for="(linkItem,i) in colItem.link" :key="i">{{linkItem}}</el-link>
                        </el-space>
                    </div>
                    <el-divider v-if="index==0"/>
                </div>

            </el-col>
            <el-col :span="6" :push="2">
                <div style="display: inline-block">
                    <el-tooltip content="project github" placement="top">
                        <a href="https://github.com/Haruluya/tifa">
                            <img src="../../assets/logos/github.png">
                        </a>
                    </el-tooltip>
                </div>
                <div style="display: inline-block">
                    <el-tooltip content="project wechat" placement="top">
                        <a href="https://github.com/Haruluya/tifa">
                            <img src="../../assets/logos/wechat.png">
                        </a>
                    </el-tooltip>
                </div>
            </el-col>
        </el-row>

    </el-container>

</template>



<script>
export default {
    name: "Footer",
    data(){
        return {
            footerTIFALinkList:[
                {
                    'title':'TIFA',
                    'link':['关于我们','关于TIFA','隐私协议','用户协议','加入我们','关于ff7','友情链接']
                },
                {
                    'title':'售后服务',
                    'link':['售后政策','退款说明','返修/退换说明','其他说明']
                }
            ]
        }
    },

    
}
</script>

<style lang="less" scoped>
.el-container{
    background-color: rgba(204, 198, 198, 0.352);
    height: 200px;
}

img{
    margin-right:50px;
}

.el-row{
    width: 100%;
    margin-top: 10px;

}




.TIFALinkContainer{
    text-align: left;
    .TIFALinkTitle{
        font-family: Roboto-sans-serif;
        font-size: 1.5em;
    };

}
</style>