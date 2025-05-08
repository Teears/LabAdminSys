// pages/stu_check/stu_check.js
import {wxp} from '../../utils/promise.js'

const app = getApp()
var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js')
var qqmapsdk = new QQMapWX({
  key:'5NCBZ-TZ5WF-GGRJL-JCX57-UCO3J-MSFPX'
})

Page({

  /**
   * 页面的初始数据
   */
  data: {
    cardId:1,
    queshengMark:0,
    queshengText:"你尚未加入任何实验室",
    rank:"0",  //签到名次
    address:'',
    turn_in:0,
    turn_out:0,
    shuaxinAnimation:null,
    rotateAngle:1
  },

  checkinSetData:function(res){
    wx.setStorageSync('rank', res.data.rank)
      this.setData({
        rank:res.data.rank,
        turn_in:1
    })
  },
  checkoutSetData:function(){
      this.setData({
        turn_out:1
    })
  },
    /* 
    签到点击事件监听函数
  */
  checkin:function(){
    console.log("checkin")
    if(this.data.turn_in == 1){
      return
    }
    this.check('checkin',this.checkinSetData)
  },

  checkout:function(){
    console.log("checkout")
    if(this.data.turn_out == 1){
      return
    }
    this.check('checkout',this.checkoutSetData)
  },
  check:function(checkurl,func){
    const that = this
    //检查位置授权
    wxp.getSetting().then(res=>{
      const scopeAddress = res.authSetting["scope.userLocation"]
      if(scopeAddress == true || scopeAddress == undefined){
        console.log("if auth")
        //如果已授权，获取地址信息
        that.getAddress().then(res =>{
           that.setData({
            address:res
          })
        }).then((res)=>{
          console.log("---------签到request----------")
          wxp.request({
            method:"POST",
            url: app.globalData.host+'/stu/check/'+checkurl,
            header:{
              "content-type":"application/x-www-form-urlencoded",
              'token': wx.getStorageSync('token')
            },
            timeout:10000,
            data:{
              address:that.data.address
            },
            success:function(res){
              res = res.data
              func(res)
            },
            fail:function(){
              wx.showToast({
                title: '网络繁忙',
                icon:"none",
                duration: 2000
              })
            }
          })
        })
      }else{
        // 引导授权
        console.log("if not auth")
        wx.openSetting()
      }
    })
  },

  /* 
    获取当前位置Promise化函数
  */
  getAddress:function(){
    var promise = new Promise((resolve,reject) =>{
      //获取腾讯逆向地址解析SDK
      qqmapsdk.reverseGeocoder({
        poi_options:'policy=2',
        success: function(res){
          const address = res.result.address_component.province+res.result.address_component.city+res.result.formatted_addresses.recommend
          console.log("获取当前定位:"+address)
          resolve(address)
        },
        fail:function(err){
          console.log(err)
          reject("getAddress failed")
        }
      })
    })
    return promise
  },

  /* 
    刷新按钮事件监听函数
  */
  shuaxinTap:function(){
    const that = this
    var animation = wx.createAnimation({
      duration:300
    })
    animation.rotate(this.data.rotateAngle*240).step()
    that.setData({shuaxinAnimation: animation.export()})
    that.setData({rotateAngle: this.data.rotateAngle+1})
    this.getAddress().then(res=>{
      this.setData({
        address:res
      })
    })
  },

  initPage:function(){
    const that = this
    var promise = new Promise((resolve,reject) =>{
      wx.request({
        url: app.globalData.host+'/stu/check/load',
        method:"GET",
        "header": {
          "content-type":"application/json; charset=utf-8",
          "token":wx.getStorageSync('token')
        },
        timeout:10000,
        success:function(res){
          res = res.data
          console.log(res)
          that.setData({
            cardId:res.data.checkinORout,
            queshengMark:res.data.queshengMark,
            turn_in:res.data.turn_in,
            turn_out:res.data.turn_out,
            queshengText:res.data.msg,
          })
          return resolve(1)
        },
        fail:function(){
          return reject()
        }
      })
    })
    return promise
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    this.initPage().then(res=>{
      if(res==1){
        that.getAddress().then(res =>{
          that.setData({
            address:res,
            rank:wx.getStorageSync('rank')
          })
        })
      }else{
        that.setData({
          queshengMark:1,
          queshengText:"系统出错了..."
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
        })
      }
  },

})