//app.js
var app = getApp() 
App({
  data: {
    role: "",
    uid: "",
    latitude: "",
    longitude: "",
    code:"",
    encryptedData:"",
    iv:"",
    session_key:""
  },

  getLaction: function () {
    var that = this;
    wx.getLocation({
      type: 'gcj02', //返回可以用于wx.openLocation的经纬度
      success: function (res) {
        var latitude = res.latitude
        var longitude = res.longitude
        that.data.latitude = latitude;
        that.data.longitude = longitude;
      }
    })
  },
  cjwLogin:function(){
    var req_url = 'User/login'
    wx.request({
        url: app.globalData.host + req_url,
      data:{
        //code调用login()获取
        code: wx.getStorageSync("code"),
        //这两个参数调用getUserInfo()获取
        encryptedData: wx.getStorageSync("encryptedData"),
        iv:wx.getStorageSync("iv")
      },
      method:"GET",
      success(res){
        console.log(res)
        //之后请求就获取一下session_key然后放在header里请求
        wx.setStorageSync("session_key", res.sessionKey)
      }
      
      
    })
   
      
  
    

  },
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        //存储code
        wx.setStorageSync("code", res.code)
        console.log(res)
      }
    })

    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              console.log(res)
              //存储encryptedData和iv
              wx.setStorageSync("encryptedData", res.encryptedData)
              wx.setStorageSync("iv", res.iv)
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
    
    //获取用户信息
    var that = this
    var req_url = 'User/findByUserId'
    wx.request({
      url: that.globalData.host + req_url,
      data: {
        userId: 1
      },
     
      header: {
        'content-type': 'application/json', // 默认值
        "session_key": that.globalData.session_key
      },
      method: "POST",
      success: function (res) {
        console.log("请求用户信息成功");
        that.globalData.userData=res.data.data
        console.log(that.globalData.userData)
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
    
  },
  
  globalData: {
    userInfo: null,
    host: "http://localhost:8080/",
    // host:"http://115.159.209.104:8080/",
    //小程序appid
    projectId: "wxe12df03a91262d60center",
    //临时用户id
    // userid: 'lisi2',
    session_key: "VTERSv7f1ANeWlG5/iViO2QEvNQlVt4P2TTvuQNL+7xf0f9sgs/xtSnZ24yZCjSL",
    userData:null
  }

})