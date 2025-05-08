// pages/start/start.js
import {wxp} from '../../utils/promise.js'

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    backgroundImgUrl:app.globalData.backgroundImgUrl
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this
    wxp.getSetting().then(res=>{
      const scopeUserinfo = res.authSetting["scope.userInfo"]
      console.log(scopeUserinfo)
      if(scopeUserinfo != true){
      // if(app.globalData.avatarUrl == ''){
        wx.navigateTo({
          url: '/pages/authLogin/authLogin',
        })
      }else{
        that.jumppage()
      }
    })
  },

  jumppage:function(){
    app.userLogin().then(res =>{
      if(res == 0){
        wx.redirectTo({
          url: '/pages/bindId/bindId'
        })
      }else if(res == 1){
        wx.switchTab({
          url: '/pages/stu_check/stu_check',
        })
      }else if(res == 2){
        wx.switchTab({
          url: '/pages/tea_manage/tea_manage',
        })
      }else{
        console.log("身份校验出错")
      }
    })
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

})