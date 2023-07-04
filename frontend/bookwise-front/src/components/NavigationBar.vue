<script setup>
import Button from "../components/Button.vue"
</script>
<template>
    <div class="content-bar">
        <span class="logo" @click="redirectToIndex">logo</span>
        <span class="selling-books-title" @click="redirectToSellings">Top selling books</span>
        <span class="recommend-books-title">Recommend me a book</span>
        <input type="text" class="search-input" placeholder="Título...">     
        <div class="login-buttons">
            <Button textButton="Sign in" @click="redirectToLogIn"></Button>
            <Button textButton="Sign up" @click="redirectToSignUp"></Button>
        </div>
       
    </div>
</template>

<script>
export default {
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
    }
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
}
</style>
