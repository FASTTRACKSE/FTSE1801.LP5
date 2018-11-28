<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">

	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa Danh Mục</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/TranDuc-QuanLyTaiLieu/DanhMuc/" />'>Danh
									sách Danh Mục</a></li>
							<li class="breadcrumb-item active">Sửa Danh Mục</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="DanhMuc" action="">
						<div class="form-group col-sm-6">
							<label>Mã Danh Mục</label>
							<input  class="form-control" value="${DanhMuc.maDM}" readonly />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên Danh Mục</label>
							<form:input class="form-control" path="tenDM"
								value="${DanhMuc.tenDM}" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>