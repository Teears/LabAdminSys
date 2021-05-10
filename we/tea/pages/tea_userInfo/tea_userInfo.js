// tea/pages/tea_userInfo/tea_userInfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl: "",
    name: "",
    sex: "",
    teaNum: "",
    phone: "",
    manageList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/mine/getUserInfo',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        that.setData({
          avatarUrl: res.data.avatarUrl,
          name: res.data.name,
          sex: res.data.sex,
          teaNum: res.data.teaNum,
          phone: res.data.phone,
          manageList: res.data.manageList
        })
      }
    })
  }
})