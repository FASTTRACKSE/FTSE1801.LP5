<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="LoginServlet" method="POST">
	<br>
		<input type="hidden" name="nameUrl" value="${url}">
		Username <input type="text" name="user"> <br><br>
		Password <input	type="password" name="pass"> <br><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>