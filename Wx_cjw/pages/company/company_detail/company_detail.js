// pages/company/company_detail/company_detail.js
var app = getApp() 
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //当前所选选项卡
    search_selected: 0,
    search_value: '',
    currentTab: 0,
    companyId:1,

  },

  main_19_click: function (e) {
    wx.navigateTo({
      url: '../../job_detail/job_detail',
    })


  },
  
  onLoad: function (options) {
  var that=this;
    var companyId = options.id;
 this.setData({
   companyId:companyId
 })

that.getcompanydetail()
  },

  getcompanydetail: function (e) {
    var that = this
    // 请求后台 
    var req_url = 'Company/findById'
    
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        companyId:that.data.companyId
      },

      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {
       
        // 后端获取的公司详情
        var companydetail = res.data.data

        // 前端需要渲染的公司详情
        var comdetail = companydetail
          that.setData({
            comdetail: companydetail,
          })

      },
      fail: function (res) {
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
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