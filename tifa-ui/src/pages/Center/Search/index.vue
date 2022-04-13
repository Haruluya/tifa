<template lang="">
  <div>
    <SearchClassHeader @hotTitleEventHandler="hotTitleEventHandler" @attrBreadAdd="attrBreadAdd" />
    <div class="main">
      <div class="py-container">
        <!--bread:面包屑，带有x的结构的-->
        <div class="bread">
          <ul class="fl sui-breadcrumb">
            <li>
              <a href="#">全部结果</a>
            </li>
          </ul>
          <ul class="fl sui-tag">
            <!-- 分类的面包屑 -->
            <li class="with-x" v-if="searchParams.categoryName">
              {{ searchParams.categoryName
              }}<i @click="removeCategoryBread">×</i>
            </li>
            <!-- 关键字的面包屑 -->
            <li class="with-x" v-if="searchParams.keyword">
              {{ searchParams.keyword }}<i @click="removeKeyWordBread">×</i>
            </li>
            <!-- 品牌的面包屑 -->
            <li class="with-x" v-if="searchParams.trademark">
              {{ searchParams.trademark.split(":")[1]
              }}<i @click="removeHotTitleBread">×</i>
            </li>
            <!--平台的售卖的属性值展示 -->
            <li
              class="with-x"
              v-for="(attrValue, index) in searchParams.props"
              :key="index"
            >
              {{ attrValue.split(":")[1] }}<i @click="removeAttrBread(index)">×</i>
            </li>
          </ul>
        </div>
        <!--selector-->
        <!-- <SearchSelector @trademarkInfo="trademarkInfo" @attrInfo="attrInfo" /> -->
        <!--details-->
        <div class="details clearfix">
          <div class="sui-navbar">
            <div class="navbar-inner filter">
              <!-- 排序的解构 -->
              <ul class="sui-nav">
                <li :class="{ active: isOne }" @click="orderGoods('1')">
                  <a
                    >综合<span
                      v-show="isOne"
                      class="iconfont"
                      :class="{ 'icon-UP': isAsc, 'icon-DOWN': isDesc }"
                    ></span
                  ></a>
                </li>
                <li :class="{ active: isTwo }" @click="orderGoods('2')">
                  <a
                    >价格<span
                      v-show="isTwo"
                      class="iconfont"
                      :class="{ 'icon-UP': isAsc, 'icon-DOWN': isDesc }"
                    ></span
                  ></a>
                </li>
              </ul>
            </div>
          </div>
          <!-- 销售产品列表 -->
          <div class="goods-list">
            <ul class="yui3-g">
              <li
                class="yui3-u-1-5"
                v-for="(good, index) in goodsList"
                :key="good.id"
              >
                <div class="list-wrap">
                  <div class="p-img">
                    <!-- 在路由跳转的时候切记别忘记带id（params）参数 -->
                    <!-- <router-link :to="`/detail/${good.id}`">
                      <img src="good.defaultImg" />
                    </router-link> -->
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>{{ good.price }}.00</i>
                    </strong>
                  </div>
                  <div class="attr">
                    <a
                      target="_blank"
                      href="item.html"
                      title="促销信息，下单即赠送三个月CIBN视频会员卡！【小米电视新品4A 58 火爆预约中】"
                      >{{ good.title }}</a
                    >
                  </div>
                  <div class="commit">
                    <i class="command">已有<span>2000</span>人评价</i>
                  </div>
                  <div class="operate">
                    <a
                      href="success-cart.html"
                      target="_blank"
                      class="sui-btn btn-bordered btn-danger"
                      >加入购物车</a
                    >
                    <a href="javascript:void(0);" class="sui-btn btn-bordered"
                      >收藏</a
                    >
                  </div>
                </div>
              </li>
            </ul>
          </div>
          <PageHelper  :currentPageIndex="31"  :onePageItemAmount="3" :totalItemAmount="99" :pageSize="5" @skipToClickPage="skipToClickPage"/> 
          <!-- 分页器:测试分页器阶段，这里数据将来需要替换的-->
          <!-- <Pagination
            :pageNo="searchParams.pageNo"
            :pageSize="searchParams.pageSize"
            :total="total"
            :continues="5"
            @getPageNo="getPageNo"-->
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {mapState,mapGetters} from 'vuex';
import SearchClassHeader from '_pages/Center/Search/SearchClassHeader'

export default {
  name: "Search",
  components:{
    SearchClassHeader,
  },
  data() {
    return {

      // 搜索请求参数
      searchParams: {
        //产品相应的id
        category1Id: "",
        category2Id: "",
        category3Id: "",
        //产品的名字
        categoryName: "",
        //搜索的关键字
        keyword: "",
        //排序:初始状态应该是综合且降序
        order: "1:desc",
        //第几页
        pageNo: 1,
        //每一页展示条数
        pageSize: 3,
        //平台属性的操作
        props: [],
        //品牌
        trademark: "",
      },
    };
  },


  //首次跳转时需要分析route路径的参数，
  beforeMount() {
    Object.assign(this.searchParams, this.$route.query, this.$route.params);
  },


  //组件挂载时获取数据。
    mounted() {
    //在发请求之前咱们需要将searchParams里面参数进行修改带给服务器
    this.getShowData();
  },


  watch: {
      // 统一监听路由的参数变化，是为了应对组件刷新不重新挂载的模式。
      $route(newValue, oldValue) {
        // 重新发请求。
        Object.assign(this.searchParams, this.$route.query, this.$route.params);
        this.getShowData();
        // 分类名并非一定会改变，需要每次请求后清空。
        this.searchParams.category1Id = undefined;
        this.searchParams.category2Id = undefined;
        this.searchParams.category3Id = undefined;
      },
  },

  methods: {
    // 根据参数请求数据展示。
    getShowData() {
      this.$store.dispatch("getSearchData", this.searchParams);
    },

    // 分类面包屑删除处理。
    removeCategoryBread(){
      // 更新请求参数。
      this.searchParams.categoryName = undefined;
      this.searchParams.category1Id = undefined;
      this.searchParams.category2Id = undefined;
      this.searchParams.category3Id = undefined;
      // 重新请求。
      this.getShowData();
      // 路由url中应该保留搜索栏的关键词。
      if (this.$route.params) {
        this.$router.push({ name: "search", params: this.$route.params });
      }
    },

    //搜索关键字面包屑处理。
    removeKeyWordBread(){
      this.searchParams.keyword = undefined;
      this.getShowData();
      // //通知组件Header清除关键字
      // this.$bus.$emit("clear");
      //进行路由的跳转,保留query。
      if (this.$route.query) {
        this.$router.push({ name: "search", query: this.$route.query });
      }
    },

    //热点模块点击跳转响应。
    hotTitleEventHandler(trademark){
      this.searchParams.trademark = `${trademark.tmId}:${trademark.tmName}`;
      this.getShowData();
    },

    //模块属性面包屑添加响应。
    attrBreadAdd(attr,attrValue){
      let props = `${attr.attrId}:${attrValue}:${attr.attrName}`;
      //面包屑不重复。
      if (this.searchParams.props.indexOf(props) == -1)
        this.searchParams.props.push(props);
      this.getShowData();
    },

    //模块属性面包屑删除。
    removeAttrBread(index){
      this.searchParams.props.splice(index, 1);
      this.getShowData();
    },

    //热点关键词面包屑删除。
    removeHotTitleBread() {
      this.searchParams.trademark = undefined;
      this.getShowData();
    },

    //排序方式控制。
    orderGoods(param){
      let originOrder = this.searchParams.order;
      let orginsFlag = originOrder.split(":")[0];
      let originSort = originOrder.split(":")[1];
      let newOrder = "";
      if (param== orginsFlag) {
        newOrder = `${orginsFlag}:${originSort == "desc" ? "asc" : "desc"}`;
      } else {
        newOrder = `${param}:${"desc"}`;
      }
      this.searchParams.order = newOrder;
      this.getShowData();
    },

    //请求跳转到指定页数。
    skipToClickPage(page){
      this.searchParams.pageNo = page;
      this.getShowData();
    }
  },
  computed: {
    ...mapGetters(["goodsList"]),

    //状态值的储存。
    isOne() {
      return this.searchParams.order.indexOf("1") != -1;
    },
    isTwo() {
      return this.searchParams.order.indexOf("2") != -1;
    },
    isAsc() {
      return this.searchParams.order.indexOf("asc") != -1;
    },
    isDesc() {
      return this.searchParams.order.indexOf("desc") != -1;
    },

    //获取search模块展示产品一共多少数据
    ...mapState({
      total: (state) => state.search.searchList.total,
    }),
  },


  


}
</script>
<style lang="less" scoped>
.main {
  margin: 10px 0;

  .py-container {
    width: 1200px;
    margin: 0 auto;

    .bread {
      margin-bottom: 5px;
      overflow: hidden;

      .sui-breadcrumb {
        padding: 3px 15px;
        margin: 0;
        font-weight: 400;
        border-radius: 3px;
        float: left;

        li {
          display: inline-block;
          line-height: 18px;

          a {
            color: #666;
            text-decoration: none;

            &:hover {
              color: #4cb9fc;
            }
          }
        }
      }

      .sui-tag {
        margin-top: -5px;
        list-style: none;
        font-size: 0;
        line-height: 0;
        padding: 5px 0 0;
        margin-bottom: 18px;
        float: left;

        .with-x {
          font-size: 12px;
          margin: 0 5px 5px 0;
          display: inline-block;
          overflow: hidden;
          color: #000;
          background: #f7f7f7;
          padding: 0 7px;
          height: 20px;
          line-height: 20px;
          border: 1px solid #dedede;
          white-space: nowrap;
          transition: color 400ms;
          cursor: pointer;

          i {
            margin-left: 10px;
            cursor: pointer;
            font: 400 14px tahoma;
            display: inline-block;
            height: 100%;
            vertical-align: middle;
          }

          &:hover {
            color: #28a3ef;
          }
        }
      }
    }

    .details {
      margin-bottom: 5px;

      .sui-navbar {
        overflow: visible;
        margin-bottom: 0;

        .filter {
          min-height: 40px;
          padding-right: 20px;
          background: #fbfbfb;
          border: 1px solid #e2e2e2;
          padding-left: 0;
          border-radius: 0;
          box-shadow: 0 1px 4px rgba(0, 0, 0, 0.065);

          .sui-nav {
            position: relative;
            left: 0;
            display: block;
            float: left;
            margin: 0 10px 0 0;

            li {
              float: left;
              line-height: 18px;

              a {
                display: block;
                cursor: pointer;
                padding: 11px 15px;
                color: #777;
                text-decoration: none;
              }

              &.active {
                a {
                  background: black;
                  color: #fff;
                }
              }
            }
          }
        }
      }

      .goods-list {
        margin: 20px 0;

        ul {
          display: flex;
          flex-wrap: wrap;

          li {
            height: 100%;
            width: 20%;
            margin-top: 10px;
            line-height: 28px;

            .list-wrap {
              .p-img {
                padding-left: 15px;
                width: 215px;
                height: 255px;

                a {
                  color: #666;

                  img {
                    max-width: 100%;
                    height: auto;
                    vertical-align: middle;
                  }
                }
              }

              .price {
                padding-left: 15px;
                font-size: 18px;
                color: #c81623;

                strong {
                  font-weight: 700;

                  i {
                    margin-left: -5px;
                  }
                }
              }

              .attr {
                padding-left: 15px;
                width: 85%;
                overflow: hidden;
                margin-bottom: 8px;
                min-height: 38px;
                cursor: pointer;
                line-height: 1.8;
                display: -webkit-box;
                -webkit-box-orient: vertical;
                -webkit-line-clamp: 2;

                a {
                  color: #333;
                  text-decoration: none;
                }
              }

              .commit {
                padding-left: 15px;
                height: 22px;
                font-size: 13px;
                color: #a7a7a7;

                span {
                  font-weight: 700;
                  color: #646fb0;
                }
              }

              .operate {
                padding: 12px 15px;

                .sui-btn {
                  display: inline-block;
                  padding: 2px 14px;
                  box-sizing: border-box;
                  margin-bottom: 0;
                  font-size: 12px;
                  line-height: 18px;
                  text-align: center;
                  vertical-align: middle;
                  cursor: pointer;
                  border-radius: 0;
                  background-color: transparent;
                  margin-right: 15px;
                }

                .btn-bordered {
                  min-width: 85px;
                  background-color: transparent;
                  border: 1px solid #8c8c8c;
                  color: #8c8c8c;

                  &:hover {
                    border: 1px solid #666;
                    color: #fff !important;
                    background-color: #666;
                    text-decoration: none;
                  }
                }

                .btn-danger {
                  border: 1px solid #e1251b;
                  color: #e1251b;

                  &:hover {
                    border: 1px solid #e1251b;
                    background-color: #e1251b;
                    color: white !important;
                    text-decoration: none;
                  }
                }
              }
            }
          }
        }
      }

      .page {
        width: 733px;
        height: 66px;
        overflow: hidden;
        float: right;

        .sui-pagination {
          margin: 18px 0;

          ul {
            margin-left: 0;
            margin-bottom: 0;
            vertical-align: middle;
            width: 490px;
            float: left;

            li {
              line-height: 18px;
              display: inline-block;

              a {
                position: relative;
                float: left;
                line-height: 18px;
                text-decoration: none;
                background-color: #fff;
                border: 1px solid #e0e9ee;
                margin-left: -1px;
                font-size: 14px;
                padding: 9px 18px;
                color: #333;
              }

              &.active {
                a {
                  background-color: #fff;
                  color: #e1251b;
                  border-color: #fff;
                  cursor: default;
                }
              }

              &.prev {
                a {
                  background-color: #fafafa;
                }
              }

              &.disabled {
                a {
                  color: #999;
                  cursor: default;
                }
              }

              &.dotted {
                span {
                  margin-left: -1px;
                  position: relative;
                  float: left;
                  line-height: 18px;
                  text-decoration: none;
                  background-color: #fff;
                  font-size: 14px;
                  border: 0;
                  padding: 9px 18px;
                  color: #333;
                }
              }

              &.next {
                a {
                  background-color: #fafafa;
                }
              }
            }
          }

          div {
            color: #333;
            font-size: 14px;
            float: right;
            width: 241px;
          }
        }
      }
    }
  }
}
</style>
