<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HungHK</title>
</head>
<body>
	<%
		for (int i = 1; i <= 10; i++) {
	%>
	<h1>
		Hello Hưng
		<%=i%></h1>
	<%
		}
		out.print("ABC");
	%>
	<h3>ABCD</h3>
	<%
		String name = (String) request.getAttribute("username");
	%>
	chào thằng
	<%=name%>

	<form action="servlet" method="GET">
		First name: <input type="text" name="firstName" /><br>
		Last name: <input type="text" name="lastName" /><br>
		<input type="submit" value="Submit" />
	</form><br>

	<form action="servlet" method="get">
		a: <input type="text" name="a" /><br>
		b: <input type="text" name="b" /><br>
		<input type="submit" name="phepTinh" value=" + ">
		<input type="submit" name="phepTinh" value=" - ">
		<input type="submit" name="phepTinh" value=" * ">
		<input type="submit" name="phepTinh" value=" / ">
		
	</form><br>
	
	<h3>Giai phuong trinh bac 2</h3>
	<form action="servlet" method="get">
		Nhap a: <input type="text" name="a"><br>
		Nhap b: <input type="text" name="b"><br>
		Nhap c: <input type="text" name="c"><br>
		<input type="submit" name="giai" value="Giai phuong trinh">
	</form><br><br>
	
	<h1>Login</h1>
	<form action="Servlet" method="POST">
		Username <input type="text" name="user">
		Password <input type="password" name="pass">
		<input type="submit" value="Dang nhap">
	</form>
	
	<c:forEach items="${a}" var="element">
		${element}
	</c:forEach>
</body>
</html>