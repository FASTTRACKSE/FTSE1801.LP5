<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sinh viên</title>
</head>
<body>
	<h1>Thêm sinh viên</h1>
	
	<form:form modelAttribute="add" method="post" action="/demoWeb/save" enctype="multipart/form-data">
		<table >    
		<tr>
			<td><spring:message code="img"/></td>
			<td><input type="file" name="file"></td>
		</tr>
         <tr>    
          <td><spring:message code="id"/> : </td>   
          <td><form:input path="id"  /></td>  
         </tr>    
         <tr>    
          <td><spring:message code="ten"/> :</td>    
          <td><form:input path="ten" /></td>  
         </tr>   
         <tr>    
          <td><spring:message code="tuoi"/> :</td>    
          <td><form:input path="tuoi" /></td>  
         </tr> 
         <tr>    
          <td><spring:message code="diachi"/> :</td>    
          <td><form:input path="diachi" /></td>  
         </tr>
         <tr>    
          <td><spring:message code="lop"/> :</td>    
          <td><form:input path="lop" /></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="<spring:message code="them"/>" /></td>    
         </tr>    
        </table>    
	</form:form>
</body>
</html>