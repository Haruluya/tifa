<template>
    <div class="mainContainer">
        <el-card shadow="hover" :body-style="{ padding: '0px'}">
            <img
            src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image"
            />
            <div style="padding: 14px" class="bottom">
            <span>Yummy hamburger....</span>
            <div class="price">
                <el-link type="danger">$45</el-link>
            </div>
            </div>
        </el-card>
    </div>
</template>

<script setup>


</script>

<style scoped>
.mainContainer{
    margin-bottom: 14px;
}




.image {
  width: 80%;
  display: block;
}
</style>
