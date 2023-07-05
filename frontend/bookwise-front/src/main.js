import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import NormalButton from './components/NormalButton.vue'

const app = createApp(App)

app.use(router)
app.component('NormalButton', NormalButton)
app.mount('#app')
