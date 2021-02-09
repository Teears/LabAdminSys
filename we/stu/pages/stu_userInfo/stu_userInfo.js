// stu/pages/stu_userInfo/stu_userInfo.js
import Dialog from '@vant/weapp/dialog/dialog';

Page({

  /**
   * 页面的初始数据
   */
  data: {
    "avatarUrl": "https://img.yzcdn.cn/vant/cat.jpeg",
  },


  dropout: function () {
    Dialog.confirm({
      title: '确定退出吗？',
      message: '退出实验室后需要再次审核才能加入',
    }).then(() => {
      console.log("confirm")
    })
      .catch(() => {
        console.log("cancel")
      })
  },

  tapAvatar: function () {
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success(res) {
        // tempFilePath可以作为img标签的src属性显示图片
        const tempFilePaths = res.tempFilePaths[0]
        console.log(tempFilePaths)
        wx.navigateTo({
          url: '/stu/pages/uploader/uploader?src=' + tempFilePaths
        })
      }
    })
  },
  tapStuNumber: function () {
    wx.navigateTo({
      url: '/pages/bindId/bindId'
    })
  },
  tapPhone: function () {
    wx.navigateTo({
      url: '/stu/pages/change_phone/change_phone'
    })
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