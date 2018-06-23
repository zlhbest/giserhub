import Vue from 'vue'
import Login from './App'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'font-awesome/css/font-awesome.min.css';
import axios from 'axios';

Vue.prototype.$http = axios

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#login',
  template: '<Login/>',
  components: { Login }
})
