<template>
<div class="book-list-content">
    <span>Se han encontrado los siguientes resultados para la búsqueda blabla</span>
    <div class="bl-books">
        <BookCard imageName="template-book-cover" bookStars=2 widthSize="100%" class="book-card"></BookCard>
        <BookCard imageName="template-book-cover" bookStars=4 widthSize="100%" class="book-card"></BookCard>
        <BookCard imageName="template-book-cover" bookStars=2 widthSize="100%" class="book-card"></BookCard>
        <BookCard imageName="template-book-cover" bookStars=4  widthSize="100%" class="book-card"></BookCard>
    </div>
</div>
</template>
<script>
import BookCard from '../components/BookCard.vue'

export default {
    name: "BookListView",
    components: {
        BookCard,
    },
}
</script>
<style>

.bl-books{
  margin: 50px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 100px;
}

</style>