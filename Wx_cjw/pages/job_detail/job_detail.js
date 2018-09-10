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
    response:'' //存取返回数据  
  }, 

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    app.checkLogin();
    app.getLaction();

    if (options.id != null && options.id !=""){
      this.setData({
        id: options.id
      })
    }   
    //执行初始化
    this.dataRefresh("init");
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
	//执行初始化
	this.dataRefresh("init");
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
    // 显示顶部刷新图标  
    _page=0;
    wx.showNavigationBarLoading();  
    this.dataRefresh("init");
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

  //刷新数据
  dataRefresh:function(_action) {
    //提交到服务器
    var that = this
    wx.request({
      url: app.data.apiUrl+'/job_detail.aspx',
      data: {
        action: _action,
        uid: app.data.uid,
        //定义变量---start
	4: that.data.index_4,
5: that.data.index_5,

        //定义变量---end
        id: that.data.id,
	del_id: that.data.del_id,
	_page:_page
      },
      method: 'GET',
      success: function (res) {
        console.log(res.data);
        var tmp = res.data;

        if(_action=="init"){
		that.setData({
		array_4: tmp.picker_4,
		array_5: tmp.picker_5,

			response: res
		})
	}



	that.setData({
		response: res
        })

	if (tmp.message != null && tmp.message != "") {
          wx.showToast({
            title: tmp.message,
            icon: 'none',
            duration: 2000
          })
        }
        
	if(tmp._page!=null && tmp._page!=""){
	  _page=tmp._page;
	}
	
        // 隐藏导航栏加载框  
        wx.hideNavigationBarLoading();
        // 停止下拉动作  
        wx.stopPullDownRefresh();  

        // 隐藏加载框  
        wx.hideLoading();  

      },
      fail: function (res) {
        console.log(res.data);
        console.log('is failed')
      }
    })
  },

   /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})  

