<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Img</title>
</head>
<body>
	<center>
        <h2>URL image: ${message}</h2>
 <img src="${images}"/>
 <h3>Upload has been done successfully!</h3>
    <a href="${pageContext.request.contextPath}/UploadImg.jsp">Continue Upload</a>
    </center>
</body>
</html>