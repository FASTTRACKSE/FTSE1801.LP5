<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thanh Pho</title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid red;
	border-collapse: collapse;
}

a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: blue;
}
</style>
</head>
<body>
	<table style="width: 60%">

		<tr>
			<th colspan="5">Danh sách tỉnh/thành phố</th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${list}" var="element">
			<tr>
				<td style="text-align: center;">${element.matp}</td>
				<td style="text-align: center;">${element.name}</td>
				<td style="text-align: center;">${element.type}</td>
			</tr>
		</c:forEach>
	</table>
	</br>

	<form action="PagingSeverlet" method="post">
		<table border="1" , cellpadding="5" , cellspacing="5">
			<tr>
				<input type="hidden" value="${page}" name="pages">
				<input type="hidden" value="${pageBegin}" name="pageBegin">
				<input type="hidden" value="${pageEnd}" name="pageEnd">
	<c:choose>
		<c:when test="${soTrang <= 2}">
			<c:forEach var="i" begin="1" end="${soTrang}">
				<a href="PagingSeverlet?page=${i}">${i}</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:if test="${page != 1}">
				<td><a href="PagingSeverlet?page=1">|<</a></td>
				<td><a href="PagingSeverlet?page=${page-1}&pageBegin=${page -2}&pageEnd=${page}"><</a></td>
			</c:if>
			<c:choose>
				<c:when test="${pageBegin ne null}">
					<c:choose>
						<c:when test="${page eq 1}">
							<c:forEach var="i" begin="1" end="3">
								<td><a href="PagingSeverlet?page=${i}&pageBegin=1&pageEnd=3">${i}</a></td>
							</c:forEach>
						</c:when>
						<c:when test="${page eq soTrang}">
							<c:forEach var="i" begin="${soTrang -2}" end="${soTrang}">
								<td><a href="PagingSeverlet?page=${i}&pageBegin=${page - 2}&pageEnd=${page}">${i}</a></td>
							</c:forEach>
						</c:when>
						<c:when test="${page eq pageBegin}">
							<c:forEach var="i" begin="${page -1}" end="${page + 1}">
								<td><a href="PagingSeverlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
							</c:forEach>
						</c:when>
						<c:when test="${page eq pageEnd}">
							<c:forEach var="i" begin="${page -1}" end="${page + 1}">
								<td><a href="PagingSeverlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="${page - 1}" end="${page + 1}">
							<td><a href="PagingSeverlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${page}" end="${page + 2}">
					<td><a href="PagingSeverlet?page=${i}&pageBegin=${page}&pageEnd=${page + 2}">${i}</a></td>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${page ne soTrang}">
				<td><a href="PagingSeverlet?page=${page+1}&pageBegin=${page}&pageEnd=${page + 2}">></a></td>
				<td><a href="PagingSeverlet?page=${soTrang}&pageBegin=${soTrang-2}&pageEnd=${soTrang}">>|</a></td>
			</c:if>
		</c:otherwise>
	</c:choose>
			</tr>
		</table>
	</form>


</body>
</html>