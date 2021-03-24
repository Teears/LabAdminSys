// tea/pages/tea_enterEdit/tea_enterEdit.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone: "",
    desc: "",
    descLength: 0,
    rule:"",
    ruleLength:0,
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
  changeRule: function (e) {
    this.setData({
      rule: e.detail,
      ruleLength: e.detail.length
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  }
})