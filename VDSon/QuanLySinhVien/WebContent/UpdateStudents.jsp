<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Sửa thông tin sinh viên</title>
</head>
<body>
	<h1>
		<fmt:message key="suathongtin"></fmt:message>
	</h1>
	<form action="UpdateUserServlet" method="POST">
		<input type="hidden" value="${sv.MASV}" name="id">
		<fmt:message key="ten"></fmt:message>
		<input type="text" value="${sv.NAME}" name="name"><br /> <br />
		<fmt:message key="tuoi"></fmt:message>
		<input type="text" value="${sv.AGE}" name="age"><br /> <br />
		<input type="submit" value="<fmt:message key="sua"></fmt:message>"
			name="sua">
	</form>
</body>
</html>