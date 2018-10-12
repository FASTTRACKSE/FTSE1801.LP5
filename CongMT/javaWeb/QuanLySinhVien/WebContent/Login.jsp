<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.Locale"%>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.language" />
<title><fmt:message key="title" /></title>
</head>
<style type="text/css">
a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: blue;
}

body {
	background-image:
		url(https://wallpapertag.com/wallpaper/full/c/a/a/157415-simplistic-wallpapers-1920x1080-lockscreen.jpg)
}

#login-name {
	font-size: 65px;
	font-family: arabic typesetting;
	border-bottom-style: ridge;
	color: white;
}

#login {
	background-color: rgba(13, 13, 13, 0.2);
	min-height: 500px;
	padding: 40px 80px 40px 80px;
	box-shadow: -10px -10px 9px #33cc33;
}

.user {
	font-size: 29px;
	font-family: arabic typesetting;
	color: white;
}

#iconn {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: white;
}

#iconn1 {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: white;
}

#text1 {
	border-radius: 0;
	height: 40px;
}

#text2 {
	border-radius: 0;
	height: 40px;
}

.btn {
	width: 50%;
	float: left;
	height: 40px;
	font-size: 18px;
}
</style>
<body>
	<c:if test="${DangNhap != null }">
		<script type="text/javascript">
			alert("<fmt:message key="DangNhapSai"/>");
		</script>
	</c:if>

	<div class="container">
		<br /> <br /> <br /> <br />
		<center>
			<b id="login-name"><fmt:message key="DangNhap" /></b>
		</center>
<div class="row">
	<div class="col-md-6 col-md-offset-3" id="login">
		<form action="LoginServlet1" method="post">
			<div class="form-group">
					<input type="hidden" name="nameUrl" value="${url}" /> 
			<label class="user"><fmt:message key="TenDangNhap" /> </label>
			<div class="input-group">
				<span class="input-group-addon" id="iconn"> <i class="glyphicon glyphicon-user"></i></span> 
				<input type="text" class="form-control" id="text1" name="user" placeholder="">
			</div>
	</div>
	<div class="form-group">
		<label class="user"> <fmt:message key="MatKhau" />
		</label>
		<div class="input-group">
			<span class="input-group-addon" id="iconn1"> <i class="glyphicon glyphicon-lock"></i></span> 
			<input type="password" class="form-control" id="text2" name="passWord" placeholder="">
		</div>
	</div>
	<div class="form-group">

		<input type="submit" class="btn btn-success" value="<fmt:message key="DangNhap"/>" style="border-radius: 0px;">
		<input type="reset" class="btn btn-danger" value="reset" style="border-radius: 0px;">

	</div>
	<br/><br/><br/> 
	<a href="#" style="color: white; font-size: 15px; float: right; margin-right: 10px;">Forget Password </a> 
	<a href="#" style="color: white; font-size: 15px; float: right; margin-right: 10px;">Register </a>
</body>
</html>