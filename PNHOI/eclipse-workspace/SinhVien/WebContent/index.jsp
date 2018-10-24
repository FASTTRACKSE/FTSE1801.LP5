<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway:500'
	rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.Language" />
<title>Insert title here</title>
<style type="text/css">


body{
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShkKwozvCY6eHS6vCQXjBJBh3XGUdjEC5iuW8s9-TFwprHCw4p8w");
}

table {
	border-collapse: collapse;
}

table, tr, td, th {
	border: 1px solid black;
}

.mau1 {
	background-color: #fbfbf9;
}

.mau2 {
	background-color: while;
}

.mau3 {
	background-color: #bebebe;
}
</style>
</head>
<body>
	



		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Quản lý sinh viên</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						"<fmt:message key="submit" /></a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="studentsServlet?page=${dong}&lang=vi"><img
						src="images/vi.png"></a></li>
				<li><a href="studentsServlet?page=${dong}&lang=en"><img
						src="images/en.png"></li>
			</ul>
		</div>
		</nav>



	<div class="w3-container">
		<form action="add" method="get">
			<table>
				<tr>
					<th><fmt:message key="id" /></th>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<th><fmt:message key="name" /></th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th><fmt:message key="age" /></th>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<th><fmt:message key="address" /></th>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit"
						value="<fmt:message key="add"/>" /></th>
				</tr>
			</table>
			<br>


		</form>

		<table style="width: 100%">
			<tr class="mau3">
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="name" /></th>
				<th><fmt:message key="age" /></th>
				<th><fmt:message key="address" /></th>
				<th colspan="2"><fmt:message key="fun" /></th>
			</tr>
			<c:set var="x" value="1"></c:set>
			<c:forEach items="${list}" var="element">
				<c:choose>
					<c:when test="${x%2 ==0 }">
						<tr class="mau1">
							<td>${element.id}</td>
							<td>${element.name}</td>
							<td>${element.age}</td>
							<td>${element.address}</td>
							<td><a
								href='<c:out value="DeleteServlet?id=${element.id}"></c:out>'><fmt:message
										key="del" /></a></td>
							<td><a
								href='<c:out value="updateServlet?id=${element.id}"></c:out>'><fmt:message
										key="ins" /></a></td>
						</tr>
						<c:set var="x" value="${x+1 }"></c:set>
					</c:when>
					<c:otherwise>
						<tr class="mau2">
							<td>${element.id}</td>
							<td>${element.name}</td>
							<td>${element.age}</td>
							<td>${element.address}</td>
							<td><a
								href='<c:out value="DeleteServlet?id=${element.id}"></c:out>'><fmt:message
										key="del" /></a></td>
							<td><a
								href='<c:out value="updateServlet?id=${element.id}"></c:out>'><fmt:message
										key="ins" /></a></td>
						</tr>
						<c:set var="x" value="${x+1 }"></c:set>
					</c:otherwise>
				</c:choose>
			</c:forEach>

		</table>
		<br>


		<table cellpadding="5" cellspacing="5">
			<c:choose>
				<c:when test="${soTrang<3 }">
					<c:forEach var="i" begin="1" end="${soTrang}">
						<tr>
							<td><a href="?page=${i}">${i}</a></td>
						</tr>
					</c:forEach>
				</c:when>

				<c:when test="${dong<=soTrang }">
					<tr>
						<c:if test="${(dong > 2)&& (soTrang>3)}">
							<td><a href="studentsServlet?page=1">|<</a></td>
						</c:if>
						<c:if test="${(dong ne  '1')&& (soTrang>2)}">
							<td><a href="studentsServlet?page=${dong - 1}"><</a></td>
						</c:if>

						<c:choose>
							<c:when test="${dong eq '1'}">
								<c:forEach var="i" begin="1" end="3">
									<td><a
										href="studentsServlet?page=${i}&?pageBegin=1&pageEnd=3">${i}</a></td>
								</c:forEach>
							</c:when>

							<c:when test="${dong eq soTrang}">
								<c:forEach var="i" begin="${soTrang-2}" end="${soTrang}">
									<td><a
										href="studentsServlet?page=${i}&?pageBegin=${i-2}&pageEnd=${i}">${i}</a></td>
								</c:forEach>
							</c:when>

							<c:when test="${dong eq pageBegin}">
								<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
									<td><a
										href="studentsServlet?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
								</c:forEach>
							</c:when>

							<c:when test="${dong eq pageEnd}">
								<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
									<td><a
										href="studentsServlet?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
								</c:forEach>
							</c:when>

							<c:otherwise>
								<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
									<td><a
										href="studentsServlet?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
								</c:forEach>
							</c:otherwise>
						</c:choose>

						<c:if test="${(dong ne soTrang) && (soTrang>2)}">
							<td><a href="studentsServlet?page=${dong+1}">></a></td>
						</c:if>
						<c:if test="${(dong < soTrang-1) && (soTrang>3)}">
							<td><a href="studentsServlet?page=${soTrang}">>|</a></td>
						</c:if>
					</tr>
				</c:when>
				<c:otherwise>
				Không có trang
			</c:otherwise>

			</c:choose>
		</table>
	</div>
</body>
</html>