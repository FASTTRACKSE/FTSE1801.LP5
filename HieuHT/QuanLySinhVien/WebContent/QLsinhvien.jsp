<%@page import="model.dao.NgonNguDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />
<title>Quản Lý Sinh Viên</title>
<style type="text/css">
table, tr, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	background-color: #f1f1c1;
}

body {
	background-image: url("hinhanh/hinhanh2.png");
}
</style>
</head>
<body>
	<form action="LoginServlet" method="get">
		<input type="submit" name="login" value="<fmt:message key="login"/>">
	</form>
	<form action="logoutServlet" method="post">
		<input type="submit" name="out" value="<fmt:message key="logout"/>">
	</form>

	</br>
	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button"
			data-toggle="dropdown">
			<fmt:message key="Language" />
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="?language=vi&page=${page}">VietNamese</a></li>
			<li><a href="?language=en&page=${page}">English</a></li>
		</ul>
	</div>
	</br>
	<form action="LoginServlet" method="post">
		<table style="width: 60%">
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="ten" /></th>
				<th><fmt:message key="tuoi" /></th>
				<th><fmt:message key="diachi" /></th>
				<th><fmt:message key="lop" /></th>
				<th><fmt:message key="chucnang" /></th>
			</tr>
			<c:forEach items="${listSv}" var="element">
				<tr>
					<td>${element.id}</td>
					<td>${element.ten}</td>
					<td>${element.tuoi}</td>
					<td>${element.diachi}</td>
					<td>${element.lop}</td>

					<td><a href='<c:out value="AddSv.jsp"></c:out>'><fmt:message key="them"/></a>
					<a href='<c:out value="UpdateServlet?id=${element.id}"></c:out>'><fmt:message key="sua"/></a>
					<a href='<c:out value="DeleteServlet?id=${element.id}"></c:out>'><fmt:message key="xoa"/></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	</br>

	<table>
		<tr>
			<c:choose>
				<c:when test="${soTrang <= 2}">
					<c:forEach var="i" begin="1" end="${soTrang}">
						<td><a href="SinhVienServlet?chon=${i}">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:if test="${page != 1}">
						<td><a href="?page=1"><<</a></td>
						<td><a href="?page=${page-1}">< </a></td>
					</c:if>
					<c:choose>
						<c:when test="${pageBegin ne null}">
							<c:choose>
								<c:when test="${page eq 1}">
									<c:forEach var="i" begin="1" end="3">
										<td><a href="?page=${i}&pageBegin=1&pageEnd=3">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq soTrang}">
									<c:forEach var="i" begin="${soTrang -2}" end="${soTrang}">
										<td><a
											href="?page=${i}&pageBegin=${soTrang - 2}&pageEnd=${soTrang}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq pageBegin}">
									<c:forEach var="i" begin="${page -1}" end="${page + 1}">
										<td><a
											href="?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq pageEnd}">
									<c:forEach var="i" begin="${page -1}" end="${page + 1}">
										<td><a
											href="?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="i" begin="${page - 1}" end="${page + 1}">
										<td><a
											href="?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="${page}" end="${page + 2}">
								<td><a
									href="?page=${i}&pageBegin=${page}&pageEnd=${page + 2}">${i}</a></td>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<c:if test="${page ne soTrang}">
						<td><a
							href="?page=${page+1}&pageBegin=${page}&pageEnd=${page + 2}">></a></td>
						<td><a
							href="?page=${soTrang}&pageBegin=${soTrang-2}&pageEnd=${soTrang}">>></a></td>
					</c:if>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>