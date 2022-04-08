<template>
 <!-- 商品分类导航 -->
          <div class="type-nav">
            <div class="container">
                <h2 class="all">全部商品分类</h2>
                <nav class="nav">
                    <a href="###">服装城</a>
                    <a href="###">美妆馆</a>
                    <a href="###">尚品汇超市</a>
                    <a href="###">全球购</a>
                    <a href="###">闪购</a>
                    <a href="###">团购</a>
                    <a href="###">有趣</a>
                    <a href="###">秒杀</a>
                </nav>
                <div class="sort">
                    <div class="all-sort-list2" @click="redirectToSearch($event)">
                        <div class="item bo" v-for="(c1,index) in classNavData" :key="c1.categoryId" >
                            <h3 @mouseenter="changeMouseCurrentIndex(index)" :class="{ cur: mouseCurrentIndex == index}">
                                <a :data-tifa_categoryName="c1.categoryName" :data-tifa_categoryLevelOneId="c1.categoryId">{{c1.categoryName}}</a>
                            </h3>
                            <div class="item-list clearfix">
                                <div class="subitem" v-for="(c2,index) in c1.categoryChild" :key="c2.categoryId">
                                    <dl class="fore">
                                        <dt>
                                            <a :data-tifa_categoryName="c2.categoryName" :data-tifa_categoryLevelTwoId="c2.categoryId">{{c2.categoryName}}</a>
                                        </dt>
                                        <dd>
                                            <em v-for="(c3,index) in c2.categoryChild" :key="c3.categoryId">
                                                <a :data-tifa_categoryName="c3.categoryName" :data-tifa_categoryLevelThreeId="c3.categoryId">{{c3.categoryName}}</a>
                                            </em>
                                        </dd>
                                    </dl>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        <div style="position: absolute; bottom: 200px; right: 300px">
            <p v-if="!userName">
                <span>你现在为游客模式，请</span>

                <router-link to="/login">登录</router-link>
                <span>||||</span>
                <router-link class="register" to="/register">注册</router-link>
            </p>
            <!-- 登录了 -->
            <p v-else>
                    <span>你已经登录</span>
                    <a>{{userName}}</a>
                    <a @click="userLogOut()">退出登录</a>
            </p>
        </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex';
// 节流，防止mouseenter事件多次触发。
import throttle from 'lodash/throttle';
export default {
    name: 'ClassNav',
    data(){
        return {
            mouseCurrentIndex: 1,
        }
    },
    computed:{
        ...mapState({
            classNavData: state=>state.classNav.classNavData,
            userName: state=>state.global.userData.name
        }),
      
    },
    methods:{
        async userLogOut(){
            try {
              //如果退出成功
              await this.$store.dispatch('userLogout');
              //回到首页
              this.$router.push('/home');
            } catch (error) {
              alert('退出失败！');
            }
        } 
      },
            //100ms内只会触发一次。 
      changeMouseCurrentIndex: throttle(function(index){
          this.mouseCurrentIndex = index;
      },100),
      // 点击分类，跳转search并传递参数。
      redirectToSearch(event) {
          let targetNode = event.target;

          // 获取自定义属性。
          let { tifa_categoryname,tifa_categoryleveloneid,tifa_categoryleveltwoid,tifa_categorylevelthreeid} = targetNode.dataset;
          // 如果为a标签。
          if (tifa_categoryname) {

              let loction = { name: "search" };
              let query = { categoryName: tifa_categoryname };

              // 点击一级目录。传递一级分类id。
              if (tifa_categoryleveloneid) {
                  query.tifa_categoryleveloneid = tifa_categoryleveloneid;

              // 点击二级目录。传递一、二级分类id。
              } else if (tifa_categoryleveltwoid) {
                  query.tifa_categoryleveltwoid = tifa_categoryleveltwoid

              // 点击三级目录。传递一、二、三级分类id。
              } else {
                  query.tifa_categorylevelthreeid = tifa_categorylevelthreeid;
              }
              //如果路由跳转的时候，带有params参数，则传递。
              if (this.$route.params) {
                  loction.params = this.$route.params;
              }
              loction.query = query;
              // 路由跳转
              this.$router.push(loction);
          }
      },
    mounted() {
        try {
            console.log("sss");
            this.$store.dispatch('getClassData');
        } catch (error) {
            alert('获取类别数据失败！')
        }
    },
}
</script>
<style lang="less" scoped>
    .type-nav {
  border-bottom: 2px solid yellowgreen;

  .container {
    width: 1200px;
    margin: 0 auto;
    display: flex;
    position: relative;

    .all {
      width: 210px;
      height: 45px;
      background-color: blue;
      line-height: 45px;
      text-align: center;
      color: #fff;
      font-size: 14px;
      font-weight: bold;
    }

    .nav {
      a {
        height: 45px;
        margin: 0 22px;
        line-height: 45px;
        font-size: 16px;
        color: #333;
      }
    }

    .sort {
      position: absolute;
      left: 0;
      top: 45px;
      width: 210px;
      height: 461px;
      position: absolute;
      background: #fafafa;
      z-index: 999;

      .all-sort-list2 {
        .item {
          h3 {
            line-height: 30px;
            font-size: 14px;
            font-weight: 400;
            overflow: hidden;
            padding: 0 20px;
            margin: 0;

            a {
              color: #333;
            }
            &.cur {
              background: yellow;
            }
          }

          .item-list {
            display: none;
            position: absolute;
            width: 734px;
            min-height: 460px;
            _height: 200px;
            background: #f7f7f7;
            left: 210px;
            border: 1px solid #ddd;
            top: 0;
            z-index: 9999 !important;

            .subitem {
              float: left;
              width: 650px;
              padding: 0 4px 0 8px;

              dl {
                border-top: 1px solid #eee;
                padding: 6px 0;
                overflow: hidden;
                zoom: 1;

                &.fore {
                  border-top: 0;
                }

                dt {
                  float: left;
                  width: 54px;
                  line-height: 22px;
                  text-align: right;
                  padding: 3px 6px 0 0;
                  font-weight: 700;
                }

                dd {
                  float: left;
                  width: 415px;
                  padding: 3px 0 0;
                  overflow: hidden;

                  em {
                    float: left;
                    height: 14px;
                    line-height: 14px;
                    padding: 0 8px;
                    margin-top: 5px;
                    border-left: 1px solid #ccc;
                  }
                }
              }
            }
          }

          &:hover {
            .item-list {
              display: block;
            }
          }
        }
      }
    }
  }
}
</style>