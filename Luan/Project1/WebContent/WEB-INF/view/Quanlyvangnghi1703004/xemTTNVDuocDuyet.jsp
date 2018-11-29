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
						<a href='<c:url value="/Quanlyvangnghi1703004/danhsachduyet" />'><i
							class="icon-arrow-left"></i></a>
					</h1>
				</div>
				<h3 class="content-header-title mb-0">
					<spring:message code="label.thongTinCaNhan" />
				</h3>
			</div>

			<div class="continer">
				<br> <label><spring:message code="label.madon" /></label> <input
					class="form-control" value="${list.id}" readonly /> <label><spring:message
						code="label.maNhanVien" /></label> <input class="form-control"
					value="${list.ngayNghi.maNhanVien}" readonly /> <label><spring:message
						code="label.hoTen" /></label> <input class="form-control"
					value="${list.tenNhanVien}" readonly /> <label><spring:message
						code="label.phongBan" /></label> <input class="form-control"
					value="${list.maPhongBan}" readonly /> <label><spring:message
						code="label.ngaybatdau" /></label> <input class="form-control"
					value="${list.ngayBatDau}" readonly /> <label><spring:message
						code="label.ngayketthuc" /></label> <input class="form-control"
					value="${list.ngayKetThuc}" readonly /> <label><spring:message
						code="label.songaynghi" /></label> <input class="form-control"
					value="${list.soNgayNghi}" readonly /> <label><spring:message
						code="label.lydo" /></label> <input class="form-control"
					value="${list.lyDo.lyDo}" readonly /> <label><spring:message
						code="label.ghichunhanvien" /></label> <input class="form-control"
					value="${list.ghiChu}" readonly /> <label><spring:message
						code="label.trangThai" /></label> <input class="form-control"
					value="${list.trangThai.trangThai}" readonly />

			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
