<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${ngonNgu}" />
<fmt:setBundle basename="model.entity.language"/>
<title>Insert title here</title>
</head>
<body>
	<a href="DemoNgonNguServlet?lang=Vietnamese">VN</a>
	<a href="DemoNgonNguServlet?lang=Engligh">EN</a><br>
	<fmt:message key="tieuDe"/>
	<a href="DemoNgonNguServlet2">next</a>
	
</body>
</html>