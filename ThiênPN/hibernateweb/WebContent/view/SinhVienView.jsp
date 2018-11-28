<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Sinh Viên</title>
</head>
<body>
Language :
  <a href="${pageContext.request.contextPath}/SinhVienView?language=en">English</a>|
  <a href="${pageContext.request.contextPath}/SinhVienView?language=vi">Viet Nam</a>|
	<table border="2" width="70%" cellpadding="2">
		<tr>
		<th>img</th>
			<th><spring:message code="maSV" /></th>
			<th><spring:message code="tenSV" /></th>
			<th><spring:message code="pass" /></th>
			<th><spring:message code="tuoiSV" /></th>
			<th><spring:message code="monhoc" /></th>
			<th><spring:message code="diem" /></th>
			<th><spring:message code="sua" /></th>
			<th><spring:message code="xoa" /></th>
		</tr>
		<c:forEach var="SV" items="${listSV}">
			<tr>
			    <td><img src='<c:url value="/images/${SV.maSinhVien}/${SV.img}"/>' / style="width: 20px" height="20px"></td>
				<td>${SV.maSinhVien}</td>
				<td>${SV.tensinhVien}</td>
				<td>${SV.password}</td>
				<td>${SV.tuoi}</td>
				<td>${SV.diem.monHoc}</td>
				<td>${SV.diem.diem}</td>
				<c:url var="editSV" value="/editsv/${SV.maSinhVien}" ></c:url>
				<c:url var="deleteSV" value="/deletesv/${SV.maSinhVien}"></c:url>
				<td><a href="${editSV}"><spring:message code="sua" /></a></td>
				<td><a href="${deleteSV}"><spring:message code="xoa" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	 
</body>
</html>