<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/nheader.css">
	<link rel="stylesheet" href="css/nstyle.css">
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="js/nheader.js"></script>
	<script src="js/index.js"></script>
	</head>
<body>
	<div class="top-header">
    <!--顶部面包屑开始-->
    <div class="login" style="float: right;height: 100%;line-height: 50px;margin-right: 20px;color:white;font-size: 16px">
    <s:if test=" #session.admName == null || #session.admName.isEmpty()" >
        <a href="register.html" target="_blank">注册</a>
        <span>/</span>
        <a href="login.html" target="_blank" >登录</a>
     </s:if>
    	  		<s:else>
    	  		${admName}
    	  		</s:else>   
    </div>
    <!--<a href="index.html" style="background: paleturquoise" target="_top">-->
        <!--<div class="shouye"></div>-->
    <!--</a>-->
    <!--<div class="login-media" style="height: 100%;margin: 0 auto">-->
        <!--<a href="index.html" target="_top"><img src="img/login-media.png" title="注册/登录"></a>-->
    <!--</div>-->
    <!--<a href="#" class="media">-->
        <!--<div class="mianbaoxie"></div>-->
        <!--<ul>-->
            <!--<li id="jianjie" src="index.html">公司简介</li>-->
            <!--<li id="yewus">-->
                <!--主营业务-->
                <!--<img src="img/open.png" alt="">-->
                <!--<div>虚拟现实相关产品</div>-->
                <!--<div>图像理解解决方案</div>-->
                <!--<div>智能文本处理解决方案</div>-->
            <!--</li>-->
            <!--<li id="product">产品-->
                <!--<img src="img/open.png" alt="">-->
                <!--<div >虚拟现实</div>-->
                <!--<div>医疗影像理解</div>-->
            <!--</li>-->
            <!--<li id="contact">联系我们</li>-->
        <!--</ul>-->
    <!--</a>-->
    <!--顶部面包屑结束-->
    <!--顶部导航栏开始-->
    <div class="header_box">
        <div class="img-box" style="background:red">
            <a href="#">
                <img src="img/mianbaoxie.png" alt="" style="width: 20px;height: 20px;display: block;margin-top:15px;margin-left: 30px;float:left;cursor: pointer" class="imgaa">
            </a>
            <s:if test=" #session.admName == null || #session.admName.isEmpty()" >
       	    	<a href="login.html" target="_blank">
                <img src="img/shouye.png" alt="" style="width: 20px;height: 20px;display: block;margin-top:15px;margin-right: 30px;float: right;cursor: pointer" title="登录/注册" >
           		</a>
     		</s:if>
    	  	<s:else>
    	  		<div style="width:60px;height: 20px;margin-right:15px;float: right;line-height:50px;font-size:14px;color:white" >${admName}</div>
    	  	</s:else>   
            
        </div>
        <span class="shou"><a href="index.jsp" style="text-decoration: none;color:white;" target="_top" >首页</a></span>
        <span><a href="information.jsp" style="text-decoration: none;color:white;" target="_top">公司简介</a></span>
        <span><a href="index.jsp#yewu" style="text-decoration: none;color:white;" target="_top">主营业务</a>
                 <!--<ul style="z-index: 222">-->
                     <!--<li><a href="index.html#yewu" style="text-decoration: none;color:white;" target="_top">虚拟现实相关产品</a></li>-->
                     <!--<li><a href="index.html#yewu" style="text-decoration: none;color:white;" target="_top">图像理解解决方案</a></li>-->
                     <!--<li><a href="index.html#yewu" style="text-decoration: none;color:white;" target="_top">智能文本处理解决方案</a></li>-->
                 <!--</ul>-->
            </span>
        <span><a href="products.html" style="text-decoration: none;color:white;" target="_top">产品</a>
                 <!--<ul style="z-index: 222">-->
                     <!--<li><a href="products.html" style="text-decoration: none;color:white;" target="_top">虚拟现实</a></li>-->
                     <!--<li><a href="products.html" style="text-decoration: none;color:white;" target="_top">医疗影像理解</a></li>-->
                 <!--</ul>-->
            </span>
        <span><a href="contact.jsp" style="text-decoration: none;color:white;" target="_top">联系我们</a></span>
    </div>
</div>
</body>
</html>