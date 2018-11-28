<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${lang}"/>
    <fmt:setBundle basename="resources.language" />
    
	<form action="UpdateServlet" method="post">
		<input type="hidden" value="${sinhVien.maSV}" name="maSV">
		<table>
			<tr>
				<td><fmt:message key = "monHoc"/>:</td>
				<td><input type="text" name="monHoc" value="${sinhVien.diem.monHoc}"></td>
			</tr>
			<tr>
				<td><fmt:message key = "diem"/>:</td>
				<td><input type="text" name="diem" value="${sinhVien.diem.diem}"></td>
			</tr>
		</table>
		<br /> <input type="submit" value="<fmt:message key = "sua"/>" name="chon">
		<br /><br />
	</form>
	
</body>
</html>