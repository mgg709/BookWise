import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from 'vuex'

const store = createStore({
                            state(){
                                return {searchBooks:[], recommendations:[], username: String}
                                },mutations: {
                                    passBooks(state, books){
                                        state.searchBooks = books;
                                    },
                                    recommendBooks(state, books){
                                        state.recommendations = books;
                                    },
                                    loginUser(state, username){
                                        state.username = username;
                                    }
                                },getters:{
                                    username(state){
                                        return state.username;
                                    }
                                }
                        });
const app = createApp(App)

app.use(router)
app.use(store)

app.mount('#app')