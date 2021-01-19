// app.js
App({
  onLaunch() {
    // 登录
    var that = this
    wx.login({
      success: res => {
        wx.showLoading({
          title: '登录中...',
          mask: true
        })
        if(res.code){
          /* 
          发送 res.code 到后台换取sessionKey 
           */
          wx.request({
            method:"POST",
            url: that.globalData.host + '/login',
            data:{
              code:res.code
            },
            header:{
              "content-type":"application/json"
            },
            timeout:10000,
            success:function(res){
              console.log("roleId："+res.data.roleId+"***session_key"+res.data.session_key)
              /* 
              拿到openid等,判断登录成功则保存数据。
               */
              that.globalData.session_key = res.data.session_key
              that.globalData.roleId = res.data.roleId
              try {
                wx.setStorageSync('roleId', res.data.roleId)
                wx.setStorageSync('session_key', res.data.session_key)
              } catch (e) {
                console.log("同步保存出错")
               }
              wx.hideLoading()
              if(res.data.roleId == 0 || res.data.roleId == 1){
                wx.navigateTo({
                  url: '/pages/bindId/bindId'
                })
              }else if(res.data.roleId == 2){
                wx.switchTab({
                  url: '/pages/stu_check/stu_check',
                })
              }else{
                
              }
            },
            fail:function(e){
              wx.hideLoading()
              wx.showToast({
                title: '登录失败，请检查网络',
                icon:"none",
                duration: 2000
              })
            }
          })
        }else{
          console.log("wx.login调用失败")
        }
      }
    })

  },

  globalData: {
    roleId: null,
    code:null,
    session_key:null,
    /* 
    服务器地址
    */
    host:"http://example.com",
  }
})
