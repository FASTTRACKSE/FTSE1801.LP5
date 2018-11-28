<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>

<body>
	<div class="container">
		<div class="row" style="float: right;">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<fmt:message key="chonNN"/> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="?language=vi"><fmt:message key="tiengviet"/></a></li>
					<li><a href="?language=en"><fmt:message key="tienganh"/></a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<form action="LoginServlet" method="POST">
		<input type="hidden" name="nameUrl" value="${url}">
		<fmt:message key="taikhoan"/> <input type="text" name="user"> <br>
		<fmt:message key="matkhau"/> <input	type="password" name="pass"> <br>
		<input type="submit" value="<fmt:message key="dangnhap"/>">
	</form>
</body>
</html>