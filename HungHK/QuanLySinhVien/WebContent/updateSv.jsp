<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row" style="float: right;">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					${lang.chonNn} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="UpdateSvServlet?lang=Vietnamese">${lang.tiengviet}</a></li>
					<li><a href="UpdateSvServlet?lang=English">${lang.tienganh}</a></li>
				</ul>
			</div>
		</div>
	</div>

	<form action="UpdateSvServlet" method="POST">
		${lang.ten} <input type="text" name="name"><br>
		${lang.tuoi} <input type="text" name="age"><br> <input
			type="submit" name="sua" value="${lang.sua}">
	</form>
</body>
</html>