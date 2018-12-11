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
				<h3 class="content-header-title mb-0">Sửa thông tin gia đình</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/thongTinChungChi/" />'>Danh
									sách thông tinh gia đình</a></li>
							<li class="breadcrumb-item active">Thông tin gia đình</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="giaDinh" action="">
						<form:input type="hidden" path="id" style="display:none"
							value="${giaDinh.id}" />
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien.maNhanVien"
								value="${giaDinh.maNhanVien.maNhanVien}" placeholder="Mã nhân viên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Họ Tên</label>
							<form:input class="form-control" path="hoTen"
								value="${giaDinh.hoTen}" placeholder="Họ tên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Quê quán</label>
							<form:input class="form-control" path="queQuan"
								value="${giaDinh.queQuan}" placeholder="Quê quán" />
						</div>
						<div class="form-group col-sm-6">
							<label>Năm sinh</label>
							<form:input class="form-control" path="namSinh"
								value="${giaDinh.namSinh}" placeholder="Ngày cấp" />
						</div>
						<div class="form-group col-sm-6">
							<label>Giới tính</label>
							<form:select path="gioiTinh">
								<form:option value="${nhanVien.gioiTinh}"></form:option>
						  		<form:option value="1">Nam(1)</form:option>
						  		<form:option value="2">Nữ(2)</form:option>
						  	</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Số điện thoại</label>
							<form:input class="form-control" path="soDienThoai"
								value="${giaDinh.soDienThoai}" placeholder="Số điện thoại" />
						</div>
						<div class="form-group col-sm-6">
							<label>Công việc hiện tại</label>
							<form:input class="form-control" path="congViec"
								value="${giaDinh.congViec}" placeholder="Công việc hiện tại" />
						</div>
						<div class="form-group col-sm-6">
							<label>Quan hệ</label>
							<form:input class="form-control" path="quanHe"
								value="${giaDinh.quanHe}" placeholder="Quan hệ" />
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
