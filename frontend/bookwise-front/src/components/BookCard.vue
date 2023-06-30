<script setup></script>

<template>
    <div class="container-book-card" @click="redirectToBook">
        <img src="../assets/template-book-cover.jpeg" alt="Portada del libro">
        <p>Interesting book title</p>
        <div class="rating-book-row">
            <input type="radio" name="star" id="star1"><label for="star1"></label>
            <input type="radio" name="star" id="star2"><label for="star2"></label>
            <input type="radio" name="star" id="star3"><label for="star3"></label>
            <input type="radio" name="star" id="star4"><label for="star4"></label>
            <input type="radio" name="star" id="star5"><label for="star5"></label>
            <span></span>
        </div>
    </div>
</template>

<script>
export default {
  methods: {
    redirectToBook() {
      this.$router.push('/book');
    }
  }
}
</script>

<style>

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
    margin:0px;
}

.container-book-card img{
    width: 60%;
    border-radius: 5px;
    padding-top: 20px;
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