<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Sinh Viên</title>
<style type="text/css">
table, tr, th, td {
	border: 2px solid black;
	border-collapse: collapse;
}

</style>
</head>
<body>
	<form action="AddServlet" method="GET">
		Id: <input type="text" name="id"> 
		Họ Và Tên: <input type="text" name="ten"> 
		Tuổi: <input type="text"name="tuoi">
		Địa Chỉ: <input type="text"name="diachi"> 
		Lớp: <input type="text"name="lop">
		<input type="submit" name="them" value="Thêm"/>
	</form>
	
	<table style="width: 60%">
		<tr>
			<th colspan="6">Danh Sách Sinh Viên</th>
		</tr>
		<tr>
			<th style="text-align: left;">ID</th>
			<th style="text-align: left">Họ Và Tên</th>
			<th style="text-align: left">Tuổi</th>
			<th style="text-align: left">Địa Chỉ</th>
			<th style="text-align: left">Lớp</th>
			<th style="text-align: left;">Chức Năng</th>
		</tr>
		<c:forEach items="${sinhvien}" var="element">
			<tr>
				<td>${ element.id }</td>
				<td>${ element.ten }</td>
				<td>${ element.tuoi }</td>
				<td>${ element.diachi }</td>
				<td>${ element.lop }</td>
				<td><a href="UpdateServlet?id=${element.id}">Edit</a>
				<a href="DeleteServlet?id=${ element.id}">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>