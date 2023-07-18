<template>
    <div class="book-view-content">
      <div class="book-details">
        <div class="book-cover">
          <img :src=book[0].imageLink alt="a">
          <div class="book-data">
            <div class="book-titulo">
              <span>{{ book[0].title }}</span>
              <NormalButton textButton="Añadir a favoritos"></NormalButton>
            </div>
            <span>{{ book[0].author }}</span>
            <span>{{ book[0].category }}</span>
            <div class="bv-rating-book-row">
            <button class="bv-star">&#9734</button>
            <button class="bv-star">&#9734</button>
            <button class="bv-star">&#9734</button>
            <button class="bv-star">&#9734</button>
            <button class="bv-star">&#9734</button>
        </div>
            <span>{{ book[0].description }}</span>
          </div>
        </div>
        <div class="book-reviews">
            <span>Reviews</span>
            <ReviewCard />
        </div>
      </div>
      <aside class="related-books">
        <span>Related books</span>
        <img v-if="book[0].title != books[0].title" :src=this.books[0].imageLink alt="">
        <img v-if="book[0].title != books[1].title" :src=this.books[1].imageLink alt="">
        <img v-if="book[0].title != books[2].title" :src=this.books[2].imageLink alt="">
      </aside>
    </div>
</template>
<script>
import ReviewCard from '../components/ReviewCard.vue'
import NormalButton from '../components/NormalButton.vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

export default{
  name: 'BookView',
  components:{
    ReviewCard,
    NormalButton
  },
  data(){
    return{
      book: Object,
      books:[]
    }
  },
  methods: {
    async getBookByTitle(){
      const route = useRoute();
      const {data} = await axios.get(`http://localhost:8080/books/${route.params.title}`);
      this.book = data;
      console.log(this.book);      
    },
    fillStars(){
            let stars = this.book[0].stars.lowerBound.value;
            const starButtons = this.$el.querySelectorAll(".bv-rating-book-row > button")
            for(let i = 4; i >= 5-stars; i--){
                starButtons[i].innerHTML = "&#9733";
            }
        },
    async getBookByCategory(){
      const route = useRoute();
      const {data} = await axios.get(`http://localhost:8080/books/category/${route.params.title}`);
      this.books = data;
      this.books.sort(() => Math.random() - 0.5);
      console.log(this.books);
    }  
  },
  created(){
    this.getBookByTitle();
  },
  beforeMount(){
    this.getBookByCategory();
  },
  mounted(){
    this.fillStars();
  }
}
</script>
<style>

.book-view-content{
  width: 100%;
  display: flex;
  flex-direction: row;
  margin-top: 20px;
  align-items: center;
  margin-bottom: 20px;
  height: 100%;
}

.book-details{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 80%;
}

.book-cover{
  display: flex;
  margin-left: 40px;
}

.book-cover img{
  width: 45%;
}

.book-data{
  display: flex;
  flex-direction: column;
  margin-left: 30px;
}

.book-titulo{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  width: 100%;
  & span{
    margin-right: 20px;
  }
}


.book-data span:first-child{
  font-size: 35px;
}

.book-data span:nth-child(3){
  background-color: #d9d9d9;
  width: 15%;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 3px;
}

.book-reviews{
  margin-top: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.related-books{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.related-books span{
  margin-bottom: 20px;
}

.related-books img{
  width: 25%;
  margin: 10px 0px;
}

.bv-rating-book-row{
    display: flex;
    width: 100%;
    align-items: center;
    justify-content: flex-end;
    transform: rotateY(180deg);
}

.bv-star{
    font-size: 1.5rem;
    color: #ff9800;
    background-color: unset;
    border: none;
}

.related-books img{
  width: 40%;
  margin: 10px 0px;
}
</style>
  