// stu/pages/stu_xiaoxi/stu_xiaoxi.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark: 0,
    queshengText: "暂时未收到任何消息",
    list: [],
    dialogShow: false,
    index:''
  },

  getMessageList: function () {
    const that = this
    var promise = new Promise((resolve, reject) => {
      wx.request({
        url: app.globalData.host + '/message/stu/getmessage',
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
  },
  showPopup(e){
    var index = e.currentTarget.dataset.index
    if(this.data.list[index].dot == true){
      wx.request({
        url: app.globalData.host + '/message/setreaded?id='+this.data.list[index].id,
        method: "GET",
        "header": {
          "content-type": "application/json; charset=utf-8",
          "token": wx.getStorageSync('token')
        },
        timeout: 10000
      })
    }
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
  }
})