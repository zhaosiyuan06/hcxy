$(function(){
       // 面包屑下拉框
    $('.header_box .imgaa').on('mouseover', function(){
        $('.top-header .header_box span').slideToggle();
    })

    // var flag=true;
    // $(".header_box .imgaa").on("click",function(){
    //     if(flag){
    //         // alert(1)
    //         $(".top-header .header_box span").toggleClass("active").removeClass("none");
    //         flag=false;
    //         return
    //     }else if(flag==false){
    //         // alert(2)
    //         $(".top-header .header_box span").removeClass("active").toggleClass("none");
    //         flag=true;
    //     }
    // })

})