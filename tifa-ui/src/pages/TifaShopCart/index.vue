<template>
    <div class="mainContainer"> 
        <div class="homeHeader"><HomeHeader/></div> 
            <ShopCartContent/>
        </div>
</template>
<script>
import HomeHeader from '../ShopHome/HomeHeader'
import ShopCartContent from './ShopCartContent'
export default {
    name:"tifaShopCart",
    components:{
        HomeHeader,
        ShopCartContent
    },
 
}
</script>
<style lang="less">
    .mainContainer{
    }

</style>