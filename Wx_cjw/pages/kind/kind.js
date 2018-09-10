// pages/kind/kind.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
      kinds:0,
      current:0,
      //类别
      tag_name1s:[
        {
          tagName1:"IT",
          tagName2s: ["软件", "数据库"]
        },
        {
          tagName1: "艺术",
          tagName2s: ["美工"]
        }
      ],
     //请求tagList
      tagList:[
        {
          tag_name2:"银行",
          tags: [
            {
              tag_id: "1",
              tag_name3: "银行客户主管",
            },
            {
              tag_id: "2",
              tag_name3: "银行大堂经理",
            },
            {
              tag_id: "3",
              tag_name3: "银行客户总监",
            },
            {
              tag_id: "4",
              tag_name3: "银行客户代表",
            },
          ]
      },
        {
          tag_name2: "证券、期货",
          tags: [
            {
              tag_id: "1",
              tag_name3: "证券总监",
            },
            {
              tag_id: "2",
              tag_name3: "证券、期货、外汇经纪人",
            },
            {
              tag_id: "3",
              tag_name3: "银行客证券、投资客户总监户总监",
            },
            {
              tag_id: "4",
              tag_name3: "证券、投资客户代表",
            },
          ]
        },
        {
          tag_name2: "保险",
          tags: [
            {
              tag_id: "1",
              tag_name3: "保险业务管理",
            },
            {
              tag_id: "2",
              tag_name3: "保险顾问、财务规划师",
            },
            {
              tag_id: "3",
              tag_name3: "保险培训师",
            },
            {
              tag_id: "4",
              tag_name3: "汽车定损、车险理赔",
            },
          ]
        },
      ]
  },
 //获取tagList
 getTagList:function(){
   var that = this
   var req_url = '/showTagList'
   wx.request({
     url: app.globalData.host + req_url,
     data: {
       kinds: that.data.kinds,
       tag_name1: that.data.tag_name1s[that.data.current]
     },
     method: 'GET',
     header: {
       'content-type': 'application/json' // 默认值
     },
     success: function (res) {
       that.setData({
         tagList:res.data.tagList
       })
       console.log(that.data.tagList);
     },
     fail: function (res) {
       console.log(".....fail.....");
     }
   })
 },
 //点击更换tag_name1
 changeCurrent:function(e){
    this.setData({
      current:e.target.id
    })
    this.getTagList()
 },
 //点击标签
 tagClick:function(e){
    var id=e.target.id
    console.log(id)
 },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getTagList()
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