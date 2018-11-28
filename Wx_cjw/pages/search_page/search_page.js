// pages/search_page/search_page.js
const app=getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    search_selected: 1,
    positionName: '',
    tag_selected:1,
    positionNames: [],
  },
  //搜索职位名称
  getPositionName: function () {
    var that = this
    var req_url = "Position/getPositionName"
    wx.request({
      url: app.globalData.host + req_url + "?positionName=" + that.data.positionName,
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "GET",
      success: function (res) {
       
        that.setData({
          positionNames: res.data.data
        })
      },
      fail: function (res) {
      }
    })
  },
  /*输入时*/
  search_input: function (e) {
    this.setData({
      positionName: e.detail.value,
      tag_selected: 0
    })
    if (e.detail.value.length==0){
      this.setData({
        tag_selected: 1
      })
    }
    this.getPositionName()
  },
  /*获得焦点时*/
  search_focus: function (e) {
    this.setData({
      search_selected: 1
    })
  },
  /*失去焦点时*/
  search_blur: function (e) {
    
  },
  
  //点击取消时
  search_cabcel: function () {
    this.setData({
      positionName: '',
      tag_selected: 1
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  }
})