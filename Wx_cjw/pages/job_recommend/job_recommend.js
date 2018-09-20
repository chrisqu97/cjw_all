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
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },
  main_19_click: function (e) {
wx.navigateTo({
  url: '../job_detail/job_detail',
})
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

