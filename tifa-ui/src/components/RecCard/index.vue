<template>
    <div class="mainContainer">
        <div class="content">
            <dvi class="image">
                <img src="https://img20.360buyimg.com/jdcms/s300x300_jfs/t1/132402/26/27105/290037/62690eabEb253d9d8/23f0daa07a98a190.jpg.webp" alt="" srcset="">
            </dvi>
            <div class="title">
                <div class="tag">
                    <el-tag type="danger"> 
                        自营
                    </el-tag>
                </div>
                <span>
                    雷士（NVC）智能轻触风暖浴霸 超宽风口 
                </span>
            </div>
            <div class="price">
                <a>
                    <span>$88</span>
                </a>
            </div>
        </div>
    </div>
</template>

<script setup>


</script>

<style scoped lang="less">
.mainContainer{
    width: 200px;
    margin: 0 auto;
    .content{

        .image{
            img{
                width: 90%;
            }
        }
        .title{
            display: flex;
            .tag{

            }
        }
        .price{
            text-align: left;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 18px;
            color:red;
            margin-left: 20px;
        }
        
    }
}


</style>
