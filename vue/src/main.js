import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import './theme/index.css'
import './assets/iconfont/iconfont.css'
import './assets/scroll.css'
import router from './router/index'
import axios from 'axios'

axios.defaults.withCredentials = true
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'
Vue.prototype.$axios = axios

Vue.use(ElementUI,{ size: 'small'});

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  render: h => h(App),
}).$mount('#app')
