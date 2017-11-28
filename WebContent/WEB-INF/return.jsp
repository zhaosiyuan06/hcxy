<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="img/logoH.png" sizes="96*96">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" href="css/materialize.min.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		#particles {
			background-color: #333;
			position: absolute;
			top: 0;
			width: 100%;
			height: 100%;
		}

	.margin {
	  margin: 0 !important;
	}
	</style>
	<script src="http://www.jq22.com/jquery/html5.min.js"></script>
	
<title>结果页</title>
</head>
<body>
<div id="particles">

</div>
	<div id="login-page" class="row" style="width: 300px;z-index: 3333333;position: absolute;top:50%;margin-top:-166px;left: 50%;margin-left: -150px">
	    <div class="col s12 z-depth-6 card-panel">
	      <form class="login-form">
	        <div class="row">
	          <div class="input-field col s12 center">
	            <img src="img/logoH2.png" alt="" class="responsive-img valign profile-image-login">
	            <p class="center login-form-text">&nbsp;&nbsp;&nbsp;北京华诚兴业软件开发有限责任公司&nbsp;&nbsp;&nbsp;</p>
				  <div class="htmleaf-links">
					  <a  href="index.html" title="返回首页" >
						  <img src="img/index.png" alt="" style="width: 30px;height: 30px;position: relative;left: 50%;margin-left: -15px">
					  </a>
				  </div>
	         
		
	          </div>
	        </div>
	        <div class="row margin">
	          <div class="input-field col s12">
	           <h3 style="text-align:center">${mesg}</h3>
	           <div  style="text-align:center"><a href="index.jsp">点我返回首页</a></div>
	          </div>
	        </div>
	        
	      </form>
	    </div>
	  </div>
	
	
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
  	<!--materialize js-->
  	<script src="js/materialize.min.js"></script>
	<script src="js/register.js"></script>
	<script src="js/particles.js"></script>
	<script src="js/app.js"></script>
</body>
</html>