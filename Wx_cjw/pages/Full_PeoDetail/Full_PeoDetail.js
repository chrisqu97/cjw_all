var app = getApp();var _page=0;

Page({  
  /**
   * 页面的初始数据
   */
  data: {  
     
    app_path: app.data.apiUrl,
    id:'',//方便存在本地的locakStorage  
    del_id:'',//方便存在本地的locakStorage  
    response:'' //存取返回数据  
  }, 
  onLoad:function(){
    this.createRecommend()
  },
 
  createRecommend: function (e) {
    var that = this
    // 请求后台 
    var req_url = 'Recommend/createRecommend'

    wx.request({
      url: app.globalData.host + req_url,
      data: {
        userId: that.data.userId,
        size: that.data.size
      },

      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {
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




  /**
   * ---------------------------------------
   */

  /**
* Img处理函数
*/
Full_PeoDetail_2_click:function(e){

},

/**
* text处理函数
*/
Full_PeoDetail_3_click:function(e){

},

/**
* text处理函数
*/
Full_PeoDetail_5_click:function(e){

},

/**
* text处理函数
*/
Full_PeoDetail_7_click:function(e){

},

/**
* Img处理函数
*/
Full_PeoDetail_8_click:function(e){

},

/**
* text处理函数
*/
Full_PeoDetail_24_click:function(e){

},

/**
* text处理函数
*/
Full_PeoDetail_25_click:function(e){

},


 
  /**
   * ---------------------------------------
   */


   /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})  

