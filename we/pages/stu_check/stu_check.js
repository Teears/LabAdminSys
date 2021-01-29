// pages/stu_check/stu_check.js

var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js')
var qqmapsdk = new QQMapWX({
  key:'5NCBZ-TZ5WF-GGRJL-JCX57-UCO3J-MSFPX'
})

Page({

  /**
   * 页面的初始数据
   */
  data: {
    queshengMark:0,
    queshengText:"你尚未加入任何实验室",
    rank:"12",  //签到名次
    address:''
  },

  checkin:function(){
    const that = this
    //检查位置授权
    wx.getSetting({
      success:function(res){
        const scopeAddress = res.authSetting["scope.userLocation"]
        while(scopeAddress == false){
          wx.openSetting({
            success (res) {
              console.log(res.authSetting)
            }
          })
        }
      }
    })
    //获取腾讯逆向地址解析SDK
    qqmapsdk.reverseGeocoder({
      poi_options:'policy=2',
      success: function(res){
        const address = res.result.address_component.province+res.result.address_component.city+res.result.formatted_addresses.recommend
        console.log("获取当前定位:"+address)
        that.setData({
          address:address
        })
      },
      fail:function(err){
        console.log(err)
      },
      complete:function(res){
        console.log(res)
      }
    })

    console.log("向服务器发送签到信息，向服务器获取签到名次")
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
        })
      }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})