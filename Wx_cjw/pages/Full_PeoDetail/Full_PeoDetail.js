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
  onReachBottom: function () {
    var that = this;
    // 显示加载图标  
    wx.showLoading({
      title: '玩命加载中',
    })
    // 页数+1  
    _page = _page + 1;  

    this.dataRefresh("init");
  },


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

  //刷新数据
  dataRefresh:function(_action) {
    //提交到服务器
    var that = this
    wx.request({
      url: app.data.apiUrl+'/Full_PeoDetail.aspx',
      data: {
        action: _action,
        uid: app.data.uid,
        //定义变量---start
	
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

