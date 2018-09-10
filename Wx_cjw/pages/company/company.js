Page({
  data: {
    // 下拉菜单
    first: '规模',
    second: '行业',
    _num: 0,
    _res: 0,
    // 筛选
    array: [{ name: '0-20' }, { name: '20-99' }, { name: '100-499' }, { name: '500-999' }, { name: '1000-9999' }, { name: '10000以上' }],
    industry: [{ industry: '计算机软件' }, { industry: '游戏' }, { industry: '媒体' }, { industry: '广告营销' }, { industry: '数据服务' }, { industry: '医疗健康' }, { industry: 'O2O' }, { industry: '旅游' }, { industry: '企业服务' }, { industry: '信息安全' }, { industry: '运营' }, { industry: '其他' }],
    one: 0,
    two: 0,
    third: 0,
    four: 0,
    five: 0,
    six: 0,
    seven: 0,
  },
  isShow: true,
  currentTab: 0,

  // 下拉切换
  hideNav: function () {
    this.setData({
      displays: "none"
    })
  },
  queren:function(){
    this.setData({
      displays:"none"
    })
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

  // 筛选
  choseTxtColor: function (e) {
    var id = e.currentTarget.dataset.id;  //获取自定义的ID值  
    console.log(e.currentTarget.dataset.id)
    this.setData({
      one: id
    })
  },
  paixu: function (e) {
    var id = e.currentTarget.dataset.id;  //获取自定义的ID值  
    this.setData({
      seven: id
    })
  }
})
