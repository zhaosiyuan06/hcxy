<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/loginsuccess.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function del(id){
		if(confirm("删除的数据将无法恢复，确认删除?")) {
			window.location.href='deleteAdm?aid='+id;
			alert("删除成功！");
		}
}
</script>
</head>
<body>	

  		<form action="getAdmList" method="post">
  		<table border="1" align="center" width="80%" cellpadding="5" cellspacing="0">
        	<tr style="background:white">
            	<th style="width:50px;text-align:center">ID</th>
            	<th style="width:80px;text-align:center">用户名</th>
            	<th style="width:80px;text-align:center">手机号</th>
           	 	<th style="width:80px;text-align:center">邮箱</th>
           	 	<th style="width:80px;text-align:center">状态</th>
           	 	<th style="width:80px;text-align:center">操作</th>
       		</tr>
       <s:if test="#request.list != null">
  	 		<s:iterator var="adm" value="#request.list" >
  	 			<tr>
  	 				<td align="center"> <s:property value="#adm.aid"/> </td>
  	 				<td align="center"> <s:property value="#adm.admName"/> </td>
  	 				<td align="center"> <s:property value="#adm.admMoble"/> </td>
  	 				<td align="center"> <s:property value="#adm.admEmail"/> </td>
  	 				<td align="center"> <s:property value="#adm.state"/> </td>
  	 				<td align="center">
  	 				<input type="button" onclick="del(<s:property value="#adm.aid"/>)" value="删除"/>
  	 				</td>
  	 			</tr>
  	 		</s:iterator>
  	 	</s:if>
  	 	<s:else>
  	 		<tr>
  	 			<td colspan="6">对不起，没有你要找的数据！请先录入。</td>
  	 		</tr>
  	 	</s:else>
  		</table>
  		<input type="submit" value="刷新">
  		</form>
</body>
</html>