/**
 * Created by Administrator on 2017/7/13.
 */
$(function () {
//   导航栏
    $('.header_box span').on('mouseenter mouseleave', function (e) {
        $(this).find('ul').slideToggle()
        e.preventDefault();
    })
    //主营业务
    // $('.con1').on("mouseenter", function(){
    //     $(this).find('.con_box2').slideDown()
    // })
    // $('.con1').on("mouseleave", function(){
    //     $(this).find('.con_box2').slideUp()
    // })
    //监听鼠标滚动，设置导航栏背景色
    $(window).scroll(function() {
        var s =$(window).scrollTop();
        if (s>=752) {//782是导航条离页面顶部的距离（px）
            $(".top-header").addClass("colors")
        }
        else{
            $('.top-header').removeClass('colors');
        }
    })
})
