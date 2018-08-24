<%@ page language="java" import="java.util.*" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:useBean id="fileInfo" class="com.beans.FileInfo" scope="session"></jsp:useBean>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找文件</title>
<link rel="stylesheet" type="text/css" href="common.css" />
<link rel="stylesheet" type="text/css" href="fileInfo.css" />
</head>

<body>
	<div class="wrapper">
		<h3 class="Htext">文件编号</h3>
		<font class="text"><jsp:getProperty property="id"
				name="fileInfo" /></font><br>
		<h3 class="Htext">文件名称</h3>
		<font class="text"> <a
			href="${pageContext.request.contextPath}/downloadfile?fileid=<jsp:getProperty property="id" name="fileInfo"/>">
				<jsp:getProperty property="name" name="fileInfo" /></a>
		</font>
		<p id="move" style="color: red; margin: 5px 0 0 100px">↑ 点我下载！</p>
		<br>
		<h3 class="Htext">上传者</h3>
		<font class="text"><jsp:getProperty property="creator"
				name="fileInfo" /></font><br>
		<h3 class="Htext">下载次数</h3>
		<font class="text"><jsp:getProperty property="downloadTimes"
				name="fileInfo" /></font><br>
		<h3 class="Htext">文件描述</h3>
		<font class="text"><jsp:getProperty property="description"
				name="fileInfo" /></font><br>
	</div>
</body>

</html>