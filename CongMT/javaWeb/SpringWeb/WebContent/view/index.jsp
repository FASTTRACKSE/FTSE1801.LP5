<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, th, td {
	border: 1px solid blue;
	border-collapse: collapse;
}

a {
	color: black;
	text-decoration: none;
}
a:hover {
	color: blue;
}
body{
 background-color: lightblue;
           
}
</style>
</head>
<body>
	<div class="lang">
			<p><spring:message code="NgonNgu"/> :</p>
			<ul>
				<li> <a href="?lang=vi" >Viet Nam</a></li>
				<li> <a href="?lang=en" >English</a></li>
			</ul>
			<div class="clr"></div>
		</div>
<center>
<h1><spring:message code="TieuDe1" text="List Student" /></h1><br/>
		<c:url var="add" value="/addstudent"></c:url>
	 <a href="${add}"><spring:message code="Them"/></a> <br/>
	 <table style="width: 70%" class="container">
	
			<tr>
				<th style="text-align: center;" colspan="7"><spring:message code="TieuDe1"  /></th>
			</tr>
			<tr>
				<th style="text-align: center;"><spring:message code="id" /></th>
				<th style="text-align: center;"><spring:message code="TenDangNhap"/></th>
				<th style="text-align: center;"><spring:message code="Tuoi"  /></th>
				<th style="text-align: center;"><spring:message code="DiaChi"  /></th>
				<th style="text-align: center;"><spring:message code="Sdt" /></th>
				<th style="text-align: center;"><spring:message code="HinhAnh" /></th>
				<th style="text-align: center;"><spring:message code="ChucNang" /></th>
				
			</tr>
			<c:forEach items="${list}" var="sv">
				<tr>
					<td style="text-align: center;">${sv.id}</td>
					<td style="text-align: center;">${sv.name}</td>
					<td style="text-align: center;">${sv.old}</td>
					<td style="text-align: center;">${sv.adress}</td>
					<td style="text-align: center;">${sv.numberPhone}</td>
					<c:url value="/anh/${sv.id}/${sv.img}" var="img"> </c:url>
					<td style="text-align: center;"><img style="height: 50px; width: 50px;" src="${img}"/></td>
	
					<c:url var="edit" value="/editstudent/${sv.id}"></c:url>
					<c:url var="delete" value="/deletestudent/${sv.id}"></c:url>
					  <td><a href="${edit}"><spring:message code="Sua" text="Edit" /></a>  
   						---<a href="${delete}"><spring:message code="Xoa" text="Delete" /></a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	
		<c:if test="${page ne 1}">
			<c:url value="/index" var="first" />
			<c:url value="/index/${page-1}" var="back" />
			<a href="${first}">First</a>
			<a href="${back}">Previous</a>
		</c:if>
		<c:forEach begin="1" end="${total}" var="i">
			<c:choose>
				<c:when test="${size eq i}">
					<c:url value="/index" var="alone" />
					<a href="${alone}">${i}</a>
				</c:when>
				<c:otherwise>
					<c:url var="abc" value="/index/${i}"></c:url>
					<a href="${abc}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${page lt total}">
			<c:url value="/index/${page + 1}" var="next"/>
			<c:url value="/index/${total}" var="end"/>
			<a href="${next}">Next</a>
			<a href="${end}">Last</a>
		</c:if>
		

  	</center>	
</body>
</html>