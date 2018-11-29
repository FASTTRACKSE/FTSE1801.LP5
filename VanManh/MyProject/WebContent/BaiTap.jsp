<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "TinhToan" method = "post">
	SoA: <input type = "text" name = "SoA"><br/>
	SoB : <input type = "text" name = "SoB"><br/>
	<input type="submit" name = "Tinh" value="+">
	<input type="submit" name = "Tinh" value="-">
	<input type="submit" name = "Tinh" value="*">
	<input type="submit" name = "Tinh" value="/"><br/>
	</form>
	<% if(request.getAttribute("ketQua") != null){
	int ketQua = (int) request.getAttribute("ketQua");
	out.print("Ket qua = " + ketQua);
	
	}%>
</body>
</html>