// pages/stu_check/stu_check.js
import {wxp} from '../../utils/promise.js'

var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js')
var qqmapsdk = new QQMapWX({
  key:'5NCBZ-TZ5WF-GGRJL-JCX57-UCO3J-MSFPX'
})

Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark:0,
    queshengText:"你尚未加入任何实验室",
    rank:"12",  //签到名次
    address:'',
    turn:0,
    shuaxinAnimation:null,
    rotateAngle:1
  },

  checkin:function(){
    console.log("触发Page页面bind事件")
    const that = this
    //检查位置授权
    // wx.getSetting({
    //   success:function(res){
    //     const scopeAddress = res.authSetting["scope.userLocation"]
    //     while(scopeAddress == false){
    //       wx.openSetting({
    //         success (res) {
    //           console.log(res.authSetting)
    //         }
    //       })
    //     }
    //   }
    // })
    
    //获取腾讯逆向地址解析SDK
    that.getAddress().then(res =>{
      console.log(res)
      that.setData({
        address:res,
        turn:1
      })
    })
    console.log(this.data.turn+"data.turn<向服务器发送签到信息，向服务器获取签到名次")
  },

  getAddress:function(){
    var promise = new Promise((resolve,reject) =>{
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

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    that.getAddress().then(res =>{
      that.setData({
        address:res
      })
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
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

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})