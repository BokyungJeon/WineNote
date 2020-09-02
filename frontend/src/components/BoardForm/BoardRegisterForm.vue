<template>
  <v-app id="boardregister">
    <v-form @submit.prevent="onSubmit">
      <h3>What have you tried?</h3>
      <v-card flat>
        <v-container fluid>
          <v-row align="center">
            <v-col cols="12">
              <v-radio-group v-model="type" row>
                <v-radio label="Red" color="red darken-3" value="red"></v-radio>
                <v-radio label="White" color="orange" value="white"></v-radio>
                <v-radio label="Sparkling" color="info" value="spark"></v-radio>
                <v-radio label="Rose" color="red" value="rose"></v-radio>
                <v-radio label="Dessert/Sweet" color="indigo darken-3" value="sweet"></v-radio>
                <v-radio label="Port" color="black" value="port"></v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12" row>
              <v-text-field
                v-model="product"
                label="Product Name"
              ></v-text-field>
              <v-text-field
                v-model="winery"
                label="Winery"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12">
              <v-autocomplete
                v-model="grapes"
                :items="grapes"
                dense
                filled
                label="grapes"
              ></v-autocomplete>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12">
             <v-text-field
              v-model="regions"
              :items="country"
              label="Regions"
            ></v-text-field>
            </v-col>
          </v-row>
          <v-file-input
            show-size
            counter
            multiple
            prepend-icon="mdi-camera"
            label="File input"
          ></v-file-input>
        </v-container>
      </v-card>

      <div>
        <v-btn type="submit" label="Register">Register</v-btn>
        <v-btn @click="$router.push('BoardListPage')" label="Cancel">Cancel</v-btn>
      </div>
    </v-form>
  </v-app>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      type: '',
      title: '',
      writer: '',
      content: '',
      grapes: ['Carbernet Sauvignon', 'Merlot', 'Chardonnay', 'Pinot Noir', 'Malbec', 'Sauvignon Blanc', 'Shraz/Syrah', 'Zinfandel', 'Nebbiolo', 'Sangiovese', 'Pinot Grigio', 'Riesling', 'Chenin Blanc', 'Moscato', 'Albarino']
    }
  },
  methods: {
    onSubmit () {
      const { type, product, grapes, content } = this
      this.$emit('submit', { type, product, grapes, content })
    }
  }
}
</script>
