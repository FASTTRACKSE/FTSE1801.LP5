<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<h3>Đăng nhập</h3>
	<form action="" method="post">
		Tài khoản: <input type="text" name="user" /> Mật khẩu: <input
			type="password" name="pass" /> <input type="submit"
			value="Đăng nhập" />
	</form>
	<%
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		if (name != null && pass != null) {
			if (name.equals("son") && pass.equals("123")) {
				out.println("xin chào" + name);
			} else {
				out.println("Sai mk hoặc tên đăng nhập cmnr bạn ơi!!!!!!");
			}
		} else {
			out.println("Xin mời nhập user và pass");
		}
	%>
</body>
</html>