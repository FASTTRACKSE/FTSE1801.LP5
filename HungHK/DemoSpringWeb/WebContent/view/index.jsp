<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sinh viên</title>
<style type="text/css">
table {
	margin: auto;
	width: 50%;
	border: 1px solid black;
	border-collapse: collapse;
}

a {
	margin-right: 5px;
	text-decoration: none;
}
</style>
</head>
<body>
	Language :
	<a href="?language=en">English</a>|
	<a href="?language=vi">Viet Nam</a>|

	<h1>
		<spring:message code="danhsach" />
	</h1>

	<c:url var="ins" value="/insert"></c:url>
	<a href="${ins}"> <spring:message code="them" />
	</a>

	<table border="1">
		<tr>
			<th><spring:message code="masv" /></th>
			<th><spring:message code="ten" /></th>
			<th><spring:message code="tuoi" /></th>
			<th><spring:message code="sua" /></th>
			<th><spring:message code="xoa" /></th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.maSv}</td>
				<td>${sv.name}</td>
				<td>${sv.age}</td>
				<c:url var="upd" value="/update/${sv.maSv}"></c:url>
				<c:url var="del" value="/delete/${sv.maSv}"></c:url>
				<td><a href="${upd}"> <spring:message code="sua" />
				</a></td>
				<td><a href="${del}"> <spring:message code="xoa" />
				</a></td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${trang > 1}">
		<c:url var="begin" value="/1"></c:url>
		<c:url var="pageBegin" value="/${trang-1}"></c:url>
		<a href="${begin}">First</a>
		<a href="${pageBegin}">Prev</a>
	</c:if>
	<c:forEach var="i" begin="${start}" end="${end}">
		<c:url var="pag" value="/${i}"></c:url>
		<a href="${pag}">${i}</a>
	</c:forEach>
	<c:if test="${trang < page}">
		<c:url var="finish" value="/${page}"></c:url>
		<c:url var="next" value="/${trang+1}"></c:url>
		<a href="${next}">Next</a>
		<a href="${finish}">Last</a>
	</c:if>

	<br><br>
	<form action="savefile" method="post" enctype="multipart/form-data">
		Select File: <input type="file" name="file" /> <input type="submit"
			value="Upload File" />
	</form>

</body>
</html>