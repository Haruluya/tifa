<template>
    <div>
        <div ref="reportHTML" id="content"></div>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import {ElNotification} from 'element-plus'
export default {
    name:"purchase",
    computed:{
      ...mapGetters(['htmlText','userData','locationData','sumPrice','pids']), 
    },
    methods: {
        async init(){
            try {
                await this.$store.dispatch('purchase',{
                    subject:this.userData.uname,
                    price:this.sumPrice,
                    uid:this.userData.uid,
                    pids:this.pids,
                    aid:this.locationData[0].aid
                });
                await this.$store.dispatch('clearCart',this.userData.uid);
                document.getElementById("content").innerHTML = this.htmlText;
                document.forms[0].submit();
                } catch (error) {
                    ElNotification({
                        title: '获取支付失败！',
                        message: error,
                        type: 'error'
                    })
                }
        }
    },
    mounted() {
        this.init();
    },
}
</script>
<style lang="less" scoped>
    
</style>