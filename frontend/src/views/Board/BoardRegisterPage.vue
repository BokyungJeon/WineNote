<template>
  <layout>
    <template #content>
      <div align="center">
        <h2>Board Register</h2>
        <board-register-form @submit="onSubmit"/>
      </div>
    </template>
  </layout>
</template>

<script>
import BoardRegisterForm from '@/components/BoardForm/BoardRegisterForm'
import axios from 'axios'
import Layout from '@/components/Layout'

export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegisterForm,
    Layout
  },
  methods: {
    onSubmit (payload) {
      console.log('BoardRegisterPage onSubmit()')
      const { title, content, writer } = payload
      axios.post('http://localhost:7777/boards', { title, writer, content })
        .then(res => {
          console.log(res)
          alert('Register Success')
          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
