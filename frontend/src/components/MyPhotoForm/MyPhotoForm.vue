<template>
  <v-row style="margin-top: 80px">
    <v-col>
      <v-card>
        <v-container fluid>
          <v-row>
            <v-col
              v-for="n in 9"
              :key="n"
              class="d-flex child-flex"
              cols="4"
            >
              <v-card flat tile class="d-flex">
                <v-img
                  :src="`https://picsum.photos/500/300?image=${n * 5 + 10}`"
                  :lazy-src="`https://picsum.photos/10/6?image=${n * 5 + 10}`"
                  aspect-ratio="1"
                  class="grey lighten-2"
                >
                  <template v-slot:placeholder>
                    <v-row
                      class="fill-height ma-0"
                      align="center"
                      justify="center"
                    >
                      <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                    </v-row>
                  </template>
                </v-img>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
</script>

<style>
.theme--light.v-card {
  background-color: transparent;
  color: rgba(0, 0, 0, 0.87);
}
.v-card {
  border-width: none;
  display: block;
  max-width: 100%;
  outline: none;
  text-decoration: none;
  transition-property: opacity;
  overflow-wrap: break-word;
  position: relative;
  white-space: normal;
}
</style>
