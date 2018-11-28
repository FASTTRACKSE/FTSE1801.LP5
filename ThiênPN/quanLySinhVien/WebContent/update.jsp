<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Language" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateServlet" method="post">
		<input type="hidden" name="maSV" value="${sinhVien.maSinhVien
  }">
		<fmt:message key="tenSV" />: <input type="text" name="tenSV"
			value="${sinhVien.tensinhVien}" /> <fmt:message key="pass" />: <input type="text"
			name="passSV" value="${sinhVien.password}" /> <fmt:message key="tuoiSV" />: <input
			type="text" name="tuoi" value="${sinhVien.tuoi}" /> <fmt:message key="monhoc" />: <input
			type="text" name="MonHoc" value="${sinhVien.diem.monHoc}" />
		<fmt:message key="diem" />: <input type="text" name="diem"
			value="${sinhVien.diem.diem}" /> <input type="submit" name="edit"
			value="<fmt:message key="sua" />" />
	</form>
	
	
</body>
</html>