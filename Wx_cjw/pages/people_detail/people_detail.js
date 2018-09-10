var app = getApp();var _page=0;

Page({  
  /**
   * 页面的初始数据
   */
  data: {  
    date:'2018-01-01',//
    location:['四川省', '成都市', '锦江区'],
    people_detail_29:'',//
 
    app_path: app.data.apiUrl,
    id:'',//方便存在本地的locakStorage  
    del_id:'',//方便存在本地的locakStorage  
    response:'' //存取返回数据  
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



// 表单提交处理函数
  submit:function(e){

  },



/**
* input处理函数
*/
people_detail_15_input:function(e){
    this.setData({  
    
    })  
    console.log(e.detail.value)  
},

/**
* text处理函数
*/
people_detail_16_click:function(e){

},

/**
* text处理函数
*/
people_detail_17_click:function(e){

},

/**
* text处理函数
*/
people_detail_18_click:function(e){

},

/**
* text处理函数
*/
people_detail_19_click:function(e){

},

/**
* text处理函数
*/
people_detail_21_click:function(e){

},

/**
* text处理函数
*/
people_detail_23_click:function(e){

},

/**
* picker日期处理函数
*/
date_time_Change:function(e){
    this.setData({  
      date_time: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* input处理函数
*/
people_detail_25_input:function(e){
    this.setData({  
    
    })  
    console.log(e.detail.value)  
},

/**
* input处理函数
*/
people_detail_26_input:function(e){
    this.setData({  
  
    })  
    console.log(e.detail.value)  
},

/**
* input处理函数
*/
people_detail_27_input:function(e){
    this.setData({  
   
    })  
    console.log(e.detail.value)  
},

/**
* picker城市处理函数
*/
location_Change:function(e){
    this.setData({  
      location: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* textarea处理函数
*/
people_detail_29_input:function(e){
    this.setData({  
     
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
      url: app.data.apiUrl+'/people_detail.aspx',
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

