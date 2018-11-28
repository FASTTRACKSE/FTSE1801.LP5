<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông Tin Sinh Viên</title>
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
	<table style="with: 100%">
		<tr>
			<th>Tên</th>
			<th>Lớp</th>
			<th>Tuổi</th>
			<th>Địa Chỉ</th>
		</tr>
		<c:forEach items="${listSinhVien }" var="listSV">
			<tr>
				<td>${listSV.ten}</td>
				<td>${listSV.lop}</td>
				<td>${listSV.tuoi}</td>
				<td>${listSV.diaChi}</td>
			</tr>





			<br />
		</c:forEach>
	</table>
</body>
</html>