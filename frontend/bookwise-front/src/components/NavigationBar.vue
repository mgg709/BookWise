<template>
    <div class="content-bar">
        <RouterLink class="logo" to="/"><img class="nb-logo" src="../assets/main-logo.png" alt=""></RouterLink>
        <RouterLink class="selling-books-title" to="/selling">Top selling books</RouterLink>
        <RouterLink class="recommend-books-title" to="/recommendation">Recommend me a book</RouterLink>
        <input type="text" class="search-input" id="input-search" v-on:keyup.enter="submit()" placeholder="Título...">     
        <div class="login-buttons" v-if="this.$store.state.username == undefined">
            <RouterLink to="/login">
            <NormalButton textButton="Sign in"></NormalButton>
            </RouterLink>
            <RouterLink to="/signup">
            <NormalButton textButton="Sign up"></NormalButton>
            </RouterLink>
        </div>
        <div class="profile-btns" v-else>
            <RouterLink to="/review">
                <span>{{ this.$store.state.username }}</span>
                <img src="../assets/user.png" alt="Imagen de usuario">
            </RouterLink>
            <NormalButton textButton="Log out" @click="logout"></NormalButton>
        </div>
       
    </div>
</template>

<script>
import { RouterLink } from 'vue-router';
import axios from 'axios';

import NormalButton from './NormalButton.vue';
export default {
    name: "NavigationBar",
    components: {
        NormalButton
    },
    data() {
        return {
            books:[],
        }
    },
  methods: {
    redirectToLogIn() {
      this.$router.push('/login');
    },
    redirectToSellings(){
        this.$router.push('/selling');
    },
    redirectToIndex(){
        this.$router.push('/');
    },
    redirectToSignUp(){
        this.$router.push('/signup');
    },
    async searchBooks(title) {
        const {data} = await axios.get(`http://localhost:8080/search/${title}`);
        console.log(data);
        this.$store.commit('passBooks', data);
        console.log(this.$store.state.searchBooks)
    },
    submit() {
        var input = document.getElementById("input-search");
        var texto = input.value;
        this.searchBooks(texto);
        this.redirectToBookList();
    },
    redirectToBookList(){
        this.$router.push('/result');
    },
    logout(){
        localStorage.removeItem('username');
        this.$store.commit('loginUser', undefined);
    }
  },
  beforeMount(){
    this.$store.commit('loginUser', localStorage.getItem('username'));
  }
}
</script>

<style scoped>
.content-bar {
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    height: 10vh;
    padding: 0 2rem;
    color: var(--color-text);
}

.nb-logo
{
    width: 60%;
}

.selling-books-title{
    transition: all 1s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.selling-books-title:hover,
.logo:hover{
    cursor: pointer;
}

.selling-books-title:after{
    content: "";
    position: absolute;
    width: 0%;
    display: block;
    height: 2px;
    transition: all 0.5s ease-in;
} 
.selling-books-title:hover::after{
    width: 118px;
    height: 2px;
    background-color: #EB5E28;
}

.recommend-books-title{
    transition: all 1s cubic-bezier(0.075, 0.82, 0.165, 1);
    color: var(--color-text);
}

.recommend-books-title:hover{
    cursor: pointer;
}

.recommend-books-title:after{
    content: "";
    position: absolute;
    width: 0%;
    display: block;
    height: 2px;
    transition: all 0.5s ease-in;
} 
.recommend-books-title:hover::after{
    width: 160px;
    height: 2px;
    background-color: #EB5E28;
}
.search-input{
    padding: 10px 40px;
    background-image: url('../assets/search.png');
    background-position: 10px 45%;
    background-repeat: no-repeat;
    background-size: 18px;
    border: 1px solid #403D39;
    border-radius: 12px;
    box-shadow: 0px 3px 5px gray;
    width: 20vw;
}
.login-buttons {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 15%;
    height: 100%;
}
.profile-btns{
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 20%;
    height: 100%;
}

.profile-btns a{
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 50%;
    height: 100%;
    text-decoration: none;
    color: var(--color-text);
}

.profile-btns img{
    width: 15%;
}
</style>