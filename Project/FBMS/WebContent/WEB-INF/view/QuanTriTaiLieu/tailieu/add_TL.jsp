<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới tài liệu</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriTaiLieu/tai_lieu" />'>Danh sách
									tài liệu</a></li>
							<li class="breadcrumb-item active">Thêm mới tài liệu</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="taiLieu" action="" enctype="multipart/form-data">
						<div class="form-group col-sm-6">
							<label>Mã Tài Liệu</label>
							<form:input class="form-control" path="maTaiLieu"
								placeholder="Mã tài liệu" />
							<form:errors path="maTaiLieu" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>upload</label>
						  	<input type="file" name="file" id="fileToUpload" />
						</div>
						<div class="form-group col-sm-6">
							<label>Danh mục</label>
							<form:select path="danhMucTaiLieu.maDanhMuc">
								<form:option value="0">Chọn danh mục</form:option>
								<c:forEach items="${listDM}" var="x">
									<form:option value="${x.maDanhMuc}">${x.tenDanhMuc}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="danhMucTaiLieu" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Icon</label>
							<form:select path="iconTaiLieu.maIcon">
								<form:option value="0">Chọn Icon</form:option>
								<c:forEach items="${listIC}" var="x">
									<form:option value="${x.maIcon}">${x.tenIcon}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="iconTaiLieu" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Phòng Ban</label>
							<form:select path="phongBan.maPhongBan">
								<form:option value="0">Chọn phòng ban</form:option>
								<c:forEach items="${listPB}" var="x">
									<form:option value="${x.maPhongBan}">${x.tenPhongBan}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="phongBan" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả tài liệu</label>
							<form:input class="form-control" path="moTaTaiLieu"
								placeholder="Mô tả tài liệu" />
							<form:errors path="moTaTaiLieu" cssClass="error" />
						</div>

						<div class="form-group col-sm-6">
							<label>Trạng Thái</label>
							<form:select path="trangThaiTaiLieu.maTrangThai">
								<form:option value="0">Chọn trạng thái</form:option>
								<c:forEach items="${listTT}" var="y">
									<form:option value="${y.maTrangThai}">${y.tenTrangThai}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="trangThaiTaiLieu" cssClass="error" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />


