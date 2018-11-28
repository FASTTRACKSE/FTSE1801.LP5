<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Sinh Viên</title>
</head>
<body>
 <h1>Edit Sinh Viên</h1>
	<form:form modelAttribute="add" method="post" action="/springweb/EditSV">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="maSinhVien" /></td>
			</tr>
			<tr>
				<td><spring:message code="tenSV" /> :</td>
				<td><form:input path="tensinhVien" /></td>
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
				<td><input type="submit" value=<spring:message code="sua" /> /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>