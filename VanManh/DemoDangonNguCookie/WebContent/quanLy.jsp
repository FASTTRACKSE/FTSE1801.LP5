<%@page import="java.util.Map"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
table, tr, th, td {
	border: solid 1px;
	border-collapse: collapse;
	color: black;
	margin-left: 20%;
}

.nhap{
	color: red;
	text-align: center;
}

a {
	text-decoration: none;
}

.link{
	color: white;
}

.a{
	background-color: gray;
}
.b{
	background-color: lightgray;
}

body {
	background-image: url("https://cdn-images-1.medium.com/max/1600/1*dP6SWQSv09pHJRxhhXNT4g.jpeg");
	text-align: center;
}

</style>
<title>Van Manh Bank</title>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="i18n.language" />
</head>
<body>
	<div class="dropdown" style="text-align: left;">
		<button class="btn btn-primary dropdown-toggle" stype="button" data-toggle="dropdown">Language
	  	<span class="caret"></span></button>
		<ul class="dropdown-menu">
		    <li><a href="DaNgonNgu?lang=vi&page=${page}">VietNam</a></li>
		    <li><a href="DaNgonNgu?lang=en&page=${page}">English</a></li>
		</ul>
	</div>
	<form action="AddKH" method="get">
		<table class="nhap">
			<tr>
				<td style="color: white;"><fmt:message key="ten"/>:</td>
				<td><input type="text" name="TenKH"></td>
			</tr>
			<tr>
				<td style="color: white;"><fmt:message key="diaChi"/> :</td>
				<td><input type="text" name="DiaChi"></td>
			</tr>
			<tr>
				<td style="color: white;"><fmt:message key="phuong"/></td>
				<td><select name="phuong">
						<c:forEach items="${phuong}" var="phuong">
							<option>${phuong}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td style="color: white;"><fmt:message key="sdt"/> :</td>
				<td><input type="text" name="SoDT"></td>
			</tr>
			<tr>
				<td style="color: white;">Email :</td>
				<td><input type="text" name="Email"></td>
			</tr>
			<tr>
				<td style="color: white;">CMND :</td>
				<td><input type="text" name="SoCMND"></td>
			</tr>
			<tr>
				<td style="color: white;"><fmt:message key="soThe"/> :</td>
				<td><select name="soThe">
						<c:forEach items="${theATM}" var="soThe">
							<option>${soThe}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td style="color: white;"><fmt:message key="soTien"/> :</td>
				<td><input type="text" name="Tien"></td>
			</tr>
		</table>
		<input type="submit" value="<fmt:message key="them"/>" name="luaChon" class="nhap">
	</form>
	<table>
		<tr>
			<th style="color: white;"><fmt:message key="maKH"/></th>
			<th style="color: white;"><fmt:message key="ten"/></th>
			<th style="color: white;"><fmt:message key="diaChi"/></th>
			<th style="color: white;"><fmt:message key="phuong"/></th>
			<th style="color: white;"><fmt:message key="quan"/></th>
			<th style="color: white;"><fmt:message key="sdt"/></th>
			<th style="color: white;">Email</th>
			<th style="color: white;">CMND</th>
			<th style="color: white;"><fmt:message key="soThe"/></th>
			<th style="color: white;"><fmt:message key="soTien"/></th>
		</tr>
		<c:set var="i" value="1"></c:set>
		<c:forEach items="${listKH}" var="khachHang">
			<c:choose>
				<c:when test="${i%2 eq 0}">
					<tr class="a">
						<td>${khachHang.maKH}</td>
						<td>${khachHang.tenKH}</td>
						<td>${khachHang.diaChi}</td>
						<td>${khachHang.phuong}</td>
						<td>${khachHang.quan}</td>
						<td>${khachHang.soDT}</td>
						<td>${khachHang.email}</td>
						<td>${khachHang.soCMND}</td>
						<td>${khachHang.soTheATM}</td>
						<td>${khachHang.soTienTrongTK}</td>
						<td><a href="DeleteKh?MaKH=${khachHang.maKH}"><fmt:message key="xoa"/></a></td>
						<td><a href="UpdateKh?MaKH=${khachHang.maKH}&lang=${lang}"><fmt:message key="sua"/></a></td>
					</tr>
					<c:set var="i" value="${i+1}"></c:set>
				</c:when>
				<c:otherwise>
					<tr class="b">
						<td>${khachHang.maKH}</td>
						<td>${khachHang.tenKH}</td>
						<td>${khachHang.diaChi}</td>
						<td>${khachHang.phuong}</td>
						<td>${khachHang.quan}</td>
						<td>${khachHang.soDT}</td>
						<td>${khachHang.email}</td>
						<td>${khachHang.soCMND}</td>
						<td>${khachHang.soTheATM}</td>
						<td>${khachHang.soTienTrongTK}</td>
						<td><a href="DeleteKh?MaKH=${khachHang.maKH}"><fmt:message key="xoa"/></a></td>
						<td><a href="UpdateKh?MaKH=${khachHang.maKH}&lang=${lang}"><fmt:message key="sua"/></a></td>
					</tr>
					<c:set var="i" value="${i+1}"></c:set>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<form action="KhachHangServlet" method="get">
		<ul class="pagination">
			<c:if test="${page ne 1 && soTrang > 2}">
				<li><a href="KhachHangServlet?page=1&PageEnd=3&PageBegin=1" class="link"> <c:out value="<<"></c:out> </a></li>
			</c:if>
			<c:if test="${page ne 1}">
				<li><a href="KhachHangServlet?page=1" class="link"> <c:out value="<"></c:out> </a></li>
			</c:if>
				<c:choose>
					<c:when test="${soTrang eq 1}">
						<li><a href="KhachHangServlet?page=1" class="link">1</a></li>
					</c:when>
					<c:when test="${soTrang eq 2}">
						<li><a href="KhachHangServlet?page=1&PageEnd=2&PageBegin=1" class="link">1</a></li>
						<li><a href="KhachHangServlet?page=2&PageEnd=2&PageBegin=1" class="link">2</a></li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${page eq 1}">
								<c:forEach var="i" begin="1" end="3">
									<li><a href="KhachHangServlet?page=${i}&PageEnd=3&PageBegin=1" class="link">${i}</a></li>
								</c:forEach>
							</c:when>	
							<c:when test = "${page eq soTrang}">
								<c:forEach var="i" begin="${soTrang-2}" end="${soTrang}">
									<li><a href="KhachHangServlet?page=${i}&PageEnd=${soTrang}&PageBegin=${sotrang-2}" class="link">${i}</a></li>
								</c:forEach>
							</c:when>
							<c:when test="${page eq pageBegin}">
								<c:forEach var="i" begin="${page-1}" end="${page+1}">
									<li><a href="KhachHangServlet?page=${i}&PageEnd=${page+1}&PageBegin=${page-1}" class="link">${i}</a></li>
								</c:forEach>
							</c:when>
							<c:when test="${page eq pageEnd}">
								<c:forEach var="i" begin="${page-1}" end="${page+1}">
										<li><a href="KhachHangServlet?page=${i}&PageEnd=${page+1}&PageBegin=${page-1}" class="link">${i}</a></li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="i" begin="${page-1}" end="${page+1}">
									<li><a href="KhachHangServlet?page=${i}&PageEnd=${page+1}&PageBegin=${page-1}" class="link">${i}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			<c:if test="${page ne soTrang}">
				<li><a href="KhachHangServlet?page=${page+1}&PageEnd=${page+3}&PageBegin=${page}" class="link">></a></li>
			</c:if>
			<c:if test="${page ne soTrang && soTrang>2}">
				<li><a href="KhachHangServlet?page=${soTrang}&PageEnd=${soTrang}&PageBegin=${soTrang-2}" class="link">>></a></li>
			</c:if>
		</ul>	
	</form>

</body>
</html>