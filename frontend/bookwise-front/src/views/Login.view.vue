<template>
    <div class="container">
    <div class="content">
        <h1>Log in to BookWise</h1>
        <div class="action-buttons">
            <button class="primary-button sign-in-button">
                <object data="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"></object>
                <span>Sign in with google</span>
            </button>
            <button class="primary-button sign-in-button">
                <object data="https://upload.wikimedia.org/wikipedia/commons/b/b8/2021_Facebook_icon.svg"></object>
                <span>Sign in with Facebook</span>
            </button>
        </div>

        <div class="divider">
            <p>or</p>
        </div>

        <div class="email-log-in">
            <input type="text" id="log-in" placeholder="Username" v-model="username">
            <label for="log-in">Username</label>
        </div>

        <div class="password-log-in">
            <input type="password" id="pass-log-in" placeholder="Password" v-model="password">
            <label for="pass-log-in">Password</label>
        </div>

        <div class="action-buttons">
            <button class="primary-button" @click="signIn(username, password)">Next</button>
            <button class="secondary-button">Forgot password?</button>
        </div>
    </div>
    <div class="sign-up">
        <p>Don't have an account? <a href="signup">Sign up</a></p>
    </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: "LoginView",
    data(){
        return{
            username: '',
            password: ''
        }
    },
    methods: {
        redirectToSignUp(){
        this.$router.push('/signup');
        },
        signIn(user, pass){
            axios.post(`http://localhost:8080/login?user=${user}&password=${pass}`).then
            (data => {
            localStorage.setItem('username', data.data);
            this.$store.commit('loginUser', localStorage.getItem('username'));
            this.$router.push("/");
            }
            ).catch(error => {
            console.log(error);
            });
        }
    }
}
</script>

<style>
.container{
    max-width: 37.5rem;
    width: 100%;
    min-height: 85vh;
    background-color: black;
    padding: 1.5rem 1.25rem;
    border-radius: 1rem;
    margin-inline: 2rem;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    color: white;
}

.content{
    width: 18.75rem;
    text-align: center;
    margin-inline: auto;
}

.content h1{
    margin-block: 1.75rem;
}

.action-buttons{
    display: flex;
    flex-direction: column;
    gap: 1.5rem;
    margin-top: 2.25rem;
}

.primary-button,
.secondary-button{
    width: 100%;
    border-radius: 1.25rem;
    padding: 0.5rem 0;
    font-size: 0.938rem;
    font-weight: 500;
}

.primary-button{
    background-color: #fff;
    color: #0f1419;
}

.primary-button:hover{
    background-color: #e6e6e6;
}

.secondary-button{
    background-color: transparent;
    color: #fff;
    border: 0.063rem solid #536471;
}

.secondary-button:hover{
    background-color: #181919;
}

.sign-in-button{
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 0.5rem;
}

.sign-in-button object{
    width: 1.5rem;
    height: 1.5rem;
}

input::placeholder{
    opacity: 0;
}

input + label{
    position: absolute;
    top: 1.25rem;
    left: 0.625rem;
    color: #71767b;
    font-size: 1.125rem;
    pointer-events: none;
    transition: 200ms ease;
}

input:focus{
    outline: 0.063rem solid #1d9bf0;
}

input:focus + label{
    color: #1d9bf0;
}

input:not(:placeholder-shown) + label,
input:focus + label{
    top: 0.375rem;
    left: 0.625rem;
    font-size: 0.75rem;
}

.sign-up{
    margin-top: 2rem;
    font-weight: 300;
    text-align: center;
}

.sign-up a{
    color:#1d9bf0;
}

.sign-up a:hover{
    text-decoration: underline;
    text-decoration-color: #1d9bf0;
}

.divider{
    width: 100%;
    margin-block: 1.25rem;
    position: relative;
}

.divider p::before,
.divider p::after{
    content: "";
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 45%;
    height: 0.063rem;
    background-color: #333639;
}

.divider p::before{
    left: 0;
}

.divider p::after{
    right: 0;
}

.email-log-in,
.password-log-in{
    width: 100%;
    position: relative;
}

.email-log-in input,
.password-log-in input{
    width: 100%;
    border-radius: 0.375rem;
    background-color: transparent;
    border: 0.063rem solid #333639;
    outline: none;
    padding: 1.25rem 0.625rem;
    color:white;
    font-size: 1.125rem;
}
</style>