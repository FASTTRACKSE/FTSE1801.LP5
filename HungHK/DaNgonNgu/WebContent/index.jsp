<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Da Ngon Ngu</title>
</head>
<body>

	<div style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		<a href="DaNgonNguServlet?n=vi">Vietnamese</a> | 
		<a href="DaNgonNguServlet?n=en">English</a>
	</div>
	<form method="post" action="DaNgonNguServlet">
		<table>
			<tr>
				<td><strong><fmt:message key="user" /></strong></td>
				<td><input name="userName" /></td>
			</tr>
			<tr>
				<td><strong><fmt:message key="pass" /></strong></td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<fmt:message key="submit"/>" /></td>
			</tr>
		</table>
	</form>

</body>
</html>