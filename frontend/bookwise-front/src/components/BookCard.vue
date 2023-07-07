<template>
    <div class="container-book-card" :style="{width: widthSize}">
        <img :src="book.imageLink" alt="Portada del libro" @click="redirectToBook(book.title)">
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
        redirectToBook(title) {
        this.$router.push('/book/'+title);
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
.star{
    font-size: 1.5rem;
    color: #ff9800;
    background-color: unset;
    border: none;
}
</style>