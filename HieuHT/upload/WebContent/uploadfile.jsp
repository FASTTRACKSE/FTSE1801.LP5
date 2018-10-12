<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload file in servlet - itphutran.com</title>
</head>
<body>
	<center>
		<form method="post" action="uploadServlet"
			enctype="multipart/form-data">
			Vui lòng chọn tệp: <input type="file" name="upload" multiple> <br /> <br />
			<input type="submit" value="Upload" />
		</form>
	</center>
</body>
</html>