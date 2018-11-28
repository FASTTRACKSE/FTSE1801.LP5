<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="themthongtin"/></title>
</head>
<body>
	<center>
		<h1><spring:message code="themthongtin"/></h1>
		<form:form method="post" action="save" enctype="multipart/form-data">
			<table>
				<tr>
					<input name="file" id="fileToUpload" type="file" />
				</tr>
				<tr>
					<td><spring:message code="masv"/> :</td>
					<td><form:input path="MASV" /></td>
				</tr>
				<tr>
					<td><spring:message code="ten"/> :</td>
					<td><form:input path="NAME" /></td>
				</tr>
				<tr>
					<td><spring:message code="tuoi"/> :</td>
					<td><form:input path="AGE" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="<spring:message code="them"/>" /></td>
					<td><a href="/SpringDemo/display"><spring:message code="quayve"/></a></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>