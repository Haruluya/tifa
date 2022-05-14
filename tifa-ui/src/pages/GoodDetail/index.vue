<template>
    <div class="mainContainer">
        <div class="homeHeader"><HomeHeader/></div>
        <div class="topInfo">
            <div class="leftInfo">
                <el-image src="https://img12.360buyimg.com/n1/s450x450_jfs/t1/92268/16/25934/75321/62592d7cEa8474210/94e9750d0719ff07.jpg"></el-image>
                <el-carousel :interval="4000" type="card" height="100px">
                    <el-carousel-item v-for="item in 6" :key="item">
                    <h3 text="2xl" justify="center">
                        <img src="https://img12.360buyimg.com/n5/s54x54_jfs/t1/92268/16/25934/75321/62592d7cEa8474210/94e9750d0719ff07.jpg"/>
                    </h3>
                    </el-carousel-item>
                </el-carousel>
            </div>
            <div class="rightOpration">
                <div class="classBread">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item :to="{ path: '/' }">数码</el-breadcrumb-item>
                        <el-breadcrumb-item
                        ><a href="/">智能设备</a></el-breadcrumb-item
                        >
                        <el-breadcrumb-item>智能手表</el-breadcrumb-item>
                        <el-breadcrumb-item>ZeppOs</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="title">
                    <el-tag type="danger" effect="dark">TIFA</el-tag>
                    <span>Amazfit 跃我 GTR 3 Pro 曜石黑 血压筛查研究 150种运动模式 50米防水 心率监测 智能运动手表华米科技出品</span>
                </div>
                <div class="des">
                    <span>【超值单品，数量有限，先到先得】 【ZeppOS系统丨12天超长续航丨150+运动模式】 【白条6期免息】更多福利戳此</span>
                </div>
                <div class="pricePanel">
                    <div class="header"><el-icon><shopping-bag /></el-icon>TIFA限购</div>
                    <div class="content">
                        <div class="labels">
                            <div class="label">
                                原价格：
                                <div class="prePrice">￥9999</div>
                            </div>
                            <div class="label">
                                现价格：
                                <div class="nowPrice">￥9999
                                    <el-tag class="ml-2" type="danger">特价</el-tag>
                                    <el-tag class="ml-2" type="danger">满9999减1</el-tag>
                                </div>
                            </div>

                        </div>
                        <div class="sales">
                            <el-divider direction="vertical"></el-divider>
                            累计销量：
                            <div class="salesNum">
                                888
                            </div>
                        </div>
                    </div>
                </div>
                <div class="location">
                    <span>配送至：</span>
                    <div class="locationCas">
                        <el-cascader
                        v-model=" locationValue"
                        :options="options"
                        :props="props"
                        @change="handleChange"
                        />
                    </div>
                </div>
                <div class="color">
                    <span>颜色：</span>
                    <el-radio v-model="goodColor" label="1"  border>黄色</el-radio>
                    <el-radio v-model="goodColor" label="2"  border>蓝色</el-radio>
                </div>
                <div class="amount">
                    <span>数量：</span>
                    <el-input-number
                        v-model="goodNum"
                        :min="1"
                        :max="10"
                        controls-position="right"
                        @change="handleChange"
                    />
                </div>
                <el-divider></el-divider>
                <div class="addShopCart">
                    <el-icon><shopping-cart-full /></el-icon>加入购物车
                </div>
            </div>
        </div>
        <div class="simRec">
            <RecPanel title="基于Item-CF的商品相似推荐"/>
        </div>
        <div class="evaluationContainer">
          <el-container>
            <el-aside width="300px">
              <div class="merchant">
                <div class="title">
                  希箭厨房卫浴旗舰店
                </div>
                <el-divider></el-divider>
                <div class="score">
                    <el-rate
                      v-model="scoreValue"
                      disabled
                      show-score
                      text-color="#ff9900"
                      size="large"
                      score-template="{value} 分"
                    />
                </div>
                <div class="merchantImg">
                  <el-image :src="merchantImg">

                  </el-image>
                </div>
                <div class="merchantButton">
                  <el-button type="primary"><el-icon><Briefcase /></el-icon>进店逛逛</el-button>
                  <el-button type="primary"><el-icon><StarFilled /></el-icon>关注店铺</el-button>
                </div>
              </div>
            </el-aside>
            <el-main>
              <el-tabs v-model="evaluationActiveTab" @tab-click="handleEvaluationTabClick"  type="border-card">
                <el-tab-pane label="商品介绍" name="introduce">
                  <div class="infoCard">
                    
                  </div>
                  <el-divider></el-divider>
                  <div class="infoImgs">
                    <div class="infoImg" v-for="(item,index) in evaluationImgList">
                      <el-image :src="item">
                      </el-image>
                    </div>
                  </div>
                </el-tab-pane>
                <el-tab-pane label="售后保障" name="guarantee">Config</el-tab-pane>
                <el-tab-pane label="商品评价" name="comment">Role</el-tab-pane>
              </el-tabs>
            </el-main>
          </el-container>
        </div>
    </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
import RecPanel from '../ShopHome/RecPanel'
// 级联地址选项。
const props = {
  expandTrigger: 'hover',
}
const handleChange = (value) => {
  console.log(value)
}
const options = [
  {
    value: 'guide',
    label: 'Guide',
    children: [
      {
        value: 'disciplines',
        label: 'Disciplines',
        children: [
          {
            value: 'consistency',
            label: 'Consistency',
          },
          {
            value: 'feedback',
            label: 'Feedback',
          },
          {
            value: 'efficiency',
            label: 'Efficiency',
          },
          {
            value: 'controllability',
            label: 'Controllability',
          },
        ],
      },
      {
        value: 'navigation',
        label: 'Navigation',
        children: [
          {
            value: 'side nav',
            label: 'Side Navigation',
          },
          {
            value: 'top nav',
            label: 'Top Navigation',
          },
        ],
      },
    ],
  },
  {
    value: 'component',
    label: 'Component',
    children: [
      {
        value: 'basic',
        label: 'Basic',
        children: [
          {
            value: 'layout',
            label: 'Layout',
          },
          {
            value: 'color',
            label: 'Color',
          },
          {
            value: 'typography',
            label: 'Typography',
          },
          {
            value: 'icon',
            label: 'Icon',
          },
          {
            value: 'button',
            label: 'Button',
          },
        ],
      },
      {
        value: 'form',
        label: 'Form',
        children: [
          {
            value: 'radio',
            label: 'Radio',
          },
          {
            value: 'checkbox',
            label: 'Checkbox',
          },
          {
            value: 'input',
            label: 'Input',
          },
          {
            value: 'input-number',
            label: 'InputNumber',
          },
          {
            value: 'select',
            label: 'Select',
          },
          {
            value: 'cascader',
            label: 'Cascader',
          },
          {
            value: 'switch',
            label: 'Switch',
          },
          {
            value: 'slider',
            label: 'Slider',
          },
          {
            value: 'time-picker',
            label: 'TimePicker',
          },
          {
            value: 'date-picker',
            label: 'DatePicker',
          },
          {
            value: 'datetime-picker',
            label: 'DateTimePicker',
          },
          {
            value: 'upload',
            label: 'Upload',
          },
          {
            value: 'rate',
            label: 'Rate',
          },
          {
            value: 'form',
            label: 'Form',
          },
        ],
      },
      {
        value: 'data',
        label: 'Data',
        children: [
          {
            value: 'table',
            label: 'Table',
          },
          {
            value: 'tag',
            label: 'Tag',
          },
          {
            value: 'progress',
            label: 'Progress',
          },
          {
            value: 'tree',
            label: 'Tree',
          },
          {
            value: 'pagination',
            label: 'Pagination',
          },
          {
            value: 'badge',
            label: 'Badge',
          },
        ],
      },
      {
        value: 'notice',
        label: 'Notice',
        children: [
          {
            value: 'alert',
            label: 'Alert',
          },
          {
            value: 'loading',
            label: 'Loading',
          },
          {
            value: 'message',
            label: 'Message',
          },
          {
            value: 'message-box',
            label: 'MessageBox',
          },
          {
            value: 'notification',
            label: 'Notification',
          },
        ],
      },
      {
        value: 'navigation',
        label: 'Navigation',
        children: [
          {
            value: 'menu',
            label: 'Menu',
          },
          {
            value: 'tabs',
            label: 'Tabs',
          },
          {
            value: 'breadcrumb',
            label: 'Breadcrumb',
          },
          {
            value: 'dropdown',
            label: 'Dropdown',
          },
          {
            value: 'steps',
            label: 'Steps',
          },
        ],
      },
      {
        value: 'others',
        label: 'Others',
        children: [
          {
            value: 'dialog',
            label: 'Dialog',
          },
          {
            value: 'tooltip',
            label: 'Tooltip',
          },
          {
            value: 'popover',
            label: 'Popover',
          },
          {
            value: 'card',
            label: 'Card',
          },
          {
            value: 'carousel',
            label: 'Carousel',
          },
          {
            value: 'collapse',
            label: 'Collapse',
          },
        ],
      },
    ],
  },
  {
    value: 'resource',
    label: 'Resource',
    children: [
      {
        value: 'axure',
        label: 'Axure Components',
      },
      {
        value: 'sketch',
        label: 'Sketch Templates',
      },
      {
        value: 'docs',
        label: 'Design Documentation',
      },
    ],
  },
]

const handleEvaluationTabClick = (value)=>{
}
export default {
    name: 'gooddetail',
    components:{
        HomeHeader,
        RecPanel
    },
    data() {
        return {
            locationValue:'',
            options,
            props,
            goodColor: '1',
            goodNum : 1,
            evaluationActiveTab:"introduce",
            scoreValue:"3.7",
            merchantImg:"data:image/png;base64,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",
            evaluationImgList:["https://img10.360buyimg.com/imgzone/jfs/t1/202058/20/11876/172626/616d220eE1705e703/5ca6d504dbd2f305.jpg",
              "http://img30.360buyimg.com/popWareDetail/jfs/t1/65795/25/18154/185329/627cfef4E08b0df77/ae09124e913d1704.jpg",
              "http://img30.360buyimg.com/popWareDetail/jfs/t1/49166/38/17259/156232/627cfeb7E9a1d614a/bb0d9130bca47697.jpg",
              "https://img30.360buyimg.com/imgzone/jfs/t1/211557/24/5722/178695/616d2211E8263408d/fe2931d8ee3f6cc3.jpg"]
        }
    },

}
</script>
<style lang="less" scoped>
    .mainContainer{
        margin: 0 auto; 
    }
    .topInfo{
        width: 1200px;
        // background-color: white;
        margin: 0 auto; 
        display: flex;
        .leftInfo{
            margin-top: 20px;
            height: 100%;
            width: 500px;
            .el-image{
                width: 500px;
                border-radius: 20px;
                box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
                &:hover{
                    transform: scale(1.01);
                    cursor: pointer;
                }
            }
        }
        .rightOpration{
            width: 700px;
            margin-top: 20px;
            margin-left: 30px;
            padding: 20px;
            background-color: white;
            .classBread{
                margin-top: 5px;
                span{
                    font-size: 16px;
                    color: #c8c8c8;
                }
            }
            .title{
                color: #666666;
                font-size: 18px;
                font-weight: bold;
                margin-top: 20px;
                .el-tag{
                    font-size: 18px;
                    padding: 12px;
                    margin-right: 10px;
                }
            }
            .des{
                margin-top: 15px;
                font-size: 12px;
                color: red;
                cursor: pointer;
            }
            .pricePanel{
                margin-top: 30px;
                .header{
                    text-align: left;
                    padding: 5px;
                    padding-left: 20px;
                    background-color: #fb1c77;
                    font-size: 20px;
                    border-radius: 3px;
                    color: white;
                }
                .content{
                    background-color: #f3f3f3;
                    display: flex;
                    padding: 10px;
                    padding-left: 20px;
                    .labels{
                        font-size: 18px;
                        .label{
                            display: flex;
                            margin-top: 20px;
                            color: #999999;
                            .prePrice{
                                color: #7049ff;
                                font-size: 20px;
                                font-weight: bold;
                            }
                            .nowPrice{
                                font-size: 25px;
                                font-weight: bold;
                                color: #e4393c;
                                transform: translateY(-5px);
                                .el-tag{
                                    margin-left: 5px;
                                    transform: translateY(-5px);
                                }
                            }
                        }

                    }
                    .sales{
                        margin-left: 150px;
                        color: #999999;
                        font-size: 18px;
                        .salesNum{
                            margin-top: 10px;
                            color: #007fc2;
                        }
                    }
                }
            }
            .location{
                margin-top: 20px;
                display: flex;
                font-size: 18px;
                color: #c8c8c8;
                .locationCas{
                    margin-left: 15px;
                    transform: translateY(-3px);
                }
            }
            .color{
                margin-top: 20px;
                display: flex;
                font-size: 18px;
                color: #c8c8c8;
                .el-radio{
                    margin-right: 10px;
                }
            }
            .amount{
                margin-top: 20px;
                display: flex;
                font-size: 18px;
                color: #c8c8c8;
            }
            .addShopCart{
                font-size: 23px;
                font-weight: bold;
                display: flex;
                margin-top: 20px;
                color: white;
                width: 150px;
                padding: 8px;
                border-radius: 5px;
                background-color: #df3033;
                &:hover{
                    transform: scale(1.01);
                    cursor: pointer;
                }
            }
        }
    }
    .simRec{
        width: 1400px;
        margin: 0 auto;
        margin-top: 50px;
    }
    .evaluationContainer{
        margin: 0 auto;
        margin-top: 200px;
        width: 1400px;
        .merchant{
          margin-top: 20px;
          background-color: white;
          border-radius: 20px;
          padding: 20px;
          box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
          .title{
            font-size: 18px;
            font-weight: bold;
            background-color: #f7f7f7;
            &:hover{
              color: #e4393c;
              cursor: pointer;
            }
          }
          .score{
            
          }
          .merchantImg{
            margin-top: 10px;
            .el-image{
              border-radius: 10px;
            }
          }
          .merchantButton{
            margin-top: 15px;
          }
        }
        .infoCard{
          height: 200px;


        }
    }
</style>