<template>
    <div class="mainContainer">
        <div class="title">
            {{'★'+userData.uname +"的店铺商品"}}
        </div>
        <div class= "itemx" v-for="(item,index) in merchantProductsData.products">
            <MechantCard  :index="index"/>
        </div>
        <div class="addProduct">
            <el-button type="success" size="large" @click="showDialog()">
                添加商品
            </el-button>
        </div>
        <el-dialog v-model="dialogFormVisible" title="添加商品" append-to-body>
        <el-form :model="form">
        <el-form-item label="商品名称" :label-width="formLabelWidth">
            <el-input v-model="form.pname" autocomplete="off" />
        </el-form-item>
        <el-form-item label="商品描述" :label-width="formLabelWidth">
            <el-input v-model="form.subTitle" autocomplete="off" />

        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
            <el-input v-model="form.orignalPrice" autocomplete="off" />
        </el-form-item>
        <el-form-item label="库存数量" :label-width="formLabelWidth">
            <el-input v-model="form.stock" autocomplete="off" />
        </el-form-item>
        <el-form-item label="商品图片" :label-width="formLabelWidth">
            <el-input v-model="form.img" autocomplete="off" />
        </el-form-item>
        </el-form>
        <div class="img">
            <el-image :src="form.img"></el-image>
        </div>
        <template #footer>
        <span class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="commitAddProduct()"
            >确认</el-button
            >
        </span>
        </template>
    </el-dialog>
    </div>
</template>
<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex'
import MechantCard from '../MerchantCard'
import { ElNotification} from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'  
export default {
    name:"myproducts",
    components:{
        MechantCard,

    },
    computed:{
      ...mapGetters(['userData','merchantProductsData']), 
    },
    data() {
        return {
            dialogFormVisible:false,
            form:{
                pname:"",
                subTitle:"",
                orignalPrice:"",
                
                img:"",
                stock:"",
            },
        }
    },
    methods: {
        async init(){
            await this.$store.dispatch('getMerchantProductData',{uid:this.userData.uid});
        },
        async commitAddProduct(){
            ElMessageBox.confirm(
                '确认提交商品?',
                '询问',
                {
                    confirmButtonText: '确认',
                    cancelButtonText: '取消',
                    type: 'Info',
                }
            )
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '取消提交',
                })
            })
            .then(async () => {
                this.form['uid'] = this.userData.uid;
                await this.$store.dispatch('addProduct',this.form);
                this.init();
                ElMessage({
                    type: 'success',
                    message: '添加成功！',
                })
                this.dialogFormVisible = false;
            })
        },
        showDialog(){
            console.log(this.merchantProductsData)
            this.dialogFormVisible = true
        }
    },
    mounted() {
        this.init();
    },
}
</script>
<style lang="less" scoped>
    .mainContainer{
        background-color: white;
        height: 600px;
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