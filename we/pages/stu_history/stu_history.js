// pages/stu_history/stu_history.js
// "mp-dialog": "/miniprogram_npm/weui-miniprogram/dialog/dialog"
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

    startDate:"2020-01",
    endDate:"2020-01",
    daysInfo: "",

    dialogTitle:"",
    dialogShow:"",
    checkinTime:"",
    checkinAddress:"",
    checkoutTime:"",
    checkoutAddress:"",

    oneButton: [{text: '确定'}],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this
    //初始化图表信息 和 日历页数
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
          },
          startDate:res.data.startDate,
          endDate:res.data.endDate,        
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
  
    //初始化当前页日历
    const currentYear = new Date().getFullYear
    const currentMonth = new Date().getMonth+1
    that.getDaysInfo(currentMonth,currentYear)
  },

  nextMonth:function(e){
    this.getDaysInfo(e.detail.currentMonth,e.detail.currentYear)
  },
  prevMonth:function(e){
    this.getDaysInfo(e.detail.currentMonth,e.detail.currentYear)
  },
  dateChange:function(e){
    this.getDaysInfo(e.detail.currentMonth,e.detail.currentYear)
  },
  //点击日历某一天
  dayClick:function(e){
    const that = this
    wx.request({
      // url: app.globalData.host+'/stu/dayDetail?year='+e.detail.year+'&month='+e.detail.month+'&day='+e.detail.day,
      url: app.globalData.host+'/stu/dayDetail',
      method:"GET",
      "header": {
        "content-type":"application/json; charset=utf-8",
        "token":""
      },
      timeout:10000,
      success:function(res){
        that.setData({
          dialogTitle:e.detail.month+"月"+e.detail.day+"日",
          checkinTime:res.data.checkinTime,
          checkinAddress:res.data.checkinAddress,
          checkoutTime:res.data.checkoutTime,
          checkoutAddress:res.data.checkoutAddress,
          dialogShow:true
        })
      }
    })
  },
  //渲染某个月的日历
  getDaysInfo:function(currentMonth,currentYear){
    const that = this
    wx.request({
      // url: app.globalData.host+'/stu/daysInfo?month='+currentMonth+"&year="+currentYear,
      url: app.globalData.host+'/stu/daysInfo',
      method:"GET",
      "header": {
        "content-type":"application/json; charset=utf-8",
        "token":""
      },
      timeout:10000,
      success:function(res){
        that.setData({
          daysInfo:res.data.daysInfo
        })
      }
    })
  },

  tapDialogButton(e) {
    this.setData({
      dialogShow: false
    })
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

})