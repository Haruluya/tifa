<template>
    <div class="mainContainer" @click="toGoodDetail()">
        <div class="content">
            <dvi class="image">
                <img :src="pdata.imageUrl" alt="" srcset="">
            </dvi>
            <div class="title">
                <span class="des">
                    {{pdata.name}}
                </span>
            </div>
            <div class="price">
                <a>
                    <span>Score:{{pdata.score.toString().substring(0,4)}}</span>
                </a>
            </div>
        </div>
    </div>
</template>

<script>
export default{
    name:"reccard",
    data(){

    },
    props:{
        pdata:{
            default:{}
        }
    },
    methods: {
        toGoodDetail(){
            this.$router.push('/gooddetail');
        }
    },
    mounted() {
    },
}

</script>

<style scoped lang="less">
.mainContainer{
    width: 200px;
    margin: 0 auto;
    box-shadow: rgba(18, 18, 18, 0.09) 0px 1px 3px 0px;
    &:hover{
        opacity: 0.8;
        transform: scale(1.02);
    }
    .content{
        cursor: pointer;
        padding: 5px;
        .image{
            img{
                width: 80%;
            }
        }

        .title{
            display: flex;
            font-size: 13px;
            color: #4c4c4c;
            &:hover{
                color: #e1251b;
            }
            .des{
                margin-left: 5px;
            }

        }
        .price{
            text-align: center;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 18px;
            color:#e1251b;
            margin-left: 20px;
            margin-top: 8px;
        }
        
    }
}


</style>
