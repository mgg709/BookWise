<script setup>
import BookCard from '../components/BookCard.vue'
import Footer from '../components/Footer.vue'
import Button from "../components/Button.vue"
</script>

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
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
  </div>
  <div class="book-list">
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
  </div>
  <div class="book-list">
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
  </div>
  <div class="book-list">
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
  </div>
  <div class="book-list">
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
    <BookCard imageName="template-book-cover"></BookCard>
  </div>
  <Button id="load-more" textButton="Load more"></Button>
</div>
<Footer class="footer"></Footer>
</template>

<style>
.container-home{
    overflow:hidden;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100vw;
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
  width: 55%;
  height: 100%;
  object-fit: cover;
}

#parallelogram-left {
  display: flex;
  width: 100%;
  height: 45vh;
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
  margin-top: 50px;
  margin-bottom: 50px;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}

.footer{
  width: 100%;
  text-align: center;
}

#load-more{
  margin-bottom: 15px;
}
</style>