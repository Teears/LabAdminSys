// pages/stu_mine/stu_mine.js
const app = getApp()
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
    var avatarUrl=wx.getStorageSync('avatarUrl')
    var stuName=wx.getStorageSync('stuName')
    var belong=wx.getStorageSync('belong')
    if(stuName!=""&&belong!=""){
      this.setData({
        avatarUrl:avatarUrl,
        stuName:stuName,
        belong:belong
      })
      return
    }
    const that = this
    wx.request({
      url: app.globalData.host+'/stu/mine/getNameAndBelong',
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
          avatarUrl:res.data.avatarUrl,
          stuName:res.data.stuName,
          belong:res.data.belong
        })
        wx.setStorageSync('avatarUrl', res.data.avatarUrl)
        wx.setStorageSync('stuName', res.data.stuName)
        wx.setStorageSync('belong', res.data.belong)
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
          selected: 2
        })
      }
  },
})