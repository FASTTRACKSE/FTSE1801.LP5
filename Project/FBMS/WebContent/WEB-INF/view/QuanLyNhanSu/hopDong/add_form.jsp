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
				<h3 class="content-header-title mb-0">Thêm mới hợp đồng lao
					động</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/thongTinGiaDinh/" />'>Hợp
									đồng lao động</a></li>
							<li class="breadcrumb-item active">Thêm mới hợp đồng lao
								động</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="hopDong" action="">
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien.maNhanVien"
								placeholder="Mã nhân viên" />
							<form:errors path="maNhanVien.maNhanVien" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Loại hợp đồng</label>
							<form:select path="maLoaiHopDong.maLoaiHopDong">
								<form:option value="1">Thử việc</form:option>
								<form:option value="2">Ngắn hạn</form:option>
								<form:option value="3">Dài hạn</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Lương tháng 13</label>
							<form:select path="luongThang13">
								<form:option value="1">Không có </form:option>
								<form:option value="2">1/2</form:option>
								<form:option value="3">Đầy đủ</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Số ngày phép</label>
							<form:input class="form-control" path="soNgayPhep"
								placeholder="Số ngày phép" />
							<form:errors path="soNgayPhep" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày ký</label>
							<div class='input-group date datetimepicker10'>
								<form:input type='text' path="ngayKy" placeholder="Ngày ký"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="ngayKy" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Hợp đồng từ ngày</label>
							<div class='input-group date datetimepicker10'>
								<form:input type='text' path="hopDongTuNgay"
									placeholder="Hợp đồng từ ngày" class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="hopDongTuNgay" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Hợp đồng đến ngày</label>
							<div class='input-group date datetimepicker10'>
								<form:input type='text' path="hopDongDenNgay"
									placeholder="Hợp đồng đến ngày" class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="hopDongDenNgay" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái hợp đồng</label>
							<form:select path="trangThai">
								<form:option value="1">Có hiệu lực</form:option>
								<form:option value="2">Hết hiệu lực</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Isdelete</label>
							<form:select path="isdelete">
								<form:option value="1">Đã xóa</form:option>
								<form:option value="0">Chưa xóa</form:option>
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
