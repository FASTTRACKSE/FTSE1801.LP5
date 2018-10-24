<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language"/>

</head>
<body>

	<form action="AddServlet" method="post">
		<input type="hidden" name="id"/>
		<fmt:message key="ten"/>: <input type="text"  name="ten"/> 
		<fmt:message key="tuoi"/>: <input type="text" name="tuoi"/>
		<fmt:message key="diachi"/>: <input type="text" name="diachi"/> 
		<fmt:message key="lop"/>: <input type="text" name="lop"/>
		<input type="submit" name="add" value="AddSv"/>
	</form>
</body>
</html>