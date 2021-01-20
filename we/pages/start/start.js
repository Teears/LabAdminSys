// pages/start/start.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
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
    app.userLogin().then(res =>{
      if(res == 0 || res == 1){
        wx.redirectTo({
          url: '/pages/bindId/bindId'
        })
      }else if(res == 2){
        wx.switchTab({
          url: '/pages/stu_check/stu_check',
        })
      }else if(res == 3){
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