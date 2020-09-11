<template>
  <layout>
    <template #content>
      <login-form @submit="onSubmit"/>
    </template>
  </layout>
</template>

<script>
import LoginForm from '@/components/Member/LoginForm.vue'
import Layout from '@/components/Layout.vue'

import { mapActions } from 'vuex'

export default {
  name: 'LoginPage',
  components: {
    LoginForm,
    Layout
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Login Success')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
