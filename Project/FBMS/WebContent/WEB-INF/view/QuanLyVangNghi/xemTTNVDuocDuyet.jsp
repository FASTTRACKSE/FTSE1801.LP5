<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div>
				<div class="col-md-5">
					<h1>
						<a href='<c:url value="/QuanLyVangNghi/danhsachduyet" />'><i
							class="icon-arrow-left"></i></a>
					</h1>
				</div>
				<h3 class="content-header-title mb-0">Thông tin cá nhân</h3>
			</div>

			<div class="continer">
				<br>Mã đơn</label> <input class="form-control" value="${list.id}"
					readonly /> <label>Mã nhân viên</label> <input
					class="form-control" value="${list.ngayNghi.maNhanVien}" readonly />
				<label>Họ và tên</label> <input class="form-control"
					value="${list.tenNhanVien}" readonly /> <label>Phòng ban</label> <input
					class="form-control" value="${list.maPhongBan}" readonly /> <label>Ngày
					bắt đầu</label> <input class="form-control" value="${list.ngayBatDau}"
					readonly /> <label>Ngày kết thúc</label> <input
					class="form-control" value="${list.ngayKetThuc}" readonly /> <label>Số
					ngày nghỉ</label> <input class="form-control" value="${list.soNgayNghi}"
					readonly /> <label>Lý do</label> <input class="form-control"
					value="${list.lyDo.lyDo}" readonly /> <label>Ghi chú</label> <input
					class="form-control" value="${list.ghiChu}" readonly /> <label>Trạng
					thái</label> <input class="form-control"
					value="${list.trangThai.trangThai}" readonly />

			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
