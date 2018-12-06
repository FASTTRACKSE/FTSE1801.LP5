<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

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
				<h3 class="content-header-title mb-0">Sửa nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/" />'>Danh sách nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Sửa nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="edit" action="">
						<form:input type="hidden" path="id" value="${edit.id}" />
						<div class="form-group col-sm-6">
							<label>Mã dự án</label>
							<%-- <form:select path="idLoaiCongViec" >
						  	 	<form:option value="none">Chọn công việc</form:option>
						  	 	<c:forEach items="${listCongViec}" var="x">
						  	 		<form:option value="${x.id}">${x.loaiCongViec}</form:option>
						  	 	</c:forEach>
						  	</form:select> --%>
							<form:input class="form-control" path="maDuAn"
								value="${edit.maDuAn}" placeholder="Mã dự án" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên công việc </label>
							<form:input class="form-control" path="tenCongViec"
								value="${edit.tenCongViec}" placeholder="Tên công việc" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:input class="form-control" path="moTa" value="${edit.moTa}"
								placeholder="Mô tả" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu</label>
							<div class='input-group date' id='datetimepicker11'>
								<form:input type='text' path="thoiGianBatDau" 
									value="${edit.thoiGianBatDau}" placeholder="Thời gian bắt đầu"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc</label>
							<div class='input-group date' id='datetimepicker10'>
								<form:input type='text' path="thoiGianKetThuc"
									value="${edit.thoiGianKetThuc}"
									placeholder="Thời gian kết thúc" class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Vai trò</label>
							<form:input class="form-control" path="maVaiTro"
								value="${edit.maVaiTro}" placeholder="Tên vai trò" />
							<%-- <form:select path="idNhanVien" >
						  	 	<form:option value="none">Chọn phòng ban</form:option>
						  	 	<c:forEach items="${listNhanVien}" var="x">
						  	 		<form:option value="${x.maNhanVien}">${x.hoDem} ${x.ten}</form:option>
						  	 	</c:forEach>
						  	</form:select>  --%>
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian dự kiến hoàn thành (Giờ)</label>
							<form:input class="form-control" path="thoiGianDuKienHoanThanh"
								value="${edit.thoiGianDuKienHoanThanh}"
								placeholder="Thời gian dự kiến hoàn thành" />
							<form:errors path="thoiGianDuKienHoanThanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Loại công việc</label>
							<form:select path="idLoaiCongViec.id">
								<c:forEach items="${listCongViec}" var="x">
									<form:option value="${x.id}">${x.loaiCongViec}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Trạng thái</label>
						  	<form:select path="idTrangThai.id" >
						  	 	<c:forEach items="${listTrangThai}" var="k">
						  	 		<form:option value="${k.id}">${k.trangThai}</form:option>
						  	 	</c:forEach>
						  	</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Phòng Ban</label>
							<form:select path="idPhongBan.maPhongBan">
								<c:forEach items="${listPhongBan}" var="y">
									<form:option value="${y.maPhongBan}">${y.tenPhongBan}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Nhân viên được phân công</label>
							<form:select path="idNhanVien.maNhanVien">
								<c:forEach items="${listNhanVien}" var="z">
									<form:option value="${z.maNhanVien}">${z.hoDem} ${z.ten}</form:option>
								</c:forEach>
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

