// stu/pages/stu_userInfo/stu_userInfo.js
import Dialog from '@vant/weapp/dialog/dialog';
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    avatarUrl: "",
    name:"",
    belong:"",
    sex:"",
    stuNum:"",
    phone:"",
    dept:"",
    major:""
  },

  dropout: function () {
    const that = this
    Dialog.confirm({
      title: '确定退出吗？',
      message: '退出实验室后需要再次审核才能加入',
    }).then(() => {
      wx.request({
        url: app.globalData.host + '/stu/mine/exitlab',
        method: "POST",
        "header": {
          "content-type": "application/json; charset=utf-8"
        },
        data:{
          stuNum:that.data.stuNum
        },
        timeout: 10000,
        success: function (res) {
          if(res.data.statusCode < 0){
            console.log("操作失败")
          }else{
            wx.navigateTo({
              url: '/pages/bindId/bindId'
            })
          }
        }
      })
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
          url: '/common/pages/uploader/uploader?src=' + tempFilePaths
        })
      }
    })
  },

  tapStuNumber: function () {
    Dialog.confirm({
      title: '确定重新绑定学号吗？',
      message: '该操作可能导致部分信息丢失',
    }).then(() => {
      wx.navigateTo({
        url: '/pages/bindId/bindId'
      })
    })
    .catch(() => {
      console.log("cancel")
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    this.setData({
      avatarUrl:wx.getStorageSync('avatarUrl'),
      name:wx.getStorageSync('stuName'),
      belong:wx.getStorageSync('belong')
    })
    wx.request({
      url: app.globalData.host + '/stu/mine/getbindinfo',
      method: "GET",
      "header": {
        "content-type": "application/json; charset=utf-8",
        "token": wx.getStorageSync('token')
      },
      timeout: 10000,
      success: function (res) {
        res = res.data
        that.setData({
          sex:res.data.sex,
          stuNum:res.data.stuNum,
          phone:res.data.phone,
          dept:res.data.dept,
          major:res.data.major
        })
      }
    })
  }
})