<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/show/${page}?lang=en" var="en"/>
	<c:url value="/show/${page}?lang=vi" var="vi"/>
	Language : <a href="${en}">English</a> | <a href="${vi}">Vietnamese</a>
	<center>
		<c:url value="/add" var="add"></c:url>
		<form action="${add}" method="post">
			<input type="submit" value="<spring:message code="add"/>">
		</form>

		<table>
			<tr>
				<th><spring:message code="id"/></th>
				<th><spring:message code="name"/></th>
				<th><spring:message code="mk"/></th>
				<th><spring:message code="age"/></th>
				<th><spring:message code="address"/></th>
				<th><spring:message code="img"/></th>

			</tr>
			<c:forEach items="${listSV}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.pass}</td>
					<td>${user.age}</td>
					<td>${user.add}</td>
					<td><img src="<c:url value="/image/${user.id}/${user.img}"/>" style="width: 40px; height: 40px;"></td>
					<c:url value="/edit/${user.id}" var="edit"></c:url>
					<c:url value="/delete/${user.id}" var="del"></c:url>
					<td><a href="${edit}">Edit</a></td>
					<td><a href="${del}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${page ne 1}">
			<c:url value="/show" var="first" />
			<c:url value="/show/${page-1}" var="back" />
			<a href="${first}">First</a>
			<a href="${back}">Previous</a>
		</c:if>
		<c:forEach begin="1" end="${total}" var="i">
			<c:choose>
				<c:when test="${size eq i}">
					<c:url value="/show" var="alone" />
					<a href="${alone}">${i}</a>
				</c:when>
				<c:otherwise>
					<c:url var="abc" value="/show/${i}"></c:url>
					<a href="${abc}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${page lt total}">
			<c:url value="/show/${page + 1}" var="next" />
			<c:url value="/show/${total}" var="end" />
			<a href="${next}">Next</a>
			<a href="${end}">Last</a>
		</c:if>
	</center>

</body>
</html>