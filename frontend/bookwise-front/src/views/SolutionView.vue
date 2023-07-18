<template>
    <div class="solution-content">
        <span>Our recommendation is...</span>
        <div class="solution-books" >
            <div class="s-book" v-for="book in booksRecommended">
                <BookCard :book="book" class="space"></BookCard>
                <NormalButton textButton="Add to favourites"></NormalButton>
            </div>
        </div>
    </div>
    
</template>
<script>
import { mapState } from 'vuex';
import NormalButton from '../components/NormalButton.vue'
import BookCard from '../components/BookCard.vue'
export default {
    components: {
        BookCard,
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
}

.s-book .space{
    margin-bottom: 20px;
}


</style>