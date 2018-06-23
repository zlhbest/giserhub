import Vue from 'vue'
import Home from './App'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'font-awesome/css/font-awesome.min.css';

Vue.use(ElementUI)
/* eslint-disable no-new */
new Vue({
  el: '#home',
  template: '<Home/>',
  components: { Home }
})
