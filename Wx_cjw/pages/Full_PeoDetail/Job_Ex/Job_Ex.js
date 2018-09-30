// pages/Full_PeoDetail/Job_Ex/Job_Ex.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ta_value: '',
    checkbox: [],
    workExperiences:[]
  },
  insert: function () {
    var cb = this.data.checkbox;
    cb.push(this.data.checkbox.length);
    this.setData({
      checkbox: cb
    });
  },
  formSubmit: function (e) {
    var that = this;
    var formData  = e.detail.value;
    var req_url = 'User/addWorkExperience'

    console.log(formData)
    wx.request({
      url: app.globalData.host + req_url,
      data: formData,
      header: {
        "Content-Type": "application/json",
        "session_key": "VTERSv7f1ANeWlG5/iViO2QEvNQlVt4P2TTvuQNL+7xf0f9sgs/xtSnZ24yZCjSL"
      },
      method: "POST",
      success: function (res) {
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