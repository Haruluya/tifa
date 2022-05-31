<template>
    <div class="mainContainerx">
        <div class="title">
            {{'★'+userData.uname +"的店铺订单"}}
        </div>
        <div  class= "itemx" v-for="(item,index) in merchantOrderData.ordersData" >
            <OrderCard   :index="index"/>
        </div>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import OrderCard from './OrderCard'
import { ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"myproducts",
    components:{
       OrderCard,
    },
    computed:{
      ...mapGetters(['userData','merchantOrderData']), 
    },
    data() {
        return {
        }
    },
    methods: {
        async init(){
            await this.$store.dispatch('getMerchantOrderData',{uid:this.userData.uid});
        },
    
    },
    mounted() {
        this.init();
    },
}
</script>
<style lang="less" scoped>
    .mainContainerx{
        background-color: white;
        min-height: 600px;
        border-radius: 20px;
        padding: 30px;
    }
    .addProduct{
        position: absolute;
        top: 600px;
        right: 100px;
    }
    .title{
        font-size: 25px;
        font-weight: bold;
        text-align: left;
        color: #51a9ff;
    }
</style>