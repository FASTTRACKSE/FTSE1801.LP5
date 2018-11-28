<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="" method="post">
	User name: <input type="text" name="user">
	Password: <input type="password" name="pass">
	<input type="submit" name="sub" value="Login">
	</form>
	<%
	String name = request.getParameter("user");
	String pass = request.getParameter("pass");
	if(request.getParameter("sub") != null){
		if(name.equals("Hoi") && pass.equals("123")){
			out.print("hello"+name);
		}else{
			out.print("dang nhap that bai");
		}
	} %>
</body>
</html>