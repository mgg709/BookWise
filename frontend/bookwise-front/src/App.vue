<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import NavigationBar from './components/NavigationBar.vue'
</script>

<template>
  
  <section class="content">
    <NavigationBar class="navbar"></NavigationBar>
    <RouterView></RouterView>
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

</style>
