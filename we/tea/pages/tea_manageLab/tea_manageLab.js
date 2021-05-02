// tea/pages/tea_manageLab/tea_manageLab.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    labId:"",
    checkinList:[],
    statisticList:[],
    havaLoaded:false,
    date:"",
    dataStamp:"",
    showPop:false,
    visible:true
  },

  onChange:function(event){
    if(event.detail.index == 0){
      this.setData({
        visible:true
      })
      return
    }
    this.setData({
      visible:false
    })
    if(this.data.havaLoaded == false){
      this.getStatisticList()
    }
  },

  //筛选日期
  select:function(){
    this.setData({
      showPop:true
    })
  },
  onClosePop(){
    this.setData({
      showPop:false
    })
  },
  confirm(event) {
    var now = new Date(event.detail)
    var month = now.getMonth()+1
    var date=now.getFullYear()+"-"+month+"-"+now.getDate()
    this.setData({
      showPop:false,
      date:date
    })
    this.getCheckinList(date)
  },

  //服务器请求
  getCheckinList:function(date){
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/manage/getCheckinList?labId='+that.data.labId+'&checkDate='+that.data.date,
      // url: app.globalData.host + '/tea/manage/getCheckinList',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        that.setData({
          checkinList:res.data
        })
      }
    })
  },
  getStatisticList:function(){
    const that = this
    wx.request({
      url: app.globalData.host + '/tea/manage/getStatisticList?labId='+that.data.labId,
      // url: app.globalData.host + '/tea/manage/getStatisticList',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        that.setData({
          statisticList:res.data
        })
      }
    })
    this.setData({
      havaLoaded:true
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var now = new Date()
    var month = now.getMonth()+1
    var date=now.getFullYear()+"-"+month+"-"+now.getDate()
    this.setData({
      labId:options.labId,
      date:date,
      dateStamp:now.getTime()
    })
    this.getCheckinList(date)
  }
})