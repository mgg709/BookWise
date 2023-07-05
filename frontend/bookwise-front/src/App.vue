<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavigationBar from './components/NavigationBar.vue'
import Footer from './components/Footer.vue'
</script>

<template>
  
  <section class="content">
    <NavigationBar class="navbar"></NavigationBar>
    <RouterView></RouterView>
    <Footer class="footer"></Footer>
  </section>
  
</template>

<style scoped>
.content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}

.navbar{
  top: 0;
}
.footer{
  width: 100%;
  text-align: center;
}

</style>
