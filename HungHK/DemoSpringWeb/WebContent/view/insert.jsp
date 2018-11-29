<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sinh viên</title>
</head>
<body>
	<h1>Thêm Sinh Viên</h1>
	<form:form modelAttribute="add" method="post" action="addSv">
		<table>
			<tr>
				<td>Masv :</td>
				<td><form:input path="maSv" /></td>
			</tr>
			<tr>
				<td>Tên :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Tuổi :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>