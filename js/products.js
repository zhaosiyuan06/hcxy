/**
 * Created by Administrator on 2017/7/18.
 */
$(function () {
//   导航栏
    $('.header_box span').on('mouseenter mouseleave', function () {
        $(this).find('ul').slideToggle()
    })
    //主营业务
    $('.con1').on("mouseenter mouseleave", function () {
        $(this).find('.con_box2').slideToggle()
    })

    //    面包屑下拉框
    $('.mianbaoxie').on('click', function () {
        $('.media ul').slideToggle();
    })
    $(".media ul li").on("click",function(){
        $(this).find("img").addClass("img_animate")
        $(this).find('div').slideToggle()
    })


    //项目展示
    //var iframe=$('iframe')
    //$('.play').on('click',function(){
    //    //for( var i=0;i<iframe.length;i++){
    //    //   iframe.attr('src', 'img/product'+i+'.jpg');
    //    //}
    //    $('.color').addClass('colorss')
    //    $('.close').css('display','block');
    //    $(this).next().addClass('big')
    //    $('.big').attr('src','unit3d/11111.html');
    //    //$(this).next().attr('src','unit3d/333/333.html');
    //})
    //
    //$('.color .close').on('click',function(){
    //    $('.color').removeClass('colorss')
    //    $('.close').css('display','none');
    //    iframe.removeClass('big')
    //    $('.product_list iframe').attr('src','img/product0.jpg')
    //    $('.product_list1 iframe').attr('src','img/product1.jpg')
    //
    //
    //})

    var iframe=$('iframe')
   $('.play').on('click',function(value){
      var val=$(this).attr('value')
       //alert(val)
       $('.openIframe').css('display','block');
       $('.color').addClass('colorss')
       $('.close').css('display','block');
       //iframe.attr('src','unit3d/2/2.html');
       iframe.attr('src',"unit3d/"+val+"/"+val+".html");
       //alert("unit3d/"+val+"/"+val+".html")

       //$.ajax({
       //    type:"GET",
       //    url:"filecAction_filecList",
       //    data:{
       //           lujing:lujing,
       //           value:value
       //         },
       //    dataType:"json",
       //    success: function(msg){
       //       var data = eval("("+msg+")");
       //        $(data).each(function(i,v){
       //            $('iframe').attr('src',v.lujing);
       //            $("span").text(v).appendTo(".product_list .list")
       //            $('h2').html( v.value).appendTo(".product_list .list");
       //        })
       //        //iframe.attr('src',data.lujing);
       //        //$('.product_list .product_box .list h2').html( data.value);
       //    },
       //    error:function(data){
       //         alert("失败了！")
       //    }
       //})
       var isAjaxMocked = true;
       if (isAjaxMocked) {
           $.mockjax({
               url: 'http://www.mocky.io/v2/5981d8ec110000c00b396418',
               status: 200,
               responseTime: 750,
               responseText: 'User Information'
           });
       }
       $.ajax({
           type:"POST",
           url:"http://www.mocky.io/v2/5981d8ec110000c00b396418",
           data:{
               roud:roud,
               value:value
           },
           dataType:"json",
           async:false,
           success: function(msg){
               alert("成功了！")
               alert(mag)
               //var data = eval("("+msg+")");
               //$(data).each(function(i,v){
               //    alert(v.roud)
               //    alert(v)
               //    alert(v.value)
               //    //$('iframe').attr('src',v.lujing);
               //    //$("span").text(v).appendTo(".product_list .list")
               //    //$('h2').html( v.value).appendTo(".product_list .list");
               //})
           },
           error:function(data){
               alert("失败了！")
           }
       })

   })
    $('.color .close').on('click',function(){
            $('.color').removeClass('colorss')
            $('.close').css('display','none');
            $('.openIframe').css('display','none');
            //$('.product_list iframe').attr('src','img/product0.jpg')
            //$('.product_list1 iframe').attr('src','img/product1.jpg')
        })
})
