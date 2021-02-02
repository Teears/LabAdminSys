// stu/pages/stu_qingjia/stu_qingjia.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentPage:1,
    pageSize:10,
    list:[]
  },

  getDayoffList:function(){
    const that = this
    wx.request({
      // url: app.globalData.host+'/stu/dayDetail?currentPage='+that.data.currentPage+'&pageSize='+that.data.pageSize,
      url: app.globalData.host+'/stu/dayoffList',
      method:"GET",
      "header": {
        "content-type":"application/json; charset=utf-8",
        "token":""
      },
      timeout:10000,
      success:function(res){
        var list = res.data.list
        for(var i = 0;i < list.length;i++){
          if(list[i].tag==0){
            list[i]['tagType'] = "danger"
            list[i].tag = "驳回"
          }else if(list[i].tag==1){
            list[i]['tagType'] = "success"
            list[i].tag = "批准"
          }else{
            list[i]['tagType'] = "primary"
            list[i].tag = "等待"
          }
        }
        that.setData({
          list:list,
          currentPage:that.data.currentPage+1
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getDayoffList()
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