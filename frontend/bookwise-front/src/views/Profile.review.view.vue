<template>
    <Header imageName="user"></Header>
    <div class="p-reviews" id="section1">
        <div class="p-review" v-for="review in reviews">
            <ReviewCard :review = review class="p-space"></ReviewCard>
            <NormalButton textButton="Remove review" @click="removeReview(review)"></NormalButton>
        </div>
    </div>
</template>

<script>
import Header from "../components/ProfileHeader.vue"
import ReviewCard from "../components/ReviewCard.vue"
import Footer from "../components/Footer.vue"
import NormalButton from "../components/NormalButton.vue";
import axios from 'axios';
export default {
    components: {
        Header,
        ReviewCard,
        Footer,
        NormalButton
    },
    data(){
        return{
            reviews: []
        }
    },
    methods: {
        async getReviews(){
            const {data} = await axios.get(`http://localhost:8080/reviews/user/${localStorage.getItem('username')}`);
            console.log(data);
            this.reviews = data;
        },
        async removeReview(review){
            const {data} = await axios.delete(`http://localhost:8080/reviews?username=${this.$store.state.username}&bookTitle=${review.titlebook}&reviewTitle=${review.title}`);
            this.reviews.splice(this.reviews.indexOf(review), 1);
        }
    },
    beforeMount(){
        this.getReviews();
    }

}
</script>

<style>
.review-profile{
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    margin-bottom: 30px;
}

.p-reviews{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
}

.p-review{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.p-space{
    margin-bottom: 20px;
}
</style>