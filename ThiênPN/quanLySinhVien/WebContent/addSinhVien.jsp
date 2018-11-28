<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD Sinh Viên</title>
</head>
<body>
	<form action="addSVServlet" method="post">
		<fmt:message key="maSV" />
		: <input type="text" name="maSV" />
		<fmt:message key="tenSV" />
		: <input type="text" name="tenSV" />
		<fmt:message key="pass" />
		: <input type="text" name="passSV" />
		<fmt:message key="tuoiSV" />
		: <input type="text" name="tuoi" />
		<fmt:message key="monhoc" />
		: <input type="text" name="MonHoc" />
		<fmt:message key="diem" />
		: <input type="text" name="diem" /> <input type="submit" name="add"
			value="addStudent" />
	</form>
</body>
</html>