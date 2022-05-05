<template>
    <div class="mainContainer">
        <div class="content">
            <dvi class="image">
                <img src="https://img14.360buyimg.com/ceco/s300x300_jfs/t1/147923/30/18586/454087/5fdc028eE9518ec6b/1e4e64b14043aa71.png.webp" alt="" srcset="">
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
                width: 93%;
            }
        }

        .title{
            display: flex;
            font-size: 13px;
            color: #4c4c4c;
            &:hover{
                        color: #e1251b;
            }
            .tag{

            }
        }
        .price{
            text-align: center;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 18px;
            color:#e1251b;
            margin-left: 20px;
        }
        
    }
}


</style>
