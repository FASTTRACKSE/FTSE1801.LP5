<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/daterange/daterangepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/datetime/bootstrap-datetimepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/pickadate/pickadate.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/pickers/daterange/daterange.css"/>">


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.QuanLyNhiemVu.ThemMoiNhiemVu" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/" />'><spring:message
										code="label.QuanLyNhiemVu.DanhSachNhiemVu" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.QuanLyNhiemVu.ThemMoiNhiemVu" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="nhiemVu" action="">
						<div class="form-group col-sm-6">
							<label><spring:message code="database.QuanLyNhiemVu.DuAn" /></label>
							<%-- <form:select path="idLoaiCongViec" >
						  	 	<form:option value="none">Chọn công việc</form:option>
						  	 	<c:forEach items="${listCongViec}" var="x">
						  	 		<form:option value="${x.id}">${x.loaiCongViec}</form:option>
						  	 	</c:forEach>
						  	</form:select> --%>
							<form:input class="form-control" path="maDuAn"
								placeholder="Mã dự án" />
							<form:errors path="maDuAn" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.LoaiCongViec" /></label>
							<form:select path="idLoaiCongViec.id">
								<form:option value="0">
									<spring:message
										code="database.QuanLyNhiemVu.LoaiCongViec.ChonCongViec" />
								</form:option>
								<c:forEach items="${listCongViec}" var="x">
									<form:option value="${x.id}">${x.loaiCongViec}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="idLoaiCongViec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.TenCongViec" /></label>
							<form:input class="form-control" path="tenCongViec"
								placeholder="Tên công việc" />
							<form:errors path="tenCongViec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="database.QuanLyNhiemVu.MoTa" /></label>
							<form:input class="form-control" path="moTa" placeholder="Mô tả" />
							<form:errors path="moTa" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.ThoiGianBatDau" /></label>
							<div class='input-group date' id='datetimepicker11'>
								<form:input type='text' path="thoiGianBatDau"
									class="form-control" placeholder="Thời gian bắt đầu" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="thoiGianBatDau" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.ThoiGianKetThuc" /></label>
							<div class='input-group date' id='datetimepicker10'>
								<form:input type='text' path="thoiGianKetThuc"
									class="form-control" placeholder="Thời gian kết thúc" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="thoiGianKetThuc" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.PhongBan" /></label>
							<form:select path="idPhongBan.maPhongBan">
								<form:option value="0">Chọn phòng ban</form:option>
								<c:forEach items="${listPhongBan}" var="y">
									<form:option value="${y.maPhongBan}">${y.tenPhongBan}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="idPhongBan" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.NhanVien" /></label>
							<form:select path="idNhanVien.maNhanVien">
								<form:option value="0">Chọn nhân viên</form:option>
								<c:forEach items="${listNhanVien}" var="z">
									<form:option value="${z.maNhanVien}">${z.hoDem} ${z.ten}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="idNhanVien" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.VaiTro" /></label>
							<form:input class="form-control" path="maVaiTro"
								placeholder="Tên vai trò" />
							<%-- <form:select path="idNhanVien" >
						  	 	<form:option value="none">Chọn phòng ban</form:option>
						  	 	<c:forEach items="${listNhanVien}" var="x">
						  	 		<form:option value="${x.maNhanVien}">${x.hoDem} ${x.ten}</form:option>
						  	 	</c:forEach>
						  	</form:select>  --%>
							<form:errors path="maVaiTro" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.ThoiGianDuKienHoanThanh" /> (Giờ)</label>
							<form:input class="form-control" path="thoiGianDuKienHoanThanh"
								placeholder="Thời gian dự kiến hoàn thành" />
							<form:errors path="thoiGianDuKienHoanThanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="database.QuanLyNhiemVu.TrangThai" /></label>
							<form:select path="idTrangThai.id">
								<form:option value="0">Chọn trạng thái</form:option>
								<c:forEach items="${listTrangThai}" var="k">
									<form:option value="${k.id}">${k.trangThai}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="idTrangThai" cssClass="error" />
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

<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.date.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.time.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/legacy.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/daterange/daterangepicker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/scripts/pickers/dateTime/picker-date-time.js"/> "></script>
