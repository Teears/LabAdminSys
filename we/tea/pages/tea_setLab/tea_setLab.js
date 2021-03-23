// tea/pages/tea_setLab/tea_setLab.js
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
    checkoutTimr2:'',
    currentTime:"12:30"
  },

  submit:function(){
    console.log(this.data)
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