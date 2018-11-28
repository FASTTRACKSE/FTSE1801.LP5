<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Van Manh Bank</title>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="i18n.language" />
</head>
<body>
		<form action="UpdateKh" method="get">
		<input type="hidden" name = "maKH" value="${KhachHang.maKH}">
		<table>
			<tr>
				<td><fmt:message key="ten"/> :</td>
				<td><input type="text" name="TenKH" value="${KhachHang.tenKH}"></td>
			</tr>
			<tr>
				<td><fmt:message key="diaChi"/> :</td>
				<td><input type="text" name="DiaChi" value="${KhachHang.diaChi}"></td>
			</tr>
			<tr>
				<td><fmt:message key="phuong"/></td>
				<td><select name="phuong">
						<c:forEach items="${phuong}" var="phuong">
							<option>${phuong}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><fmt:message key="sdt"/> :</td>
				<td><input type="text" name="SoDT" value="${KhachHang.soDT}"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="Email" value="${KhachHang.email}"></td>
			</tr>
			<tr>
				<td>CMND :</td>
				<td><input type="text" name="SoCMND" value="${KhachHang.soCMND}"></td>
			</tr>
		</table>
		<input type="submit" value="<fmt:message key="sua"/>" name="luaChon"> 
	</form>
</body>
</html>