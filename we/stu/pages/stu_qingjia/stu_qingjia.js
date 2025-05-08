// stu/pages/stu_qingjia/stu_qingjia.js
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark: 0,
    queshengText: "您没有任何请假记录",
    currentPage: 1,
    pageSize: 10,
    last: false,
    list: [],
    loading: false,
    loadingFail: false
  },

  getDayoffList: function () {
    const that = this
    var promise = new Promise((resolve, reject) => {
      wx.request({
        url: app.globalData.host+'/stu/dayOff/dayOffList?currentPage='+that.data.currentPage+'&pageSize='+that.data.pageSize,
        method: "GET",
        "header": {
          "content-type": "application/json; charset=utf-8",
          "token": wx.getStorageSync('token')
        },
        timeout: 10000,
        success: function (res) {
          res = res.data
          var list = res.data.list
          for (var i = 0; i < list.length; i++) {
            if (list[i].tag == 0) {
              list[i]['tagType'] = "danger"
              list[i].tag = "驳回"
            } else if (list[i].tag == 1) {
              list[i]['tagType'] = "success"
              list[i].tag = "批准"
            } else {
              list[i]['tagType'] = "primary"
              list[i].tag = "等待"
            }
          }
          that.setData({
            list: that.data.list.concat(list),
            currentPage: that.data.currentPage + 1,
            last: res.data.isLastPage,
            loading: false
          })
          resolve(list.length)
        },
        fail: function () {
          that.setData({
            loading: false,
            loadingFail: true
          })
          reject()
        }
      })
    })
    return promise
  },

  addBtn: function () {
    wx.navigateTo({
      url: '/stu/pages/stu_addqingjia/stu_addqingjia',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    this.getDayoffList().then(res=>{
      if(res==0){
        that.setData({
          queshengMark:1
        })
      }
    })
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    if (this.data.last == true) {
      return
    }
    this.setData({
      loadingFail: false,
      loading: true
    })
    this.getDayoffList()
  }

})