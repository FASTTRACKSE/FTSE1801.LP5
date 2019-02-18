<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
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
				<h3 class="content-header-title mb-0">Chỉnh Sửa Ngôn Ngữ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyDuAn/NgonNgu/list-ngonNgu" />'>Danh Sách Ngôn Ngữ</a></li>
							<li class="breadcrumb-item active">Chỉnh Sửa Ngôn Ngữ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" action="/FBMS/QuanLyDuAn/NgonNgu/update" modelAttribute="ngonNgu">
					
						<div class="form-group col-sm-12">
							<label>Mã Ngôn Ngữ</label><br>
							<p Class="error" >${messageMa}</p>
							<form:errors path="maNgonNgu" cssClass="error" />
							<form:input path="maNgonNgu" class="form-control round"
								placeholder="Mã ngôn ngữ" />
							
						</div>
						<div class="form-group col-sm-12">
							<label>Tên Ngôn Ngữ</label><br>
							<p Class="error" >${messageName}</p>
							<form:errors path="tenNgonNgu" cssClass="error" />
							<form:input path="tenNgonNgu" class="form-control round"
								placeholder="Tên ngôn ngữ" />
							
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-outline-success round btn-min-width mr-1 mb-1">Submit </button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
