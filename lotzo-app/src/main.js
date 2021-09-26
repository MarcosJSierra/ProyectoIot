import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import axiosSetUp from './axios';

Vue.config.productionTip = false

axiosSetUp();

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
