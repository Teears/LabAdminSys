// tea/pages/tea_post/tea_post.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark: 0,
    queshengText: "暂时未发布任何消息",
    list: [],
    dialogShow: false,
    index:''
  },

  showPopup(e){
    var index = e.currentTarget.dataset.index
    this.setData({
      index:index,
      dialogShow: true
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

  getMessageList: function () {
    const that = this
    var promise = new Promise((resolve, reject) => {
      wx.request({
        url: app.globalData.host + '/message/tea/getPost',
        method: "GET",
        "header": {
          "content-type": "application/json; charset=utf-8",
          "token": wx.getStorageSync('token')
        },
        timeout: 10000,
        success: function (res) {
          res = res.data
          that.setData({
            list: res.data,
          })
          if(res.data == null || res.data == undefined){
            resolve(0)
          }else{
            resolve(res.data.length)
          }
        },
        fail: function () {
          reject()
        }
      })
    })
    return promise
  }
})