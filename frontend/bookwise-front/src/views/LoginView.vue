<template>
    <div class="form-body">
        <p>Welcome</p>
        <form class="login-form">
            <input class="input" type="text" placeholder="Email or username">
            <input class="input" type="password" placeholder="Password">
            <Button textButton="Submit"></Button>
        </form>
    </div>
</template>
<script>
import NormalButton from "../components/NormalButton.vue"

export default {
    name: "LoginView",
    components: {
        NormalButton,
    }
}
</script>
<style>
*{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

template{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: var(--color-black-light);
}

.form-body{
    width: 400px;
    min-width: 300px;
    border-radius: 10px;
    border-top-left-radius: 50px;
    border-bottom-right-radius: 50px;
    border: solid 1px;
    margin:10px;
}

p{
    text-align: center;
    font-weight: 600;
    color: white;
    margin-bottom: 25px;
}

.input{
    display: block;
    margin: auto;
    height: 40px;
    width: 75%;
    padding-left: 10px;
    color:white;
    border: 1px solid white;
    border-radius: 2px;
    background-color: transparent;
    border-top-left-radius: 10px;
    border-bottom-right-radius: 10px;
    font-size: 1rem;
    outline: none;
}

.input[type="password"]{
    margin-top: 20px;
}

.input:hover{
    transition: .5s;
    border:1px solid;
}

form button{
    display: block;
    margin: auto;
    margin-top: 25px;
    margin-bottom: 30px;
    height: 40px;
    width: 78%;
    border-radius: 2px;
    cursor: pointer;
    outline: none;
    transition: all .5s ease;
}
</style>