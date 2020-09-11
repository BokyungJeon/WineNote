<template>
  <v-app id="login" style="margin-top: 130px">
    <v-row justify="center">
      <v-form @submit.prevent="submit">
        <v-col align="center">
          <v-text-field
            v-model="userid"
            label="ID"
            required
          ></v-text-field>
        </v-col>
        <v-col align="center">
          <v-text-field
            input type="password"
            v-model="password"
            label="Password"
            required
          ></v-text-field>
        </v-col>
        <v-col align="center">
          <v-btn type="submit">Login</v-btn>
        </v-col>
      </v-form>
    </v-row>
  </v-app>
</template>

<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>
