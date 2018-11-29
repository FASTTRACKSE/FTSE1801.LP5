<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Van Manh Bank</title>
<link rel="icon" type="image/png"
	href="http://aux.iconspalace.com/uploads/13079831461297786048.png">
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="i18n.language" />
<style type="text/css">
body {
	background-image:
		url("https://wallpaper-house.com/data/out/10/wallpaper2you_375401.jpg");
	text-align: center;
}

table, tr, th, td {
	border: solid 1px;
	border-collapse: collapse;
	color: black;
	margin-left: 40%;
}

.a {
	color: white;
}

.b {
	color: green;
	text-decoration: none;
}

.b:hover {
	color: blue;
	text-decoration: underline;
}
</style>
</head>
<body>
	<marquee>
		<h:Demo greeting="Hello" name="${userName}" />
	</marquee>
	<form action="UpdateKh" method="get">
		<input type="hidden" name="maKH" value="${KhachHang.maKH}">
		<table>
			<tr>
				<td class="a"><fmt:message key="ten" /> :</td>
				<td><input type="text" name="TenKH" value="${KhachHang.tenKH}"></td>
			</tr>
			<tr>
				<td class="a"><fmt:message key="diaChi" /> :</td>
				<td><input type="text" name="DiaChi"
					value="${KhachHang.diaChi}"></td>
			</tr>
			<tr>
				<td class="a"><fmt:message key="phuong" /></td>
				<td><select name="phuong">
						<c:set var="i" value="36"></c:set>
						<c:forEach items="${phuong}" var="phuong">
							<option value="${i}">${phuong}</option>
							<c:set var="i" value="${i+1}"></c:set>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="a"><fmt:message key="sdt" /> :</td>
				<td><input type="text" name="SoDT" value="${KhachHang.soDT}"></td>
			</tr>
			<tr>
				<td class="a">Email :</td>
				<td><input type="text" name="Email" value="${KhachHang.email}"></td>
			</tr>
			<tr>
				<td class="a">CMND :</td>
				<td><input type="text" name="SoCMND"
					value="${KhachHang.soCMND}"></td>
			</tr>
		</table>
		<input type="submit" value="<fmt:message key="sua"/>" name="luaChon">
	</form>
	<a class="b" href="KhachHangServlet">Back to list</a>
	<br />
	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/oFy1ojw11JI" frameborder="0"></iframe>
	<iframe
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.63952575396!2d108.2342473142323!3d16.08418508887166!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142182015cbea73%3A0x169cc952ebb2a176!2zMjQgQW4gSOG6o2kgNiwgQW4gSOG6o2kgQuG6r2MsIFPGoW4gVHLDoCwgxJDDoCBO4bq1bmcgNTUwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1538122201615"
		width="560" height="315" frameborder="0" style="border: 0"></iframe>
</body>
</html>