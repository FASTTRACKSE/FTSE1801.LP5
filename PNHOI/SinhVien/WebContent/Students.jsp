<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.Language"/>
<title>Insert title here</title>
</head>
<body>
	<form action="updateServlet" method="post">
		<input type="hidden" value="${students.id}" name="id"/>
		<fmt:message key="name"/>:<input type="text" value="${students.name}" name="name"/><br/>
		<fmt:message key="age"/>:<input type="text" value="${students.age}" name="age"/><br/>
		<fmt:message key="address"/>:<input type="text" value="${students.address}" name="address"/><br/>
		<input type="submit" value="<fmt:message key="ins"/>" name="sua">
	</form>
	
</body>
</html>