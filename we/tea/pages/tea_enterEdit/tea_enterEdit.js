// tea/pages/tea_enterEdit/tea_enterEdit.js
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    labId:"",
    desc: "",
    descLength: 0,
    rule:"",
    ruleLength:0,
    fileList:[]
  },

  changeDesc: function (e) {
    this.setData({
      desc: e.detail,
      descLength: e.detail.length
    })
  },
  changeRule: function (e) {
    this.setData({
      rule: e.detail,
      ruleLength: e.detail.length
    })
  },
  afterRead(event) {
    var fileList = [{
      url:event.detail.file.url,
      name:'file'
    }]
    console.log(fileList)
    this.setData({
      fileList:fileList
    })
  },
  submit:function(){
    console.log(this.data)
    const that = this
    wx.uploadFile({
      url: app.globalData.host + '/tea/manage/editlab', // 仅为示例，非真实的接口地址
      filePath: that.data.fileList[0].url,
      name: that.data.fileList[0].name,
      formData: { 
        labId:that.data.labId,
        desc: that.data.desc,
        rule:that.data.rule,
      },
      success(res) {
        console.log("上传成功")
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      labId:options.labId
    })
  }
})