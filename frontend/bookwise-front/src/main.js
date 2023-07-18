import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from 'vuex'

const store = createStore({
                            state(){
                                return {searchBooks:[], recommendations:[]}
                                },mutations: {
                                    passBooks(state, books){
                                        state.searchBooks = books;
                                    },
                                    recommendBooks(state, books){
                                        state.recommendations = books;
                                    }
                                }
                        });
const app = createApp(App)

app.use(router)
app.use(store)

app.mount('#app')
