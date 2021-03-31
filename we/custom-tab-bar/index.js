Component({
  data: {
    roleId:'',
    selected: null,
    color: "#ffffff",
    selectedColor: "#ff8673",
    tabList: [{
      stuList: [{
        "pagePath": "/pages/stu_history/stu_history",
        "text": "历史",
        "iconPath":"/image/clock.png",
        "selectedIconPath":"/image/clock_on.png"
      },{
        "pagePath": "/pages/stu_check/stu_check",
        "text": "签到",
        "iconPath":"/image/check.png",
        "selectedIconPath":"/image/check_on.png"
      },{
        "pagePath": "/pages/stu_mine/stu_mine",
        "text": "个人",
        "iconPath":"/image/mine.png",
        "selectedIconPath":"/image/mine_on.png"
      }],
      teaList: [{
        "pagePath": "/pages/tea_manage/tea_manage",
        "text": "实验室",
        "iconPath":"/image/manage.png",
        "selectedIconPath":"/image/manage_on.png"
      },{
        "pagePath": "/pages/tea_mine/tea_mine",
        "text": "功能",
        "iconPath":"/image/function.png",
        "selectedIconPath":"/image/function_on.png"
      }]
    }],
    list: []
  },
  attached() {
    const roleId = wx.getStorageSync('roleId')
    if(roleId == 1){
      this.setData({
        list: this.data.tabList[0].stuList
      })
    }else if(roleId == 2){
      this.setData({
        list: this.data.tabList[0].teaList
      })
    }
  },
  methods: {
    switchTab(e) {
      const data = e.currentTarget.dataset
      const url = data.path
      wx.switchTab({url})
    }
  }
})