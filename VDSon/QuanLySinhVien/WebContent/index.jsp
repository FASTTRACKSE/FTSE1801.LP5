<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>


<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />


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
<link rel="icon" type="image/png"
	href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHlmqgjuL_-yqeQkgzMIdOs4kY2_f0Fkv-cMMC4tohsvkINEBo">
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	color: red;
}

a {
	text-decoration: none
}

a:hover {
	color: red
}

body {
	color: white;
	background-image:
		url("https://quangvinhdd.files.wordpress.com/2013/04/b8f4c-tuyetdenbatngo5b-5dvn-1.jpg");
	font-family: sans-serif;
	color: #333;
}

.back-to-top {
	margin: 0;
	position: fixed;
	bottom: 20px;
	right: 15px;
	z-index: 100;
	display: none;
	cursor: pointer;
	background-image:
		url(http://icons.iconarchive.com/icons/saki/nuoveXT/64/Actions-arrow-up-top-icon.png);
	width: 50px;
	height: 50px
}

a {
	color: pink;
}

h1 {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				<fmt:message key="ngonngu"></fmt:message>
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="?page=${trang}&lang=vi"><fmt:message
							key="vietnam"></fmt:message></a></li>
				<li><a href="?page=${trang}&lang=en"><fmt:message
							key="english"></fmt:message></a></li>
			</ul>
		</div>
		<center>
			<c:if test="${empty name}">
				<a href="Login.jsp"><fmt:message key="dangnhap"></fmt:message></a>
			</c:if>

		</center>
		<c:if test="${!empty name}">
			<center>
				<marquee>
					<h1>XIN CHÀO ${name}</h1>
				</marquee>
				<a href="logoutServlet"><fmt:message key="dangxuat"></fmt:message></a>
			</center>
		</c:if>
	</div>
	<center>
		<iframe width="360" height="200"
			src="https://www.youtube.com/embed/fmywb_RpGYk" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15739751.36848881!2d96.86112854448939!3d15.606989583500553!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31157a4d736a1e5f%3A0xb03bb0c9e2fe62be!2zVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1538122936833"
			width="360" height="200" frameborder="0" style="border: 0"
			allowfullscreen></iframe>
		<iframe scrolling="no" width="340" height="200"
			src="https://mp3.zing.vn/embed/song/ZW9DCEE6?start=true"
			frameborder="0" allowfullscreen="true"></iframe>
	</center>
	<br />
	<table style="width: 100%">
		<tr>
			<th><marquee behavior="alternate">
					<fmt:message key="masv"></fmt:message>
				</marquee></th>
			<th><marquee behavior="alternate">
					<fmt:message key="ten"></fmt:message>
				</marquee></th>
			<th><marquee behavior="alternate">
					<fmt:message key="tuoi"></fmt:message>
				</marquee></th>
			<th><marquee behavior="alternate">
					<fmt:message key="chucnang"></fmt:message>
				</marquee></th>
		</tr>
		<c:forEach items="${sv}" var="element1">
			<tr>
				<td>${element1.MASV}</td>
				<td>${element1.NAME}</td>
				<td>${element1.AGE}</td>
				<td><a href='<c:out value="AddUserServlet"></c:out>'><fmt:message
							key="them"></fmt:message></a> --- <a
					href="UpdateUserServlet?id1=${element1.MASV}"><fmt:message
							key="sua"></fmt:message></a> --- <a
					href="<c:out value='DeleteUser?id=${element1.MASV}'></c:out>"><fmt:message
							key="xoa"></fmt:message></a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<form action="SinhVienServlet" method="GET">
			<%-- <table>
				<tr>
						<td colspan="4">
							<cs:paging sotrang="${sotrang}" trang="${trang}"></cs:paging>
						</td>
					</tr>
			</table> --%>
			 <c:if test="${trang != 1}">
				<a href="SinhVienServlet?page=1">First</a>
				<a href="SinhVienServlet?page=${trang-1}">Previous</a>
			</c:if>
			<br />
			<table cellpadding="5" cellspacing="5">
				<tr>
					<c:forEach begin="1" end="${soTrang}" var="i">
						<c:choose>
							<c:when test="${size eq i}">
								<td>${i}</td>
							</c:when>
							<c:otherwise>
								<td><a href="SinhVienServlet?page=${i}">${i}</a></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</table>

			<c:if test="${trang lt soTrang}">
				<a href="SinhVienServlet?page=${trang + 1}">Next</a>
				<a href="SinhVienServlet?page=${soTrang}">Last</a>
			</c:if>
		</form>
	</center>
	  <c:forEach var="i" begin="1" end="${soTrang}">
		<a
			href="http://localhost:8080/QuanLySinhVien/SinhVienServlet?page=${i}">${i}</a>
	</c:forEach>
	<center>
		<form method="post" action="UploadServlet"
			enctype="multipart/form-data">
			Select file to upload: <br /> <br /> <input type="file"
				name="uploadFile" /> <br /> <br /> <input style="color: black"
				type="submit" value="Upload" />
		</form>
	</center>
	<br />
	<a href="#" class="back-to-top" style="display: inline;"
		title="Lên đầu trang"></a>
</body>
</html>