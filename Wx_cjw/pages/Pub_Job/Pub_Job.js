var app = getApp();var _page=0;

Page({  
  /**
   * 页面的初始数据
   */
  data: {  
        Pub_Job_6:'',//
    Pub_Job_7:'',//
    location:['四川省', '成都市', '锦江区'],
    array_Pub_Job_10:['请选择'],//
    index_Pub_Job_10:0,
    price: ['1000月/以下', '1000-2000元', '2001-4000元', '4000-6000元', '6001-8000元', '8001-10000元', '100001-15000元', '15K以上'],
    index:0,
    people_number:['1','2','3','4','5','6'],//
    index_n:0,
    Pub_Job_29:'',//
 
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
   * ---------------------------------------
   */

  /**
* Img处理函数
*/
Pub_Job_2_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_3_click:function(e){

},

/**
* input处理函数
*/
Pub_Job_6_input:function(e){
    this.setData({  
      6: e.detail.value
    })  
    console.log(e.detail.value)  
},

/**
* textarea处理函数
*/
Pub_Job_7_input:function(e){
    this.setData({  
      7: e.detail.value
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
* button处理函数
*/
Pub_Job_14_click:function(e){
   wx.navigateTo({
     url: './pub_job2/pub_job2',
   })

   
},

/**
* Img处理函数
*/
Pub_Job_15_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_17_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_18_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_19_click:function(e){

},

/**

/**
* text处理函数
*/
Pub_Job_21_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_22_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_23_click:function(e){

},

/**
* text处理函数
*/
Pub_Job_24_click:function(e){

},

/**
* picker处理函数
*/
Pub_Job_24_Change:function(e){
   console.log('picker发送选择改变，携带值为', e.detail.value);
   this.setData({
     index: e.detail.value
   })
},

/**
* text处理函数
*/
Pub_Job_25_click:function(e){

},

/**
* picker处理函数
*/
Pub_Job_25_Change:function(e){
   console.log('picker发送选择改变，携带值为', e.detail.value);
   this.setData({
     index_n: e.detail.value
   })
},

/**
* text处理函数
*/
Pub_Job_28_click:function(e){

},

/**
* input处理函数
*/
Pub_Job_29_input:function(e){
    this.setData({  
      29: e.detail.value
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
      url: app.data.apiUrl+'/Pub_Job.aspx',
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
		array_10: tmp.picker_10,
		array_20: tmp.picker_20,
		array_24: tmp.picker_24,
		array_25: tmp.picker_25,

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

