<%@page import="com.sun.xml.internal.fastinfoset.sax.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${lang}"/>
    <fmt:setBundle basename="main.resources.messenge" />
    
	<a href="HelloWorld?lang=en">English</a>
	<a href="HelloWorld?lang=vi">Vietnamese</a>
	
	<h1><fmt:message key="title"/></h1>
	
	<form action="Hello" method="get">
	
		<input type="submit" name="chon" value="chon">
	
	</form>
	<fieldset>
		<legend>Date</legend>
		<fmt:formatDate value="<%= new java.util.Date() %>" type="both" timeStyle="full" dateStyle="full"/>
		
	</fieldset>
	
</body>
</html>