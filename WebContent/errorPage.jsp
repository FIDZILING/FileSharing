<%@ page language="java" import="java.util.*" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>errorMessage</title>
<link rel="stylesheet" type="text/css" media="screen" href="common.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="error&success.css" />
</head>

<body>
	<div class="wrapper">
		<img src="error.gif" />
		<h3>发生错误啦！</h3>
		<br> 错误原因：<%=request.getAttribute("errorMessage")%>
	</div>
</body>

</html>