// common/pages/feedback/feedback.js
// stu/pages/stu_addqingjia/stu_addqingjia.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    desc: "",
    descLength: 0
  },
  //数据绑定
  changeDesc: function (e) {
    this.setData({
      desc: e.detail,
      descLength: e.detail.length
    })
  },

  submit: function () {
    const that = this
    wx.showLoading({
      title: '请稍后...',
    })
    setTimeout(function(){
      wx.hideLoading()
    },10000)
    wx.request({
      method: 'POST',
      url: app.globalData.host + '/feedback/addfeedback',
      data: {
        content: that.data.desc
      },
      header: {
        "content-type": "application/x-www-form-urlencoded",
        "token":wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function () {
        wx.hideLoading()
        wx.showToast({
          title: '感谢您的反馈',
          duration: 4000
        })
      },
      fail:function(){
        wx.hideLoading()
        wx.showToast({
          title: '网络繁忙',
          icon: "none",
          duration: 2000
        })
      }
    })
  }
})