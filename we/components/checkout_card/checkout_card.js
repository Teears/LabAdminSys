// components/checkout_card/checkout_card.js

Component({
  /**
   * 组件的属性列表
   */
  properties: {
    turn: {
      type: Number,
      value: null
    },
  },

  /**
   * 组件的初始数据
   */
  data: {
    text:"",
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
    }
  }
})
