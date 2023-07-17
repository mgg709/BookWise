<template>
    <div class="solution-content">
        <span>Our recommendation is...</span>
        <div class="solution-books" v-for="book in booksRecommended">
            <div class="s-book">
                <img :src="book.imageLink" alt="">
                <span>{{ book.title }}</span>
                <NormalButton textButton="Add to favourites"></NormalButton>
            </div>
        </div>
    </div>
    
</template>
<script>
import { mapState } from 'vuex';
import NormalButton from '../components/NormalButton.vue'
export default {
    components: {
    NormalButton
    },
    computed: mapState({
            booksRecommended() {
                return this.$store.state.recommendations;
            }
        })
}
</script>
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