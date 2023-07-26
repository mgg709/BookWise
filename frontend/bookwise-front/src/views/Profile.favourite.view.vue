<template>
    <Header imageName="user"></Header>
    <div class="favourites-profile" id="section2">
        <div class="f-book" v-for="book in books">
            <BookCard class="f-space" :book="book"></BookCard>
            <NormalButton textButton="Remove favourite" @click="removeFavourite(book)"></NormalButton>
        </div>
       
    </div>
</template>

<script>
import Header from "../components/ProfileHeader.vue"
import BookCard from "../components/BookCard.vue"
import NormalButton from "../components/NormalButton.vue"
import axios from "axios"
export default{
    components: {
        Header,
        BookCard,
        NormalButton
    },
    data(){
        return{
            books: []
        }
    },
    methods: {
        async getFavourites(){
            const {data} = await axios.get(`http://localhost:8080/users/getFavourites/${localStorage.getItem('username')}`);
            this.books = data;
        },
        async removeFavourite(book){
            const {data} = await axios.delete(`http://localhost:8080/users/removeFavourite?username=${this.$store.state.username}&booktitle=${book.title}`);
            this.books.splice(this.books.indexOf(book), 1);
        }
    },
    beforeMount(){
        this.getFavourites();
    }
}
</script>
<style>

.favourites-profile{
  margin: 50px;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-gap: 100px;
}

.f-book{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.f-book .f-space{
    margin-bottom: 20px;
}

</style>