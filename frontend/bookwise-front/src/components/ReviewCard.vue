<script setup></script>
<template>
    <div class="review-card-content">
        <div class="rc-user-logo">
            <img src="../assets/user.png" alt="">
            <span>Name</span>
        </div>
        <div class="rc-separator"></div>
        <div class="rc-review-content">
            <span>Estrellas</span>
            <span>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Commodi distinctio mollitia veritatis doloribus ab voluptatibus eaque magnam blanditiis, dolorem labore aliquam eius quasi fugiat ipsum, numquam quam exercitationem necessitatibus odit.</span>
        </div>
    </div>
</template>

<style>
.review-card-content{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 70%;
    margin-top: 20px;
    box-shadow: 0px 0px 7px gray;
    padding: 30px 10px;
}

.rc-user-logo{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.rc-user-logo img{
    width: 25%;
    margin-bottom: 20px;
}

.rc-separator{
    width: 1px;
    height: 5rem;
    background-color: #cccccc;
    border-radius: 5px;
    margin-right: 30px;
}

.rc-review-content{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
    text-align: justify;
    padding-right: 40px;
}
</style>