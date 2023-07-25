<template>
  <span>Top selling books</span>
  <div class="top-sellings-books">
    <div class="layer-list" v-for="book in booksBestSellings">
      <BookCard :book=book></BookCard>
    </div>
  </div>
  <span>Top best rated</span>
  <div class="top-best-rated">
    <div class="layer-list" v-for="book in booksBestRated">
      <BookCard :book=book></BookCard>
    </div>
  </div>
</template>
<script>
import BookCard from '@/components/BookCard.vue'
import axios from 'axios'
export default {
  name: 'SellingView',
  components: {
    BookCard,
  },
  data() {
    return {
      booksBestRated: [],
      booksBestSellings: [],
    }
  },
  methods: {
    async getBooksBestRated() {
      try {
        const {data} = await axios.get('http://localhost:8080/books/best-rated')
        this.booksBestRated = data
      } catch (error) {
        console.log(error)
      }
    },
    async getBooksBestSellings() {
      try {
        const {data} = await axios.get('http://localhost:8080/books/best-sellers')
        this.booksBestSellings = data
      } catch (error) {
        console.log(error)
      }
    },
  },
  mounted() {
    this.getBooksBestRated(),
    this.getBooksBestSellings()
  },
}
</script>  
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

Footer{
  width: 100%;
  text-align: center;
}

  </style>
  