<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="giaiPTBac2" method="get">
		So A : <input type="text" id = "a" name = "SoA" value="0"><br>
		So B : <input type="text" id = "b" name = "SoB" value="0"><br>
		So C : <input type="text" id = "c" name = "SoC" value="0"><br>
		<input type="submit" name = "Tinh" value="Giai PT">
	</form>

	<% if(request.getAttribute("x2") != null){
	String x2 = ""+ request.getAttribute("x2");
	String x1 = ""+ request.getAttribute("x1");
	out.print("Phuong trinh co 2 nghiem la : " + x1 +" va "+ x2);
	
	}else if(request.getAttribute("x1") != null){
		String x1 = ""+ request.getAttribute("x1");
		out.print(x1);
	}%>
</body>
</html>