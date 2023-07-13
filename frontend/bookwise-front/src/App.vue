<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavigationBar from './components/NavigationBar.vue'
import Footer from './components/Footer.vue'
</script>

<template>
  
  <section class="content">
    <NavigationBar class="navbar"></NavigationBar>
    <RouterView class="main"></RouterView>
    <Footer class="footer"></Footer>
  </section>
  
</template>

<style scoped>
.content {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 100%;
  min-height: 100vh;
}

.main{
  min-height: calc(100vh - 97px - 146px);
}

.navbar{
  top: 0;
}
.footer{
  width: 100%;
  text-align: center;
  bottom: 0;
  position: relative;
}

</style>
