<template>
    <div class="solution-content">
        <span>Our recommendation is...</span>
        <div class="solution-books">
            <div class="s-book">
                <img src="../assets/template-book-cover.jpeg" alt="">
                <span>TITLE</span>
                <button>Add to favourites</button>
            </div>
            <div class="s-book">
                <img src="../assets/template-book-cover.jpeg" alt="">
                <span>TITLE</span>
                <button>Add to favourites</button>
            </div>
            <div class="s-book">
                <img src="../assets/template-book-cover.jpeg" alt="">
                <span>TITLE</span>
                <button>Add to favourites</button>
            </div>
        </div>
    </div>
    
</template>
<script></script>
<style>
.solution-content{
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    & span{
        margin: 50px
    }
}
.solution-books{
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 100%;
}
.s-book{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    & img{
        width: 50%;
    }
}
</style>