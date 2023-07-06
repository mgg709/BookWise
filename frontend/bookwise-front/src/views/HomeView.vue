<template>
 <div class="container-home">
  <div id="parallelogram-left">
    <div class="text-banner-home">
      <span>FIND YOUR FAVOURITES</span>
      <span>BOOKS</span>
    </div>
    <div id="parallelogram-right">
      <img src="../assets/banner-bg.jpeg" alt="">
    </div>
  </div>
  <div class="book-list">
    <span v-for="book in books">
      <BookCard :book=book widthSize="100%" class="book-card"></BookCard>
    </span>
    
  </div>
  <NormalButton id="load-more" textButton="Load more" @click="loadMore"></NormalButton>
</div>

</template>
<script>
import BookCard from '../components/BookCard.vue'
import NormalButton from '../components/NormalButton.vue'
import axios from 'axios'

export default {
  name: "HomeView",
  components: {
    BookCard,
    NormalButton
  },
  data(){
    return{
      books:[],
      counter:0
    }
  },
  methods:{
    async loadMore(){
      const data = await axios.get(`http://localhost:8080/api/books/getTwentyBooks/${this.counter}`);
      console.log(data);
      data.data.content.forEach(element => {
        this.books.push(element);
      });
      this.counter++;
    }
  },
  mounted(){
    this.loadMore()
    console.log(this.books);
  }
}
</script>
<style>
.container-home{
    overflow:hidden;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width:100%;
}
#parallelogram-right {
    display: flex;
    width: 100%;
    height: 50vh;

    overflow:hidden;
    position:relative;
    clip-path: polygon(60% 0%, 100% 0, 100% 50%, 100% 100%, 40% 100%);
    align-self: flex-end;
    justify-content: flex-end;
    /* background-image: url('../assets/banner-bg.jpeg');
    background-size: 70% 100%;
    background-position: right;
    background-repeat: no-repeat; */
}

#parallelogram-right::before{
  content: "";
  width: 100%;
  height: 100%;
  background: linear-gradient(to right, var(--color-orange-dark) 50%, var(--color-orange-light) 100%);
  position: absolute;
  mix-blend-mode: hard-light;
  right: 0;
}

#parallelogram-right img{
  width: 60%;
  height: 100%;
  object-fit: cover;
  display: block;
}

#parallelogram-left {
  display: flex;
  width: 100%;
  height: 50vh;
  background: var(--color-black-light);
  overflow:hidden;
  position:relative;
}

.text-banner-home{
  color: white;
  font-size: 60px;
  position: absolute;
  top: 15%;
  left: 5%;
  display: flex;
  flex-direction: column;
}

.text-banner-home span:nth-child(2){
  font-size: 120px;
  color: var(--color-orange-dark);
}

.book-list{
  margin: 50px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 100px;
}


.footer{
  width: 100%;
  text-align: center;
}

#load-more{
  margin-bottom: 15px;
}

</style>