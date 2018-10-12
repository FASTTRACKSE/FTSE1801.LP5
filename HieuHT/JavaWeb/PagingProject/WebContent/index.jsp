<%@page import="model.dao.QuocgiaDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />
<title><fmt:message key="trang" /></title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button"
			data-toggle="dropdown">
			Language <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="changeLanguage?lang=Vietnamese&page=${page}">VietNamese</a></li>
			<li><a href="changeLanguage?lang=English&page=${page}">English</a></li>
			<li><a href="changeLanguage?lang=中国&page=${page}">中国</a></li>
		</ul>
	</div>
	<table style="width: 40%">

		<tr>
			<th colspan="5"><fmt:message key="trang" /></th>
		</tr>
		<tr>
			<th><fmt:message key="stt" /></th>
			<th><fmt:message key="ma" /></th>
			<th><fmt:message key="ten" /></th>
		</tr>
		<c:forEach items="${listQg}" var="element">
			<tr>
				<td style="text-align: center;">${element.id}</td>
				<td style="text-align: center;">${element.code}</td>
				<td style="text-align: center;">${element.name}</td>
		</c:forEach>
	</table>

	<table>
		<tr>
			<c:choose>
				<c:when test="${soTrang <= 2}">
					<c:forEach var="i" begin="1" end="${soTrang}">
						<td><a href="PagingServlet?chon=${i}">${i}</a></td>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:if test="${page != 1}">
						<td><a href="PagingServlet?chon=1"><<</a></td>
						<td><a href="PagingServlet?chon=${page-1}">< </a></td>
					</c:if>
					<c:choose>
						<c:when test="${pageBegin ne null}">
							<c:choose>
								<c:when test="${page eq 1}">
									<c:forEach var="i" begin="1" end="3">
										<td><a
											href="PagingServlet?chon=${i}&pageBegin=1&pageEnd=3">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq soTrang}">
									<c:forEach var="i" begin="${soTrang -2}" end="${soTrang}">
										<td><a
											href="PagingServlet?chon=${i}&pageBegin=${soTrang - 2}&pageEnd=${soTrang}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq pageBegin}">
									<c:forEach var="i" begin="${page -1}" end="${page + 1}">
										<td><a
											href="PagingServlet?chon=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:when test="${page eq pageEnd}">
									<c:forEach var="i" begin="${page -1}" end="${page + 1}">
										<td><a
											href="PagingServlet?chon=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="i" begin="${page - 1}" end="${page + 1}">
										<td><a
											href="PagingServlet?chon=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></td>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="${page}" end="${page + 2}">
								<td><a
									href="PagingServlet?chon=${i}&pageBegin=${page}&pageEnd=${page + 2}">${i}</a></td>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<c:if test="${page ne soTrang}">
						<td><a
							href="PagingServlet?chon=${page+1}&pageBegin=${page}&pageEnd=${page + 2}">></a></td>
						<td><a
							href="PagingServlet?chon=${soTrang}&pageBegin=${soTrang-2}&pageEnd=${soTrang}">>></a></td>
					</c:if>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>