<template>
    <div class="recommendation-content">
        <span class="description">Description of the section</span>
    <div class="question">
        <span>What are your favourite categories?</span>
        <div class="question-inputs-1">
            <div class="row">
                <input type="checkbox" id="poetry" value="Poetry" v-model="checkedCategories">
                <label for="poetry">Poetry</label>
                <input type="checkbox" id="fiction" value="Fiction" v-model="checkedCategories">
                <label for="fiction">Fiction</label>
                <input type="checkbox" id="mystery" value="Mystery" v-model="checkedCategories">
                <label for="mystery">Mystery</label>
                <input type="checkbox" id="history" value="History" v-model="checkedCategories">
                <label for="history">History</label>
            </div>
            <div class="row">
                <input type="checkbox" id="business" value="Business" v-model="checkedCategories">
                <label for="business">Business</label>
                <input type="checkbox" id="young-adult" value="Young adult" v-model="checkedCategories">
                <label for="young-adult">Young adult</label>
                <input type="checkbox" id="art" value="Art" v-model="checkedCategories">
                <label for="art">Art</label>
                <input type="checkbox" id="music" value="Music" v-model="checkedCategories">
                <label for="music">Music</label>
            </div>
            <div class="row">
                <input type="checkbox" id="politics" value="Politics" v-model="checkedCategories">
                <label for="politics">Politics</label>
                <input type="checkbox" id="travel" value="Travel" v-model="checkedCategories">
                <label for="travel">Travel</label>
                <input type="checkbox" id="thriller" value="Thriller" v-model="checkedCategories">
                <label for="thriller">Thriller</label>
                <input type="checkbox" id="food" value="Food" v-model="checkedCategories">
                <label for="food">Food</label>
            </div>
            <div class="row">
                <input type="checkbox" id="romance" value="Romance" v-model="checkedCategories">
                <label for="romance">Romance</label>
                <input type="checkbox" id="fantasy" value="Fantasy" v-model="checkedCategories">
                <label for="fantasy">Fantasy</label>
                <input type="checkbox" id="fantasy" value="Fantasy" v-model="checkedCategories">
                <label for="fantasy">Fantasy</label>
                <input type="checkbox" id="fantasy" value="Fantasy" v-model="checkedCategories">
                <label for="fantasy">Fantasy</label>
            </div>
        </div>
    </div>
    <div class="question">
            <span>What was the last book you enjoyed?</span>
            <input type="text" v-model="title">
    </div>
    <div class="question">
        <span>How many days a week are you going to read?</span>
        <div class="question-inputs-3">
            <div class="column">
                <input type="radio" id="one" value=1 v-model="picked">
                <label for="one">1</label> 
            </div>
            <div class="column">
                <input type="radio" id="one" value=2 v-model="picked">
                <label for="one">2</label>
            </div>
            <div class="column">
                <input type="radio" id="one" value=3 v-model="picked">
                <label for="one">3</label> 
            </div>
            <div class="column">
                <input type="radio" id="one" value=4 v-model="picked">
                <label for="one">+3</label> 
            </div> 
        </div>
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
    },
    data(){
        return{
            picked: int,
            checkedCategories:[],
            title: String
        }
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

.question-inputs-1{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.row{
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        gap: 20px;
        margin: 20px 0px;
}

.question-inputs-3{
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 20px;
}

.column{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 5px;
}

</style>