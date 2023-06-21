<script setup>
import NavigationBar from '../components/NavigationBar.vue';
import TheWelcome from '../components/TheWelcome.vue'
</script>

<template>
 <div class="container-home">
  <div id="parallelogram-left">
    <div id="parallelogram-right">
    </div>
  </div>  
  
</div>
</template>

<style>
.container-home{
    overflow:hidden;
    display: flex;
    justify-content: center;
    align-items: center;
}
#parallelogram-right {
  display: flex;
    width: 100vw;
    height: 50vh;
    background: red;
    overflow:hidden;
    position:relative;
    clip-path: polygon(60% 0%, 100% 0, 100% 50%, 100% 100%, 40% 100%);
    align-self: flex-end;
}

#parallelogram-left {
  display: flex;
    width: 100vw;
    height: 50vh;
    background: blue;
    overflow:hidden;
    position:relative;
}
</style>