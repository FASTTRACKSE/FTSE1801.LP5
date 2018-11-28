<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />

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
body {
	margin-left: 10px;
}
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
			<div class="dropdown" style="float: right;">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<fmt:message key="chonNN" />
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="?page=${trang}&language=vi"><fmt:message
								key="tiengviet" /></a></li>
					<li><a href="?page=${trang}&language=en"><fmt:message
								key="tienganh" /></a></li>
				</ul>
			</div>
			<!-- <form style="float: right;" action="SinhVienServlet" method="POST">
				Username <input type="text" name="user"> Password <input
					type="password" name="pass"> <input type="submit"
					value="Đăng nhập"> &nbsp;
			</form> -->
		</div>
	</div>


	<div>
		<a href="login.jsp"><fmt:message key="dangnhap" /></a> | <a
			href="LogoutServlet"><fmt:message key="dangxuat" /></a>
	</div>
	<br>

	<div class="row">
		<form class="col-sm-3" action="AddSvServlet" method="get">
			<fmt:message key="masv" />
			<input type="text" name="id"><br><br>
			<fmt:message key="ten" />
			<input type="text" name="name"><br><br>
			<fmt:message key="tuoi" />
			<input type="text" name="age"><br><br> <input type="submit"
				value="<fmt:message key="them" />">
		</form>
		<div class="col-sm-4">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.783969708566!2d108.23415494243329!3d16.076696326645884!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31421827a05f11e5%3A0x1eb1c75a2d925d91!2sFast+Track+SE!5e0!3m2!1svi!2s!4v1538126924694"
				width="300" height="200" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
	</div>

	<table style="width: 50%; text-align: center;">
		<tr>
			<th><fmt:message key="masv" /></th>
			<th><fmt:message key="ten" /></th>
			<th><fmt:message key="tuoi" /></th>
			<th><fmt:message key="chucnang" /></th>
		</tr>
		<c:forEach items="${sv}" var="sinhVien">
			<tr>
				<td>${sinhVien.maSv}</td>
				<td>${sinhVien.name}</td>
				<td>${sinhVien.age}</td>
				<td><a
					href='<c:out value="UpdateSvServlet?id1=${sinhVien.maSv}"></c:out>'><fmt:message
							key="sua" /></a> <a
					href='<c:out value="DeleteSvServlet?id=${sinhVien.maSv}"></c:out>'><fmt:message
							key="xoa" /></a></td>
			</tr>
			<br>
		</c:forEach>
	</table>

	<c:if test="${trang != 1}">
		<a href="SinhVienServlet?page=1">First</a>
		<a href="SinhVienServlet?page=${trang-1}">Preview</a>
	</c:if>
	<c:forEach var="i" begin="1" end="${soTrang}">
		<a href="SinhVienServlet?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${trang != soTrang}">
		<a href="SinhVienServlet?page=${trang+1}">Next</a>
		<a href="SinhVienServlet?page=${soTrang}">Last</a>
	</c:if>


	<center>
		<form method="post" action="UploadServlet"
			enctype="multipart/form-data">
			Select file to upload: <input type="file" name="uploadFile" /> <br />
			<br /> <input type="submit" value="Upload" />
		</form>
	</center>

</body>
</html>