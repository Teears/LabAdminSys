// stu/pages/stu_shiyanshi/stu_shiyanshi.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tab:[{
      tabTitle:"简介",
      tabContent:''
    },{
      tabTitle:"管理规定",
      tabContent:''
    }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    var belong=wx.getStorageSync('belong')
    if(belong == ""){
      return
    }
    wx.showLoading({
      title: '加载中...',
    })
    setTimeout(function(){
      wx.hideLoading()
    },5000)
    wx.request({
      url: app.globalData.host + '/stu/mine/shiyanshi',
        method: "GET",
        header: {
          "content-type": "application/json; charset=utf-8",
          "token": wx.getStorageSync('token')
        },
        timeout: 10000,
        success: function (res) {
          res = res.data
          console.log(res)
          var name=res.data.name
          var content1=res.data.basicDesc
          var imgUrl=res.data.imgUrl
          var phone=res.data.phone
          var teaName=res.data.teaName
          var content2=res.data.ruleDesc
          var createTime=res.data.createTime
          that.setData({
            ['tab[0].tabContent']:'<center><h4>'+name+'实验室介绍</h4></center><br><p>&emsp;&emsp;'+content1+'</p><img src="'+imgUrl+'" width="100%"/></p><p>&nbsp;&nbsp;&nbsp;&nbsp;负责人：'+teaName+'</p><p>&nbsp;&nbsp;&nbsp;&nbsp;联系方式：'+phone+'</p>',

            ['tab[1].tabContent']:'<center><h4>实验室守则</h4></center><br>'+content2+'<br><h4>'+createTime+'</h4>'
          })
        },
        fail:function(){
          console.log("网络繁忙")
        },
        complete:function(){
          wx.hideLoading()
        }
    })
  }
})