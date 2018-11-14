// pages/job_recommend/job_recommend.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    search_selected: 0,
    search_value: '',
    currentTab: 0,
    pageNum:1,
    pageSize:3,
    positionIds:[42,14,6],
  
  },
  findPos: function (e) {
    var that = this
    // 请求后台 
    var req_url = 'Position/findByPositionIds'

    wx.request({
      url: app.globalData.host + req_url,
      data: {
       pageNum:that.data.pageNum,
       pageSize:that.data.pageSize,
       positionIds:that.data.positionIds
      },

      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {

        // 后端获取的推荐职位列表
        var Repostions = res.data.data.positionPojos
        console.log(Repostions)

        //  前端需要渲染的职位列表详情
        var job = Repostions
        that.setData({
          job: job,
        })
        console.log(job)
      },
      fail: function (res) {
      }
    })
  },

  main_19_click: function (e) {
    var positionId = e.currentTarget.dataset.id;
    console.log("id+" + e.currentTarget.dataset.id)
    wx.navigateTo({
      url: '../job_detail/job_detail?id=' + positionId,
    })


  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.findPos()
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

