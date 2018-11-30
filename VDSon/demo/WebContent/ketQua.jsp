<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kết quả</title>
</head>
<body>
	<c:choose>
		<c:when test="${a==0}">
			<c:choose>
				<c:when test="${b==0 and c==0}">
					<c:set var="vosonghiem" value="Phương trình vô số nghiệm"></c:set>
				kết quả: <c:out value="${vosonghiem}"></c:out>
				</c:when>
				<c:when test="${b==0 and c!=0}">
					<c:set var="vonghiem" value="Phương trình vô nghiệm"></c:set>
				kết quả: <c:out value="${vonghiem}"></c:out>
				</c:when>
				<c:otherwise>
					<c:set var="conghiem" value="Phương trình có 1 nghiệm ${-c/b}"></c:set>
				kết quả: <c:out value="${conghiem}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${dt lt 0}">
			<c:set var="dtvonghiem" value="Phương trình vô nghiệm"></c:set>
					kết quả: <c:out value="${dtvonghiem}"></c:out>
		</c:when>
		<c:when test="${dt eq 0 }">
			<c:set var="nghiemkep" value="Phương trình có nghiệm kép ${-b/2*a}"></c:set>
			<c:out value="${nghiemkep}"></c:out>
		</c:when>
		<c:otherwise>
			<c:set var="nghiem1" value="x1 = ${-b + Math.sqrt(dt)/2*a }"></c:set>
			<c:set var="nghiem2" value="x2 = ${-b - Math.sqrt(dt)/2*a}"></c:set>
			kết quả: <c:out value="${nghiem1}"></c:out>
			<br/>
				và <c:out value="${nghiem2}"></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>