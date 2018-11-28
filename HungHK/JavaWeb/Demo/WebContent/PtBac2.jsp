<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Giai phuong trinh bac 2</h3>
	<form action="PtBac2" method="get">
		Nhap a: <input type="text" name="a"><br> Nhap b: <input
			type="text" name="b"><br> Nhap c: <input type="text"
			name="c"><br> <input type="submit" name="giai"
			value="Giai phuong trinh">
	</form>
	<br>
	<br>

	<c:choose>
		<c:when test="${a==0}">
			<c:choose>
				<c:when test="${b==0}">
				<c:choose>
					<c:when test="${c==0}">
						<c:set var="bien" value="Phương trình có vô số nghiệm"></c:set>
						<c:out value="${bien}"></c:out>
					</c:when>
					<c:otherwise>
						<c:set var="bien2" value="Phương trình vô nghiệm"></c:set>
						<c:out value="${bien2}"></c:out>
					</c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
					<c:set var="bien3" value="Phương trình có 1 nghiệm x = ${c/b}"></c:set>
					<c:out value="${bien3}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${dt<0}">
					<c:set var="bien4" value="Phương trình vô nghiệm"></c:set>
					<c:out value="${bien4}"></c:out>
				</c:when>
				<c:when test="${dt==0}">
					<c:set var="bien5" value="Phương trình có nghiệm kép x1 = x2 = ${-b/(2*a)}"></c:set>
					<c:out value="${bien5}"></c:out>
				</c:when>
				<c:otherwise>
					<c:set var="bien6" value="Phương trình có 2 nghiệm"></c:set>
					<c:out value="${bien6}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>

</body>
</html>