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

// * picker日期处理函数
// */
date_time_Change:function(e){
    this.setData({  
      date: e.detail.value
    })  
    console.log(e.detail.value)  
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

