<template>
  <v-app id="layout">
    <v-app-bar
      absolute
      color="#fcb69f"
      dark
      shrink-on-scroll
      src="@/assets/wineback.jpg"
      scroll-target="#scrolling-techniques-2"
    >
      <template v-slot:img="{ props }">
        <v-img
          v-bind="props"
        ></v-img>
      </template>
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
          <img src="@/assets/winelogo.png">
        </router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>
      <div id="header" v-if="isAuthorized">
        <v-btn id="myboard" @click="$router.push('BoardListPage')" style="margin-left: 70px">My Board</v-btn>
        <v-btn id="login" @click="onClickLogout" color="black" style="margin-top: 2.2px">Logout</v-btn>
        <div>
          <br><span>{{ myinfo.auth }}님, 환영합니다!</span>
        </div>
      </div>

      <div id="header" v-else>
        <v-btn id="login" @click="$router.push('LoginPage')">
          Login
        </v-btn>
        <v-btn id="login" @click="$router.push('SignupPage')">
          Signup
        </v-btn>
      </div>
    </v-app-bar>
    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>
  </v-app>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  components: {
  },
  data: function () {
    return {
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  }
}
</script>

<style scoped>
div {
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #77aadd;
  color: #ffffff;
  font-weight: bold;
  float: right;
}

</style>
