<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giải Phương Trình Bậc 2</title>
</head>
<body>
	<c:choose>
		<c:when test="${soA == 0}">
			<c:out value="Đây Phương Trình Bậc Nhất"></c:out>
			<br/>
			<c:choose>
				<c:when test="${soB == 0}">
					<c:choose>
						<c:when test="${soC == 0}">
							<c:out value="Phương Trình Vô Số Nghiệm"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="Phương Trình Vô Nghiệm"></c:out>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:set var="PT1" value="${-soC/soB}" />
					<c:out value="${PT1}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:out value="Phương Trình Bậc 2"></c:out>
			<br/>
			<c:set var="delta" value="${Math.pow(soB,2)-4*soA*soC}" />
			<c:set var="can" value="${Math.sqrt(delta)}" />
			<c:choose>
				<c:when test="${delta<0}">
					<c:out value="Phương Trình Vô Số Nghiêm"></c:out>
				</c:when>
				<c:when test="${delta==0}">
					<c:set var="Kep" value="${-soB/(2*soA)}" />
					<c:out value="Phương Trình Có Nghiêm Kép:${Kep}"></c:out>
				</c:when>
				<c:otherwise>
					<c:set var="Nghiem1" value="${(-soB + can)/2}" />
					<c:set var="Nghiem2" value="${(-soB- can)/2}" />
					<c:out
						value="Phương Trình Có 2 nghiệm Phân Biệt: ${Nghiem1} và ${Nghiem2}"></c:out>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>

</body>
</html>