// app.js

App({
  onLaunch() {
    
  },
  userLogin:function(){
    var that = this
    var promise = new Promise((resolve,reject) =>{
      // 登录
      wx.login({
        success: res => {
          wx.showLoading({
            title: '登录中...',
            mask: true
          })
          if(res.code){
            wx.request({
              method:"POST",
              url: that.globalData.host + '/login',
              data:{
                code:res.code,
                nickName: that.globalData.nickName,
                avatarUrl: that.globalData.avatarUrl,
                encryptedData:that.globalData.encryptedData,
                iv:that.globalData.iv,
              },
              header:{
                "content-type":"application/x-www-form-urlencoded"
              },
              timeout:10000,
              success:function(res){
                // res = res.data
                console.log(res)
                that.globalData.session = res.data.session
                that.globalData.roleId = res.data.roleId
                try {
                  wx.setStorageSync('roleId', res.data.roleId)
                  wx.setStorageSync('session', res.data.session)
                  wx.setStorageSync('userName', res.data.userName)
                  wx.setStorageSync('belong', res.data.belong)
                  wx.setStorageSync('avatarUrl', res.data.avatarUrl)
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
    encryptedData:'',
    iv:'',
    nickName:'',
    avatarUrl:'',
    /* 
    服务器地址
    */
    // host:"http://example.com",
    host:"http://localhost:8080",

  }
})
