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
<title>FileSharing用户<jsp:getProperty property="name"
		name="users" />操作
</title>
<link rel="stylesheet" type="text/css" media="screen" href="common.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="useroperator.css" />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></Script>
<script src="useroperator.js"></Script>
</head>

<body>
	<section id="section-1">
		<h1 class="Htext">welcome</h1>
		<h1 class="Htext"><jsp:getProperty property="name" name="users" /></h1>
		<div id="changePass" class="Htext">修改密码</div>
	</section>
	<section id="section-2">
		<font class="textHead">修改密码</font> <br> <br>
		<form action=userschangePassword.do method="post">
			<input type="hidden"
				value="<jsp:getProperty property="name" name="users" />"
				name="username"> <font class="textMain">原密码：</font> <input
				id="oldpass" type="password" name="oldpassword" maxlength="20"><br>
			<font class="textMain">新密码：</font> <input id="newpass"
				type="password" name="newpassword" maxlength="20"><br>
			<div id="showpassnull">新密码不能为空！</div>
			<input id="submitBtn-1" class="submitBtn" type="submit"
				style="cursor: pointer;" value="修改密码"><br>
		</form>
	</section>
	<section id="section-3">
		<font class="textHead">查看所有文件</font><br> <br>
		<form action=seeAllFileInfo.do method="post">
			<input id="submitBtn-2" class="submitBtn" type="submit"
				style="cursor: pointer;" value="查看所有文件"><br>
		</form>
	</section>
	<section id="section-4">
		<font class="textHead">查找文件</font><br> <br>
		<form action=searchFileInfo.do method="post">
			<font class="textMain">文件编号：</font> <input id="fileid" type="text"
				name="id" maxlength="11"><br> <input id="submitBtn-3"
				class="submitBtn" type="submit" style="cursor: pointer;" value="查找"><br>
		</form>
		<br>
	</section>
	<section id="section-5">
		<font class="textHead">上传文件</font><br> <br>
		<form action=FileUpload.do method="post" enctype="multipart/form-data">
			<input type="hidden"
				value="<jsp:getProperty property="name" name="users" />"
				name="username"> <font class="textMain">文件编号：</font> <input
				id="fileid-up" type="text" name="id" maxlength="11"><br>
			<font class="textMain">文件描述：</font> <input id="fileDes" type="text"
				name="description"><br> <font class="textMain">文件路径：</font>
			<input id="filePath" class="fileBtn" type="file" name="f"><br>
			<input id="submitBtn-4" class="submitBtn-2" type="submit"
				style="cursor: pointer;" value="上传">
		</form>
	</section>
</body>

</html>