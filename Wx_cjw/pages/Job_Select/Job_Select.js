//获取应用实例
var app = getApp()
Page({
  data: {
    list1: [
      { 'job': '互联网/电子商务' },
      { 'job': '计算机软件' },
      { 'job': 'IT服务（系统/数据/维护）' },
      { 'job': '电子技术/半导体/集成电路' },
      { 'job': '通信/电信/网络设备' },
      { 'job': '计算机硬件' },
      { 'job': '网络游戏' },
    ],
    list2: [
      { 'job': '项目管理/项目协调' },
      { 'job': '质量管理/安全防护' },
      { 'job': '高级管理' },
    ],
    list3: [
      { 'job': '证券/期货/投资管理/服务' },
      { 'job': '银行' },
      { 'job': '保险' },
      { 'job': '信托/担保/拍卖/典当' },
    ],
    animationData: {},
    animating: '',
    taName: '',
    shoufenqinName: '',
    animationShoufenqin: '',
    shoufenqinBloo: '',
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {

  },
  onShow: function () {


  },
  alllist() {
    if (this.data.animating) {
      this.animationHua.translate(0, 0).step();
      this.setData({
        animationData: this.animationHua.export(),
        animating: ''
      });
    }
  },
  //手风琴    ---------------------------------------
  shoufenqin(e) {
    var animation = wx.createAnimation({
      duration: 1000,
      timingFunction: 'ease',
    });
    this.animationShou = animation;
    this.animationHua = animation;
    this.animationHua.translate(0, 0).step();
    this.setData({
      animationData: this.animationHua.export(),
      animating: ''
    });

    var listid = e.currentTarget.dataset.listid;
    if (this.data.shoufenqinBloo) {
      this.animationShou.height(0).step();
      this.setData({
        animationShoufenqin: this.animationShou.export(),
        shoufenqinBloo: '',
      })
    } else {
      this.animationShou.height('auto').step();
      this.setData({
        animationShoufenqin: this.animationShou.export(),
        shoufenqinBloo: listid,
        shoufenqinName: listid,
      })
    }
  }
})
