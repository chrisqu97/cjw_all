// pages/Full_PeoDetail/Job_YX/Job_YX.js
var app = getApp();

Page({
  data: {
    price: ['1000月/以下', '1000-2000元', '2001-4000元', '4000-6000元', '6001-8000元', '8001-10000元', '100001-15000元', '15K以上',],
    index: 0,
  },
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
   

    that.setData({
      userData: app.globalData.userData
    })
   
  },
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;//获取的表单信息
    var req_url = 'User/updateUser'
    var index = 0

    //这里把表单值赋给userData
    that.data.userData.jobIntension.positionTypeName = formData.positionTypeName
    that.data.userData.jobIntension.salary = formData.salary
   


    wx.request({
      url: app.globalData.host + req_url,
      data: that.data.userData,//把修改后userData发送给后端
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",
      success: function (res) {
        //修改成功后把数据归档到全局数据
        app.globalData.userData = that.data.userData
        console.log(res)

        wx.showToast({
          title: '成功',
          icon: 'succes',
          duration: 1000,
          mask: true
        })
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
  
  }
})