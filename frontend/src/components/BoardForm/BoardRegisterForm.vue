<template>
  <v-app id="boardregister">
    <v-form @submit.prevent="onSubmit">
      <h3>What have you tried?</h3>
      <v-card flat>
        <v-container fluid>
          <v-row>
            <v-col cols="12" sm="6" md="6">
              <v-radio-group v-mode="type">
                <v-radio label="Red" color="red darken-3" value="red"></v-radio>
                <v-radio label="White" color="orange" value="white"></v-radio>
                <v-radio label="Rose" color="red" value="rose"></v-radio>
                <v-radio label="Dessert/Sweet" color="indigo darken-3" value="sweet"></v-radio>
                <v-radio label="Sparkling" color="info" value="spark"></v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
      <v-container fluid>
        <v-row>
          <v-col sm="6" cols="12">
          <v-text-field v-model="title" label="title"></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col sm="6" cols="12">
          <v-text-field v-model="writer" label="writer"></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col sm="6" cols="12">
          <v-text-field v-model="content" label="content"></v-text-field>
          </v-col>
        </v-row>
        <v-file-input show-size counter multiple label="File input"></v-file-input>
      </v-container>

      <div>
        <v-btn type="submit" label="Register"></v-btn>
        <router-link :to="{ name: 'BoardListPage' }">
          Cancel
        </router-link>
      </div>
    </v-form>
  </v-app>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
