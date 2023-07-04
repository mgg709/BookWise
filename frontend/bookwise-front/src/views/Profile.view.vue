<script setup>
import Header from "../components/ProfileHeader.vue"
import BookCard from "../components/BookCard.vue"
import ReviewCard from "../components/ReviewCard.vue"
</script>

<template>
    <Header imageName="search"></Header>
    <div class="review-profile" id="section1">
        <ReviewCard></ReviewCard>
        <ReviewCard></ReviewCard>
        <ReviewCard></ReviewCard>
        <ReviewCard></ReviewCard>
        <ReviewCard></ReviewCard>
    </div>
    <div class="favourites-profile" id="section2">
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
        <BookCard imageName="template-book-cover"></BookCard>
    </div>
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
</style>