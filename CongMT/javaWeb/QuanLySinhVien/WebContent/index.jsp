<%@page import="model.dao.NgonNguDao"%>
<%@page import="model.dao.StudentDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.language"/>
<link rel="stylesheet" href="Css.css" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><fmt:message key="title"/></title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid blue;
	border-collapse: collapse;
}

a {
	color: black;
	text-decoration: none;
}
a:hover {
	color: blue;
}
body{
	background-image: url("images/css.jpg");
           
}
</style>
</head>
<body class="body" >
<div class="container">
<div class="row" style= float: right>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
			Language<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="?language=vi">VietNamese</a></li>
			<li><a href="?language=en">English</a></li>
		</ul>
	</div>
	</div><br>
	<a href="Login.jsp"><fmt:message key="DangNhap"/></a>
	<a href="LogOutServlet"><fmt:message key="DangXuat"/></a>
	</div>
	
	
	
	
	</br>
	</br>
	<div>
	<h1 class="container"><fmt:message key="TieuDe"/></h1>
	<form action="AddServlet" method="post" class="container">
		<table>
			<tr>
				<td>- <fmt:message key="TenDangNhap"/>:</td>
				<td><input type="text" name="name" /></td>
			<tr>
				<td>- <fmt:message key="Tuoi"/>:</td>
				<td><input type="text" name="old" /></td>
			</tr>
			<tr>
				<td>- <fmt:message key="DiaChi"/>:</td>
				<td><input type="text" name="adress" /></td>
			</tr>
			<tr>
				<td>- <fmt:message key="Sdt"/>:</td>
				<td><input type="text" name="number" /></td>
			</tr>

		</table>
		<br> <input type="submit" name="nutchon" value="<fmt:message key="Them"/>">
		<br></br>
	</form>
	</div>
	<form action="StudentServlet" method="post" >

		<table style="width: 70	%" class="container">

			<tr>
				<th style="text-align: center;" colspan="6"><fmt:message key="TieuDe1"/></th>
			</tr>
			<tr>
				<th style="text-align: center;"><fmt:message key="id"/></th>
				<th style="text-align: center;"><fmt:message key="TenDangNhap"/></th>
				<th style="text-align: center;"><fmt:message key="Tuoi"/></th>
				<th style="text-align: center;"><fmt:message key="DiaChi"/></th>
				<th style="text-align: center;"><fmt:message key="Sdt"/></th>
				<th style="text-align: center;"><fmt:message key="ChucNang"/></th>
			</tr>
			<c:forEach items="${list}" var="element">
				<tr>
					<td style="text-align: center;">${element.id}</td>
					<td style="text-align: center;">${element.name}</td>
					<td style="text-align: center;">${element.old}</td>
					<td style="text-align: center;">${element.adress}</td>
					<td style="text-align: center;">${element.numberPhone}</td>
					<td style="text-align: center;"><a href="<c:out value="deletelStudent?IdStudent=${element.id}"></c:out>"><fmt:message key="Xoa"/></a>
						<a href="<c:out value="UpdateSevervlet?IdStudent=${element.id}"></c:out>"><fmt:message key="Sua"/></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br>
	<form action="StudentServlet" method="post" class="container">
<table border="1" , cellpadding="5" , cellspacing="5" style="width: 10%", "text-align: center" >
<tr>
	<input type="hidden" value="${page}" name="pages">
<input type="hidden" value="${pageBegin}" name="pageBegin">
<input type="hidden" value="${pageEnd}" name="pageEnd">
<c:choose>
<c:when test="${soTrang <= 2}">
	<c:forEach var="i" begin="1" end="${soTrang}">
		<a href="StudentServlet?page=${i}">${i}</a>
	</c:forEach>
</c:when>
<c:otherwise>
	<c:if test="${page != 1}">
		<td><a href="StudentServlet?page=1">|<</a></td>
		<td><a href="StudentServlet?page=${page-1}&pageBegin=${page -2}&pageEnd=${page}"><</a></td>
	</c:if>
	<c:choose>
		<c:when test="${pageBegin ne null}">
			<c:choose>
				<c:when test="${page eq 1}">
					<c:forEach var="i" begin="1" end="3">
						<td><a href="StudentServlet?page=${i}&pageBegin=1&pageEnd=3">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:when test="${page eq soTrang}">
					<c:forEach var="i" begin="${soTrang -2}" end="${soTrang}">
						<td><a
							href="StudentServlet?page=${i}&pageBegin=${page - 2}&pageEnd=${page}">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:when test="${page eq pageBegin}">
					<c:forEach var="i" begin="${page -1}" end="${page + 1}">
						<td><a
							href="StudentServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:when test="${page eq pageEnd}">
					<c:forEach var="i" begin="${page -1}" end="${page + 1}">
						<td><a
							href="StudentServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${page - 1}" end="${page + 1}">
						<td><a
							href="StudentServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="${page}" end="${page + 2}">
				<td><a
					href="StudentServlet?page=${i}&pageBegin=${page}&pageEnd=${page + 2}">${i}</a></td>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:if test="${page ne soTrang}">
		<td><a
			href="StudentServlet?page=${page+1}&pageBegin=${page}&pageEnd=${page + 2}">></a></td>
		<td><a
			href="StudentServlet?page=${soTrang}&pageBegin=${soTrang-2}&pageEnd=${soTrang}">>|</a></td>
	</c:if>
</c:otherwise>
</c:choose>
	</tr>
</table>
	</form>
	<div style="margin-left: -100px;">
	<div class="col_p col-md-3 col-sm-4 col-smx-4 col-xs-6 " id="map" style="float:right; margin-right: 190px; width:350px;height:300px;">
	<iframe width="350" height="200" src="https://www.youtube.com/embed/jNrRz8X1Ubc" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
	</div>
	<div class="col_p col-md-3 col-sm-4 col-smx-4 col-xs-6 " id="map" style="float:right; margin-right: 10px; width:350px;height:300px;"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1416.5603197502367!2d108.23515218580444!3d16.077129601667348!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31421827a3c439f5%3A0xdec2fb897aa16a90!2zxJDhuqFpIGjhu41jIEdyZWVud2ljaCBWaeG7h3QgTmFt!5e1!3m2!1svi!2s!4v1538125567794" width="350" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
	</div>
	</div>
</body>
</html>
</body>
</html>