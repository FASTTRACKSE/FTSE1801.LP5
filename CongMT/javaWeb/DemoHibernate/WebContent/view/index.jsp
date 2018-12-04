<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh sách sinh viên</h1>
	<br />
	<c:url var="VietNam" value="/listSV/${paging}?lang=vi"></c:url>
	<c:url var="English" value="/listSV/${paging}?lang=en"></c:url>
	<a href="${VietNam}">VietNam</a>
	<a href="${English}">English</a>
	<table style="width: 60%">
		<tr>
			<td><spring:message code="img"/></td>
			<td><spring:message code="id"/></td>
			<td><spring:message code="ten"/></td>
			<td><spring:message code="tuoi"/></td>
			<td><spring:message code="diachi"/></td>
			<td><spring:message code="lop"/></td>
			<c:url var="c" value="/addSV"></c:url>
			<td><a href='<c:out value="${c}"></c:out>'><spring:message code="them"/></a></td>
		</tr>
		<c:forEach items="${listSv}" var="element">
		<c:url var="a" value="/UpdateSV/${element.id}"></c:url>
		<c:url var="b" value="/delete/${element.id}"></c:url>
			<tr>
				<c:url var="img" value="/Thuvienanh/${element.id}/${element.img}"></c:url>
				<td><img style="height: 40px; width: 40px;" src="${img}"/></td>
				<td>${element.id}</td>
				<td>${element.ten}</td>
				<td>${element.tuoi}</td>
				<td>${element.diachi}</td>
				<td>${element.lop}</td>
				<td><a href='<c:out value="${a}"></c:out>'><spring:message code="sua"/></a>
				<a href='<c:out value="${b}"></c:out>'><spring:message code="xoa"/></a></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paging>1}">
		<c:url var="begin" value="/listSV/1"></c:url>
		<c:url var="pagingbegin" value="/listSV/${paging-1}"></c:url>
		<a href="${begin}" style="text-decoration: none;"><<</a>
		<a href="${pagingbegin}" style="text-decoration: none;"><</a>
	</c:if>
	<c:forEach var="paging" begin="${Start}" end="${End}">
		<c:url var="page" value="/listSV/${paging}"/>
		<a href="${page}">${paging}</a>
	</c:forEach>
	<c:if test="${paging<total}">
		<c:url var="finish" value="/listSV/${total}"></c:url>
		<c:url var="pagingfinish" value="/listSV/${paging+1}"></c:url>
		<a href="${pagingfinish}" style="text-decoration: none;">></a>
		<a href="${finish}" style="text-decoration: none;">>></a>
	</c:if>
</body>
</html>