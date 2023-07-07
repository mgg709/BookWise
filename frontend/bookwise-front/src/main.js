import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from 'vuex'

const store = createStore({
                            state(){
                                return {searchBooks:[]}
                                },mutations: {
                                    passBooks(state, books){
                                        state.searchBooks = books;
                                    }
                                }
                        });
const app = createApp(App)

app.use(router)
app.use(store)

app.mount('#app')
