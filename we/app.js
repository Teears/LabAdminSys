// app.js
App({
  onLaunch() {
  },
  userLogin:function(){
    var promise = new Promise((resolve,reject) =>{
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
            测试后台URL为/login，发送 res.code 到后台换取sessionKey 
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
                //拿到openid等,判断登录成功则保存数据。
                console.log("roleId："+res.data.roleId+"***session_key"+res.data.session_key)
                that.globalData.session_key = res.data.session_key
                that.globalData.roleId = res.data.roleId
                try {
                  /* 
                  真机测试置为2
                  */
                  // wx.setStorageSync('roleId', "2")
                  wx.setStorageSync('roleId', res.data.roleId)
                  wx.setStorageSync('session_key', res.data.session_key)
                } catch (e) {
                  console.log("同步保存出错")
                }
                wx.hideLoading()
                resolve(res.data.roleId)
              },
              fail:function(e){
                wx.hideLoading()
                wx.showToast({
                  title: '登录失败，请检查网络',
                  icon:"none",
                  duration: 2000
                })
                reject("登录失败")
              }
            })
          }else{
            console.log("wx.login调用失败")
            reject("wx.login--error")
          }
        }
      })
    })
    return promise
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
