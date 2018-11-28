
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<link
	href="https://rawgit.com/istvan-ujjmeszaros/bootstrap-duallistbox/master/src/bootstrap-duallistbox.css"
	rel="stylesheet" />
<script
	src="https://rawgit.com/istvan-ujjmeszaros/bootstrap-duallistbox/master/src/jquery.bootstrap-duallistbox.js"></script>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<div class="app-content content container-fluid">

	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới dự án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/project/list-project" />'>Danh
									sách dự án</a></li>
							<li class="breadcrumb-item active">Thêm mới dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<!-- End Path -->

		<div class="justify-content-md-center" style="width: 95%">
			<h4 class="card-title" id="basic-layout-form">Project Info</h4>
			<div class="card-body">

				<form:form method="POST" action="addnew">
					<div class="form-body">
						<h4 class="form-section">
							<i class="ft-user"></i> Thông tin dự án***
						</h4>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput1">Mã dự án*</label>
									<p class="error">${messageMa}</p>
									<form:errors path="idProject" cssClass="error" />
									<form:input path="idProject" placeholder="Mã dự án"
										class="form-control" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput2">Tên dự án*</label>
									<p class="error">${messageName}</p>
									<form:errors path="nameProject" cssClass="error" />
									<form:input path="nameProject" placeholder="Tên dự án"
										class="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Khách hàng*</label><br>
										<form:errors path="khachHang" cssClass="error" />
									<form:select multiple="single" path="khachHang.idKhachHang"  
										class="form-control">
										<form:option value="" selected = "selected" disabled = "true"> --Chọn khach hang--</form:option>
										<c:forEach items="${khachHang}" var="kh">
										<option value="${kh.idKhachHang }">${kh.idKhachHang } - ${kh.fullname }</option>
									</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Phòng dự án*</label><br>
									<form:errors path="roomProject" cssClass="error" />
									<form:select id="idPhongBan" multiple="single" path="roomProject.maPhongBan"
										class="form-control" onchange="myFunction()">
										<form:option value="" selected = "selected" disabled = "true"> --Chọn Phong ban--</form:option>
										<form:options items="${phongDuAn}" itemValue="maPhongBan"
											itemLabel="tenPhongBan" />
									</form:select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Nghiệp vụ*</label><br>
									<form:errors path="domain" cssClass="error" />
									<form:select multiple="single" path="domain.idDomain"
										class="form-control">
										<form:option value="" selected = "selected" disabled = "true"> --Chọn Domain--</form:option>
										<form:options items="${domain}" itemValue="idDomain"
											itemLabel="nameDomain" />
									</form:select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5"> PM</label>	<br>
									<form:errors path="pm" cssClass="error" />								
									 <form:select path="pm.maNv" id="idPm" name="pm"
										type="text" class="form-control" >
										<form:option value="" selected = "selected" disabled = "true"> --Chọn PM--</form:option>
									</form:select> 
							</div>
						</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Ngày bắt đầu*</label>
									<form:errors path="startDate" cssClass="error" />
									<form:input path="startDate" cssClass="form-control round"
										type="date" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">Ngày kết thúc*</label>
									<form:errors path="endDate" cssClass="error" />
									<form:input path="endDate" cssClass="form-control round"
										type="date" />
								</div>
							</div>

						</div>

						
					</div>
					

					<h4 class="form-section">
						<i class="fa fa-paperclip"></i> Công nghệ
					</h4>
					<div class="form-group">
						<label for="companyName" style="text-align: center;">Kĩ
							thuật</label>
						<form:select multiple="multiple" path="technical"
							title="technical" class="form-control">
							<form:options items="${technical}" itemValue="idTechnical"
								itemLabel="nameTechnical" />
						</form:select>
					</div>
					<div class="form-group text-center">
						<label for="companyName">Database</label>
						<form:select path="database" items="${database}" multiple="true"
							itemValue="idDatabase" itemLabel="nameDatabase"
							class="form-control" />
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="projectinput5">Programming language</label>
								<form:select path="language" items="${language}" multiple="true"
									itemValue="idLanguage" itemLabel="nameLanguage"
									class="form-control" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="projectinput6">Framework</label>
								<form:select path="framework" items="${framework}"
									multiple="true" itemValue="idFrame" itemLabel="nameFramework"
									class="form-control" />
							</div>
						</div>
					</div>
					<h4 class="form-section">
						<i class="fa fa-paperclip"></i> Mô tả dự án
					</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="projectinput5">Nhà cung cấp</label>
								<form:select path="vendor" items="${vendor}" multiple="true"
									itemValue="idVendor" itemLabel="nameVendor"
									class="form-control" />
							</div>
						</div>

					</div>
					<div class="form-group">
						<label for="projectinput8">Mô tả dự án</label>

						<form:textarea path="detail" placeholder="Mô tả dự án"
							class="form-control" />
					</div>
					<div class="col-sm-12 text-center">

						<div class="form-group">
							<label for="projectinput6">Trạng thái</label>
							<form:hidden path="status.idStatus" value="13"/>
							<form:select multiple="single" path="status.idStatus"
								class="form-control " disabled="true">
								<form:options items="${status}" itemValue="idStatus"
									itemLabel="nameStatus" />
							</form:select>
						</div>
					</div>
					<div class="col-sm-12 text-center">

						<button type="submit"
							class="btn btn-outline-primary btn-lg mr-1 mb-1 btn-block round">
							<i class="fa fa-check-circle"></i> Lưu thông tin
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

<script>
	var demo1 = $('select[name="technical"]').bootstrapDualListbox();
	var demo2 = $('select[name="database"]').bootstrapDualListbox();
	var demo3 = $('select[name="language"]').bootstrapDualListbox();
	var demo4 = $('select[name="framework"]').bootstrapDualListbox();
	var demo5 = $('select[name="vendor"]').bootstrapDualListbox();

 	
</script>
<script>
function myFunction() {
	
	var maPhongBan = $("#idPhongBan").val();
	if (maPhongBan == '') {

		$('#idPm option').remove();
	} else {
		$('#idPm').prop('disabled', false);
		$('#idPm option').remove();
	}

	$.ajax({
		url : "/ffse-fbms/mvpquanliduan/project/get-pm/" + maPhongBan,
		dataType : "json",
		success : function(data) {
			/* alert("Hello! I am an alert box!"); */
	 		$('#idPm').append($('<option>', {
				value : '',
				text : 'Chọn PM'
			}));

			for (var i = 0; i < data.length; i++) {
				$('#idPm').append($('<option>', {
					value : data[i].maNhanVien,
					text : data[i].tenNhanVien
				}));
			}
		}
	});
}
</script>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />