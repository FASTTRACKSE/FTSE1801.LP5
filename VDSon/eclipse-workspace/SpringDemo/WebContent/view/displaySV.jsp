<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="danhsach" /></title>
</head>
<body>
	<center>
		<h1>
			<spring:message code="danhsach" />
		</h1>
	</center>
	<center>
		<c:if test="${param.lang == 'vi' }">
			<a href="<spring:url value="/display?lang=vi"/>" style="color: red;"><spring:message
					code="vietnam" /></a>
			<a href="<spring:url value="/display?lang=en"/>"><spring:message
					code="english" /></a>
		</c:if>
		<c:if test="${param.lang != 'vi' }">
			<a href="<spring:url value="/display?lang=vi"/>"><spring:message
					code="vietnam" /></a>
			<a href="<spring:url value="/display?lang=en"/>" style="color: red;"><spring:message
					code="english" /></a>
		</c:if>
		<c:choose>
			<c:when test="${not empty list}">
				<table border="2" width="70%" cellpadding="2">
					<tr>
						<th><marquee behavior="alternate">Ảnh đại diện</marquee></th>
						<th><marquee behavior="alternate"><spring:message code="masv" /></marquee></th>
						<th><marquee behavior="alternate"><spring:message code="ten" /></marquee></th>
						<th><marquee behavior="alternate"><spring:message code="tuoi" /></marquee></th>
						<th><marquee behavior="alternate"><spring:message code="sua" /></marquee></th>
						<th><marquee behavior="alternate"><spring:message code="xoa" /></marquee></th>
					</tr>
					<c:forEach var="sv" items="${list}">
						<tr>
							<c:url var="a" value="/editSV/${sv.MASV}"></c:url>
							<c:url var="b" value="/deleteSV/${sv.MASV}"></c:url>
							<td><center>
									<a href="<c:url value="/images/${sv.MASV}/${sv.image}"/>"><img
										src="<c:url value="/images/${sv.MASV}/${sv.image}"/>"
										style="width: 80px" height="60px" /></a>
								</center></td>
							<td>${sv.MASV}</td>
							<td>${sv.NAME}</td>
							<td>${sv.AGE}</td>
							<%-- <td><a href="${a}"><spring:message code="sua" /></a></td> --%>
							<td><center><a href="${a}"><img
										src="<c:url value="/images/if_pencil_3688460.png"/>"
										style="width: 30px" height="30px"></a></center></td>
							<%-- <td><a href="${b}"><spring:message code="xoa" /></a></td> --%>
							<td><center>
									<a href="${b}"><img
										src="<c:url value="/images/if_Remove_27874.png"/>"
										style="width: 30px" height="30px"></a>
								</center></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br />Not exits list student</c:otherwise>
		</c:choose>
		<c:url var="a" value="/addSinhVien"></c:url>
		<br /> <a href="${a}"><spring:message code="themthongtin" /></a> <a
			href="uploadform">Upload Image</a>
	</center>

	<center>
		<c:if test="${page != 1}">
			<a href="/SpringDemo/display/${1}">First</a>
			<a href="/SpringDemo/display/${page-1}">Previous</a>
		</c:if>
		<br />
		<table cellpadding="5" cellspacing="5">
			<tr>
				<c:forEach begin="1" end="${total}" var="i">
					<c:choose>
						<c:when test="${size eq i}">
							<td>${i}</td>
						</c:when>
						<c:otherwise>
							<c:url var="abc" value="/display/${i}"></c:url>
							<td><a href="${abc}">${i}</a></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</table>

		<c:if test="${page lt total}">
			<a href="${page + 1}">Next</a>
			<a href="${abc}">Last</a>
		</c:if>
	</center>
</body>
</html>