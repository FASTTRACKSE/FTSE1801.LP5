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
	<h1>
		<spring:message code="edit" />
	</h1>

	<form:form modelAttribute="saveEdit" action="/DemoSpringWeb/editUser">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><spring:message code="name" /> :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="mk" /> :</td>
				<td><form:input path="pass" /></td>
			</tr>
			<tr>
				<td><spring:message code="age" /> :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><spring:message code="address" /> :</td>
				<td><form:input path="add" /></td>
			</tr>
			<tr>
				<td><spring:message code="img" /> :</td>
				<td><form:input path="img" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>