var app = getApp();
Page({  
  /**
   * 页面的初始数据
   */
  data: {  
    date:'2018-01-01',//
     location:['四川省', '成都市', '锦江区'],
  
  }, 
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;
    var req_url = 'User/updateUser'
   
    console.log(formData)
    wx.request({
      url: app.globalData.host + req_url,
      data: formData,
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log("成功")
       wx.showToast({
         title: '成功',
         icon: 'succes',
         duration: 1000,
         mask: true
       })
     
      }
    })
  },

// * picker日期处理函数
// */
date_time_Change:function(e){
    this.setData({  
      date: e.detail.value
    })  
    console.log(e.detail.value)  
},

  onLoad: function (options) {
    // / 默认联动显示北京
    var id = address.provinces[0].id
    this.setData({
      provinces: address.provinces,
      citys: address.citys[id],
      areas: address.areas[address.citys[id][0].id],
    })
  },


/**
* picker城市处理函数
// */
location_Change:function(e){
    this.setData({  
      location: e.detail.value
    })  
    console.log(e.detail.value)  
},

})  

