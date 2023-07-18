<template>
    <div class="book-list-content">
        <span>Se han encontrado los siguientes resultados para la búsqueda blabla</span>
        <div class="bl-books">
            <span v-for="book in miArray">
                <BookCard :book="book" widthSize="100%"></BookCard>
            </span>
        </div>
    </div>
    </template>
    <script>
    import BookCard from '../components/BookCard.vue'
    import { mapState } from 'vuex';
    
    export default {
        name: "BookListView",
        components: {
            BookCard,
        },
        computed: mapState({
            miArray() {
                return this.$store.state.searchBooks;
            }
        })
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