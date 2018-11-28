<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="${filename}" width="100" height="100" src="<c:url value="/images/${filename}"/>">
	<a href="${pageContext.request.contextPath}/QuanLySinhVien?lang=en"><spring:message code="en"></spring:message></a>
	<a href="${pageContext.request.contextPath}/QuanLySinhVien?lang=vi"><spring:message code="vi"></spring:message></a>
	<h1><spring:message code="h"></spring:message></h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th><spring:message code="id"/></th>
			<th><spring:message code="name"/></th>
			<th><spring:message code="age"/></th>
			<th><spring:message code="address"/></th>
			<th><spring:message code="ins"/></th>
			<th><spring:message code="del"/></th>
		</tr>
		
		<c:forEach var="emp" items="${list}">
		<c:url var="updateUrl" value="/updateSinhVien/${emp.id}"></c:url>
		<c:url var="deleteUrl" value="/deleteSinhVien/${emp.id}"></c:url>
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.age}</td>
				<td>${emp.address}</td>
				<td><a href="${updateUrl}">Edit</a></td>
				<td><a href="${deleteUrl}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	
	<c:forEach begin="1" end="${soTrang}" var="page">
		<a href="/JavaSpringWep/QuanLySinhVien/${page}">${page}</a>
	</c:forEach>
	
    <br /> 
    <c:url var="addUrl" value="/addSinhVien"></c:url>
	<a href="${addUrl}"><spring:message code="add"/></a>
	
	<c:url var="addUrl" value="/upload"></c:url>
	<a href="${addUrl}">Upload File></a>
	
</body>
</html>