<template>
    <div class="mainContainer">
        <div class="header">
            <div class="time">
                <el-icon><AlarmClock /></el-icon>2022-05-14 15:30:00
            </div>
            <div class="orderId">
                订单号: 245647148036<el-icon><Collection /></el-icon>
            </div>
        </div>
        <div class="content">
            <div class="goodImg">
                <el-image src="https://img10.360buyimg.com/N6/s60x60_jfs/t1/169501/31/27324/79770/6170d624Eaeed6143/567977574c36a0b3.jpg">

                </el-image>
            </div>
            <div class="title">
                TheNorthFace北面卫衣情侣款2021秋冬情侣款户
                <br/>外舒适抓绒印花连帽卫衣 5B35/V1T 绿色
            </div>
            <div class="amount">
                x1
            </div>
            <el-divider direction="vertical" />
            <div class="name">
                Haruluya<el-icon><Avatar /></el-icon>
            </div>
            <el-divider direction="vertical" />
            <div class="price">
                ￥359.00
            </div>
            <el-divider direction="vertical" />
            <div class="status">
                已完成
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name:"ordercard"
}
</script>
<style lang="less" scoped>
    .mainContainer{
        border: 1px solid rgb(128, 128, 128);
        margin-top: 15px;
        box-shadow: rgba(18, 18, 18, 0.1) 0px 1px 3px 0px;
        .header{
            display: flex;
            padding: 10px;
            padding-bottom: 5px;
            padding-top: 3px;
            background-color: #f5f5f5;
            font-size: 14px;
            color: #aaaaaa;
            .el-icon{
                font-size: 20px;
                transform: translateY(5px);
                margin-right: 10px;
                margin-left: 10px;
            }
            .time{
                margin-right: 30px;
            }
            .orderId{
                &:hover{
                    color: red;
                    cursor: pointer;
                }
            }
        }
        .content{
            display: flex;
            padding: 10px;
            .el-divider{
                height: 70px;
                margin-left: 50px;
            }
            .goodImg{
                margin-left: 10px;
            }
            .title{
                margin-left: 20px;
                margin-top: 5px;
                font-size: 14px;
                color: #333333;
                text-align: left;
            }
            .amount{
                margin-left: 80px;
                margin-right: 50px;
                margin-top: 20px;
                font-size: 20px;
                font-weight: bold;
                color: #aaaaaa;
            }
            .name{
                margin-right: 80px;
                margin-left: 10px;
                margin-top: 20px;
                color: #aaaaaa;
            }
            .price{
                margin-left: 10px;
                margin-top: 20px;
                font-weight: bold;
            }
            .status{
                margin-left: 10px;
                margin-top: 20px;
            }
        }
    }
</style>