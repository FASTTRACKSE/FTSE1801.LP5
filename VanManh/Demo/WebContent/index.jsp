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
<h1>ssss</h1>
	<% if(request.getAttribute("user")!=null){
		out.print("Hello"+request.getAttribute("user"));	
	
	}%>

		<c:choose>
			<c:when test="${user!=null}">
				<% for(int i=0; i<7; i++){%>
					 Xin chao "${user}" <br/>
					<%} %>
			</c:when>
		</c:choose>
		
</body>
</html>