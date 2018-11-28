<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Work</title>
</head>
<body>
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<p>
		Hello Em Nhé
		<%=i%></p>

	<%
		}
	%>
	<h1>
		<%
			out.print("hahahahah");
		%>
	</h1>
	<%
		String name = (String) request.getAttribute("username");
	%>
	
	hello
	<%=name%>

   <form action="hello" method="GET">
First name: <input type="text" name="firstName" />
Last name: <input type="password" name="lastName" />
<input type="submit" value="Submit" />
a: <input type = "text" name = "a"/>
b: <input type = "text" name = "b"/>

<input type="submit" name="phepTinh" value="+"/>
<input type="submit" name = "phepTinh" value="-"/>
<input type="submit" name = "phepTinh" value="x"/>
<input type="submit" name = "phepTinh" value="/"/>
</form>
<br/>
 
</body>
</html>