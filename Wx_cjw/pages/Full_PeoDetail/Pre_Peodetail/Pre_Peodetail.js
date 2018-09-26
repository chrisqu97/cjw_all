// pages/Full_PeoDetail/Pre_Peodetail/Pre_Peodetail.js
var app = getApp() 
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    userdata:[]

  },
 
  onLoad: function () {
   this.getusrInfo(),
   this.getjianli()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },
  getjianli: function () {
    var that = this
    var req_url = 'User/findByUserId'
    var userdata=this.data.userdata

    wx.request({
      url: app.globalData.host + req_url,
      data: {
        userId: 1
      },
      method: 'GET',
      header: {
        'content-type': 'application/json', // 默认值
        "session_key": "VTERSv7f1ANeWlG5/iViO2QEvNQlVt4P2TTvuQNL+7xf0f9sgs/xtSnZ24yZCjSL"
      },
      method: "POST",
      success: function (res) {
        console.log("请求简历成功");
        that.setData({
          userdata: res.data.userdata
        })
        console.log(that.data.userdata)
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },
  getusrInfo: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
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