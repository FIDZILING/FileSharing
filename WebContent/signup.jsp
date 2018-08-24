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
<link rel="stylesheet" type="text/css" href="signup.css" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></Script>
<script src="signup.js"></Script>
</head>

<body>
	<div id="header">
		<h1>FileSharing</h1>
	</div>
	<div id="wrapper">
		<form action=signup.do method="post">
			<p class="textHead">注册：</p>
			<font class="textMain">用&ensp;户&ensp;名：</font> <input id="username"
				type="text" name="name" maxlength="20"><br>
			<div id="usernamehint" class="hint" style="display: none;">用户名的长度不能大于20位</div>
			<font class="textMain">密&emsp;&emsp;码：</font> <input id="password"
				type="password" name="password1" maxlength="20"><br>
			<div id="passwordhint" class="hint" style="display: none;">密码的长度不能大于20位</div>
			<font class="textMain">重复密码：</font> <input id="checkpassword"
				type="password" name="password2" maxlength="20"><br>
			<div id="checkpasswordhint" class="hint"
				style="display: none; margin: 0 0 0 1200px;">none</div>
			<input class="submitBtn" type="submit" style="cursor: pointer;"
				value="注册">

		</form>
	</div>
</body>

</html>