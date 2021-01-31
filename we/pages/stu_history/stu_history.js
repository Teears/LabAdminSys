// pages/stu_history/stu_history.js
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    surpassOption:'',
    finishRateOption:'',
    detailOption:'',
    total:'',
    startDate:new Date(2020, 11, 1).getTime(),
    endDate:(new Date().getTime())-86400000,
    defaultDate:(new Date().getTime())-86400000
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    wx.request({
      method:"POST",
      url: app.globalData.host+'/stu/historyInit',
      header:{
        "content-type":"application/x-www-form-urlencoded"
      },
      timeout:10000,
      data:{
        token:''
      },
      success:function(res){
        that.setData({
          total:res.data.total,
          surpassOption:{
            series:[{
              name:'超过同伴',
              type:'pie',
              radius:['65%','85%'],
              label:{position:'center'},
              data:[{
                value:res.data.surpass,name:'超过同伴\n'+res.data.surpass+'%',
                itemStyle:{
                  color:'#66CCFF',
                  borderRadius: 10,
                }},{
                  value:100-res.data.surpass,
                  itemStyle:{color:'#EFEFEF'}
                }]
            }]
          },
          finishRateOption:{
            series:[{
              name:'到勤率',
              type:'pie',
              radius:['70%','85%'],
              label:{position:'center'},
              data:[
                {value:res.data.finishRate,name:'到勤率\n'+res.data.finishRate+'%',itemStyle:{color:'#66CC99'}},
                {value:100-res.data.finishRate,itemStyle:{color:'#EFEFEF'}}
              ]
            }]
          },
          detailOption:{
            grid : {
              top:10,
              bottom:10,
              left:10,
              right: 35,
            },
            xAxis: {
              type: 'log',
              show: false,
            },
            yAxis: {
              type: 'category',
              show:false,
              data:['到勤','迟到/早退','缺席','请假']
            },
            series:[{
              name:'detail',
              type:'bar',
              label:{
                show: true,
                position:'right',
                formatter:'{b}{c}',
                fontSize:9
              },
              borderRadius: [10, 10, 10, 10],
              barWidth:'8',
              barMinWidth:'1',
              data:[{
                value:res.data.finished,
                itemStyle:{color:'#99CC33'}
              },{
                value:res.data.late,
                itemStyle:{color:'#FF9966'}
              },{
                value:res.data.absent,
                itemStyle:{color:'#CC3333'}
              },{
                value:res.data.dayoff,
                itemStyle:{color:'#666666'}
              }]
            }]
          }

        })//setData
      },
      fail:function(){
        wx.showToast({
          title: '网络繁忙',
          icon:"none",
          duration: 2000
        })
      }
    })
    
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
    if (typeof this.getTabBar === 'function' &&
      this.getTabBar()) {
      this.getTabBar().setData({
        selected: 0
      })
    }
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