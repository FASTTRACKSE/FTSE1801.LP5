<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SỬA THÔNG TIN</title>
</head>
<body>
	<center>
		<h1>
			SỬA THÔNG TIN
		</h1>
		<form:form method="POST" action="/SpringDemo/editSave">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="MASV" /></td>
				</tr>
				<tr>
					<td>Tên sinh viên :</td>
					<td><form:input path="NAME" /></td>
				</tr>
				<tr>
					<td>Tuổi :</td>
					<td><form:input path="AGE" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Edit save" /></td>
				<%-- 	<td><a href="/SpringDemo/display"><spring:message
								code="quayve" /></a></td> --%>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>