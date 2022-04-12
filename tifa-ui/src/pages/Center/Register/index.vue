<template>
<div class="bodyContainer">
    <div class="container">
      <h1>TIFA Register</h1>
      
        <form>
          <div class="form-control" >
            <input type="text" required placeholder="Name" autocomplete="new-password" v-model="name">
            <label></label>
          </div>

          <div class="form-control" >
            <input v-model="password" type="password" required placeholder="Password" autocomplete="new-password">
            <label></label>
          </div>

          <div class="form-control" >
            <input v-model="confirmPassword" type="password" required placeholder="Password Confirm" autocomplete="new-password">
            <label></label>
          </div>

          <button class="btn" @click.prevent="commitRegister()">Register</button>
        </form>

        <p class="text">Inpute you name and password to register!</p>
    </div>
</div>
</template>
<script>

// 注册界面
export default {
    name:'Register',


    data() {
        return {
            // 收集表单数据--手机号
            name: "",
            //验证码
            code: "",
            //密码
            password: "",
            //确认密码
            confirmPassword: "",
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
            const { name, code, password} = this;
            try {
                await this.$store.dispatch("commitRegister", {
                    name,
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
<style lang="css" scoped>

.bodyContainer {
  background-color: rgba(14, 205, 222, 0.052);
  color: #fff;
  font-family: 'Muli', sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  overflow: hidden;
  margin: 0;
}

.container {
  background-color: rgba(0, 0, 0, 0.4);
  padding: 20px 40px;
  border-radius: 5px;
}

.container h1 {
  text-align: center;
  margin-bottom: 30px;
}

.container a {
  text-decoration: none;
  color: rgba(237, 37, 74, 0.518);
}

.btn {
  cursor: pointer;
  display: inline-block;
  width: 100%;
  background: rgba(43, 100, 234, 0.948);
  padding: 15px;
  font-family: inherit;
  font-size: 16px;
  border: 0;
  border-radius: 5px;
}

.btn:focus {
  outline: 0;
}

.btn:active {
  transform: scale(0.98);
}

.text {
  margin-top: 30px;
}

.form-control {
  position: relative;
  margin: 20px 0 40px;
  width: 300px;
}

.form-control input {
  background-color: transparent;
  border: 0;
  border-bottom: 2px #fff solid;
  display: block;
  width: 100%;
  padding: 15px 0;
  font-size: 18px;
  color: #fff;
}

.form-control input:focus,
.form-control input:valid {
  outline: 0;
  border-bottom-color: lightblue;
}

.form-control label {
  position: absolute;
  top: 15px;
  left: 0;
  pointer-events: none;
}

.form-control label span {
  display: inline-block;
  font-size: 18px;
  min-width: 5px;
  transition: 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.form-control input:focus + label span,
.form-control input:valid + label span {
  color: lightblue;
  transform: translateY(-30px);
}


input:-webkit-autofill,
input:-webkit-autofill:hover,
input:-webkit-autofill:focus,
input:-webkit-autofill:active {
  transition-delay: 90000s;
  transition: color 90000s ease-out, background-color 90000s ease-out;
  -webkit-transition-delay: 90000s;
  -webkit-transition: color 90000s ease-out, background-color 90000s ease-out;
  -webkit-text-fill-color: black;
}

</style>