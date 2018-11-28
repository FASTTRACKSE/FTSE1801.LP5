<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="i18n.language" />
</head>
<body>
	<c:if test="${DangNhap != null}">
			<script type="text/javascript">
			alert('Sai tai khoan or mat khau');
			</script>
	</c:if>
	<form action="LoginServlet" method="post">
	<input type="hidden" name="Url" value="${URL}">
		<table>
			<tr>
				<td><fmt:message key="tk"/> : </td>
				<td><input type="text" name="tk" placeholder="<fmt:message key="tk"/>"></td>
			</tr>
			<tr>
				<td><fmt:message key="mk"/> : </td>
				<td><input type="password" name="mk" placeholder="<fmt:message key="mk"/>"></td>
			</tr>
		</table>
		<input type="submit" value='<fmt:message key="DangNhap" />'>
	</form>
</body>
</html>