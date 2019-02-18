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
				<h3 class="content-header-title mb-0">Thêm mới nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/hoSoNhanVien/" />'>Danh
									sách Nhân Viên</a></li>
							<li class="breadcrumb-item active">Thêm mới nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="nhanVien" action="">
						<div class="form-group col-sm-6">
							<label>Mã phòng ban</label>
							<form:input class="form-control" path="maPhongBan.maPhongBan"
								placeholder="Mã phòng ban" />
							<form:errors path="maPhongBan.maPhongBan" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã chức danh</label>
							<form:input class="form-control" path="maChucDanh.maChucDanh"
								placeholder="Mã chức danh" />
							<form:errors path="maChucDanh.maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Họ đệm</label>
							<form:input class="form-control" path="hoDem"
								placeholder="Họ đệm" />
							<form:errors path="hoDem" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên</label>
							<form:input class="form-control" path="ten" placeholder="Tên" />
							<form:errors path="ten" cssClass="error" />
						</div>
						<!-- <div class="form-group col-sm-6">
							<label>Avatar:</label> <input id="imgUrl" class="form-control"
								type="file" name="file" /> <br> <img id="img" src="#"
								alt="your image" width="100" height="150" />
						</div> -->
						<div class="form-group col-sm-6">
							<label>Ảnh đại diện</label>
							<form:input class="form-control" path="avatar"
								placeholder="Ảnh đại diện" />
							<form:errors path="avatar" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Năm sinh</label>
							<div class='input-group date datetimepicker10'>
								<form:input type='text' path="namSinh" placeholder="Ngày sinh"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="namSinh" cssClass="error" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Giới tính</label>
							<form:select path="gioiTinh">
								<form:option value="1">Nam(1)</form:option>
								<form:option value="2">Nữ(2)</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Tình trạng hôn nhân</label>
							<form:select path="tinhTrangHonNhan">
								<form:option value="1">Độc thân(1)</form:option>
								<form:option value="2">Đã kết hôn(2)</form:option>
								<form:option value="3">Đã ly hôn(3)</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Quê quán</label>
							<form:input class="form-control" path="queQuan"
								placeholder="Quê quán" />
						</div>
						<div class="form-group col-sm-6">
							<label>Dân tộc</label>
							<form:input class="form-control" path="danToc"
								placeholder="Dân tộc" />
							<form:errors path="danToc" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi tạm trú</label>
							<form:input class="form-control" path="noiTamTru"
								placeholder="Nơi tạm trú" />
						</div>
						<div class="form-group col-sm-6">
							<label>Số điện thoại</label>
							<form:input class="form-control" path="soDienThoai"
								placeholder="Số điện thoại" />
							<form:errors path="soDienThoai" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Email</label>
							<form:input class="form-control" path="email" placeholder="Email" />
						</div>
						<div class="form-group col-sm-6">
							<label>Số CMND</label>
							<form:input class="form-control" path="soCMND"
								placeholder="Số CMND" />
							<form:errors path="soCMND" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi cấp</label>
							<form:input class="form-control" path="noiCap"
								placeholder="Nơi cấp" />
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
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:select path="trangThai">
								<form:option value="1">Đang làm việc(1)</form:option>
								<form:option value="2">Đã nghỉ(2)</form:option>
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
