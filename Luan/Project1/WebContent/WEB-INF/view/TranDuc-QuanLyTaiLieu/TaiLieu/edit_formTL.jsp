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
					<h3 class="content-header-title mb-0">Sửa Tài Liệu</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item"><a
									href='<c:url value="/TranDuc-QuanLyTaiLieu/TaiLieu/" />'>Danh
										sách Tài Liệu</a></li>
								<li class="breadcrumb-item active">Sửa Tài Liệu</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->
			<div class="content-body">
				<div class="main-content">
					<div class="row">
						<form:form method="POST" modelAttribute="TaiLieu" enctype="multipart/form-data" action="">
							<div class="form-group col-sm-6">
								<label>ID Tài Liệu</label>
								<input class="form-control" value="${TaiLieu.idTL}" readonly />
							</div>
							<div class="form-group col-sm-6">
								<label>Mã Tài Liệu</label>
								<form:input class="form-control" path="maTL"
									value="${item.maTL}" />
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicSelect">Danh Mục</label>
									<form:select cssClass="form-control" path="danhMuc.maDM">
										<option title="DanhMuc"></option>
										<c:forEach var="item" items="${listDanhMuc}" begin="0">
											<form:option value="${item.maDM}" label="${item.tenDM}"></form:option>
										</c:forEach>
									</form:select>
								</fieldset>
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicSelect">Phòng Ban</label>
									<form:select cssClass="form-control" path="phongBan.maPhongBan">
										<option></option>
										<c:forEach var="item" items="${listPhongBan}" begin="0"
											varStatus="counter">
											<form:option value="${item.maPhongBan }"
												label="${item.tenPhongBan }"></form:option>
										</c:forEach>
									</form:select>
								</fieldset>
							</div>
							<div class="form-group col-sm-6">
								<label>Mô Tả Tài Liệu</label>
								<form:input class="form-control" path="motaTL"
									placeholder="Mô Tả Tài Liệu" />
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicSelect">Trạng Thái</label>
									<form:select cssClass="form-control" path="trangThai.maTT">
										<option></option>
										<c:forEach var="item" items="${TrangThai}" begin="0"
											varStatus="counter">
											<form:option value="${item.maTT }" label="${item.tenTT }"></form:option>
										</c:forEach>
									</form:select>
								</fieldset>
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicInputFile">Tài Liệu</label>
									<form:hidden path="link" />
									<input type="file" class="form-control-file"
										id="basicInputFile" name="file">
								</fieldset>
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