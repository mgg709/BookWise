<template>
    <div class="book-view-content">
      <div class="book-details">
        <div class="book-cover">
          <img :src=book[0].imageLink alt="">
          <div class="book-data">
            <div class="book-titulo">
              <span>{{ book[0].title }}</span>
              <NormalButton textButton="Añadir a favoritos"></NormalButton>
            </div>
            <span>{{ book[0].author }}</span>
            <span>{{ book[0].category }}</span>
            <span>{{ book[0].stars.lowerBound.value }}</span>
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
        <img src="../assets/template-book-cover.jpeg" alt="">
        <img src="../assets/template-book-cover.jpeg" alt="">
      </aside>
    </div>
</template>
<script>
import ReviewCard from '../components/ReviewCard.vue'
import NormalButton from '../components/NormalButton.vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

export default{
  components:{
    ReviewCard,
    NormalButton
  },
  data(){
    return{
      book: Object,
    }
  },
  methods: {
    async getBook(){
      const route = useRoute();
      const {data} = await axios.get(`http://localhost:8080/api/books/${route.params.title}`);
      this.book = data;
      console.log(this.book);
    }
  },
  mounted(){
    this.getBook()
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

</style>
  