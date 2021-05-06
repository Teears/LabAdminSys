import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/components/Login'
import MainPage from '@/components/Main'
import Nothing from '@/components/nothing'
import Student from '@/components/student'
import Teacher from '@/components/teacher'
import Statistic from '@/components/statistic'
import Message from '@/components/message'
import Super from '@/components/super'
import Lab from '@/components/lab'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes:[
    {
      path:'/',
      component:Login
    },{
      path:'/main',
      component: MainPage,
      children:[{
        path:'/main',
        component: Nothing,
      },{
        path:'/main/student',
        component: Student,
      },{
        path:'/main/teacher',
        component: Teacher,
      },{
        path:'/main/statistic',
        component: Statistic,
      },{
        path:'/main/message',
        component: Message,
      },{
        path:'/main/lab',
        component: Lab,
      },{
        path:'/main/super',
        component: Super
      }]
    }
  ]
})