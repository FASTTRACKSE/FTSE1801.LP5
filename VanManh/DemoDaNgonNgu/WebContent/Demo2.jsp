<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="DaNgonNguServlet?language=vi">Viet Nam</a>
	<a href="DaNgonNguServlet?language=en">English</a>
	 <fmt:requestEncoding value="UTF-8" />
   <fmt:setLocale value="${cookie.language.value}"/>
    <fmt:setBundle basename="i18n.language" />
    <fmt:message key="say-hello" />
    <a href="Demo3.jsp">bbb</a>
</body>
</html>