<template>
  <div>
    <h3>My Wine List</h3>
    <table border="1">
      <tr>
        <th align="center" width="40">No</th>
        <th align="center" width="160">Product Name</th>
        <th align="center" width="160">Winery</th>
        <th align="center" width="80">Type</th>
        <th align="center" width="80">Region</th>
        <th align="center" width="160">Grape</th>
        <th align="center" width="180">Registration Date</th>
      </tr>
      <tr v-for="page in paginatedData" :key="page.boardNo">
        <td>{{ page.boardNo }}</td>
        <td>{{ page.product }}</td>
        <td>{{ page.winery }}</td>
        <td>{{ page.type }}</td>
        <td>{{ page.regions }}</td>
        <td>{{ page.grapes }}</td>
        <td>{{ page.regDate }}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <v-btn class="page-btn"
        :disabled="pageNum === 0"
        @click="prevPage"
      >이전</v-btn>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} page</span>
      <v-btn class="page-btn"
        :disabled="pageNum >= pageCount - 1"
        @click="nextPage"
      >다음</v-btn>
    </div>
  </div>
</template>

<script>

export default {
  name: 'BoardListForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 5
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>
