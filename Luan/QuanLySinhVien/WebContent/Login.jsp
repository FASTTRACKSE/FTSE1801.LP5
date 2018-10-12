<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="http://taihinhnendoc.com/wp-content/uploads/2016/09/hinh-nen-kinh-di.jpg">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	color: white;
    text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("http://4.bp.blogspot.com/-rVrO_bUgK1g/Uqgoo8w11_I/AAAAAAAABuo/_Lpguxs3Vls/s1600/hinh-nen-may-tinh-hd-7.jpg");
	}
* {box-sizing: border-box;}
body:hover{
 background-image: url("https://thuthuattienich.com/wp-content/uploads/2013/12/hinh-nen-may-tinh-hd.jpg");
 }
.input-container {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    width: 30%;
    margin-bottom: 15px;
}

.icon {
    padding: 10px;
    background: dodgerblue;
    color: white;
    min-width: 50px;
    text-align: center;
}

.input-field {
    width: 100%;
    padding: 10px;
    outline: none;
}

.input-field:focus {
    border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
    background-image: linear-gradient(to top, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red);
    color: white;
    padding: 15px 20px;
    border: none;
    cursor: pointer;
    width: 30%;
    opacity: 0.9;
}

.btn:hover {

    background-image: linear-gradient(to top right, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red, violet, gray , blue, green, yellow, orange, red);
    
}
</s</style>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
	<fmt:setLocale value="${lang}"/>
	<fmt:setBundle basename="resources.language" />
	
	<center>
	<h1><fmt:message key="dangNhap"/></h1><br>
	<form action="LoginServlet" method="post">
			<div class="input-container">
		    <i class="fa fa-user icon"></i>
	    <input class="input-field" type="text" placeholder="<fmt:message key="tk"/>" name="id">
	 	</div>
	 	
		
		<div class="input-container">
		    <i class="fa fa-key icon"></i>
		    <input class="input-field" type="password" placeholder="<fmt:message key="mk"/>" name="pass">
		</div>
		<input class="btn" type="submit" name="chon" value="login">
		<c:if test="${thatbai != null}">
			<h5 style="color: red;"><fmt:message key="thatbai"/></h5>
		</c:if>
		
	</form>
	</center>
</body>
</html>