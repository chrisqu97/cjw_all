var app = getApp();var _page=0;

Page({  
  /**
   * 页面的初始数据
   */
  data: {  
    school: ['985', '211', '一本','二本','三本','专科','其他'],
    index:0,
    date: '2016-09-26',
    app_path: app.data.apiUrl,
    id:'',//方便存在本地的locakStorage  
    del_id:'',//方便存在本地的locakStorage  
    response:'' //存取返回数据  
  }, 
  
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },
  DatePickerSelected: function (e) {
    this.setData({
      date: e.detail.value
    })
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
   * ---------------------------------------
   */

  /**
* input处理函数
*/
renzheng_6_input:function(e){
    this.setData({  
      6: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
renzheng_10_click:function(e){

},

/**
* input处理函数
*/
renzheng_11_input:function(e){
    this.setData({  
      11: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
renzheng_14_click:function(e){

},

/**
* input处理函数
*/
renzheng_15_input:function(e){
    this.setData({  
      15: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
renzheng_19_click:function(e){

},

/**
* input处理函数
*/
renzheng_20_input:function(e){
    this.setData({  
      20: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
r1_click:function(e){

},



/**
* text处理函数
*/
r2_click:function(e){

},



/**
* text处理函数
*/
r3_click:function(e){

},



/**
* text处理函数
*/
renzheng_27_click:function(e){

},

/**
* input处理函数
*/
renzheng_28_input:function(e){
    this.setData({  
      28: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
renzheng_30_click:function(e){

},

/**
* input处理函数
*/
renzheng_31_input:function(e){
    this.setData({  
      31: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
renzheng_33_click:function(e){

},

/**
* input处理函数
*/
renzheng_34_input:function(e){
    this.setData({  
      34: e.detail.value
    })  
    console.log(e.detail.value)  
},


 
  /**
   * ---------------------------------------
   */

  //刷新数据
  dataRefresh:function(_action) {
    //提交到服务器
    var that = this
    wx.request({
      url: app.data.apiUrl+'/renzheng.aspx',
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

