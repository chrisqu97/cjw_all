var wxCharts = require('../../utils/wxchart.js');
var app = getApp();
var radarChart = null;
Page({
  data: {
    userId:1
  },
  touchHandler: function (e) {
    console.log(radarChart.getCurrentDataIndex(e));
  },

  recommendpos:function(e){
    
    wx.navigateTo({
      url: '../job_recommend/job_recommend',
    })
  },
  getrecommend:function(e){
    var that = this
    // 请求后台 
    var req_url = 'Recommend/getRecommend'

    wx.request({
      url: app.globalData.host + req_url,
      data: {
        userId: that.data.userId,
     
      },

      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {
        var positionList=res.data.data
      },
      fail: function (res) {
      }
    })
  },
  onReady: function (e) {
    var windowWidth = 320;
    try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }

    radarChart = new wxCharts({
      canvasId: 'radarCanvas',
      type: 'radar',
      categories: ['实践能力', '技能能力', '任职资格', '团队能力'],
      series: [{
        data: [90, 80, 40, 20]
      }],
      width: windowWidth,
      height: 180,
      extra: {
        radar: {
          max: 100
        }
      }
    });
  }
});