<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sinh viên</title>
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
	<div class="container">
		<div class="row" style="float: right;">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
					${lang.chonNn} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="SinhVienServlet?lang=Vietnamese">${lang.tiengviet}</a></li>
					<li><a href="SinhVienServlet?lang=English">${lang.tienganh}</a></li>
				</ul>
			</div>
		</div>
	</div>


	<form action="AddSvServlet" method="get">
		${lang.masv} <input type="text" name="id"><br>
		${lang.ten} <input type="text" name="name"><br>
		${lang.tuoi} <input type="text"	name="age"><br>
		<input type="submit" value="${lang.them}">
	</form>

	<table style="width: 30%">
		<tr>
			<th>${lang.masv}</th>
			<th>${lang.ten}</th>
			<th>${lang.tuoi}</th>
			<th>${lang.chucnang}</th>
		</tr>
		<c:forEach items="${list}" var="sinhVien">
			<tr>
				<td>${sinhVien.maSv}</td>
				<td>${sinhVien.name}</td>
				<td>${sinhVien.age}</td>
				<td><a
					href='<c:out value="UpdateSvServlet?id1=${sinhVien.maSv}"></c:out>'>${lang.sua}</a>
					<a
					href='<c:out value="DeleteSvServlet?id=${sinhVien.maSv}"></c:out>'>${lang.xoa}</a>
				</td>
			</tr>
			<br>
		</c:forEach>
	</table>

	<c:if test="${dong != 1}">
		<a href="SinhVienServlet?page=1">First</a>
		<a href="SinhVienServlet?page=${dong-1}">Preview</a>
	</c:if>
	<c:forEach var="i" begin="1" end="${soTrang}">
		<a href="?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${dong != soTrang}">
		<a href="SinhVienServlet?page=${dong+1}">Next</a>
		<a href="SinhVienServlet?page=${soTrang}">Last</a>
	</c:if>

</body>
</html>