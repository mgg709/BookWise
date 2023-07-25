<template>
    <Header imageName="user"></Header>
    <div class="favourites-profile" id="section2">
        <div v-for="book in books">
            <BookCard :book="book"></BookCard>
        </div>
       
    </div>
</template>

<script>
import Header from "../components/ProfileHeader.vue"
import BookCard from "../components/BookCard.vue"
import axios from "axios"
export default{
    components: {
        Header,
        BookCard
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
        }
    },
    beforeMount(){
        this.getFavourites();
    }
}
</script>
<style>
Footer{
    width: 100%;
  text-align: center;
}

.favourites-profile{
    margin-top: 30px;
    margin-bottom: 30px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.favourites-profile div{
    margin-bottom: 15px;
    width: 50%;
}
</style>