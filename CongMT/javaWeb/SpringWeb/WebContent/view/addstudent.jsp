<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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

</style>
</head>
<body>
	
        <h1>Add New Employee</h1> 
        <c:url var="add" value="/savefile"></c:url> 
       <form:form method="post" modelAttribute="addstudent" action="${add}" enctype="multipart/form-data">    
        <table > 
         <tr>    
          <td>Id : </td>   
          <td><form:input path="id" /></td>  
         </tr>     
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Old :</td>    
          <td><form:input path="old" /></td>  
         </tr>   
         <tr>    
          <td>Adress :</td>    
          <td><form:input path="adress" /></td>  
         </tr>   
         <tr>    
          <td>PhoneNumber :</td>    
          <td><form:input path="numberPhone" /></td>  
         </tr>   
         <tr>   
      	 <td>Select File:</td> 
		 <td><input type="file" name="file"/></td>  
		</tr>
		<tr>
          
          <td><input type="submit" value="Add" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>