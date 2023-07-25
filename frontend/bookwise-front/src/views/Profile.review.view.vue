<template>
    <Header imageName="user"></Header>
    <div class="review-profile" id="section1">
        <div v-for="review in reviews">
            <ReviewCard :review = review></ReviewCard>
        </div>
    </div>
</template>

<script>
import Header from "../components/ProfileHeader.vue"
import ReviewCard from "../components/ReviewCard.vue"
import Footer from "../components/Footer.vue"
import axios from 'axios';
export default {
    components: {
        Header,
        ReviewCard,
        Footer
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
Footer{
    width: 100%;
    text-align: center;
}
</style>