<script setup></script>

<template>
    <footer>
        <address>
            <p>You can contact us via the following e-mail addresses:</p>
            <ul>
                <li><a href="mailto:luismag@empathy.co">luismag@empathy.co</a></li>
                <li><a href="mailto:matiasgg@empathy.co">matiasgg@empathy.co</a></li>
                <li><a href="mailto:manuelaf@empathy.co">manuelaf@empathy.co</a></li>
            </ul>
        </address>
        <p>If you want to know more <span @click="redirectToAbout">About us</span></p>
        <p>Copyright © 2023 BookWise. All rights reserved</p>
    </footer>
</template>

<script>
export default {
  methods: {
    redirectToAbout() {
      this.$router.push('/about');
    }
  }
}
</script>

<style scoped>
footer{
    background: var(--color-black-light);
    color: white;
}

li{
    list-style: none;
}

address{
    border-radius: 10px;
    border-top-left-radius: 50px;
    border-bottom-right-radius: 50px;
    border: solid 1px;
}

span{
    color:aqua;
}

span:hover{
    cursor: pointer;
}
</style>