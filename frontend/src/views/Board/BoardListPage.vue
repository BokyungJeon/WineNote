<template>
  <layout>
    <template #content>
      <h2>" No Note have been created yet. "</h2><br>
      <v-btn @click="$router.push({name: 'BoardRegisterPage'})">
        Create New Note
      </v-btn>
      <board-list-form :boards="boards"/>
    </template>
  </layout>
</template>

<script>
import BoardListForm from '@/components/BoardForm/BoardListForm'
import { mapState, mapActions } from 'vuex'
import Layout from '@/components/Layout'

export default {
  name: 'BoardListPage',
  components: {
    BoardListForm,
    Layout
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>
