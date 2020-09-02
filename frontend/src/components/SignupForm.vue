<template>
  <v-app id="signup">
    <v-row align="center" justify="center">
      <v-form @submit.prevent="submit">
        <v-col align="center">
          <v-text-field
            v-model="userId"
            label="ID"
            required
          ></v-text-field>
        </v-col>
        <v-col align="center">
          <v-text-field
            v-model="userName"
            label="Name"
            required
          ></v-text-field>
        </v-col>
        <v-col align="center">
          <v-text-field
            input type="password"
            v-model="userPw"
            label="Password"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-btn type="submit">Sign Up</v-btn>
        </v-col>
      </v-form>
    </v-row>
  </v-app>
</template>

<script>
export default {
  name: 'SignupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId + ', ' + this.userName + ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>
