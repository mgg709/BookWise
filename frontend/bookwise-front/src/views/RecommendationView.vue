<template>
    <div class="recommendation-content">
        <span class="description">Description of the section</span>
    <div class="question">
        <span>What are your favourite categories?</span>
        <input type="checkbox" id="poetry" value="Poetry" v-model="checkedCategories">
        <label for="poetry">Poetry</label>
        <input type="checkbox" id="fiction" value="Fiction" v-model="checkedCategories">
        <label for="fiction">Fiction</label>
        <input type="checkbox" id="mystery" value="Mystery" v-model="checkedCategories">
        <label for="mystery">Mystery</label>
        <input type="checkbox" id="history" value="History" v-model="checkedCategories">
        <label for="history">History</label>
        <input type="checkbox" id="business" value="Business" v-model="checkedCategories">
        <label for="business">Business</label>
        <input type="checkbox" id="young-adult" value="Young adult" v-model="checkedCategories">
        <label for="young-adult">Young adult</label>
        <input type="checkbox" id="art" value="Art" v-model="checkedCategories">
        <label for="art">Art</label>
        <input type="checkbox" id="music" value="Music" v-model="checkedCategories">
        <label for="music">Music</label>
        <input type="checkbox" id="politics" value="Politics" v-model="checkedCategories">
        <label for="politics">Politics</label>
        <input type="checkbox" id="travel" value="Travel" v-model="checkedCategories">
        <label for="travel">Travel</label>
        <input type="checkbox" id="thriller" value="Thriller" v-model="checkedCategories">
        <label for="thriller">Thriller</label>
        <input type="checkbox" id="food" value="Food" v-model="checkedCategories">
        <label for="food">Food</label>
        <input type="checkbox" id="romance" value="Romance" v-model="checkedCategories">
        <label for="romance">Romance</label>
        <input type="checkbox" id="fantasy" value="Fantasy" v-model="checkedCategories">
        <label for="fantasy">Fantasy</label>

    </div>
    <RouterLink to="/solution"><NormalButton textButton="Recommend"></NormalButton></RouterLink>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router'
import NormalButton from '../components/NormalButton.vue'
export default{
    name: 'RecommendationView',
    components:{
        RouterLink,
        NormalButton
    }
}

</script>
<style>
.recommendation-content{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    padding-bottom: 20px;
}
.description{
    margin: 20px;
}
.question{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    border: 2px solid #ff9153 ;
    padding: 20px;
    border-radius: 7px;
    & span{
        margin-bottom: 20px;
    }
    margin-bottom: 30px;
}
</style>