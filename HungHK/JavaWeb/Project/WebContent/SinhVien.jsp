<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table {
	border-collapse: collapse;
	}
	table, tr, td, th {
	border: 1px solid black;
	}
</style>
</head>
<body>
	<table style="width: 30%">
		<tr>
			<th>Ten</th>
			<th>Lop</th>
			<th>Tuoi</th>
			<th>Dia chi</th>
		</tr>
		<c:forEach items="${listSinhVien}" var="listSv">
			<tr>
				<td>${listSv.ten}</td>
				<td>${listSv.tuoi}</td>
				<td>${listSv.lop}</td>
				<td>${listSv.diaChi}</td>
			</tr>
			<br>
		</c:forEach>
	</table>
</body>
</html>