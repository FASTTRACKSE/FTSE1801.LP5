<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello word</title>
</head>
<body>
	<% for(int i = 0;i<10;i++){%>
		<h1>Hello alo <%=i+1%></h1>
	<% }
	out.print("hahaha");
	%>
	
	<%String name = (String)request.getAttribute("UserName"); %>
	hello <%= name %>
	
	<form action="loginServlet" method="post">
	User Name:<input type="text" name="user"/><br/>
	Password:<input type="text" name="pass"/>
	<input type="submit" value="Login">
	</form>
	
</body>
</html>