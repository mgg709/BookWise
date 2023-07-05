<script setup>
import Header from "../components/ProfileHeader.vue"
import ReviewCard from "../components/ReviewCard.vue"
import Footer from "../components/Footer.vue"
</script>

<template>
    <Header imageName="search"></Header>
    <div class="review-profile" id="section1">
        <ReviewCard v-for="i in 6"></ReviewCard>
    </div>
    <Footer></Footer>
</template>

<script>
</script>

<style>
.review-profile{
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
}
Footer{
    width: 100%;
    text-align: center;
}
</style>