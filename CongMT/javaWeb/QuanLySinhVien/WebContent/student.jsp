<%@page import="model.dao.NgonNguDao"%>
<%@page import="model.dao.StudentDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.language"/>
<link rel="stylesheet" href="Css.css" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><fmt:message key="title"/></title>
<style type="text/css">
body{
	background-image: url("images/css1.jpg");
           
}
</style>
</head>
<body class="body">
	
	<h1><fmt:message key="TieuDe"/></h1></br></br>
	
	<form action="UpdateSevervlet" method="post">
	 <input name="id" type="hidden" value="${student.id}" >
	 <table>
			<tr>
				<td>- <fmt:message key="TenDangNhap"/>:</td>
				<td><input type="text" name="name"  value="${student.name}" /></td>
			<tr>
				<td>- <fmt:message key="Tuoi"/>:</td>
				<td><input type="text" name="old" value="${student.old}" /></td>
			</tr>
			<tr>
				<td>- <fmt:message key="DiaChi"/>:</td>
				<td><input type="text" name="adress" value="${student.adress}" /></td>
			</tr>
			<tr>
				<td>- <fmt:message key="Sdt"/>:</td>
				<td><input type="text" name="number" value="${student.numberPhone}" /></td>
			</tr>

		</table>
		<br> <input type="submit" name="nutchon" value="<fmt:message key="Sua"/>">
	
	
	</form>
</body>
</html>