// pages/search_page/search_res/search_res.js
const app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    positionName:'',
    positions:[],
    pageSize:10,
    pageNum:1
  },

  findByPositionName:function(){
    var that = this
    var req_url = "Position/findByPositionName"
    wx.request({
      url: app.globalData.host + req_url,
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      data:{
        pageSize:that.data.pageSize,
        pageNum:that.data.pageNum,
        positionName:that.data.positionName
      },
      method: "POST",
      success: function (res) {
        console.log(res.data.data)
        that.setData({
          positions: res.data.data.positionPojos
        })
      },
      fail: function (res) {
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.positionName)
    var that =this
    that.setData({
      positionName: options.positionName
    })
    this.findByPositionName()
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