<template>
    <span class="description">Description of the section</span>
    <div class="question">
        <span>What are your favourite genres?</span>
        <input type="text">
    </div>
    <RouterLink to="/solution"><button>Recommend</button></RouterLink>
</template>
<script>
</script>
<style>
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
</style>