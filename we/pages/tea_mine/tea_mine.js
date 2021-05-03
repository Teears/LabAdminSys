// pages/tea_mine/tea_mine.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl:'',
    teaNum:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var avatarUrl=wx.getStorageSync('avatarUrl')
    var teaName=wx.getStorageSync('teaName')
    if(teaName!=""&&avatarUrl!=""){
      this.setData({
        avatarUrl:avatarUrl,
        teaName:teaName,
      })
      return
    }
    const that = this
    wx.request({
      url: app.globalData.host+'/tea/mine/getTeaName',
      method:"GET",
      "header": {
        "content-type":"application/json; charset=utf-8",
        "token":wx.getStorageSync('token')
      },
      timeout:10000,
      success:function(res){
        console.log(res)
        res = res.data
        that.setData({
          // avatarUrl:res.data.avatarUrl,
          teaName:res.data.name
        })
        // wx.setStorageSync('avatarUrl', res.data.avatarUrl)
        wx.setStorageSync('teaName', res.data.name)
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
  }
})