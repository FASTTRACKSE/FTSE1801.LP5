<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
<a href='<c:out value="addQuan.jsp"></c:out>'>Thêm Quận</a>
<a href="?language=vi&page=${dong}">VietNamese</a>
<a href="?language=en&page=${dong}">English</a>
	<table style="with: 100%">
		<tr>
			<th><fmt:message key="ma" /></th>
			<th><fmt:message key="ten" /></th>
		</tr>
		<c:forEach items="${list}" var="element">
			<tr>
				<td>${element.maQuanHhuyen}</td>
				<td>${element.tenQuanHuyen}</td>
			</tr>
		</c:forEach>
	</table>

	<c:choose>
		<c:when test="${soTrang<3}">
			<c:forEach var="i" begin="1" end="${soTrang}">
				<a href="?page=${i}">${i}</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:if test="${dong != 1}">
				<a href="PagingServlet?page=1">Begin</a>
				<a href="PagingServlet?page=${dong-1}">Preview</a>
			</c:if>
			<c:choose>
				<c:when test="${dong eq 1}">
					<c:forEach var="i" begin="1" end="3">
						<a href="?page=${i}&Begin=1&End=3">${i}</a>
					</c:forEach>
				</c:when>
				<c:when test="${dong eq soTrang}">
					<c:forEach var="i" begin="${soTrang-2}" end="${soTrang}">
						<a href="?page=${i}&Begin=${soTrang-2}&End=${soTrang}">${i}</a>
					</c:forEach>
				</c:when>
				<c:when test="${dong eq Begin}">
					<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
						<a href="?page=${i}&Begin=${dong-1}&End=${dong+1}">${i}</a>
					</c:forEach>
				</c:when>
				<c:when test="${dong eq End}">
					<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
						<a href="?page=${i}&Begin=${dong-1}&End=${dong+1}">${i}</a>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
						<a href="?page=${i}&Begin=${dong-1}&End=${dong+1}">${i}</a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${dong != soTrang}">
				<a href="PagingServlet?page=${dong+1}">next</a>
				<a href="PagingServlet?page=${soTrang}">Last</a>
			</c:if>

		</c:otherwise>
	</c:choose>

</body>
</html>