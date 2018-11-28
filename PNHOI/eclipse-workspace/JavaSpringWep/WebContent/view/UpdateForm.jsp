<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/QuanLySinhVien?lang=en"><spring:message code="en"/></a>
	<a href="${pageContext.request.contextPath}/QuanLySinhVien?lang=vi"><spring:message code="vi"/></a>
	<h1>Update Student</h1>
	<form:form modelAttribute="update" method="POST" action="/JavaSpringWep/updateSinhVien">
		<table>
			<tr>
				<td></td>
				<td><form:hidden  path="id"  /></td>
			</tr>
			<tr>
				<td><spring:message code="name"/> :</td>
				<td><form:input  path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="age"/> :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><spring:message code="address"/> :</td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="<spring:message code="ins"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>