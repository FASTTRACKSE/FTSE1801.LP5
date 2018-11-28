<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ptb2Servlet" method="post" >
		Số a:<input id="soA" type="text" name="soA" value=""/><br/>
		Số b:<input id="soB" type="text" name="soB" value=""/><br/>
		Số c:<input id="soC" type="text" name="soC" value=""/>
		<input class="giai" onclick="click" type="submit" name="giai" value="Giải">
	</form>
	<%
	if(request.getAttribute("ketQua") != null) {
		String ketQua = (String) request.getAttribute("ketQua");
		out.print(ketQua);
	}
	%>
</body>
</html>