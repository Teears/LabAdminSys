// pages/tea_manage/tea_manage.js
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    loading:false,
    gradientColor: {
      '0%': '#0093E9',
      '100%': '#80D0C7'
    },
    list:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.initData()
  },

  initData:function(){
    const that = this
    wx.request({
      url: app.globalData.host+'/tea/manage/managelist',
      method:"GET",
      "header": {
        "content-type":"application/json; charset=utf-8",
        "token":wx.getStorageSync('token')
      },
      timeout:10000,
      success:function(res){
        res = res.data
        that.setData({
          list:res.data
        })
      },
      complete:function(){
        wx.stopPullDownRefresh()
      }
    })
  },

  tapSet:function(e){
    var index = e.currentTarget.dataset.index
    wx.navigateTo({
      url: '/tea/pages/tea_setLab/tea_setLab?labId=' + this.data.list[index].labId,
    })
  },
  tapEdit:function(e){
    var index = e.currentTarget.dataset.index
    wx.navigateTo({
      url: '/tea/pages/tea_editLab/tea_editLab?labId=' + this.data.list[index].labId,
    })
  },
  tapBottom:function(e){
    var index = e.currentTarget.dataset.index
    wx.navigateTo({
      url: '/tea/pages/tea_manageLab/tea_manageLab?labId=' + this.data.list[index].labId,
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 0
        })
      }
  },

  onPullDownRefresh: function () {
    this.initData()
  }
})