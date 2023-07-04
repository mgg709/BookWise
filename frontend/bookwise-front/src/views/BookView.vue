<script setup>
import ReviewCard from '../components/ReviewCard.vue'
</script>
<template>
    <div class="book-view-content">
      <div class="book-details">
        <div class="book-cover">
          <img src="../assets/template-book-cover.jpeg" alt="">
          <div class="book-data">
            <div class="book-titulo">
              <span>título</span>
              <button>Añadir a Favoritos</button>
            </div>
            <span>Autor</span>
            <span>Categoría</span>
            <span>Rating</span>
            <span>description</span>
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
<style>

.book-view-content{
  width: 100vw;
  display: flex;
  flex-direction: row;
  margin-top: 20px;
  align-items: center;
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
  justify-content: center;
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
  width: 50%;
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
  