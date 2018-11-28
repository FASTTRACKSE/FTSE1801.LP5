<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="giaiPhuongTrinhBac2" method="post">
 Hệ Số a: <input type="text" name = "a" /><br/>
 Hệ Số b: <input type="text" name = "b" /><br/>
 Hệ Số c: <input type="text" name = "c" /><br/>
 <input type = "submit" name = "Giai" value="Giải"/>
 </form>
   <form action="LoginServlet" method="post">
 USERNAME: <input type="text" name = "user" /><br/>
 PASSWORD: <input type="text" name = "pass" /><br/>
 
 <input type = "submit" name = "Giai" value="Login"/>
 
 
 </form>
</body>
</html>