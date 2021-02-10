import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import './theme/index.css';

Vue.use(ElementUI,{ size: 'small'});

Vue.config.productionTip = false

new Vue({
	el: '#app',
  render: h => h(App),
}).$mount('#app')
