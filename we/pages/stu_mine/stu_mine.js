// pages/stu_mine/stu_mine.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl:"",
    stuName:"",
    belong:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      avatarUrl:wx.getStorageSync('avatarUrl'),
      stuName:wx.getStorageSync('userName'),
      belong:wx.getStorageSync('belong')
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 2
        })
      }
  },
})