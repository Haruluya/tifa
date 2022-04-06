<template>
  <div class="register-container">
    <!-- 注册内容 -->
    <div class="register">
      <h3>
        注册新用户
        <span class="go"
          >我有账号，去 <a href="login" target="_blank">登陆</a>
        </span>
      </h3>
      <div class="content">
        <label>手机号:</label>
        <input
          placeholder="请输入你的手机号"
          v-model="phone"
          name="phone"
        />
        <span class="error-msg">{{ }}</span>
      </div>
      <div class="content">
        <label>验证码:</label>
        <input
          placeholder="请输入你的验证码"
          v-model="code"
          name="code"
        />
        <button style="width:100px;height:38px" @click="getCode">
          获取验证码
        </button>
        <span class="error-msg">{{ }}</span>
      </div>
      <div class="content">
        <label>登录密码:</label>
        <input
          placeholder="请输入你的密码"
          v-model="password"
          name="password"
        />
        <span class="error-msg">{{  }}</span>
      </div>
      <div class="content">
        <label>确认密码:</label>
        <input
          placeholder="请输入确认密码"
          v-model="confimPassword"
          name="confimPassword"
        />
        <span class="error-msg">{{ }}</span>
      </div>
      <div class="controls">
        <input
          type="checkbox"
          v-model="agree"
          name="agree"
        />
        <span>同意协议并注册《尚品汇用户协议》</span>
        <span class="error-msg">{{  }}</span>
      </div>
      <div class="btn">
        <button @click="commitRegister">完成注册</button>
      </div>
    </div>

    <!-- 底部 -->
    <div class="copyright">
      <ul>
        <li>关于我们</li>
        <li>联系我们</li>
        <li>联系客服</li>
        <li>商家入驻</li>
        <li>营销中心</li>
        <li>手机尚品汇</li>
        <li>销售联盟</li>
        <li>尚品汇社区</li>
      </ul>
      <div class="address">地址：北京市昌平区宏福科技园综合楼6层</div>
      <div class="beian">京ICP备19006430号</div>
    </div>
  </div>
</template>
<script>
import postRegisterConfim from '_api/index.js'

// 注册界面
export default {
    name:'Register',


    data() {
        return {
            // 收集表单数据--手机号
            phone: "",
            //验证码
            code: "",
            //密码
            password: "",
            //确认密码
            confimPassword: "",
            //是否同意
            agree: true,
        };
    },
    methods: {
        //获取验证码
        async getCode() {

        },
        //用户注册
        async commitRegister() {
            const { phone, code, password} = this;
            try {
                await this.$store.dispatch("commitRegister", {
                    phone,
                    code,
                    password,
                });
                alert("注册成功！");
                this.$router.push("/login");
            } catch (error) {
                alert("注册失败！");
                this.$router.push("/login");
            }
        },
    },
}
</script>
<style lang="less" scoped>
.register-container {
  .register {
    width: 1200px;
    height: 445px;
    border: 1px solid rgb(223, 223, 223);
    margin: 0 auto;

    h3 {
      background: #ececec;
      margin: 0;
      padding: 6px 15px;
      color: #333;
      border-bottom: 1px solid #dfdfdf;
      font-size: 20.04px;
      line-height: 30.06px;

      span {
        font-size: 14px;
        float: right;

        a {
          color: #e1251b;
        }
      }
    }

    div:nth-of-type(1) {
      margin-top: 40px;
    }

    .content {
      padding-left: 390px;
      margin-bottom: 18px;
      position: relative;

      label {
        font-size: 14px;
        width: 96px;
        text-align: right;
        display: inline-block;
      }

      input {
        width: 270px;
        height: 38px;
        padding-left: 8px;
        box-sizing: border-box;
        margin-left: 5px;
        outline: none;
        border: 1px solid #999;
      }

      img {
        vertical-align: sub;
      }

      .error-msg {
        position: absolute;
        top: 100%;
        left: 495px;
        color: red;
      }
    }

    .controls {
      text-align: center;
      position: relative;

      input {
        vertical-align: middle;
      }

      .error-msg {
        position: absolute;
        top: 100%;
        left: 495px;
        color: red;
      }
    }

    .btn {
      text-align: center;
      line-height: 36px;
      margin: 17px 0 0 55px;

      button {
        outline: none;
        width: 270px;
        height: 36px;
        background: #e1251b;
        color: #fff !important;
        display: inline-block;
        font-size: 16px;
      }
    }
  }

  .copyright {
    width: 1200px;
    margin: 0 auto;
    text-align: center;
    line-height: 24px;

    ul {
      li {
        display: inline-block;
        border-right: 1px solid #e4e4e4;
        padding: 0 20px;
        margin: 15px 0;
      }
    }
  }
}
</style>