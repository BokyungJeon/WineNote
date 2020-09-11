<template>
  <v-app id="signup" style="margin-top: 60px">
    <v-row justify="center">
      <v-form @submit.prevent="submit">
        <v-col>
          <v-text-field
            v-model="userId"
            :rules="idRules"
            label="ID"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            v-model="userName"
            :rules="nameRules"
            label="Name"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            input type="password"
            v-model="userPw"
            :rules="passwordRules"
            label="Password"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            v-model="userEmail"
            :rules="emailRules"
            label="E-mail"
            required
          ></v-text-field>
        </v-col>
        <v-col align="center">
          <v-btn type="submit">Sign up</v-btn>
        </v-col>
      </v-form>
    </v-row>
  </v-app>
</template>

<script>
export default {
  name: 'SignupForm',
  data: () => ({
    valid: false,
    userId: '',
    userName: '',
    userPw: '',
    userEmail: '',
    idRules: [
      v => !!v || 'id is required',
      v => v.length <= 10 || 'ID must be less than 10 characters'
    ],
    nameRules: [
      v => !!v || 'name is required',
      v => v.length <= 10 || 'Name must be less than 10 characters'
    ],
    passwordRules: [
      v => !!v || 'Password is required',
      v => v.length >= 6 || 'Password must be more than 6 characters'
    ],
    emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@+/.test(v) || 'E-mail must be valid'
    ]
  }),
  methods: {
    submit () {
      console.log('this: ' + this.userId + ', ' + this.userName + ', ' + this.userPw + ',' + this.userEmail)
      const { userId, userName, userPw, userEmail } = this
      this.$emit('submit', { userId, userName, userPw, userEmail })
    }
  }
}
</script>
