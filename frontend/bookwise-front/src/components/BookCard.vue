<script setup>
import Button from "../components/Button.vue"
</script>

<template>
    <div class="container-book-card" >
        <div class="prueba" @click="redirectToBook"><img src="../assets/template-book-cover.jpeg" alt="Portada del libro" >
        <p>Interesting book title</p></div>
        
        <div class="rating-book-row">
            <input type="radio" name="star" id="star1"><label for="star1"></label>
            <input type="radio" name="star" id="star2"><label for="star2"></label>
            <input type="radio" name="star" id="star3"><label for="star3"></label>
            <input type="radio" name="star" id="star4"><label for="star4"></label>
            <input type="radio" name="star" id="star5"><label for="star5"></label>
            <span></span>
        </div>
    </div-->
    <section class="container-book-card">
        <img :src= "`src/assets/${imageName}.jpeg`" alt="Portada del libro">
        <p>Interesting book title</p>
        <section class="rating-book-row">
            <input type="radio" name="star" id="star1"><label for="star1"></label>
            <input type="radio" name="star" id="star2"><label for="star2"></label>
            <input type="radio" name="star" id="star3"><label for="star3"></label>
            <input type="radio" name="star" id="star4"><label for="star4"></label>
            <input type="radio" name="star" id="star5"><label for="star5"></label>
        </section>
        <Button textButton="Read more" @click="redirectToBook"></Button>
    </section>
</template>

<script>
export default {
  name: "BookCard",
  methods: {
    redirectToBook() {
      this.$router.push('/book');
    }
  },
  props:{
    imageName:{
        type: String,
        required: true
    }
  }
}
</script>

<style>

.prueba{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    cursor: pointer;
}

.container-book-card{
    width:100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: white;
    border-radius: 5px;
    box-shadow: 0px 0px 7px gray;
    padding: 10px 0px;
    margin:0px;*/
    max-height: 100x;
    border: 2px solid;
    display: flex;
    background-color: gray;
    flex-direction: column;
}

.container-book-card img{
    object-fit: cover;
    width: 250px;
    height: 350px;
}

.container-book-card p{
    font-size: 1.2rem;
    margin: 10px 0px;
}

.rating-book-row{
    display: flex;
    width: 100%;
    align-items: center;
    justify-content: center;
    transform: rotateY(180deg);
}

.rating-book-row input{
    display: none;
}

.rating-book-row label{
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    width: 20%;
    align-self: center;
} 

.rating-book-row label:before{
    content: "\f005";
    font-family: fontAwesome;
    position: relative;
    font-size: 20px;
    color: #101010;
}

.rating-book-row label:after{
    content: "\f005";
    font-family: fontAwesome;
    position: absolute;
    font-size: 20px;
    color: #1f9cff;
    opacity: 0;
    transition: .5s;
    text-shadow: 0 2px 5px rgba(0,0,0,.5);
}

.rating-book-row label:hover:after,
.rating-book-row label:hover ~ label:after,
.rating-book-row input:checked ~ label:after
{
    opacity: 1;
}
</style>