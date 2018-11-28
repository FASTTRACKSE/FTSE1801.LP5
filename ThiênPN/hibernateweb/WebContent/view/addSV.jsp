<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Sinh Viên</title>
</head>
<body>
	<h1>
		<spring:message code="them" />
	</h1>
	<form:form modelAttribute="add" method="post" action="AddSinhVien" enctype="multipart/form-data">
		<table>
			<tr>
						<input name="file" id="fileToUpload" type="file" />
			</tr>
			<tr>
				<td><spring:message code="maSV" />:</td>
				<td><form:input path="maSinhVien" /></td>
			</tr>
			<tr>
				<td><spring:message code="tenSV" /> :</td>
				<td><form:input  path="tensinhVien" /></td>
			</tr>
			<tr>
				<td><spring:message code="pass" /> :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><spring:message code="tuoiSV" /> :</td>
				<td><form:input path="tuoi" /></td>
			</tr>
			<tr>
				<td><spring:message code="monhoc" /> :</td>
				<td><form:input path="diem.monHoc" /></td>
			</tr>
			<tr>
				<td><spring:message code="diem" /> :</td>
				<td><form:input path="diem.diem" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value=<spring:message code="them" /> /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>