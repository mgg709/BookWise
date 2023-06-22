<script setup></script>

<template>
    <div class="container-book-card">
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

<style>

.container-book-card{
    width:15%;
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
}

.rating-book-row input{
}

.rating-book-row label{
    display: block;
    cursor: pointer;
    width: 20%;
    background: #ccc;
} 

.rating-book-row label::before{
     
}
</style>