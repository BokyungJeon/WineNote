import Vue from 'vue'
import VueRouter from 'vue-router'
import Starter from '../views/Starter.vue'
import Home from '../views/Home.vue'

// For Login System
import LoginPage from '../views/Member/LoginPage.vue'
import SignupPage from '../views/Member/SignupPage.vue'

// For Cafe Board
import BoardListPage from '../views/Board/BoardListPage.vue'
import BoardRegisterPage from '../views/Board/BoardRegisterPage.vue'
import BoardModifyPage from '../views/Board/BoardModifyPage.vue'
import BoardReadPage from '../views/Board/BoardReadPage.vue'

import GalleryPage from '../views/Gallery/GalleryPage.vue'
import MyPhotoPage from '../views/MyPhoto/MyPhotoPage.vue'
import NewsPage from '../views/News/NewsPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Starter',
    component: Starter
  },
  {
    path: '/home',
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
  },
  {
    path: '/myPhotoPage',
    name: 'MyPhotoPage',
    components: {
      default: MyPhotoPage
    }
  },
  {
    path: '/galleryPage',
    name: 'GalleryPage',
    components: {
      default: GalleryPage
    }
  },
  {
    path: '/NewsPage',
    name: 'NewsPage',
    components: {
      default: NewsPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
