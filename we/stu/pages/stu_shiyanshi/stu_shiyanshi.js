// stu/pages/stu_shiyanshi/stu_shiyanshi.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tab:[{
      tabTitle:"简介",
      tabContent:'<center><h4>xxxx实验室介绍</h4></center><br><p>&emsp;&emsp;xxx实验室成立于2016年，隶属于四川师范大学计算机科学学院，xxx配备有先进的xx设备，可以容纳20位学生行xx实验，这是乱写的乱写的乱写的乱写为实验人员提供xxx保障。</p><p>&emsp;&emsp;这是第二段内容我们试试能否用HTML解析<img src="https://img.yzcdn.cn/vant/cat.jpeg" width="100%"/></p><p>&nbsp;&nbsp;&nbsp;&nbsp;负责人：张三</p><p>&nbsp;&nbsp;&nbsp;&nbsp;联系方式：18712344321</p>'
    },{
      tabTitle:"管理规定",
      tabContent:"xxxxxxxxxxxxx保障用电安全，xxxxxxxxxxxxxxxxxxx不能携带危险物品,xxxxxxxxxxxx禁止携带有气味的食物进入xxxx。xxxxxxxxxxxxx在微信小程序进行签到xxxxxxxx"
    }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.showLoading({
      title: '加载中...',
    })
    setTimeout(function(){
      wx.hideLoading()
    },10000)
    wx.request({
      url: app.globalData.host + '/stu/shiyanshi',
        method: "GET",
        header: {
          "content-type": "application/json; charset=utf-8",
          "token": ""
        },
        timeout: 10000,
        success: function (res) {
          that.setData({
            tab:res.tab
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