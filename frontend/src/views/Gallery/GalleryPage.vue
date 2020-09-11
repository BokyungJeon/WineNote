<template>
  <layout>
    <template #content>
      <gallery-from/>
    </template>
  </layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import GalleryFrom from '@/components/GalleryForm/GalleryForm.vue'

export default {
  name: 'GalleryPage',
  components: {
    Layout,
    GalleryFrom
  }
}
</script>
