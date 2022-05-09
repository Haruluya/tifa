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
        <div class="goodImgs">

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
</style>