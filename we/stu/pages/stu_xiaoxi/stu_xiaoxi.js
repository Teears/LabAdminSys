// stu/pages/stu_xiaoxi/stu_xiaoxi.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark: 0,
    queshengText: "暂时未收到任何消息",
    currentPage: 1,
    pageSize: 10,
    last: false,
    list: [],
    loading: false,
    loadingFail: false,
    dialogShow: false,
    index:''
  },

  getMessageList: function () {
    const that = this
    var promise = new Promise((resolve, reject) => {
      wx.request({
        // url: app.globalData.host+'/stu/dayDetail?currentPage='+that.data.currentPage+'&pageSize='+that.data.pageSize,
        url: app.globalData.host + '/stu/message',
        method: "GET",
        "header": {
          "content-type": "application/json; charset=utf-8",
          "token": ""
        },
        timeout: 10000,
        success: function (res) {
          that.setData({
            list: that.data.list.concat(res.data.list),
            currentPage: that.data.currentPage + 1,
            last: res.data.last,
            loading: false
          })
          resolve(res.data.list.length)
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
  showPopup(e){
    var index = e.currentTarget.dataset.index
    var newIndexList = 'list['+index+'].dot'
    this.setData({
      index:index,
      dialogShow: true,
      [newIndexList]:false
    })
  },
  tapDialogButton(e) {
    this.setData({
      dialogShow: false
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    this.getMessageList().then(res=>{
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
    this.getMessageList()
  }
})