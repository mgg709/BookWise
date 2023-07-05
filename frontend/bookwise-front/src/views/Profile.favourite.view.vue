<script setup>
import Header from "../components/ProfileHeader.vue"
import BookCard from "../components/BookCard.vue"
import Footer from "../components/Footer.vue"
</script>

<template>
    <Header imageName="search"></Header>
    <div class="favourites-profile" id="section2">
        <BookCard v-for="i in 7" imageName="template-book-cover"></BookCard>
    </div>
    <Footer></Footer>
</template>

<style>
Footer{
    width: 100%;
  text-align: center;
}
</style>