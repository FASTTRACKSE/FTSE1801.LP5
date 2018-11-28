<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tran Duy Luan</title>
</head>
<body>
	<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Age</th>
				<th>Address</th>
				<th>Image</th>

			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.pass}</td>
					<td>${user.age}</td>
					<td>${user.add}</td>
					<td>${user.img}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>