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
				<h3 class="content-header-title mb-0">Thêm mới chứng chỉ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/hoSoNhanVien/" />'>Danh
									sách chứng chỉ</a></li>
							<li class="breadcrumb-item active">Thêm mới chứng chỉ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="chungChi" action="">
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien.maNhanVien"
								placeholder="Mã nhân viên" />
							<form:errors path="maNhanVien.maNhanVien" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên chứng chỉ</label>
							<form:input class="form-control" path="tenChungChi"
								placeholder="Tên chứng chỉ" />
							<form:errors path="tenChungChi" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Đơn vị cấp</label>
							<form:input class="form-control" path="donViCap"
								placeholder="Đơn vị cấp" />
							<form:errors path="donViCap" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày cấp</label>
							<div class='input-group date datetimepicker10'>
								<form:input type='text' path="ngayCap" placeholder="Ngày cấp"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="ngayCap" cssClass="error" />
							</div>
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
