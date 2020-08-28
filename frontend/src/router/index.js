import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import SignupPage from '../views/SignupPage.vue'

// For Cafe Board
import BoardListPage from '../views/Board/BoardListPage.vue'
import BoardRegisterPage from '../views/Board/BoardRegisterPage.vue'
import BoardModifyPage from '../views/Board/BoardModifyPage.vue'
import BoardReadPage from '../views/Board/BoardReadPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/SignupPage',
    name: 'SignupPage',
    components: {
      default: SignupPage
    }
  },
  {
    path: '/BoardListPage',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
