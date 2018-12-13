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
						<a href='<c:url value="/QuanLyVangNghi/danhsachcho" />'><i
							class="icon-arrow-left"></i></a>
					</h1>
				</div>
				<h3 class="content-header-title mb-0">Thông Tin Cá Nhân</h3>
			</div>

			<div class="continer">
				<br> <label>Mã Đơn</label> <input class="form-control"
					value="${list.id}" readonly /> <label>Họ và tên</label> <input class="form-control"
					value="${list.maNhanVien}" readonly /> <label>Phòng ban</label> <input
					class="form-control" value="${list.idPhongBan.tenPhongBan}" readonly /> <label>Ngày
					Bắt Đầu</label> <input class="form-control" value="${list.ngayBatDau}"
					readonly /> <label>Ngày Kết Thúc</label> <input
					class="form-control" value="${list.ngayKetThuc}" readonly /> <label>Lý
					Do</label> <input class="form-control" value="${list.lyDo.lyDo}" readonly />
				<label>Ghi Chú</label> <input class="form-control"
					value="${list.ghiChu}" readonly /> <label>Trạng Thái</label> <input
					class="form-control" value="${list.maTrangThai.tenTrangThai}" readonly />

			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
