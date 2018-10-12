<%@page import="model.dao.LanguageDao"%>
<%@page import="model.dao.SinhVienDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=
UTF-8">
 <!-- <link rel="stylesheet" href="Css.css" type="text/css"> -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body{
	text-align: center;
	background-image: url("https://www.quirkybyte.com/wp-content/uploads/2018/06/The-NUN.jpg");
	}
	table, tr, th, td {
		border: solid 1px;
	}
	table{
		border-collapse: collapse;
		margin-left: 40%;
	}
	a{
		text-decoration: none;
		
	}
	.a{
		background-color: lightgray;
	}
	.b{
		background-color: yellow;
	}
	.c{
		background-color: green;
	}
</style>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${lang}"/>
    <fmt:setBundle basename="resources.language" />
    <l:demo name="name"/>
	
	<div class="dropdown" style="text-align: left;">
	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Language
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="SinhVienServlet?language=vi&page=${page}">Vietnamese</a></li>
      <li><a href="SinhVienServlet?language=en&page=${page}">English</a></li>
    </ul>
	</div>
	
	<form action="AddServlet" method="post">
		<input type="submit" name = "them" value="<fmt:message key = "themSV"/>">
	</form><br>
	<table>
		<tr class="c">
			<th><fmt:message key = "maSV"/></th>
			<th><fmt:message key = "tenSV"/></th>
			<th><fmt:message key = "monHoc"/></th>
			<th><fmt:message key = "diem"/></th>
			<th><fmt:message key = "xoa"/></th>
			<th><fmt:message key = "sua"/></th>
		</tr>
		<c:set var="i" value="1"></c:set>
		<c:forEach items="${listSV}" var="sinhVien">
			<c:choose>
				<c:when test="${i%2 eq 0}">
					<tr class = "a">
						<td>${sinhVien.maSV}</td>
						<td>${sinhVien.tenSV}</td>
						<td>${sinhVien.diem.monHoc}</td>
						<td>${sinhVien.diem.diem}</td>
						<td><a href="DeleteServlet?maSV=${sinhVien.maSV}"><fmt:message key = "xoa"/></a></td>
						<td><a href="UpdateServlet?maSV=${sinhVien.maSV}"><fmt:message key = "sua"/></a></td>
					</tr>
					<c:set var="i" value="${i+1}"></c:set>
				</c:when>
				<c:otherwise>
					<tr class = "b">
						<td>${sinhVien.maSV}</td>
						<td>${sinhVien.tenSV}</td>
						<td>${sinhVien.diem.monHoc}</td>
						<td>${sinhVien.diem.diem}</td>
						<td><a href="DeleteServlet?maSV=${sinhVien.maSV}"><fmt:message key = "xoa"/></a></td>
						<td><a href="UpdateServlet?maSV=${sinhVien.maSV}"><fmt:message key = "sua"/></a></td>
					</tr>
					<c:set var="i" value="${i+1}"></c:set>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table><br>
	<form action="SinhVienServlet" method="post" class="paging">
	<input type="hidden" value="${page}"  name = "pages">
	<input type="hidden" value="${pageBegin}"  name = "pageBegin">
	<input type="hidden" value="${pageEnd}"  name = "pageEnd">
	<ul class="pagination">
	<c:choose>
		<c:when test="${soTrang <= 2}">
			<c:forEach var="i" begin="1" end="${soTrang}">
				<li><a href="SinhVienServlet?page=${i}">${i}</a></li>
			</c:forEach>
				
		</c:when>
		<c:otherwise>
			<c:if test="${page != 1}">
			<li><a href="SinhVienServlet?page=1"><fmt:message key = "dau"/></a></li>
			<li><a href="SinhVienServlet?page=${page-1}&pageBegin=${page -2}&pageEnd=${page}"><fmt:message key = "lui"/></a></li>
			</c:if>
			<c:choose>
				<c:when test="${pageBegin ne null}">
					<c:choose>
						<c:when test="${page eq 1}">
							<c:forEach var="i" begin="1" end="3">
								<li><a href="SinhVienServlet?page=${i}&pageBegin=1&pageEnd=3">${i}</a></li>
							</c:forEach>
						</c:when>
						<c:when test="${page eq soTrang}">
							<c:forEach var="i" begin="${soTrang -2}" end="${soTrang}">
								<li><a href="SinhVienServlet?page=${i}&pageBegin=${page - 2}&pageEnd=${page}">${i}</a></li>
							</c:forEach>
						</c:when>
						<c:when test="${page eq pageBegin}">
							<c:forEach var="i" begin="${page -1}" end="${page + 1}">
								<li><a href="SinhVienServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></li>
							</c:forEach>
						</c:when>
						<c:when test="${page eq pageEnd}">
							<c:forEach var="i" begin="${page -1}" end="${page + 1}">
								<li><a href="SinhVienServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="${page - 1}" end="${page + 1}">
								<li><a href="SinhVienServlet?page=${i}&pageBegin=${page - 1}&pageEnd=${page + 1}">${i}</a></li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${page}" end="${page + 2}">
						<li><a href="SinhVienServlet?page=${i}&pageBegin=${page}&pageEnd=${page + 2}">${i}</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${page ne soTrang}">
				<li><a href="SinhVienServlet?page=${page+1}&pageBegin=${page}&pageEnd=${page + 2}"><fmt:message key = "tien"/></a></li>
				<li><a href="SinhVienServlet?page=${soTrang}&pageBegin=${soTrang-2}&pageEnd=${soTrang}"><fmt:message key = "cuoi"/></a></li>
			</c:if>
		</c:otherwise>	
	</c:choose>
	
  </ul>
	</form>
	<form action="Logout" method="post">
		<input type="submit" name="chon" value="logout">
	</form>
	<iframe src="https://www.youtube.com/"></iframe>
</body>
</html>