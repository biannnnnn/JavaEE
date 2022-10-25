import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import HomeView from '../views/HomeView'
import FruitView from '../views/FruitView'
import ContractView from '../views/ContractView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'LoginView',
    component: LoginView
  },
  {
    path: '/RegisterView',
    name: 'RegisterView',
    component: RegisterView
  },
  {
    path: '/HomeView',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/FruitView',
    name: 'FruitView',
    component: FruitView
  },
  {
    path: '/ContractView',
    name: 'ContractView',
    component: ContractView
  }
]

const router = new VueRouter({
  routes
})

export default router
