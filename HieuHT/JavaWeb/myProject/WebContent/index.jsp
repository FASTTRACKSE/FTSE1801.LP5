<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<% for(int i =0; i<10; i++){%>
	<p>Hello World  <%=i %></p>
	<%  } %>
	<h2> <% out.print("Hôm Nay Là Thứ Mấy?");%></h2>
	<% out.print("<hr>"); %>
	<% String name = (String)request.getAttribute("a"); %>
	Chắc Chắc Là <%=name %>
	
	<form action="pheptinh" method="get">
		Số a: <input type="text" name="soA"> 
		Số b: <input type="text"name="soB"> 
		<input type="submit" name="pheptinh" value="+"/>
		<input type="submit" name="pheptinh" value="-"/> 
		<input type="submit" name="pheptinh" value="*"/> 
		<input type="submit" name="pheptinh" value="/"/>
	</form>
	
	<form action="giaiPT" method="post">
	Số a: <input type="text" name = "a">
	Số b: <input type="text" name = "b">
	Số c: <input type="text" name = "c">
	<input type="submit" name="giaiPT" value="Giải">
	</form>
	 
	 <form action="LoginServlet" method="post">
	 username: <input type="text" name="user">
	 password: <input type="password" name="pass">
	 <input type="submit" name="LoginServlet" value="Đăng Nhập">
	 </form>
</body>
</html>