<template>
  <layout>
    <template #content>
      <signup-form @submit="onSubmit"/>
    </template>
  </layout>
</template>

<script>
import axios from 'axios'
import SignupForm from '@/components/SignupForm.vue'
import Layout from '@/components/Layout.vue'

export default {
  name: 'SignupPage',
  components: {
    SignupForm,
    Layout
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userPw)
      const { userId, userName, userPw } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw })
        .then(res => {
          alert('Register Success')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
