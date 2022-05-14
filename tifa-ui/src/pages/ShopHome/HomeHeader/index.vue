<template>
    <div class="mainContainer">
        <el-row align="middle">
          <el-col :span="6" class="logo" :push="1">
              <el-link :underline="false" class="title" href="shophome">
                  TIFA
              </el-link>
              <el-link :underline="false">
                <el-image :src="logo">
                </el-image>
              </el-link>
          </el-col>
          <el-col :span="10" class="search">
            <el-input
            v-model="searchContent"
            placeholder="Please input"
            class="input-with-select,searchInput"
            size="large"

            >
            <template #append>
                <el-button type="primary"><el-icon><search /></el-icon></el-button>
            </template>
            </el-input>
            <div class="tags">
                <el-link v-for="(item,index) in tags" :key="index" class="tag" :underline="false">
                    {{item}}
                </el-link>
            </div>
          </el-col>
          <el-col :span="8" class="user" :push="1">
                <el-link :underline="false" class="shopCart" href="tifashopcart">
                   <el-badge :value="0" :max="99" class="item"> <el-icon><shopping-cart-full /></el-icon>我的购物车</el-badge>
                </el-link> 
              <div class="adImg">
                  <el-link :underline="false">
                    <el-image :src="erweima">
                    </el-image>
                  </el-link>
              </div>
          </el-col>
        </el-row>
    </div>
</template>
<script>
import logo from '../../../assets/logo.png' 
import erweima from '../../../assets/erweima.png'
export default {
    name: 'homeHeader',
    data() {
        return {
            searchContent:'',
            tags:['五五乐享周','五一爆品','手机好店','买一赠一','全场八折','tifa手办','ff7收藏'],
            logo,
            erweima,
        }
    },
}
</script>
<style lang="less" scoped>
.input-with-select .el-input-group__prepend {
  background-color: var(--el-fill-color-blank);
}
.mainContainer{
    height: 100%;
    background-color: white;
    box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
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
    .search{
        .tags{
            margin-top: 8px;
            .tag{
                margin-left: 12px;
                color: #9d9d9d;
                &:hover{
                    color: #e1251b;
                }
            }
        }
    }
    .user{
        display: flex;
        align-content: center;
        .shopCart{
            font-size: 16px;
            height: 30px;
            padding: 5px 20px;
            border: 1px solid rgb(238, 238, 238);
            transform: translateX(-45px) translateY(20px);
            .el-icon{
                margin-right: 5px;
                font-size: 25px;
            }
            &:hover{
                color: #e1251b;
                border: 1px solid #e1251b;
            }
        }
        .adImg{
            margin-left: 40px;
            width: 100px;
        }
    }
}
// .el-button{
//     height: 40px;
//     background-color: #409eff !important;
// }


</style>