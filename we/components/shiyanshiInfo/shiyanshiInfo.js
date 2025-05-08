// components/shiyanshiInfo/shiyanshiInfo.js
const app = getApp()

Component({
  /**
   * 组件的属性列表
   */
  properties: {
    labId: {
      type: String,
      value: ''
    },
  },

  /**
   * 组件的初始数据
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

  ready:function(){
    const that = this
    console.log("实验室编号"+that.properties.labId)
    wx.showLoading({
      title: '加载中...',
    })
    setTimeout(function(){
      wx.hideLoading()
    },5000)
    wx.request({
      url: app.globalData.host + '/common/shiyanshiInfo?labId='+that.properties.labId,
        // url: app.globalData.host + '/common/shiyanshiInfo',
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
  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
})
