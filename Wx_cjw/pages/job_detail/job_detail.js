var app = getApp();var _page=0;

Page({  
  /**
   * 页面的初始数据
   */
  data: {  
        array_job_detail_4:['请选择'],//
    index_job_detail_4:0,
    array_job_detail_5:['请选择'],//
    index_job_detail_5:0,
 
    app_path: app.data.apiUrl,
    id:'',//方便存在本地的locakStorage  
    del_id:'',//方便存在本地的locakStorage  
    response:'', //存取返回数据 ，
    posdetail:[],
 
  }, 
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  var that=this;
  var positionId=options.id;
  this.setData({
    positionId:positionId
  })
    console.log(positionId)
    that.getposition()
  },
  
  getposition: function(){
    var that = this
    // 请求后台 
    var req_url = 'Position/findById'
    
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        positionId: that.data.positionId
      },

      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {

        // 后端获取的公司详情
        var position = res.data.data
        console.log(res.data.data)
        // 前端需要渲染的公司详情
        var posdetail = position
        that.setData({
          posdetail: position,
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
   * 页面上拉触底事件的处理函数
   */
 


  /**
   * ---------------------------------------
   */

  /**
* Img处理函数
*/
job_detail_1_click:function(e){

},

/**
* picker处理函数
*/
job_detail_4_Change:function(e){
   console.log('picker发送选择改变，携带值为', e.detail.value);
   this.setData({
     index_4: e.detail.value
   })
},

/**
* picker处理函数
*/
job_detail_5_Change:function(e){
   console.log('picker发送选择改变，携带值为', e.detail.value);
   this.setData({
     index_5: e.detail.value
   })
},

/**
* text处理函数
*/
job_detail_7_click:function(e){

},

/**
* Img处理函数
*/
job_detail_8_click:function(e){

},

/**
* text处理函数
*/
job_detail_9_click:function(e){

},

/**
* text处理函数
*/
job_detail_10_click:function(e){

},

/**
* Img处理函数
*/
job_detail_11_click:function(e){

},

/**
* text处理函数
*/
job_detail_13_click:function(e){

},

/**
* text处理函数
*/
job_detail_15_click:function(e){

},

/**
* text处理函数
*/
job_detail_16_click:function(e){

},

/**
* Img处理函数
*/
job_detail_28_click:function(e){

},

/**
* button处理函数
*/
job_detail_29_click:function(e){

},

/**
* Img处理函数
*/
job_detail_32_click:function(e){

},

/**
* button处理函数
*/
job_detail_34_click:function(e){
   
  wx.showToast({
    title: '成功',
    icon: 'succes',
    duration: 1000,
    mask: true
  })
   
},


/**
* Img处理函数
*/
job_detail_35_click:function(e){

},

/**
* Img处理函数
*/
job_detail_38_click:function(e){

},

/**
* text处理函数
*/
job_detail_40_click:function(e){

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

