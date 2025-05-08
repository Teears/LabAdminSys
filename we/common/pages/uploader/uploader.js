// stu/pages/uploader/uploader.js
import WeCropper from '../../../components/we-cropper/we-cropper.js'

const device = wx.getSystemInfoSync() // 获取设备信息
const width = device.windowWidth // 示例为一个与屏幕等宽的正方形裁剪框
const height = device.windowHeight
const app = getApp()
Page({


  /**
   * 页面的初始数据
   */
  data: {
    cropperOpt: {
      id: 'cropper', // 用于手势操作的canvas组件标识符
      targetId: 'targetCropper', // 用于用于生成截图的canvas组件标识符
      pixelRatio: device.pixelRatio, // 传入设备像素比
      width,  // 画布宽度
      height, // 画布高度
      scale: 2.5, // 最大缩放倍数
      zoom: 8, // 缩放系数
      cut: {
        x: 10, // 裁剪框x轴起点
        y: (height - width) / 2 + 10, // 裁剪框y轴期起点
        width: width - 20, // 裁剪框宽度
        height: width - 20 // 裁剪框高度
      },
      src: '',
    }
  },
  upload: function (path) {
    wx.showLoading({
      title: '上传中...',
    })
    setTimeout(function () {
      wx.hideLoading()
    }, 20000)
    wx.uploadFile({
      url: app.globalData.host, //仅为示例，非真实的接口地址
      filePath: path,
      name: 'file',
      header: {
        "content-type": "multipart/form-data",
        "token": ""
      },
      success: function(res){
        console.log(res)
        if(res.statusCode != 200){
          wx.showToast({
            title: '上传失败',
            icon: "none",
            duration: 2000
          })
          return
        }
        wx.setStorageSync('avatarUrl', res.data.avatarUrl)
        wx.navigateBack({
          delta: 1,
        })
      },
      fail:function(){
        wx.showToast({
          title: '上传失败',
          icon: "none",
          duration: 2000
        })
      },
      complete:function(){
        wx.hideLoading()
      }
    })
  },

  enterTap: function () {
    const that = this
    this.wecropper.getCropperImage((tempFilePath) => {
      // tempFilePath 为裁剪后的图片临时路径
      if (tempFilePath) {
        that.upload(tempFilePath)
      } else {
        console.log('获取图片地址失败，请稍后重试')
      }
    })
  },
  cancelTap: function () {
    wx.navigateBack({
      delta: 1,
    })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      "cropperOpt.src": options.src
    })
    const { cropperOpt } = this.data
    this.cropper = new WeCropper(cropperOpt)
      .on('ready', (ctx) => {
        console.log(`wecropper is ready for work!`)
      })
      .on('beforeImageLoad', (ctx) => {
        wx.showToast({
          title: '上传中',
          icon: 'loading',
          duration: 20000
        })
      })
      .on('imageLoad', (ctx) => {
        wx.hideToast()
      })
  },
  touchStart(e) {
    this.cropper.touchStart(e)
  },
  touchMove(e) {
    this.cropper.touchMove(e)
  },
  touchEnd(e) {
    this.cropper.touchEnd(e)
  }
})