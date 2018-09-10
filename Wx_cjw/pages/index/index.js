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

    jobs: []
  },
  main_19_click: function (e) {
    wx.navigateTo({
      url: '../job_detail/job_detail',
    })
  },

  getjob: function () {
    var that = this
    var req_url = '/getJob'
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        username: app.globalData.userid
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("请求职位列表成功");
        that.setData({
          jobs: res.data.jobdata
        })
        console.log(that.data.jobs)
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
