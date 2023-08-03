<template>
    <div class="su-container">
    <div class="su-content">
        <h1>Sign-Up to BookWise</h1>
        <div class="action-buttons">
            <button class="primary-button sign-in-button">
                <object data="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"></object>
                <span>Use google</span>
            </button>
            <button class="primary-button sign-in-button">
                <object data="https://upload.wikimedia.org/wikipedia/commons/b/b8/2021_Facebook_icon.svg"></object>
                <span>Use Facebook</span>
            </button>
        </div>

        <div class="divider">
            <p>or</p>
        </div>

        <div class="email-log-in">
            <input class="su-input" type="text" id="log-in" placeholder="Email" v-model="email">
            <label for="log-in">Email</label>
        </div>

        <div class="username-log-in">
            <input class="su-input" type="text" id="user-log-in" placeholder="Username" v-model="username">
            <label for="user-log-in">Username</label>
        </div>

        <div class="password-log-in">
            <input class="su-input" type="password" id="pass-log-in" placeholder="Password" v-model="password">
            <label for="pass-log-in">Password</label>
        </div>

        <div class="repeat-password-log-in">
            <input class="su-input" type="password" id="rep-pass-log-in" placeholder="Repeat Password" v-model="repeatPassword">
            <label for="rep-pass-log-in">Repeat Password</label>
        </div>

        <div class="action-buttons">
            <button class="primary-button" @click="signUp">Sign-Up</button>
        </div>
    </div>
    <div class="sign-up">
        <p>Already have an account? <RouterLink to="/login">Sign in</RouterLink></p>
    </div>
    </div>
</template>

<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';
export default {
    name: "LoginView",
    data() {
        return {
            email: "",
            username: "",
            password: "",
            repeatPassword: ""
        };
    },
    methods: {
        async signUp() {
            if (this.password === this.repeatPassword) {
                const { data } = await axios.post(`http://localhost:8080/signup?username=${this.username}&password=${this.password}&mail=${this.email}`, { withCredentials: true });
                this.$router.push('/login');
            }
            else {
                alert("Passwords do not match!");
            }
        }
    },
    components: { RouterLink }
}
</script>

<style>
.su-container{
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

.su-content{
    width: 18.75rem;
    text-align: center;
    margin-inline: auto;
}

.su-content h1{
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

.su-input::placeholder{
    opacity: 0;
}

.su-input + label{
    position: absolute;
    top: 1.25rem;
    left: 0.625rem;
    color: #71767b;
    font-size: 1.125rem;
    pointer-events: none;
    transition: 200ms ease;
}

.su-input:focus{
    outline: 0.063rem solid #1d9bf0;
}

.su-input:focus + label{
    color: #1d9bf0;
}

.su-input:not(:placeholder-shown) + label,
.su-input:focus + label{
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
.username-log-in,
.password-log-in,
.repeat-password-log-in{
    width: 100%;
    position: relative;
}

.email-log-in input,
.username-log-in input,
.password-log-in input,
.repeat-password-log-in input{
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