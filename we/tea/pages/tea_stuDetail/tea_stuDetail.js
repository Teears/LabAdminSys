// tea/pages/tea_stuDetail/tea_stuDetail.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl: "",
    name:"",
    sex:"",
    stuNum:"",
    phone:"",
    dept:"",
    major:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/getStuDetail',
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
          sex:res.data.sex,
          stuNum:res.data.stuNum,
          phone:res.data.phone,
          dept:res.data.dept,
          major:res.data.major
        })
      }
    })
  }
})