<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">View Thông Tin Hợp Đồng</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${hsnv.maNv}" />'>Thông
							Tin Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${hsnv.maNv}" />'>Hợp
							Đồng Nhân Viên</a></li>
					<li class="breadcrumb-item active">View Hợp Đồng</li>
				</ol>
			</div>
		</div>
		<form:form class="form" method="GET" modelAttribute="hopDong"
			action="">
			<div class="form-body">
				<div class="form-section"></div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Mã Nhân Viên</label> <input class="form-control"
								value="${hsnv.maNv }" disabled type="text" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Trạng Thái</label>
							<div class="form-control disabled">${hsnv.isActive}</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Phòng ban</label>
							<div class="form-control well">${hsnv.maPhongBan.tenPhongBan}</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Chức danh</label>
							<div class="form-control well">${hsnv.maChucDanh.tenChucDanh}</div>
						</div>
					</div>
				</div>
				<h4 class="form-section">
					<i class="ft-user"></i> Thông Tin Hợp Đồng
				</h4>
				<div class="row">
					<div class="col-md-4">
						<label>Mã hợp đồng</label>
						<div class="form-control well">${hopDong.maHopDong}</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Tên hợp đồng</label>
							<div class="form-control well">${hopDong.loaiHopDongPikalong.tenHopDong}</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Trạng thái</label>
							<div class="form-control well">${hopDong.trangThai == 1 ? 'Hết hợp đồng' : 'Còn hợp đồng'}</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Lương tháng 13</label>
							<div class="form-control well">${hopDong.luongThang13 == 1 ? 'Có' : 'Không'}</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Số ngày nghỉ trong năm</label>
							<div class="form-control well">${hopDong.soNgayNghiTrongNam}</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Ngày ký hợp đồng</label>
							<div class="form-control well">${hopDong.ngayKiKet}</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Ngày kết thúc hợp đồng</label>
							<div class="form-control well">${hopDong.ngayKetThuc}</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions center">
			<a
					href="/ffse-fbms/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${hsnv.maNv}">
					<button type="button"
						class="btn btn-warning btn-min-width mr-1 mb-1">
						<i class="ft-x"></i> Trở vê
					</button>
				</a>
</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
