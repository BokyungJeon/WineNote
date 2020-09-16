<template>
  <layout>
    <template #content>
      <div align="center">
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
      const { type, product, winery, vintage, grapes, country, regions, contents, scents } = payload
      axios.post('http://localhost:7777/boards', { type, product, winery, vintage, grapes, country, regions, contents, scents })
        .then(res => {
          console.log(res)
          alert('Register Success')
          this.$router.push({
            name: 'BoardReadPage',
            params: { board_no: res.data.board_no.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
