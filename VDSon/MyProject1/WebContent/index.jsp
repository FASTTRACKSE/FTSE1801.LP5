<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Sơn</title>
<style>
table, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%-- <% String name = (String)request.getAttribute("username"); %>	
	chào bạn <%=name %>
	<form action = "helloServlet" method="GET">
	Tên đệm: <input type="text" name="ten dem" />
	Tên cuối <input type="text" name="ten cuoi" />
	<input type="submit" value="Submit" />
	</form>
		
	<%String[] name1 = (String[])request.getAttribute("list"); %>
	<%for (int i = 0; i<name1.length; i++){ 
	out.println(name1[i]);%>
	<%} %> --%>

	<!-- 	<form action = "helloServlet" method="GET">
	a <input type="text" name="a" />
	<br>
	</br>
	b <input type="text" name="b" />
	<br>
	</br>
	<input type="submit" name="phepTinh" value="+" />
	<input type="submit" name="phepTinh" value="-" />
	<input type="submit" name="phepTinh" value="x" />
	<input type="submit" name="phepTinh" value="/" />
	</form>
	<br>
	<h1>PHƯƠNG TRÌNH BẬC 2</h1>
	<form action="helloServlet" method="GET">
	nhập a <input type="text" name="a1" />
	<br>
	<br>
	nhập b <input type="text" name="b1" />
	<br>
	<br>
	nhập c <input type="text" name="c1" />
	<br>
	<br>
	<input type="submit"  value="Kết Quả">
	</form> -->

	<%-- 	<c:forEach items="${a}" var="element">
		${element}
		<br/>
	</c:forEach> --%>

	<c:forEach items="${b}" var="element1">
		<table style="width: 100%">
			<tr>
				<td>${element1.name}</td>
				<td>${element1.age}</td>
				<td>${element1.address}</td>
			</tr>
		</table>
	</c:forEach>

</body>
</html>