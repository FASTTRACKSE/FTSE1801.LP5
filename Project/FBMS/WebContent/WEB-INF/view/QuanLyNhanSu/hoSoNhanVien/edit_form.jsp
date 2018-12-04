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
				<h3 class="content-header-title mb-0">Sửa hồ sơ nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/hoSoNhanVien/" />'>Danh
									sách nhân viên</a></li>
							<li class="breadcrumb-item active">Sửa hồ sơ nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="nhanVien" action="">
						<form:input type="hidden" path="maNhanVien" style="display:none"
							value="${nhanVien.maNhanVien}" />
						<div class="form-group col-sm-6">
							<label>Mã phòng Ban</label>
							<form:input class="form-control" path="maPhongBan.maPhongBan"
								value="${nhanVien.maPhongBan.maPhongBan}" placeholder="Mã phòng ban" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã chức danh</label>
							<form:input class="form-control" path="maChucDanh.maChucDanh"
								value="${nhanVien.maChucDanh.maChucDanh}" placeholder="Mã chức danh" />
						</div>
						<div class="form-group col-sm-6">
							<label>Họ đệm</label>
							<form:input class="form-control" path="hoDem"
								value="${nhanVien.hoDem}" placeholder="Họ đệm" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên</label>
							<form:input class="form-control" path="ten"
								value="${nhanVien.ten}" placeholder="Tên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ảnh đại diện</label>
							<form:input class="form-control" path="avatar"
								value="${nhanVien.avatar}" placeholder="Ảnh đại diện" />
						</div>
						<div class="form-group col-sm-6">
							<label>Năm sinh</label>
							<form:input class="form-control" path="namSinh"
								value="${nhanVien.namSinh}" placeholder="Năm sinh" />
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
							<label>Tình trạng hôn nhân</label>
							<form:select path="tinhTrangHonNhan">
								<form:option value="${nhanVien.tinhTrangHonNhan}"></form:option>
						  		<form:option value="1">Độc thân(1)</form:option>
						  		<form:option value="2">Đã kết hôn(2)</form:option>
						  		<form:option value="3">Đã ly hôn(3)</form:option>
						  	</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Quê quán</label>
							<form:input class="form-control" path="queQuan"
								value="${nhanVien.queQuan}" placeholder="Quê quán" />
						</div>
						<div class="form-group col-sm-6">
							<label>Dân tộc</label>
							<form:input class="form-control" path="danToc"
								value="${nhanVien.danToc}" placeholder="Dân tộc" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi tạm trú</label>
							<form:input class="form-control" path="noiTamTru"
								value="${nhanVien.noiTamTru}" placeholder="Nơi tạm trú" />
						</div>
						<div class="form-group col-sm-6">
							<label>Số điện thoại</label>
							<form:input class="form-control" path="soDienThoai"
								value="${nhanVien.soDienThoai}" placeholder="Số điện thoại" />
						</div>
						<div class="form-group col-sm-6">
							<label>Email</label>
							<form:input class="form-control" path="email"
								value="${nhanVien.email}" placeholder="Email" />
						</div>
						<div class="form-group col-sm-6">
							<label>Số CMND</label>
							<form:input class="form-control" path="soCMND"
								value="${nhanVien.soCMND}" placeholder="Số CMND" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi cấp</label>
							<form:input class="form-control" path="noiCap"
								value="${nhanVien.noiCap}" placeholder="Nơi cấp" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày cấp</label>
							<form:input class="form-control" path="ngayCap"
								value="${nhanVien.ngayCap}" placeholder="Ngày cấp" />
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							
							<form:select path="trangThai">
								<form:option value="${nhanVien.trangThai}"></form:option>
						  		<form:option value="1">Đang làm việc</form:option>
						  		<form:option value="2">Đã nghỉ</form:option>
						  	</form:select>
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
