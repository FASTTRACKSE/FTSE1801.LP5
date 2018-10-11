<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
	a:hover{
		color: red;
	}
	
	table {
		border-collapse: collapse;
	}
	
	table, tr, td, th {
		border: 1px solid black;
	}
	
	.mau1{
		background-color: #fbfbf9;
	}
	
	.mau2{
		background-color: while;
	}
	
	.mau3{
		background-color: #bebebe;
	}
</style>
</head>
<body>
	<table style="width: 100%">
		<tr class="mau3">
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
		</tr>
		<c:set var="x" value="1"></c:set>
		<c:forEach items="${list}" var="element">
			<c:choose>
				<c:when test="${x%2 ==0 }">
					<tr class="mau1">
						<td>${element.id}</td>
						<td>${element.name}</td>
						<td>${element.type}</td>
					</tr>
					<c:set var="x" value="${x+1 }"></c:set>
				</c:when>
				<c:otherwise>
					<tr class="mau2">
						<td>${element.id}</td>
						<td>${element.name}</td>
						<td>${element.type}</td>
					</tr>
					<c:set var="x" value="${x+1 }"></c:set>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
	</table><br>
	
	
	<table cellpadding="5" cellspacing="5">
		<c:choose>
			<c:when test="${soTrang<3 }">
				<c:forEach var="i" begin="1" end="${soTrang}">
					<tr>
	    				<td><a href="?page=${i}">${i}</a></td>
	    			</tr>
	    		</c:forEach>
			</c:when>
			
			<c:when test="${dong<=soTrang }">
				<tr>
					<c:if test="${(dong > 2)&& (soTrang>3)}">
						<td><a href="PagingServlet?page=1">|<</a></td>
					</c:if>
					<c:if test="${(dong ne  '1')&& (soTrang>2)}">
						<td><a href="PagingServlet?page=${dong - 1}"><</a></td>
					</c:if>
				    
				    <c:choose>
				    	<c:when test="${dong eq '1'}">
				    		<c:forEach var="i" begin="1" end="3">
				    			<td><a href="?page=${i}&?pageBegin=1&pageEnd=3">${i}</a></td>
				    		</c:forEach>
				    	</c:when>
				    	
				    	<c:when test="${dong eq soTrang}">
				    		<c:forEach var="i" begin="${soTrang-2}" end="${soTrang}">
				    			<td><a href="?page=${i}&?pageBegin=${i-2}&pageEnd=${i}">${i}</a></td>
				    		</c:forEach>
				    	</c:when>
				    	
				    	<c:when test="${dong eq pageBegin}">
				    		<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
				    			<td><a href="?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
				    		</c:forEach>
				    	</c:when>
				    	
				    	<c:when test="${dong eq pageEnd}">
				    		<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
				    			<td><a href="?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
				    		</c:forEach>
				    	</c:when>
				    	
				    	<c:otherwise>
				    		<c:forEach var="i" begin="${dong-1}" end="${dong+1}">
				    			<td><a href="?page=${i}&?pageBegin=${i-1}&pageEnd=${i+1}">${i}</a></td>
				    		</c:forEach>
				    	</c:otherwise>
				    </c:choose>
				      
				    <c:if test="${(dong ne soTrang) && (soTrang>2)}">
				    	<td><a href="PagingServlet?page=${dong+1}">></a></td>
				    </c:if>
				    <c:if test="${(dong < soTrang-1) && (soTrang>3)}">
						<td><a href="PagingServlet?page=${soTrang}">>|</a></td>
				    </c:if>
				 </tr>
			</c:when>
			<c:otherwise>
				Không có trang
			</c:otherwise>
		
		</c:choose>
	</table>
</body>
</html>