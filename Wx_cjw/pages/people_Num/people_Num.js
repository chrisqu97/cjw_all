var wxCharts = require('../../utils/wxchart.js');
var app = getApp();
var radarChart = null;
Page({
  data: {
  },
  touchHandler: function (e) {
    console.log(radarChart.getCurrentDataIndex(e));
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