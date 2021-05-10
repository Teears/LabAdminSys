// tea/pages/tea_addPost/tea_addPost.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    labIdList:[],
    title:"",
    contentLength:0,
    content:"",
    checkBox: []
  },

  onChangeCheckbox(e) {
    this.setData({
      checkBox: e.detail,
    });
  },
  changeTitle(e){
    this.setData({
      title: e.detail
    })
  },
  changeContent(e){
    this.setData({
      content: e.detail,
      contentLength: e.detail.length
    })
  },

  submit:function(){
    const that = this
    wx.showLoading({
      title: '请稍后...',
    })
    wx.request({
      method: "POST",
      url: app.globalData.host + '/message/tea/addPost',
      header: {
        "content-type": "application/x-www-form-urlencoded",
        "token": wx.getStorageSync('token')
      },
      data: {
        title:that.data.title,
        content:that.data.content,
        labIdList: that.data.checkBox
      },
      timeout: 10000,
      success: function (res) {
        wx.showToast({
          title: '已发布',
          duration: 2000
        })
      },
      fail:function(){
        wx.showToast({
          title: '网络繁忙',
          icon: "none",
          duration: 2000
        })
      },
      complete:function(){
        wx.hideLoading()
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/mine/getLabList',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        that.setData({
          labIdList:res.data
        })
      }
    })
  }
})