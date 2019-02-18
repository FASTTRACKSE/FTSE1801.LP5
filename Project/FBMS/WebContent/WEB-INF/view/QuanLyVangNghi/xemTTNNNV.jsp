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
						<a href='<c:url value="/QuanLyVangNghi/danhsachngaynghi" />'><i
							class="icon-arrow-left"></i></a>
					</h1>
				</div>
				<h3 class="content-header-title mb-0">Thông Tin Cá Nhân</h3>
			</div>

			<div class="continer">
				<br> <label>Mã Nhân Viên</label> <input class="form-control"
					value="${list.maNhanVien}" readonly /> <label>Họ Và Tên<input
					class="form-control" value="${list.tenNhanVien}" readonly /> <label>Số
						Ngày Đã Nghỉ</label> <input class="form-control"
					value="${list.soNgayDaNghi}" readonly /> <label>Số Ngày
						Còn Lại</label> <input class="form-control" value="${list.soNgayConLai}"
					readonly />
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
