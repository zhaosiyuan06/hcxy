/**
 * Created by Administrator on 2017/7/18.
 */
$(function () {
    function myBrowser(){
        var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
        var isOpera = userAgent.indexOf("Opera") > -1;
        if (isOpera) {
            return "Opera"
        }; //判断是否Opera浏览器
        if (userAgent.indexOf("Firefox") > -1) {
            return "FF";
        } //判断是否Firefox浏览器
        if (userAgent.indexOf("Chrome") > -1){
            return "Chrome";
        }
        if (userAgent.indexOf("Safari") > -1) {
            return "Safari";
        } //判断是否Safari浏览器
        if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
            return "IE";
        }; //判断是否IE浏览器
    }

    //以下是调用上面的函数
    var mb = myBrowser();
    if ("IE" == mb) {
         //alert("我是 IE");
        $.ajax({
            type:"POST",
            url:"filecAction_filecWebList",
            dataType:"json",
            success: function(msg){
//               var data = eval("("+msg+")");
                $(msg).each(function(i,v){
             	   if(i%2==1){
             		   // console.log(i)
             	  	   $('.color').append("<div class=\"product_list\">"
                                +"<div class=\"product_box\">"
                                +"<div class=\"list\">"
                                +"<span>"+(v.id)/2+"</span>"
                                +"<h2>"+v.fileTitle+"</h2>"
                                +"<p>"+v.fileContent+"</p>"
                                +"</div>"
                                +"<div class=\"shows\">"
//                                +"<div class=\"play\" value="+v.path+">"+"</div>"
                                +"<img class=\"imgs\" src=\"img/product0.jpg\" value="+v.path+" alt=\"\">"
                                +"</div>"
                                +"</div>"
                                + "</div>");
                 	   $('.imgs').on('click',function(){
                 	       var val=$(this).attr('value')               	      
                 	      var url="http://hcxyrjkf.cn/OfficialWebsite/"+val;
                  	      window.open(url, '_blank');
                 	   })
             	   }
           
                })
            },
            error:function(data){
                 alert("0")
            }
        })

    }else {
    	$.ajax({
            type:"POST",
            url:"filecAction_filecWebList",
            dataType:"json",
            success: function(msg){
//               var data = eval("("+msg+")");
                $(msg).each(function(i,v){
             	   if(i%2==0){
             		   console.log(i)
             	  	   $('.color').append("<div class=\"product_list\">"
                                +"<div class=\"product_box\">"
                                +"<div class=\"list\">"
                                +"<span>"+v.id+"</span>"
                                +"<h2>"+v.fileTitle+"</h2>"
                                +"<p>"+v.fileContent+"</p>"
                                +"</div>"
                                +"<div class=\"shows\">"
//                                +"<div class=\"play\" value="+v.path+">"+"</div>"
                                +"<img class=\"imgs\" src=\"img/product0.jpg\" value="+v.path+" alt=\"\">"
                                +"</div>"
                                +"</div>"
                                + "</div>");
                 	   $('.imgs').on('click',function(){
                 	       var val=$(this).attr('value')
                 	      var url="http://hcxyrjkf.cn/OfficialWebsite/"+val;
                 	      window.open(url, '_blank');
                 	   })
             	   }
           
                })
            },
            error:function(data){
                 
            }
        })
	}
       

    $('.color .close').on('click',function(){
            $('.color').removeClass('colorss')
            $('.close').css('display','none');
            $('.openIframe').css('display','none');
        })
      
})
