import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import './theme/index.css'
import './assets/iconfont/iconfont.css'
import './assets/scroll.css'
import router from './router/index'
import axios from 'axios'
import {post,get} from "./http.js"
import ECharts from 'vue-echarts'

Vue.component('v-chart', ECharts)

axios.defaults.withCredentials = true
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'
Vue.prototype.$axios = axios
Vue.prototype.$post=post
Vue.prototype.$get=get

Vue.use(ElementUI,{ size: 'small'});

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  render: h => h(App),
}).$mount('#app')
