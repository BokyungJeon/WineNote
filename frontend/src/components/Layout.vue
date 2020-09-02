<style>
body {
background-color: #ddd7cb;
}
</style>

<template>
  <v-app id="layout" style="background-color: #ddd7cb">
    <v-navigation-drawer
      v-model="drawer"
      app
      right
    >
      <v-list dense>
        <v-list-item
          router-link :to="{ name: 'Home' }">
          <v-list-item-action>
            <v-icon>mdi-home></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              Home
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router-link :to="{ name: 'BoardListPage' }">
          <v-list-item-action>
            <v-icon>mdi-home></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              My Note
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item router-link :to="{ name: 'NewsPage' }">
          <v-list-item-action>
            <v-icon>mdi-home></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              News
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      flat
      color="#ddd7cb"
      dark
      shrink-on-scroll
      scroll-target="#scrolling-techniques-2"
    >

      <v-toolbar-title>
        <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active"
        >
          <img src="@/assets/winelogo.png">
        </router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-table align="right">
        <v-row>
          <v-col>
            <v-app-bar-nav-icon
              @click.stop="drawer = !drawer"
            ></v-app-bar-nav-icon>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <div id="loginHeader">
              <div v-if="isAuthorized">
                {{ myinfo.auth }}님, 환영합니다.
                <v-btn id="mynote" @click="$router.push('BoardListPage')">
                  My Note
                </v-btn>
                <v-btn id="login" @click="onClickLogout" style="margin-left: 10px">Logout</v-btn>
              </div>
              <div v-else>
               <v-btn id="login" color="normal" @click="$router.push('LoginPage')">Login</v-btn>
               <v-btn id="signup" color="normal" @click="$router.push('SignupPage')" style="margin-left: 10px">Signup</v-btn>
              </div>
            </div>
          </v-col>
        </v-row>
      </v-table>
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

// import router from '../router'
// import store from '../store'
// import Vue from 'vue'
import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  name: 'Layout',
  data: function () {
    return {
      drawer: false
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$route.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  }
}
</script>
