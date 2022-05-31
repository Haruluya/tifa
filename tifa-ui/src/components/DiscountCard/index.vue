<template lang="html">
    <div>
        <div class="mainContainer">
            <div class="title">
                <span>每日特价 <el-icon><arrow-right-bold /></el-icon></span>
                <img src="https://img14.360buyimg.com/n7/jfs/t1/128959/39/25809/179557/61ab35c5Ef63bf787/a70bc4b79e905715.jpg"/>
            </div>
            <div class="taps">
                <el-tabs v-model="evaluationActiveTab" class="demo-tabs" @tab-click="handleClick">
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
            evaluationActiveTab:"food",
            cardImgList:{
                'food' : [
                    {
                        src:'https://img14.360buyimg.com/seckillcms/s144x144_jfs/t1/125505/3/21820/70760/61e13dbaEcb8f3e38/d3eb778ea95216ba.jpg!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '6.9'
                    },
                    {
                        src:'https://img30.360buyimg.com/seckillcms/s144x144_jfs/t1/159275/14/13667/986516/60506604Ebd88b35d/57e1d550983f0d33.png!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '16.9'
                    },
                    {
                        src:'https://img12.360buyimg.com/seckillcms/s144x144_jfs/t1/136619/38/24429/176595/6232eb30E085ca9ec/4bb4a4769ca8419f.jpg!q70.jpg.webp',
                        title: '金丝黄菊一朵大降价',
                        price: '16.9'
                    },
                ],
                'tool' : [
                    {
                        src:'https://img11.360buyimg.com/n7/jfs/t1/121041/38/13446/30347/5f6d9c88Eb0e218ea/3e4d4b75899863da.jpg',
                        title: '金丝黄菊一朵大降价',
                        price: '666.9'
                    }
                ],
                'car' : [
                    {
                        src:'https://img14.360buyimg.com/n7/jfs/t1/173965/27/28226/200160/62172865E8ad007de/9199a2e185d64aaa.jpg',
                        title: '金丝黄菊一朵大降价',
                        price: '66666.9'
                    }
                ],
                'weapon' : [
                    {
                        src:'https://img11.360buyimg.com/n7/jfs/t1/78468/5/17800/845352/6275fc4dEcf974d3a/10eb90a2cf4aa4d6.png',
                        title: '金丝黄菊一朵大降价',
                        price: '7896.99'
                    }
                ]
            },
            panelInfo: [
                {label:"美食", name:"food"},
                {label:"工具", name:"tool"},
                {label:"车", name:"car"},
                {label:"武器", name:"weapon"}
            ],


        }
    },
    mounted() {
        this.activeTap = "food";
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