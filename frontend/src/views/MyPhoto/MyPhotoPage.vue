<template>
  <layout>
    <template #content>
      <my-photo-form/>
    </template>
  </layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import MyPhotoForm from '@/components/MyPhotoForm/MyPhotoForm.vue'

export default {
  name: 'GalleryPage',
  components: {
    Layout,
    MyPhotoForm
  }
}
</script>
