<%@ page language="java" import="java.util.*" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="users" class="com.beans.Users" scope="session"></jsp:useBean>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome FileSharing</title>
<link rel="stylesheet" type="text/css" href="common.css" />
<link rel="stylesheet" type="text/css" href="first.css" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></Script>
<script src="first.js"></Script>
</head>

<body>
	<div id="header">
		<h1>FileSharing</h1>
	</div>
	<div id="wrapper">
		<form action=userslogin.do method="post">
			<p class="textHead">登陆：</p>
			<font class="textMain">用户名：</font> <input id="name" type="text"
				name="name"><br> <font class="textMain">密&emsp;码：</font>
			<input id="password" type="password" name="password"><br>
			<input class="submitBtn" type="submit" style="cursor: pointer;"
				value="登陆">
		</form>
		<font class="signup">还没有账号？注册一个！</font> <a href="/FileSharing/signup.jsp">注册</a>
	</div>
</body>

</html>