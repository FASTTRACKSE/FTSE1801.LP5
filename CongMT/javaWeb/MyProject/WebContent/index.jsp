<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@  taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mai Thanh Cong</title>
</head>
<body>
	<h1>Login</h1></br></br>
	<form action="LoginServlet" method="post">
	Username: <input type="text" name="user" /></br></br>
	Password: <input type="password" name="pass" /></br></br>
	<input type="submit" value="Login" />
	</form>
</body>
</html>