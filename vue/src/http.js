import {getCookie} from './cookie';
import axios from 'axios';
axios.defaults.timeout = 5000; //超时终止请求
import router from './router/index'


//http request 拦截器
axios.interceptors.request.use(
  config => {
    config.data = JSON.stringify(config.data);
    config.headers = {
      'Content-Type':'application/json;charset=UTF-8' 
    }
    var token =  getCookie("token")
    if(token){
      config.headers.token = token
    }
    return config;
  },
  error => {
    return Promise.reject(error)
  }
);
 
//http response 拦截器
axios.interceptors.response.use(
  response => {
    if(response.data.statusCode == -200){
      router.replace("/")
    }
    return response;
  },
  error => {
    return Promise.reject(error)
  }
)
 
 
/**
 * 封装get方法
 * @param url
 * @param data
 * @returns {Promise}
 */
 
export function get(url,data = {}){
  return new Promise((resolve,reject) => {
    axios.post(url,data)
      .then(response => {
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}
 
/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */
 
export function post(url,data = {}){
  return new Promise((resolve,reject) => {
    axios.post(url,data)
      .then(response => {
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}