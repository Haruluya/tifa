<template lang="html">
    <div>
        <div class="mainContainer">
            <div class="title">
                <span>每日特价 <el-icon><arrow-right-bold /></el-icon></span>
                <img src="https://img20.360buyimg.com/babel/s580x740_jfs/t1/169223/11/9002/236742/603f38feEa4a8d83e/4ace79eafcac855c.jpg!cc_290x370.webp"/>
            </div>
            <div class="taps">
                <el-tabs v-model="activeTab" class="demo-tabs" @tab-click="handleClick">
                    <el-tab-pane v-for="(panel,index) in panelInfo" :label="panel.label" :name="panel.name">
                        <div class="infos">
                            <div v-for="(item,index) in cardImgList[panel.name]" :key="index" class="info">
                                <img :src="item.src" />
                                <div class="titleAndPrice">
                                    <span class="title">{{item.title}}</span>
                                    <span class="price">${{item.price}}</span>
                                </div>
                            </div>
                        </div>
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'discountcard',
    data() {
        return {
            activeTap:'food',
            cardImgList:{
                'food' : [
                    {
                        src:'https://img14.360buyimg.com/seckillcms/s144x144_jfs/t1/125505/3/21820/70760/61e13dbaEcb8f3e38/d3eb778ea95216ba.jpg!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '6.9'
                    },
                    {
                        src:'https://img14.360buyimg.com/seckillcms/s144x144_jfs/t1/125505/3/21820/70760/61e13dbaEcb8f3e38/d3eb778ea95216ba.jpg!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '6.9'
                    },
                    {
                        src:'https://img14.360buyimg.com/seckillcms/s144x144_jfs/t1/125505/3/21820/70760/61e13dbaEcb8f3e38/d3eb778ea95216ba.jpg!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '6.9'
                    },
                ],
                'tool' : [],
                'car' : [],
                'weapon' : []
            },
            panelInfo: [
                {label:"美食", name:"food"},
                {label:"工具", name:"tool"},
                {label:"车", name:"car"},
                {label:"武器", name:"weapon"}
            ]

        }
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        background-color: white;
        display: flex;
        overflow: hidden;
        border-radius: 10px;
        width: 684px;
        .title{
            display: flex;
            flex-direction: column;
            margin-left: 10px;
            padding: 20px;
            width: 150px;
            span{
                font-size: large;
                font-weight: bold;
                text-align: left;
                &:hover{
                    color:#e1251b;
                }
            }
            .el-icon{
                transform: translateY(2px);
            }
            img{
                margin-top: 40px;
                border-radius: 5px;
                cursor: pointer;
                &:hover{
                    transform: scale(1.05);
                    opacity: 0.8;
                    transition: all 1 ease;
                }
            }
        }
        .taps{
            margin-left: 20px;
            padding: 20px;
            height: 300px;
            .infos{
                display: flex;

                transform:translateX(-30px);
                .info{
                    width: 150px;
                    img{
                      width: 80px;
                    }
                    .titleAndPrice{
                        display: flex;
                        flex-direction: column;
                        text-align: left;
                        .title{
                            font-size: 12px;
                            &:hover{
                                color: #e1251b;
                            }
                        }
                        .price{
                            text-align: center;
                            font-weight: bold;
                            color:#e1251b;
                        }

                    }
                    &:hover{
                        cursor: pointer;
                        box-shadow: rgba(18, 18, 18, 0.251) 0px 1px 3px 0px;
                    }
                }
            }
        }
    }




</style>