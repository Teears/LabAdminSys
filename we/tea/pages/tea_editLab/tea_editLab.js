// tea/pages/tea_editLab/tea_editLab.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    labId:''
  },

  enterEdit:function(){
    wx.navigateTo({
      url: '/tea/pages/tea_enterEdit/tea_enterEdit?labId='+ this.data.labId,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      labId:options.labId
    })
  }
})