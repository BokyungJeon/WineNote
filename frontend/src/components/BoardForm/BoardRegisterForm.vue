<template>
  <v-app id="boardregister" class="aa">
    <h2>What have you tried?</h2>
    <v-form @submit.prevent="onSubmit">
      <v-card flat style="padding: 20px 20px">
        <v-container fluid align="center">
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
            <v-col sm="6" cols="12">
              <v-text-field
                v-model="product"
                label="Product Name"
              ></v-text-field>
            </v-col>
            <v-col sm="6" cols="12">
              <v-text-field
                v-model="winery"
                label="Winery"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12">
              <v-text-field
                v-model="vintage"
                dense
                label="Vintage"
              ></v-text-field>
            </v-col>
            <v-col sm="6" cols="12">
              <v-autocomplete
                v-model="grape"
                :items="grapes"
                dense
                label="Grape"
              ></v-autocomplete>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12">
             <v-autocomplete
              :v-model="country"
              :items="countries"
              dense
              label="Country"
            ></v-autocomplete>
            </v-col>
            <v-col sm="6" cols="12">
             <v-autocomplete
              v-model="region"
              :items="regions"
              dense
              label="Region"
             ></v-autocomplete>
            </v-col>
          </v-row>
          <v-row>
            <v-col sm="6" cols="12">
              <v-text-field
                :v-model="price"
                dense
                label="Price"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
             <v-textarea
               v-model="contents"
               background-color="grey lighten-3"
               color="cyan"
               label="Note"
             ></v-textarea>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <v-sheet>
                <v-chip-group column close @click:close="remove(item)">
                  <v-chip v-for="(item, i) in aroma" :key="i">
                    {{ item }}
                  </v-chip>
                </v-chip-group>
              </v-sheet>
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

      <div style="margin-top:10px">
        <v-btn type="submit" label="Register" style="margin-right:20px">Register</v-btn>
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
      product: '',
      winery: '',
      vintage: '',
      grape: '',
      country: '',
      region: '',
      price: '',
      contents: '',
      chips: [],
      types: ['red', 'white', 'Sparkling', 'Rose', 'Port', 'Dessert'],
      grapes: ['Carbernet Sauvignon', 'Merlot', 'Chardonnay', 'Pinot Noir', 'Malbec', 'Sauvignon Blanc', 'Shraz/Syrah', 'Zinfandel', 'Nebbiolo', 'Sangiovese', 'Pinot Grigio', 'Riesling', 'Chenin Blanc', 'Moscato', 'Albarino'],
      countries: ['France', 'Italy', 'Spain', 'USA', 'Portugal', 'Chile', 'New Zealand', 'Australia'],
      regions: ['Bordeaux', 'Languedoc-Roussillon', 'Northern Rhone', 'Southern Rhone', 'Burgundy', 'Piemonte', 'Tuscany', 'Puglia', 'Veneto', 'Catalunya', 'Castilla y Leon', 'Galicia', 'Aragon'],
      aroma: ['Blackberry', 'Blackcurrant', 'Blueberry', 'Raspberry', 'Strawberry', 'Black Cherry', 'Red Cherry', 'Plum', 'Prune(dried)', 'Gooseberries(White Wine Only)', // Fruity(Berry-like)
        'Grapefruit', 'Lemon', 'Lime', // Fruity: Citrus(White)
        'Apple', 'Apricot', 'Melon', 'Peach', 'Pear', 'Pineapple', // Fruity: Stone & Tropical Fruits
        'Violet', 'Rose', 'Orange Blossom', 'Jasmine', 'Lily', 'Geranium', 'Orchid', // Floral
        'Almond', 'Coffee', 'Hazelnut', 'Walnut', // Nutty
        'Dry leaves', 'Dusty', 'Moldy', 'Mushroom', // Earthy
        'Hay', 'Mint', 'Rosemary', 'Thyme', // Herby
        'Black Pepper', 'Licorice', 'Cinnamon', 'Clove', // Spicy
        'Vanilla', 'Cedar', 'Tobacco', 'Chocolate', 'Petrol', 'Leather', 'Butterscotch', 'Olive' // etc.
      ]
    }
  },
  methods: {
    onSubmit () {
      const { type, product, winery, vintage, grapes, country, regions, contents, chips } = this
      this.$emit('submit', { type, product, winery, vintage, grapes, country, regions, contents, chips })
    },
    cancel () {
      this.$router.push('BoardListPage')
    },
    remove (item) {
      this.chips.push(item)
      this.aroma.splice(this.aroma.indexOf(item), 1)
      this.aroma = [...this.aroma]
      console.log('this.chips : ' + this.chips + 'this.aroma : ' + this.aroma)
    }
  },
  updated: {
  }
}
</script>
