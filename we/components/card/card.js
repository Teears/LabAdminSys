// components/card.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    rank: { // 名次
      type: String,
      value: '0'
    },
    turn: { // 名次
      type: Number,
      value: null
    },
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
    rightBottom:"",
    animationMain:null,
    animationBack:null
  },
  observers:{
    'turn': function(newTurn){
      if(newTurn == 1){
        this.rotate()
      }
    }
  },
  attached: function (){
    this._initPic()
    this._calendar()
    // this.animation = wx.createAnimation()
  },
  /**
   * 组件的方法列表
   */
  methods: {
    rotate: function () {
      console.log("触发组件内部tap事件，导致rotate")
      this.animation_main = wx.createAnimation({
        delay: 0,
      })
      this.animation_back = wx.createAnimation({
        delay: 0,
      })
      this.animation_main.rotateY(180).step()
      this.animation_back.rotateY(0).step()
      this.setData({
        animationMain: this.animation_main.export(),
        animationBack: this.animation_back.export()
      })
    },
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
        case 0:
          day = "星期天"
          break
        case 1:
          day = "星期一"
          break
        case 2:
          day = "星期二"
          break
        case 3:
          day = "星期三"
          break
        case 4:
          day = "星期四"
          break
        case 5:
          day = "星期五"
          break
        case 6:
          day = "星期六"
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
