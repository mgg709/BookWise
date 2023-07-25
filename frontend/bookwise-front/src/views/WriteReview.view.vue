<template>
    <div class="wr-container">
        <div class="wr-content">
            <h1>Write your review of the book </h1>
            <div class="wr-rating-book-row">
                <button
                    v-for="index in 5"
                    :key="index"
                    class="bv-star"
                    :class="{ 'bv-star-selected': rating >= index }"
                    @click="updateRating(index)" 
                >
                    &#9734
                </button>
            </div>
            <div class="wr-tittle">
                <input type="text" id="reviewTittle" placeholder="Tittle" v-model="reviewTittleText">
            </div>
            <!--div class="wr-description">
                <input type="text" id="reviewDescription" placeholder="Description" v-model="reviewDescriptionText">
                <label for="reviewDescription">Description</label>
            </div-->
            <div class="wr-description">
                <textarea id="reviewDescription" placeholder="Description" v-model="reviewDescriptionText"></textarea>
            </div>
            <NormalButton textButton="Submit" @click="addReview"></NormalButton>
        </div>
    </div>
</template>

<script>
import NormalButton from "../components/NormalButton.vue";
import axios from "axios";

export default {
    components: {
        NormalButton
    },
    data(){
        return {
            review: Object,
            rating: 0
        }
    },
    methods: {
        async addReview(){
            const aux = {
                title: this.reviewTittleText,
                description: this.reviewDescriptionText,
                assessment: this.rating,
                titlebook: this.$route.params.nombre,
                username: this.$store.state.username
            };
            console.log(aux)
            this.review = aux;
            const {data} = await axios.put(`http://localhost:8080/reviews`, this.review);
            console.log(data)
            this.redirectToBook(aux.titlebook);
        },
        updateRating(stars) {
            this.rating = stars;
        },
        fillStars(){
          let stars = this.book.stars.lowerBound.value;
          const starButtons = this.$el.querySelectorAll(".bv-rating-book-row > button")
          for(let i = 4; i >= 5-stars; i--){
              starButtons[i].innerHTML = "&#9733";
          }
        },
        redirectToBook(title) {
            this.$router.push('/book/'+title);
        }
    }
}
</script>

<style>
.wr-container {
    max-width: 37.5rem;
    width: 100%;
    min-height: 85vh;
    background-color: black;
    padding: 1.5rem 1.25rem;
    border-radius: 1rem;
    margin-inline: 2rem;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    color: white;
}

.wr-content {
    width: 18.75rem;
    text-align: center;
    margin-inline: auto;
}

.wr-content h1{
    margin-block: 1.75rem;
}

.bv-star {
  font-size: 24px;
  color: #ccc;
  border: none;
  background: transparent;
  cursor: pointer;
}

.bv-star-selected {
    font-size: 1.5rem;
    color: #ff9800;
    background-color: unset;
    border: none;
}

.wr-tittle input{
    width: 100%;
    border-radius: 0.375rem;
    background-color: transparent;
    border: 0.063rem solid #333639;
    outline: none;
    padding: 1.25rem 0.625rem;
    color:white;
    font-size: 1.125rem;
}

.wr-description textarea {
  font-size: 16px; /* Tamaño de fuente ajustable según sea necesario */
  width: 100%;
  height: 150px; /* Ajusta la altura del textarea según sea necesario */
  resize: vertical; /* Permite ajustar verticalmente el tamaño del textarea */
  padding: 10px;
  border: 0.063rem solid #333639;
  border-radius: 5px;
  box-sizing: border-box;
  background-color: transparent;
  color: white;
}
</style>