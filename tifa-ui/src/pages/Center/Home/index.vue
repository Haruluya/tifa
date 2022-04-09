<template>

  <div class="hero">
    <div class="container">
      
    </div>
  </div>
  
    <section class="container content">
    <h2>CRUD</h2>
    <p>
      <span>
        数据库增删改查的功能实现，CRUD模块的实现意味着前后端交互，通过前端控制
        数据库中数据的增加，修改，查询，删除的功能实现。
      </span>
    </p>

    <h3>Login</h3>
    <p>
      登录模块，查询数据库获取登录确认后从后端获取唯一标识token，通过token来获取用户
      信息，并获取其他模块的访问权限，登陆后拒绝访问login，register模块，可再次通过退出登录访问。
    </p>
    
    <h3>Register</h3>
    <p>
      注册模块，查询数据库检测注册确认后，由后端发送请求和微信交互，获取用户微信账号信息，
      同时通过第三方发送验证码，前端确认注册成功后返回最初状态。
    </p>

    <h3>ClassNav</h3>
    <p>
      分类显示模块，主要有3级分类，不同级别的分类代表不同的查询讯息，点击任意分类
      会导航至search模块并传递相应的分类信息。
    </p>

    <h3>Testing</h3>
    <p>测试网站</p>

    <h3>Testing</h3>
    <p>测试网站</p>
  </section>





</template>
<script>
import Swiper from 'swiper';    
import "swiper/swiper-bundle.min.css";




export default {
    name: "home",
    mounted() {
      // new Swiper ('.swiper', {
      //     // direction: 'vertical', // 垂直切换选项
      //     loop: true, // 循21q环模式选项
          
      //     // 如果需要分页器
      //     pagination: {
      //       el: '.swiper-pagination',
      //     },
          
      //     // 如果需要前进后退按钮
      //     navigation: {
      //       nextEl: '.swiper-button-next',
      //       prevEl: '.swiper-button-prev',
      //     },
          
      //     // 如果需要滚动条
      //     scrollbar: {
      //       el: '.swiper-scrollbar',
      //     },
      // })
    },
}





</script>
<style scoped lang="css">

 .swiper {
   position: absolute;
        top: 300px;
        width: 500px;
        height: 300px;
        margin: 20px auto;
    }
.hero {
  background-image: url('../../../assets/images/tifaImage01.jpeg');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: bottom center;
  height: 100vh;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  position: relative;
  margin-bottom: 20px;
  z-index: -2;
}

.hero::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: -1;
}

.hero h1 {
  font-size: 46px;
  margin: -20px 0 20px;
}

.hero p {
  font-size: 20px;
  letter-spacing: 1px;
}

.content h2,
.content h3 {
  font-size: 150%;
  margin: 20px 0;
}

.content p {
  color: #555;
  line-height: 30px;
  letter-spacing: 1.2px;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
}
</style>