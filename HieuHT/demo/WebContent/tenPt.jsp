<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phương Trình Bậc Nhất</title>
</head>
<body>
	<form action="PTbac1" method="post">
		Nhập a: <input type="text" name="a">
		Nhập b: <input type="text" name="b">
		Nhập c: <input type="text" name="c">
		<input type="submit" name="giaiPT" value="Giải">
	</form>
	<c:choose>
		<c:when test="${a==0}">
			<c:when test="${b==0}">
				<c:when test="${c==0}">
					<%
						request.getAttribute("Phương trình vô số nghiệm");
					%>
				</c:when>
			</c:when>

		</c:when>
	</c:choose>
</body>
</html>