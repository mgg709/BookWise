<template>
    <div class="review-card-content">
        <div class="rc-user-logo">
            <img src="../assets/user.png" alt="">
            <p>{{review.username}}</p>
        </div>
        <div class="rc-separator"></div>
        <div class="rc-review-content">
            <div class="rating-review-row">
                <button class="star">&#9734</button>
                <button class="star">&#9734</button>
                <button class="star">&#9734</button>
                <button class="star">&#9734</button>
                <button class="star">&#9734</button>
            </div>
            <span class="title-review">{{ review.title }}</span>
            <span class="description-review">{{ review.description }}</span>
        </div>
    </div>
</template>

<script>
import { RouterView } from 'vue-router';


export default {
    name: "Review",
    props: {
        review: {
            type: Object,
            default: () => {}
        }
    },
    methods: {
        fillStars(){
            let stars = this.review.assessment;
            const starButtons = this.$el.querySelectorAll(".rating-review-row > button")
            for(let i = 4; i >= 5-stars; i--){
                starButtons[i].innerHTML = "&#9733";
            }
        }
    },
    mounted() {
        this.fillStars();
    }
}
</script>

<style>
.review-card-content{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 70%;
    margin-top: 20px;
    box-shadow: 0px 0px 7px gray;
    padding: 30px 10px;
    min-width: 50rem;
}

.rc-user-logo{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.rc-user-logo img{
    width: 10%;
    margin-bottom: 20px;
}

.rc-separator{
    width: 1px;
    height: 5rem;
    background-color: #cccccc;
    border-radius: 5px;
    margin-right: 30px;
}

.rc-review-content{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
    text-align: justify;
    padding-right: 40px;
    width: 85%;
}
.rating-review-row{
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
.title-review{
    color: black;
    font-weight: bold;
}
</style>