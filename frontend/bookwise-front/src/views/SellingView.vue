<script setup>
import BookCard from '../components/BookCard.vue'
</script>

<template>
  <h1>Top selling books</h1>
  <div class="top-sellings-books">
    <div class="layer-list">
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
    </div>
  </div>
  <h1>Top best rated</h1>
  <div class="top-best-rated">
    <div class="layer-list">
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
      <BookCard class="book"></BookCard>
    </div>
  </div>
</template>
  
  <style>
  *{
    margin:0;
    padding: 0;
    box-sizing: border-box;
  }

  template{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    height: 100vh;
  }

  h1{
    width: 88%;
    color: white;
  }

  .top-sellings-books,
  .top-best-rated{
    width: 90%;
    display: flex;
    overflow: auto;
    border-radius: 8px;
    max-width: 1200px;
    padding-bottom: 50px;
  }

  .layer-list{
  max-height: 100x;
  border: 2px solid;
  display: flex;
  overflow-x: auto;
}

.book{
  margin-left: 2.5px;
  margin-right: 2.5px;
  padding: 15px 30px;
}

  </style>
  