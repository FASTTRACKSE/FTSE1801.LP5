<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="<c:url value='/css/facebook.css'/>"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>s
	<cs:header hideLogout="true"/>
	<form action="login" method="post">
		<table border="1">
			<tr>
				<td><fmt:message key="user" /></td>
				<td><input type="text" name = "user" /></td>
			</tr>
			<tr>
				<td><fmt:message key="pass" /></td>
				<td><input type="password" name = "pass" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="<fmt:message key='titleLoginScreen' />"/></td>
			</tr>
		</table>
		
	</form>
</body>
</html>