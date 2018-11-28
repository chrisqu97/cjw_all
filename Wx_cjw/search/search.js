// search/search.js
//把一下内容复制到需要使用该组件的页面
Page({
  data: {
      search_selected:0,
      search_value:''
  },
/*输入时*/
search_input:function(e){
    
},
/*获得焦点时*/
search_focus: function (e) {
  this.setData({
    search_selected: 1
  })
},
/*失去焦点时*/
search_blur: function (e) {

},
//点击取消时
search_cabcel:function(){

},
search_for_res:function(e){
  
}
})