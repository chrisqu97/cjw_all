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
    pageNum: 1,
    pageSize: 5,
    job: [],
    hasMoreData: true
  },


  main_19_click: function (e) {
    var positionId = e.currentTarget.dataset.id;
    console.log("id+" + positionId)
    wx.navigateTo({
      url: '../job_detail/job_detail?id=' + positionId,
    })


  },

  // * 页面上拉触底事件的处理函数
  //  */
  onReachBottom: function () {

    if (this.data.hasMoreData) {
      wx.showToast({
        title: '正在加载' + this.data.pageNum + "页",
      })
      this.getjob()
    } else {
      wx.showToast({
        title: '没有更多数据',
      })
    }
  },
  getjob: function () {
    var that = this
    var req_url = 'Position/findByRandom'
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        pageNum: that.data.pageNum,
        pageSize: that.data.pageSize,
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
        // 前端渲染包
        var job=that.data.job

        if(positionPojos.length<that.data.pageSize)
        {
          that.setData({
            job: job.concat(positionPojos),
            hasMoreData:false
          })
        }
        else{
          that.setData({
            job: job.concat(positionPojos),
            hasMoreData: true,
            pageNum:that.data.pageNum+1
          })
        }
        
        
      
      
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
