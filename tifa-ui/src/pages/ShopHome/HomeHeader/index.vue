<template>
    <div class="mainContainer">
        <el-row align="middle">
          <el-col :span="5" class="logo">
              <el-link :underline="false">
                <el-image src="https://img1.360buyimg.com/da/jfs/t1/14716/32/11447/94000/5c90a83bEaa611013/18490bf08654ba09.gif?v=0.6260315480407526">
                </el-image>
              </el-link>
          </el-col>
          <el-col :span="11" class="search">
            <el-input
            v-model="searchContent"
            placeholder="Please input"
            class="input-with-select,searchInput"
            size="large"

            >
            <template #prepend>
                <el-select v-model="select" placeholder="Select" style="width: 115px">
                <el-option label="Restaurant" value="1" />
                <el-option label="Order No." value="2" />
                <el-option label="Tel" value="3" />
                </el-select>
            </template>
            <template #append>
                <el-button type="danger">Danger</el-button>
            </template>
            </el-input>
            <div class="tags">
                <el-link v-for="index in 6" :key="index" class="tag">
                    品质好品
                </el-link>
            </div>
          </el-col>
          <el-col :span="8" class="user">
                <el-link :underline="false" class="shopCart">
                    我的购物车
                </el-link> 
              <div class="adImg">
                  <el-link :underline="false">
                    <el-image :src="`https://img12.360buyimg.com/img/jfs/t1/67481/15/565/28110/5cec9234E71c47244/dc4cf353fd96922e.png.webp`">
                    </el-image>
                  </el-link>
              </div>
          </el-col>
        </el-row>
    </div>
</template>
<script>


export default {
    name: 'homeHeader',
    data() {
        return {
            searchContent:'',

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

    }
    .search{
        transform: translateY(-10px);
        .tag{
            margin-left: 8px;
        }
    }
    .user{
        display: flex;
        justify-content: center;
        align-content: center;

        .shopCart{
            text-align: center;
            margin-left: 20px;
        }
        .adImg{
            margin-left: 20px;
            width: 150px;
            height: 90%;
        }
    }
}


</style>