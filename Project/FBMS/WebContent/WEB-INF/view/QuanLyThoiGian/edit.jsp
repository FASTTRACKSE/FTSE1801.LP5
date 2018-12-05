<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa Logwork</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyThoiGian/" />'>Danh
									sách logwork</a></li>
							<li class="breadcrumb-item active">Sửa Logwork</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="logWork" action="">
						<form:input type="hidden" path="id" style="display:none"
							value="${logWork.id}" />
						<div class="form-group col-sm-6">
							<label>Họ đệm</label>
							<form:input class="form-control" path="nhanVien.hoDem"
								value="${logwork.nhanVien.hoDem}" placeholder="Họ đệm" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên</label>
							<form:input class="form-control" path="nhanVien.ten"
								value="${logwork.nhanVien.ten}" placeholder="Tên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã phòng Ban</label>
							<form:input class="form-control" path="phongBan.maPhongBan"
								value="${logWork.phongBan.maPhongBan}" placeholder="Mã phòng ban" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên dự án</label>
							<form:input class="form-control" path="duAn"
								value="${logwork.duAnh}" placeholder="Mã dự án" />
						</div>
						<div class="form-group col-sm-6">
							<label>Vai trò</label>
							<form:input class="form-control" path="vaiTroNV"
								value="${logwork.vaiTroNV}" placeholder="Vai trò" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian</label>
							<form:input class="form-control" path="time"
								value="${logwork.time}" placeholder="Thời gian" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày</label>
							<form:input class="form-control" path="date"
								value="${logwork.date}" placeholder="Thời gian" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả công việc</label>
							<form:input class="form-control" path="moTaCongViec"
								value="${logwork.moTaCongViec}" placeholder="Mô tả công việc" />
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
