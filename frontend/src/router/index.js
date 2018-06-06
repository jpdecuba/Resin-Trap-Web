import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import PageNotFound from '@/components/NotFound'
import Login from '@/components/Login'
import Account from '@/components/Account'
import Admin from '@/components/Admin'
import Register from '@/components/Register'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/Account',
      name: 'Account',
      component: Account
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Admin',
      name: 'Admin',
      component: Admin
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register
    },
    { path: "*", component: PageNotFound }
  ]
})
