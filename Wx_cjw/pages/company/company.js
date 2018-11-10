var app = getApp();
Page({
  data: {
    // 下拉菜单
    first: '规模',
    second: '行业',
    currentCompanySize:1,
    currentIndustry:1,
    // 筛选
    array: [{ name: '请选择' },{ name: '0-20' }, { name: '20-99' }, { name: '100-499' }, { name: '500-999' }, { name: '1000-9999' }, { name: '10000以上' }],
    industry: [{ industry: '请选择' },{ industry: '国有企业' }, { industry: '集体所有制企业' }, { industry: '私营企业' }, { industry: '有限责任公司' }, { industry: '股份有限公司' }, { industry: '有限合伙企业' }, { industry: '联营企业' }, { industry: '外商投资企业' }, { industry: '个人投资企业' }, { industry: '港澳台' }, { industry: '股份合作企业' }, { industry: '其他' }, ],
    // 前台显示list
    company: [],
    // 一页显示的条数
    pageSize: 10,
    // 当前页
    pageNum: 1,
    // 公司规模
    size:"1-99",
    // 公司类型
    companyType:1,
    industryid:1,
    index2:1,
    industryType:0,
    hasMoreData:true
  },
  isShow: true,
  currentTab: 0,


  onLoad: function (options) {
    var that=this
    that.getcompany()
  },

  detail:function(e){
var postId=e.currentTarget.dataset.id;
wx.navigateTo({
  url: './company_detail/company_detail?id='+postId,
})
  },
choosecompany:function(e){
  var that = this
  // 请求后台 
  // 获取第一页的list及总页数
  var req_url = 'Company/findByCondition'
  wx.request({
    url: app.globalData.host + req_url,
    data: {
      pageSize: that.data.pageSize,
      pageNum: that.data.pageNum,
      size: that.data.currentCompanySize,
       companyType: that.data.currentIndustry
    },

    header: {
      "Content-Type": "application/json",
      "session_key": app.globalData.session_key
    },
    method: "POST",

    success: function (res) {
      console.log(that.data.currentCompanySize)
      console.log(res.data.data.companyPojos)
      // 后端获取的公司列表
      var companylist = res.data.data.companyPojos
      // 前端需要渲染的公司列表
      var companyTem = that.data.company


      if (companylist.length < that.data.pageSize) {
        that.setData({
          company: companylist,
          hasMoreData: false
        })
      }
      else {
        that.setData({
          company: companylist,
          hasMoreData: true,
          pageNum: that.data.pageNum + 1
        })
      }
    },
    fail: function (res) {
    }
  })
},
  getcompany:function(e){
    var that = this
    // 请求后台 
    // 获取第一页的list及总页数
    var req_url = 'Company/findByCondition'
    wx.request({
      url: app.globalData.host + req_url,
      data: {
        pageSize: that.data.pageSize,
        pageNum: that.data.pageNum,
       
      },
     
      header: {
        "Content-Type": "application/json",
        "session_key": app.globalData.session_key
      },
      method: "POST",

      success: function (res) {
       
        // 后端获取的公司列表
        var companylist = res.data.data.companyPojos
        // 前端需要渲染的公司列表
        var  companyTem=that.data.company
       
      
        if (companylist.length< that.data.pageSize) {
          that.setData({
            company: companyTem.concat(companylist),
            hasMoreData: false
          })  
        }
        else {
          that.setData({
            company: companyTem.concat(companylist),
            hasMoreData: true,
            pageNum: that.data.pageNum + 1
          })
        }
      },
      fail: function (res) {
      }
    })
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
    
    if (this.data.hasMoreData) {
      wx.showToast({
        title: '正在加载' + this.data.pageNum + "页",
      })
      this.getcompany()
    } else {
      wx.showToast({
        title: '没有更多数据',
      })
    }
  },

  // 下拉切换
  hideNav: function () {
    this.setData({
      displays: "none"
    })
  },
  selectIndustry:function(e){
    this.choosecompany()
    this.setData({
      displays:"none"
    })
  },
  selectSize: function (e) {
    var that=this
    this.choosecompany()
 
    this.setData({
      displays: "none"

    })
   // console.log(res.data.company)
  },
  // 区域
  tabNav: function (e) {
    this.setData({
      displays: "block"
    })

    this.setData({
      selected1: false,
      selected2: false,
      selected: true
    })
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      var showMode = e.target.dataset.current == 0;
      this.setData({
        currentTab: e.target.dataset.current,
        isShow: showMode
      })
    }
  },

  // 获取 数字
  choseCompanySize: function (e) {
    var id = e.currentTarget.dataset.id;  //获取自定义的ID值  
    console.log("规模"+e.currentTarget.dataset.id)
    this.setData({
      currentCompanySize: id
    })
  
   
  },
  choseIndustry: function (e) {
    var id = e.currentTarget.dataset.id;  //获取自定义的ID值  
    console.log("规模" + e.currentTarget.dataset.id)
    this.setData({
      currentIndustry: id
    })
   // console.log(this.data.currentIndustry)
  },

})
