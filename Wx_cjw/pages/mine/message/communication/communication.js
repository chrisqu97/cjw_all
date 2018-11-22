// pages/mine/message/communication/communication.js
var app=getApp()
Page({
  data: {
    //消息模板
    message: {
      "content": '',
      "userId":'',
      "accepterId":'',
      "positionId":'',
    },
    messageList:[
      {
        "content": 123,
        "userId": 123,
        "accepterId": 1,
        "positionId": 1,
      },
    ],
  },
  sendSocketMessage: function (msg) {
    wx.sendSocketMessage({
      data: msg
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //设置从前一个跳转带过来的参数
    var that=this
    // that.data.message.userId=options.userId
    // that.data.message.accepterId=options.accepterId
    // that.data.message.positionId=options.positionId
    that.data.message.userId=123
    that.data.message.accepterId=1
    that.data.message.positionId=1
    that.setData({
      message:that.data.message
    })

    //开启失败监控
    wx.onSocketError(function (res) {
      console.log('WebSocket连接打开失败，请检查！')
    })
    //开启服务器消息监控
    wx.onSocketMessage(function (res) {
      console.log('收到服务器内容：' + res.data)
    })
    

  },
  //更新消息的内容
  updateMessageContent:function(e){
    var that=this
    that.data.message.content = e.detail.value;
  },
  //追加消息
  addMessage: function (msg) {
    var that = this
    that.data.messageList.push(msg)
    console.log(that.data.messageList)
    that.setData({
      messageList: that.data.messageList
    })
  },

//发送消息
sendMsg :function(e){
  var that=this
  that.addMessage(that.data.message)
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