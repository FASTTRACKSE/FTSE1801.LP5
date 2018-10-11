<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Máy tính siêu cấp</h1>
	<form action="mayTinhServlet" method="post">
		Số a:<input type="text" name="soA"/><br/>
		Số b:<input type="text" name="soB"/></br></br>
		<input type="submit" name= "phepTinh" value="+">
		<input type="submit" name= "phepTinh" value="-">
		<input type="submit" name= "phepTinh" value="*">
		<input type="submit" name= "phepTinh" value="/">
	</form>
	<%
	if(request.getAttribute("ketQua") != null) {
		int ketQua = (int) request.getAttribute("ketQua");
		out.print("Ket qua = " + ketQua);
	}
	%>
</body>
</html>