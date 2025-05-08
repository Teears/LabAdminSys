// stu/pages/stu_addqingjia/stu_addqingjia.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dayoffType: "1",
    calendarShow: false,
    dayDisplay: " ",
    dayLength: 0,
    day: "",
    phone: "",
    desc: "",
    descLength: 0
  },

  //日历操作
  chooseDay: function () {
    this.setData({
      calendarShow: true
    })
  },
  closeCalendar: function () {
    this.setData({
      calendarShow: false
    })
  },
  confirmCalendar: function (e) {
    var display = []
    var day = ""
    for (var i = 0; i < e.detail.length; i++) {
      display.push(e.detail[i].getMonth() + 1 + "/" + e.detail[i].getDate())
      var month = e.detail[i].getMonth() + 1
      var date = e.detail[i].getDate()
      if ( month < 10 ) {
        month = '0' + month
      }
      if ( date < 10 ) {
        date= '0' + date
      }
      day = day + e.detail[i].getFullYear()+"-"+month+"-"+date+","
    }
    day = day.substring(0, day.length - 1)
    this.setData({
      calendarShow: false,
      day: day,
      dayDisplay: display,
      dayLength: e.detail.length
    })
  },

  //数据绑定
  changeRadio: function (e) {
    this.setData({
      dayoffType: e.detail
    })
  },
  changePhone: function (e) {
    this.setData({
      phone: e.detail
    })
  },
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
      method: "POST",
      url: app.globalData.host + '/stu/dayOff/addDayOff',
      data: {
        dayoffType: that.data.dayoffType,
        day: that.data.day,
        phone: that.data.phone,
        desc: that.data.desc
      },
      header: {
        "content-type": "application/x-www-form-urlencoded",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        wx.hideLoading()
        wx.showToast({
          title: '提交成功，请耐心等待审核',
          icon: "none",
          duration: 2000
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