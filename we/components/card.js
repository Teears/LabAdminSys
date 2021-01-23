// components/card.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    date:{
      date:"",
      day:"",
      year_month:"",
    },
    text:"",
    randomLoc:"",
    main:"",
    leftTop:"",
    rightTop:"",
    leftBottom:"",
    rightBottom:""
  },
  attached: function (){
    this._initPic()
    this._calendar()
  },
  /**
   * 组件的方法列表
   */
  methods: {
    _calendar:function(){
      var myDate = new Date()
      const year = myDate.getFullYear()
      const date = myDate.getDate()
      var day = myDate.getDay()
      const month = myDate.getMonth()+1
      var year_month;
      if(month<10){
        year_month = year+".0"+month
      }else{
        year_month = year+"."+month
      }
      switch(day){
        case 1:
          day = "星期一"
        case 2:
          day = "星期二"
        case 3:
          day = "星期三"
        case 4:
          day = "星期四"
        case 5:
          day = "星期五"
        case 6:
          day = "星期六"
        case 7:
          day = "星期天"
      }
      this.setData({
        "date.date":date,
        "date.day":day,
        "date.year_month":year_month
      })
    },

    _initPic:function(){
      const randomLoc = parseInt(Math.random()*5+1)
      const main = "/image/card/"+"planet"+(parseInt(Math.random()*7+1))+".png"
      var pic1 = parseInt(Math.random()*7+1)
      var pic2 = parseInt(Math.random()*7+1)
      if(pic1 == pic2){
        if(pic1==1){
          pic2++
        }else{
          pic2--
        }
      }
      pic1 = "/image/card/"+"item"+pic1+".png"
      pic2 = "/image/card/"+"item"+pic2+".png"
      this.setData({
        randomLoc:randomLoc,
        main:main,
        leftTop:pic2,
        rightTop:pic2,
        leftBottom:pic2,
        rightBottom:pic2
      })
      if(randomLoc==1||randomLoc==2||randomLoc==3){
        this.setData({
          leftTop:pic1
        })
      }else if(randomLoc==1||randomLoc==4||randomLoc==5){
        this.setData({
          rightTop:pic1
        })
      }else if(randomLoc==2||randomLoc==4||randomLoc==6){
        this.setData({
          rightBottom:pic1
        })
      }else if(randomLoc==3||randomLoc==5||randomLoc==6){
        this.setData({
          leftBottom:pic1
        })
      }
    }

  }
})
