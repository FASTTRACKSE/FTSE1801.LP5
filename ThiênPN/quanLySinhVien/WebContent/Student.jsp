
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />


<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Information</title>
<style type="text/css">
body{
background-image: url("https://anhdephd.com/wp-content/uploads/2018/02/tai-hinh-nen-phong-canh-thien-nhien-dep-nhat.jpg");
}
.center{
position: absolute;

left: 20%;
height: 300px;
margin-top: -75px;/* height/2 */
width: 1000px;
margin-left: -110px; /* width/2 */
}
table {
	border-collapse: collapse;
	width: 1000px;
}

table, tr, td, th {
	border: 1px solid black;
}
a:hover{
color: red;
}
.abc{
 color: white;
 font-size: 20px;
}
.kaka{
 font-size: 23px;
}
</style>


</head>
<body>
	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			Language <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="?language=vi">VietNamese</a></li>
			<li><a href="?language=en">English</a></li>
		</ul>
	</div>
	<a href="LogoutServlet"><fmt:message key="dangxuat" /></a>
	<a href="LoginServlet"><fmt:message key="dangnhap" /></a>
	<div class ="center">
	<table style="with: 100%">
		<tr class="kaka">
			<th><marquee><fmt:message key="maSV" /></marquee></th>
			<th><marquee><fmt:message key="tenSV" /></marquee></th>
			<th><marquee><fmt:message key="pass" /></marquee></th>
			<th><marquee><fmt:message key="tuoiSV" /></marquee></th>
			<th><marquee><fmt:message key="monhoc" /></marquee></th>
			<th><marquee><fmt:message key="diem" /></marquee></th>
			<th><marquee><fmt:message key="thaotac" /></marquee></th>
		</tr>
		<c:forEach items="${SinhVien}" var="listSV">
			<tr class="abc">
				<td>${listSV.maSinhVien}</td>
				<td>${listSV.tensinhVien}</td>
				<td>${listSV.password}</td>
				<td>${listSV.tuoi}</td>
				<td>${listSV.diem.monHoc}</td>
				<td>${listSV.diem.diem}</td>
				<td><a
					href='<c:out value="deleteSV?maSinhVien=${listSV.maSinhVien}"></c:out>'><fmt:message
							key="xoa" /></a> <a
					href='<c:out value="updateServlet?maSV=${listSV.maSinhVien}"></c:out>'><fmt:message
							key="sua" /></a> <a href='<c:out value="addSinhVien.jsp"></c:out>'><fmt:message
							key="them" /></a></td>
			</tr>





			<br />
		</c:forEach>
	</table>
	</div>

	<form method="post" action="uploadServlet"
		enctype="multipart/form-data">
		Select file to upload: <input type="file" name="uploadFile" /> <br />
		<br /> <input type="submit" value="Upload" />
	</form>
</body>
</html>