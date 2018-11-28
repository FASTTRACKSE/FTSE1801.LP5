<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="listStudent" method="get">
	Nhap ten: <input type="text" name = "name">
		<input type="submit" name = "ten" value="Hien thi">
		<input type="submit" name = "ten" value="luu">
	</form>
<c:forEach items="${list}" var="student">
	${student}
</c:forEach>
	
	
</body>
</html>