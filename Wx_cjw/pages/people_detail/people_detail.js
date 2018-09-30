var app = getApp();
Page({  
  /**
   * 页面的初始数据
   */
  data: {  
    date:'2018-01-01',//
     location:['四川省', '成都市', '锦江区'],
     userData:null,
     education:  ['专科', '本科', '硕士', '博士','博士后','其他'],
     index:0
  }, 
  onLoad: function () {
    //获取用户信息
    var that = this
    that.setData({
      userData: app.globalData.userData
    })
    console.log(that.data.userData)
  },
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;//获取的表单信息
    var req_url = 'User/updateUser'
   
   //这里把表单值赋给userData
    that.data.userData.userName=formData.userName
    that.data.userData.birthday = formData.birthday
    that.data.userData.educationalExperiences[0].schoolName=formData.school
    that.data.userData.educationalExperiences[0].education = formData.education
    that.data.userData.phone = formData.phone
    that.data.userData.education = formData.education
    that.data.userData.desiredWorkingPlace = formData.desiredWorkingPlace
    that.data.userData.myAdvantage = formData.myAdvantage

    console.log(that.data.userData)

    wx.request({
      url: app.globalData.host + req_url,
      data: that.data.userData,//把修改后userData发送给后端
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",
      success: function (res) {
        //修改成功后把数据归档到全局数据
        app.globalData.userData=that.data.userData
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
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
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

