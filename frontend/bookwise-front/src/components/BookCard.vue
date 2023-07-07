<template>
    <div class="container-book-card" :style="{width: widthSize}">
        <img :src="book.imageLink" alt="Portada del libro" @click="redirectToBook">
        <p>{{ book.title }}</p>
        <div class="rating-book-row">
            <button class="star">&#9734</button>
            <button class="star">&#9734</button>
            <button class="star">&#9734</button>
            <button class="star">&#9734</button>
            <button class="star">&#9734</button>
        </div>
    </div>
</template>
<script>
export default {
    name: "BookCard",
    props: {
        book: {
            type: Object,
            default: () => {}
        },
        widthSize: {
            type: String,
            default: "100%"
        },
    },
    methods: {
        redirectToBook() {
        this.$router.push('/book');
        },
        fillStars(){
            let stars = this.book.stars.lowerBound.value;
            const starButtons = this.$el.querySelectorAll(".rating-book-row > button")
            for(let i = 4; i >= 5-stars; i--){
                starButtons[i].innerHTML = "&#9733";
            }
        }
    },
    mounted(){
        this.fillStars();
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
    max-height: 100x;
    border: 2px solid gray;
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