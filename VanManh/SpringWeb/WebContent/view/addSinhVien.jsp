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
	<c:url var="add" value="/addSinhVien"></c:url>
	<form:form modelAttribute="addSV" action="${add}" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td><spring:message code="image"/></td>
				<td><input type="file" name="file"> </td>
			</tr>
			<tr>
				<td><spring:message code="name"/></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="age"/></td>
				<td><form:input path="age" /></td>
			</tr>
		</table>
		<input type="submit" value="<spring:message code="add"/>">
	</form:form>
</body>
</html>