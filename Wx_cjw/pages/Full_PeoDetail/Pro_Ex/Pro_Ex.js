// pages/Full_PeoDetail/Pro_Ex/Pro_Ex.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ta_value: '',
    ta_length: 0,
    ta_maxlength: 500,
    checkbox: [],
    projectExperiences:[]
  },
  insert: function () {
    var cb = this.data.checkbox;
    cb.push(this.data.checkbox.length);
    this.setData({
      checkbox: cb
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this


    that.setData({
      userData: app.globalData.userData
    })
    console.log(that.data.userData)
  },
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;//获取的表单信息
    var req_url = 'User/updateUser'


    //这里把表单值赋给userData

    that.data.userData.projectExperiences[0].content = formData.projectExperiences


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