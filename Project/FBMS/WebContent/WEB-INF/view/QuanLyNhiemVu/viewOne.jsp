<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.card-block input {
	border: 0;
	border-radius: 0;
}

.card-block .table td {
	padding-left: 0px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thông tin nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/" />'>Danh
									sách nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Thông tin nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Thông tin nhiệm vụ</h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block">
								<div class="table-responsive">
									<table class="table">
										<tr>
											<td><label>Mã nhiệm vụ</label> <input
												class="form-control" value="${quanLyNhiemVu.id}"
												placeholder="Mã nhiệm vụ" readonly /></td>
											<td><label>Dự án</label> <input
												class="form-control" value="${quanLyNhiemVu.maDuAn}"
												placeholder="Dự án" readonly /></td>
										</tr>
										<tr>
											<td><label>Loại công việc</label> <input
												class="form-control" value="${quanLyNhiemVu.idLoaiCongViec.loaiCongViec}"
												placeholder="Loại công việc" readonly /></td>
											<td><label>Tên công việc</label> <input
												class="form-control" value="${quanLyNhiemVu.tenCongViec}"
												placeholder="Tên công việc" readonly /></td>
										</tr>
										<tr>
											<td><label>Mô tả</label> <input
												class="form-control" value="${quanLyNhiemVu.moTa}"
												placeholder="Mô tả" readonly /></td>
											<td><label>Phòng ban</label> <input
												class="form-control" value="${quanLyNhiemVu.idPhongBan.tenPhongBan}"
												placeholder="Phòng Ban" readonly /></td>
										</tr>
										<tr>
											<td><label>Thời gian bắt đầu</label> <input
												class="form-control" value="${quanLyNhiemVu.thoiGianBatDau}"
												placeholder="Thời gian bắt đầu" readonly /></td>
											<td><label>Thời gian kết thúc</label> <input
												class="form-control" value="${quanLyNhiemVu.thoiGianKetThuc}"
												placeholder="Thời gian kết thúc" readonly /></td>
										</tr>
										<tr>
											<td><label>Nhân viên</label> <input
												class="form-control" value="${quanLyNhiemVu.idNhanVien.hoDem} ${quanLyNhiemVu.idNhanVien.ten}"
												placeholder="Nhân viên" readonly /></td>
											<td><label>Vai trò</label> <input
												class="form-control" value="${quanLyNhiemVu.maVaiTro}"
												placeholder="Vai trò" readonly /></td>
										</tr>
										<tr>
											<td><label>Thời gian dự kiến hoàn thành</label> <input
												class="form-control" value="${quanLyNhiemVu.thoiGianDuKienHoanThanh} Giờ"
												placeholder="Thời gian dự kiến hoàn thành" readonly /></td>
											<td><label>Trạng thái</label> <input
												class="form-control" value="${quanLyNhiemVu.idTrangThai.trangThai}"
												placeholder="Trạng thái" readonly /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />