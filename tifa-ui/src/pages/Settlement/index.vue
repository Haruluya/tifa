<template>
    <div class="mainContainer"> 
        <div class="header">
            <div class="logo">
                <el-link :underline="false" class="title" href="shophome">
                  TIFA
              </el-link>
              <el-link :underline="false">
                <el-image :src="logo">
                </el-image>
              </el-link>
            </div>
            <div class="steps">
                <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="查看购物车" />
                    <el-step title="拍下商品" />
                    <el-step title="付款" />
                    <el-step title="确认收货" />
                    <el-step title="评价" /> 
                </el-steps>
            </div>
        </div>
        <div class="location">

        </div>
        <div class="goodsCar">

        </div>
    </div>
</template>
<script>
import logo from '../../assets/logo.png' 
export default {
    name:"settlement",
    data() {
        return {
            logo,
        }
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        background-color: white;
        .header{
            width: 1400px;
            display: flex;
            margin: 0 auto;
            .steps{
                width: 800px;
            }
        }
    }
    .header{
        .logo{
            .title{
                font-size: 45px;
                font-weight: bold;
                &:hover{
                    color: #e1251b;
                }
            }
            .el-image{
                width: 150px;
            }
        }
    }
</style>