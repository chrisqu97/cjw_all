// pages/mine/message/communication/communication.js
var app=getApp()
Page({
  data: {
    message: [{
      "content": "",
      "userId": 123,
      "accepterId": 2,
      "positionId": 1,
    }],
    messageList:[],
    content:""

  },
  sendSocketMessage: function (msg) {
    wx.sendSocketMessage({
      data: msg
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    //开启失败监控
    wx.onSocketError(function (res) {
      console.log('WebSocket连接打开失败，请检查！')
    })
    //开启服务器消息监控
    wx.onSocketMessage(function (res) {
      console.log('收到服务器内容：' + res.data)
    })
    

  },
  message:function(e){
    var that=this
    var index=0
   var content=that.data.content
     that.data.message[index].content = e.detail.value;

  },

//发送消息
sendMsg :function(e){
  var that=this
  //后端获取聊天记录
  var messageHt = [{content:"你好"},{content:"123"}]
// 前台消息
var message=that.data.message
// 消息列表
  var messageList=that.data.messageList

var content=that.data.content
  that.setData({
    messageList:messageHt.concat(message),

    
      })
console.log(messageList)
  //开启连接
  wx.connectSocket({
    url: 'ws://localhost:8080/webSocketServer',
    header: {
      'content-type': 'application/json',
      'userId': "123"
    },
  })
  
  //检查连接是否开启 回调成功才能发送消息
  wx.onSocketOpen(function (res) {
    
    //发送
    that.sendSocketMessage(JSON.stringify(that.data.message))
  })
  console.log(that.data.message)
},

//关闭连接
close:function(e){
  wx.onSocketClose(function (res) {
    console.log('WebSocket 已关闭！')
  })
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
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})