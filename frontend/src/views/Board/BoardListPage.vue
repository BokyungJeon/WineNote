<template>
  <layout>
    <template #content>
      <router-link :to="{ name: 'BoardRegisterPage' }">
        New Note
      </router-link>
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
