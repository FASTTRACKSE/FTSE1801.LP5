<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Van Manh</title>
<style type="text/css">
table, tr, th, td {
	border: solid 1px;
}
</style>
</head>
<body>
	<c:url var="VietNam" value="/listSV/${pages}?lang=vi"/>
	<c:url var="English" value="/listSV/${pages}?lang=en"/>
	<ul>
		<li><a href="${VietNam}">VietNamese</a> </li>
		<li><a href="${English}">English</a> </li>
	</ul>
	<table>
		<tr>
			<th><spring:message code="image"/> </th>
			<th><spring:message code="maSv"/></th>
			<th><spring:message code="name"/></th>
			<th><spring:message code="age"/></th>
			<c:url var="addSVView" value="/addSinhVienView"/>
			<th colspan="2"><a href="${addSVView}"><spring:message code="add"/></a></th>
		</tr>
		<c:forEach items="${listSV}" var="sv">
			<tr>
				<c:url var="img" value="/Hinhnen/${sv.maSV}/${sv.img}"></c:url>
				<td><img style="height: 40px; width: 40px;" src="${img}"> </td>
				<td>${sv.maSV}</td>
				<td>${sv.name}</td>
				<td>${sv.age}</td>
				<c:url var="editSV" value="/editSinhVienView/${sv.maSV}"/>
				<c:url var="deleteSV" value="/deleteSV/${sv.maSV}/${pages}"/>
				<td><a href="${editSV}"><spring:message code="edit"/></a></td>
				<td><a href="${deleteSV}"><spring:message code="delete"/></a></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pages > 1}">
		<c:url var="begin" value="/listSV/1"></c:url>
		<c:url var="back" value="/listSV/${pages-1}"></c:url>
		<a href="${begin}"><spring:message code="begin"/></a>
		<a href="${back}"><spring:message code="back"/></a>
	</c:if>
	<c:forEach var="i" begin="${Start}" end="${End}">
		<c:url var="page" value="/listSV/${i}"></c:url>
		<a href="${page}">${i}</a>
	</c:forEach>
	<c:if test="${pages < total}">
		<c:url var="finish" value="/listSV/${total}"></c:url>
		<c:url var="next" value="/listSV/${pages+1}"></c:url>
		<a href="${next}"><spring:message code="next"/></a>
		<a href="${finish}"><spring:message code="finish"/></a>
	</c:if>
</body>
</html>