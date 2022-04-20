<template lang="">
    <div>
        <el-form-item :label="$t('deviceType.deviceTypeEditAdd.productionLine')+ ':'" prop="productionLine" style="margin-bottom: 20px">
        <el-select
            filterable
            :placeholder="$t('injector.plsSelect1')"
            size="small"
            :clearable="true"
            style="width:80%"
            @change="productionLineChange"
            v-model="addview.productionLine">    //这个value是下拉框实际的值，label是显示在明面上的值
            <el-option v-for="item in productionLineList"  :value="item.id" :label="item.name"></el-option>
        </el-select>
        </el-form-item>
        
        <el-form-item :label="$t('deviceType.deviceTypeEditAdd.area')+ ':'" prop="area" style="margin-bottom: 20px">
        <el-select
            filterable
            :placeholder="$t('injector.plsSelect1')"
            size="small"
            :clearable="true"
            style="width:80%"
            @change="areaChange"
            v-model="addview.area">
            <el-option v-for="item in areaData"  :value="item.id" :label="item.name"></el-option>
        </el-select>
        </el-form-item>
        
        <el-form-item :label="$t('deviceType.deviceTypeEditAdd.workshopSection')+ ':'" prop="workshopSection" style="margin-bottom: 20px">
        <el-select
            filterable
            :placeholder="$t('injector.plsSelect1')"
            size="small"
            :clearable="true"
            style="width:80%"
            v-model="addview.workshopSection">
            <el-option v-for="item in workshopSectionData"  :value="item.id" :label="item.name"></el-option>
        </el-select>
        </el-form-item>
    </div>
</template>
<script>
export default {
    data() {
        return {
             //属性
            productionLineList: [
                    {name:"PM11",id:"PM11"},
                    {name:"PM12",id:"PM12"},
                    {name:"电厂",id:"DC"},
                ],
                areaList:[
                    {name:"PM11-1楼",id:"PM11-1",pid:'PM11'},
                    {name:"PM11-2楼",id:"PM11-2",pid:'PM11'},
                    {name:"PM11-3楼",id:"PM11-3",pid:'PM11'},
                    {name:"PM11-4楼",id:"PM11-4",pid:'PM11'},
                    {name:"PM12-1楼",id:"PM12-1",pid:'PM12'},
                    {name:"PM12-2楼",id:"PM12-2",pid:'PM12'},
                    {name:"PM12-3楼",id:"PM12-3",pid:'PM12'},
                    {name:"PM12-4楼",id:"PM12-4",pid:'PM12'},
                    {name:"干煤棚及2、3#转运站、码头",id:"a",pid:'DC'},
                    {name:"电气综合楼及快装锅炉",id:"b",pid:'DC'},
                    {name:"原水综合楼",id:"c",pid:'DC'},
                    {name:"污水综合楼及斜网间污水处理",id:"d",pid:'DC'},
                    {name:"水处理区域及消防加压泵房",id:"e",pid:'DC'},
                    {name:"热电主厂房16.3、29.8、36.3米",id:"f",pid:'DC'},
                    {name:"热电主厂房",id:"g",pid:'DC'},
                    {name:"热电主厂房（4.3米层）",id:"h",pid:'DC'},
                    {name:"热电主厂房①楼(0米层)",id:"i",pid:'DC'},
                    {name:"电厂脱水楼、空压机房、5#皮带除铁站",id:"j",pid:'DC'},
                    {name:"碎煤机、油库、变频器室、循环水加药间及制冷站",id:"k",pid:'DC'},
                ],
                workshopSectionList: [
                    {name:"复卷机",id:"1",pid:'PM11-1'},
                    {name:"制冷站",id:"2",pid:'PM11-1'},
                    {name:"办公楼",id:"3",pid:'PM11-1'},
                    {name:"后烘",id:"4",pid:'PM11-1'},
                    {name:"前烘",id:"5",pid:'PM11-1'},
                    {name:"变压器",id:"6",pid:'PM11-1'},
                    {name:"化学品车间",id:"7",pid:'PM11-1'},
                    {name:"流送系统",id:"8",pid:'PM11-1'},
                    {name:"备浆",id:"9",pid:'PM11-1'},
                    {name:"碎解站",id:"10",pid:'PM11-1'},
                    {name:"复卷机",id:"11",pid:'PM11-2'},
                    {name:"后烘",id:"12",pid:'PM11-2'},
                    {name:"前烘",id:"13",pid:'PM11-2'},
                    {name:"电气配电房",id:"14",pid:'PM11-2'},
                    {name:"湿部",id:"15",pid:'PM11-2'},
                    {name:"化学品车间",id:"16",pid:'PM11-2'},
                    {name:"备浆",id:"17",pid:'PM11-2'},
                    {name:"岗位风机",id:"18",pid:'PM11-3'},
                    {name:"干部工艺风机",id:"19",pid:'PM11-3'},
                    {name:"湿部工艺风机",id:"20",pid:'PM11-3'},
                    {name:"岗位风机",id:"21",pid:'PM11-3'},
                    {name:"房顶风机",id:"22",pid:'PM11-4'},
                    {name:"流送系统",id:"23",pid:'PM11-4'},
                    {name:"复卷机",id:"24",pid:'PM12-1'},
                    {name:"后烘",id:"25",pid:'PM12-1'},
                    {name:"前烘",id:"26",pid:'PM12-1'},
                    {name:"变压器",id:"27",pid:'PM12-1'},
                    {name:"流送系统",id:"28",pid:'PM12-1'},
                    {name:"备浆",id:"29",pid:'PM12-1'},
                    {name:"碎解站",id:"30",pid:'PM12-1'},
                    {name:"复卷机",id:"31",pid:'PM12-2'},
                    {name:"后烘",id:"32",pid:'PM12-2'},
                    {name:"前烘",id:"33",pid:'PM12-2'},
                    {name:"湿部",id:"34",pid:'PM12-2'},
                    {name:"备浆",id:"35",pid:'PM12-2'},
                    {name:"电气配电房",id:"36",pid:'PM12-2'},
                    {name:"岗位风机",id:"38",pid:'PM12-3'},
                    {name:"干部工艺风机",id:"39",pid:'PM12-3'},
                    {name:"湿部工艺风机",id:"40",pid:'PM12-3'},
                    {name:"岗位风机",id:"41",pid:'PM12-3'},
                    {name:"湿部工艺风机",id:"42",pid:'PM12-4'},
                    {name:"流送系统",id:"43",pid:'PM12-4'},
                    {pid:"a",id:"null",name:'无'},
                    {pid:"b",id:"null",name:'无'},
                    {pid:"c",id:"null",name:'无'},
                    {pid:"d",id:"null",name:'无'},
                    {pid:"e",id:"null",name:'无'},
                    {pid:"f",id:"null",name:'无'},
                    {pid:"g",id:"null",name:'无'},
                    {pid:"h",id:"null",name:'无'},
                    {pid:"i",id:"null",name:'无'},
                    {pid:"j",id:"null",name:'无'},
                    {pid:"k",id:"null",name:'无'},
                ],
                
                areaData:[],
                workshopSectionData:[],
                    }
    },
    methods: {
        //方法
        productionLineChange(val){
            this.areaData = [];
            this.addview.area="";
            this.workshopSectionData = [];
            this.addview.workshopSection="";
            this.areaList.forEach(item => {
                if(item.pid == val){
                this.areaData.push(item)
                }
            })
            },
        
            areaChange(val){
            this.workshopSectionData = [];
            this.addview.workshopSection="";
            this.workshopSectionList.forEach(item => {
                if(item.pid == val){
                this.workshopSectionData.push(item)
                }
            })
        
        }
    },
}
</script>
<style lang="">
    
</style>