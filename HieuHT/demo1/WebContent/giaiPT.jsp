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
		Nhập a: <input type="text" name="a"> Nhập b: <input
			type="text" name="b"> Nhập c: <input type="text" name="c">
		<input type="submit" name="giaiPT" value="Giải">
	</form>
	
	<c:choose>

		<c:when test="${soA==0}">
			<c:choose>
				<c:when test="${soB==0}">
					<c:choose>
						<c:when test="${soC==0}">
							<c:out value="Phương trình vô số nghiệm"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="Phương trình vô nghiệm"></c:out>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:out value="Phương trình có nghiệm ${-soC/soB}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>

			<c:set var="denta" value="${Math.pow(soB, 2) - 4 * soA * soC}" />
			<c:set var="canbac" value="${Math.sqrt(denta)}" />
			<c:choose>
				<c:when test="${denta<0}">
					<c:out value="Phương trình vô nghiệm"></c:out>
				</c:when>
				<c:when test="${denta==0}">
					<c:set var="kep" value="${-soB/(2*soA)}" />
					<c:out value="Phương trình có nghiệm kép ${kep}"></c:out>
				</c:when>
				<c:otherwise>
					<c:set var="ketqua1" value="${(-soB + canbac)/2}" />
					<c:set var="ketqua2" value="${(-soB - canbac)/2}" />
					<c:out value="Phương trình có 2 nghiệm phân biệt:${ketqua1} và ${ketqua2}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>