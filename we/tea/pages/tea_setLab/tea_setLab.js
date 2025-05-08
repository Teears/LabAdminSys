// tea/pages/tea_setLab/tea_setLab.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    labId:'',
    showPop:false,
    focus:'',
    checkinTime1:'',
    checkinTime2:'',
    checkoutTime1:'',
    checkoutTime2:'',
    currentTime:"12:30"
  },

  submit:function(){
    if(!(this.data.checkinTime1<this.data.checkinTime2&&
      this.data.checkinTime2<this.data.checkoutTime1&&
      this.data.checkoutTime1<this.data.checkoutTime2)){
      wx.showToast({
        title: '内容不符合要求',
        icon: "none",
        duration: 2000
      })
      return
    }
    const that = this
    wx.showLoading({
      title: '请稍后...',
    })
    wx.request({
      method: "POST",
      url: app.globalData.host + '/tea/manage/setlab',
      data: {
        labId: that.data.labId,
        checkinTime1:that.data.checkinTime1,
        checkinTime2:that.data.checkinTime2,
        checkoutTime1:that.data.checkoutTime1,
        checkoutTime2:that.data.checkoutTime2,
      },
      header: {
        "content-type": "application/x-www-form-urlencoded",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        wx.hideLoading()
        wx.showToast({
          title: '修改成功',
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
  },

  changeCheckinStart: function () {
    this.setData({
      showPop:true,
      focus:1
    })
  },
  changeCheckinEnd: function () {
    this.setData({
      showPop:true,
      focus:2
    })
  },
  changeCheckoutStart: function () {
    this.setData({
      showPop:true,
      focus:3
    })
  },
  changeCheckoutEnd: function () {
    this.setData({
      showPop:true,
      focus:4
    })
  },
  onClosePop(){
    this.setData({
      showPop:false
    })
  },
  timeInput(event) {
    switch(this.data.focus){
      case 1:
        this.setData({
          checkinTime1:event.detail
        })
        break
      case 2:
        this.setData({
          checkinTime2:event.detail
        })
        break
      case 3:
        this.setData({
          checkoutTime1:event.detail
        })
        break
      case 4:
        this.setData({
          checkoutTime2:event.detail
        })
        break
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.labId)
    this.setData({
      labId:options.labId
    })
  }
})