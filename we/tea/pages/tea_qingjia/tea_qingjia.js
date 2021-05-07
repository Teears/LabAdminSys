// tea/pages/tea_qingjia/tea_qingjia.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dayOffList:[]
  },

  agree(e){
    const that = this
    var index = e.currentTarget.dataset.index
    wx.request({
      // url: app.globalData.host + '/tea/qingjia/agree?id='+that.data.dayOffList[inedx].id,
      url: app.globalData.host + '/tea/qingjia/agree',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        if(res.data.statusCode != 200){
          return
        }
        var str = 'dayOffList['+index+'].isPass'
        this.setData({
          [str]:1
        })
      }
    })
  },
  refuse(e){
    const that = this
    var index = e.currentTarget.dataset.index
    wx.request({
      // url: app.globalData.host + '/tea/qingjia/refuse?id='+that.data.dayOffList[inedx].id,
      url: app.globalData.host + '/tea/qingjia/refuse',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        if(res.data.statusCode != 200){
          return
        }
        var str = 'dayOffList['+index+'].isPass'
        this.setData({
          [str]:0
        })
      }
    })
  },
  reverse(e){
    const that = this
    var index = e.currentTarget.dataset.index
    wx.request({
      // url: app.globalData.host + '/tea/qingjia/reverse?id='+that.data.dayOffList[inedx].id,
      url: app.globalData.host + '/tea/qingjia/reverse',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        if(res.data.statusCode != 200){
          return
        }
        var str = 'dayOffList['+index+'].isPass'
        this.setData({
          [str]:2
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/dayOff/getDayOffList',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        console.log(res)
        that.setData({
          dayOffList:res.data
        })
      }
    })
  }
})