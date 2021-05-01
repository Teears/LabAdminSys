// pages/bindId/bindId.js
// "mp-form": "/miniprogram_npm/weui-miniprogram/form/form",
// "mp-cell": "/miniprogram_npm/weui-miniprogram/cell/cell"
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    changeCardText:"教师身份认定",
    stuCard:true,
    stuForm:{
      stuNumber:"",
      stuPassword:""
    },
    teaForm:{
      teaNumber:"",
      teaPassword:""
    },
    stuIcon:{
      tpIcon:"/image/stuIcon.png",
      tpText:"学生身份认定"
    },
    teaIcon:{
      tpIcon:"/image/teaIcon.png",
      tpText:"教师身份认定"
    }
  },
  // 获取学号
  getStuNumber:function(e){
    this.setData({
      'stuForm.stuNumber': e.detail
    })
  },
  // 获取学生密码
  getStuPassword:function(e){
    this.setData({
      'stuForm.stuPassword': e.detail
    })
  },
  // 获取工号
  getTeaNumber:function(e){
    this.setData({
      'teaForm.teaNumber': e.detail
    })
  },
  getTeaPassword:function(e){
    this.setData({
      'teaForm.teaPassword': e.detail
    })
  },
  /* 
  提交学生身份认定信息，如果认定成功就跳转，如果认定失败就弹出提示
 */
  submitStuForm:function(){
    var that = this
    wx.showLoading({
      mask: true,
      title:"请稍后..."
    })
    wx.request({
      method:"POST",
      url: app.globalData.host+'/bindId/stu',
      header:{
        "content-type":"application/x-www-form-urlencoded",
        'token': wx.getStorageSync('token')
      },
      data:that.data.stuForm,
      timeout:10000,
      success:function(res){
        res = res.data
        if(res.data.isBinded == 1){
          wx.clearStorageSync()
          wx.setStorageSync('roleId', res.data.roleId)
          wx.hideLoading()
          wx.navigateTo({
            url: '/pages/start/start',
          })
        }else if(res.data.isBinded == 0){
          wx.hideLoading()
          wx.showToast({
            title: '认定失败，请检查输入',
            icon:"none",
            duration:2000
          })
        }
        wx.hideLoading()
      },
      fail:function(e){
        wx.hideLoading()
        wx.showToast({
          title: '网络延迟，请稍后再试',
          icon:"none",
          duration:2000
        })
      }
    })
  },
/* 
  提交教师表单
 */
submitTeaForm:function(){
  var that = this
  wx.showLoading({
    mask: true,
    title:"请稍后..."
  })
  wx.request({
    method:"POST",
    url: app.globalData.host+'/bindId/tea',
    header:{
      "content-type":"application/x-www-form-urlencoded",
      'token': wx.getStorageSync('token')
    },
    data:that.data.teaForm,
    timeout:10000,
    success:function(res){
      res = res.data
      if(res.data.isBinded == 1){
        wx.clearStorageSync()
        wx.setStorageSync('roleId', res.data.roleId)
        wx.hideLoading()
        wx.navigateTo({
          url: '/pages/start/start',
        })
      }else if(res.data.isBinded == 0){
        console.log("教师身份认定失败")
        wx.hideLoading()
        wx.showToast({
          title: '认定失败，请检查输入',
          icon:"none",
          duration:2000
        })
      }
    },
    fail:function(e){
      wx.hideLoading()
      wx.showToast({
        title: '网络延迟，请稍后再试',
        icon:"none",
        duration:2000
      })
    }
  })
},


changeCard:function(){
  if(this.data.stuCard == false){
    this.setData({
      stuCard:true,
      changeCardText:"教师身份认定"
    })
  }else{
    this.setData({
      stuCard:false,
      changeCardText:"学生身份认定"
    })
  }
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      roleId: wx.getStorageSync('roleId')
    })
  }

})