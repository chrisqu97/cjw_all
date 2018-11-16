//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    //当前所选选项卡
    search_selected: 0,
    search_value: '',
    currentTab: 0,
    imgList: [
      { url: '../../images/1.jpg' },
      { url: '../../images/2.jpg' },
      ],

    job: []
  },


  main_19_click: function (e) {
    var positionId = e.currentTarget.dataset.id;
    console.log("id+" + positionId)
    wx.navigateTo({
      url: '../job_detail/job_detail?id=' + positionId,
    })


  },
  getjob: function () {
    var that = this
    var req_url = 'Position/findByRandom'
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        pageNum: 1,
        pageSize: 5,
        positionType: 5
      },
      method: 'POST',
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      success: function (res) {
        // 后端获取数据源
        var positionPojos = res.data.data.positionPojos
        console.log(positionPojos);
        var job=that.data.job

        that.setData({
        job:positionPojos
        
        })
      
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },
  onLoad: function () {
    this.getjob()
  },

  //滑动切换
  swiperTab: function (e) {
    var that = this;

    that.setData({
      currentTab: e.detail.current
    })
  },

  //点击切换
  clickTab: function (e) {
    var that = this;
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.target.dataset.current
      })
    }
  }

})
