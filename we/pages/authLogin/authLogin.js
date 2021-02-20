// pages/authLogin/authLogin.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  getUserInfo(e) {   //授权个人信息
    console.log(e.detail);
    let detail = e.detail;
    if (detail.rawData) {
      app.globalData.encryptedData = detail.encryptedData
      app.globalData.iv = detail.iv
      app.globalData.nickName = detail.userInfo.nickName
      app.globalData.avatarUrl = detail.userInfo.avatarUrl
      wx.navigateTo({
        url: '/pages/start/start',
      })
    }
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

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

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