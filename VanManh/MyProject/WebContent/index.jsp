<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Work</title>
</head>
<body>
	<form action = "loginSeverlet" method = "post">
	user: <input type = "text" name = "user"/><br/>
	pass : <input type = "text" name = "pass"/><br/>
	<input type="submit" value="login">
	</form>
</body>
