<template>
    <nav class="nav">
      <div class="container">
        <h1 class="logo"><a href="/index.html">TIFA</a></h1>
        <ul>
          <li><a href="CRUD" >CRUD</a></li>
          <li><a href="classNav">ClassNav</a></li>
          <li><a href="login">Login</a></li>
          <li><a href="register">Register</a></li>
          <li><a href="#">
            <span v-if="!userName">
              <router-link to="/login">未登录</router-link>
            </span>
            <span v-else>
              <span>{{userName}}</span>
            </span>
            </a>
          </li>
        </ul>
      </div>
    </nav>
</template>

<script>
import {mapState,mapMutations,mapAction,mapGetters} from 'vuex';
export default {
    name: "Header",
    data(){
        return {

        }
    },
    computed:{
      ...mapState({

        }),
      ...mapGetters(['userName'])
    },
    mounted(){
    }


   
}

window.onload = function(){
    const nav = document.querySelector('.nav')
    window.addEventListener('scroll', fixNav)

    function fixNav() {
        if(window.scrollY > nav.offsetHeight + 50) {
            nav.classList.add('active')
        } else {
            nav.classList.remove('active')
        }
    }

}
</script>

<style scoped lang="css">
.nav {
  position: fixed;
  background-color: #222;
  top: 0;
  left: 0;
  right: 0;
  transition: all 0.3s ease-in-out;
}

.nav .container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px 0;
  transition: all 0.3s ease-in-out;
}

.nav ul {
  display: flex;
  list-style-type: none;
  align-items: center;
  justify-content: center;
}

.nav a {
  color: #fff;
  text-decoration: none;
  padding: 7px 15px;
  transition: all 0.3s ease-in-out;
}

.nav.active {
  background-color: #fff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
}

.nav.active a {
  color: #000;
}

.nav.active .container {
  padding: 10px 0;
}

.nav a.current,
.nav a:hover {
  color: #c0392b;
  font-weight: bold;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
}
</style>