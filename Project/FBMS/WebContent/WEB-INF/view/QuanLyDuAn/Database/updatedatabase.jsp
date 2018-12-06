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
				<h3 class="content-header-title mb-0">Chỉnh sửa database</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyDuAn/Database/list-database" />'>Danh sách database</a></li>
							<li class="breadcrumb-item active">chỉnh sửa database</li>
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
					<form:form method="POST"
						action="/FBMS/QuanLyDuAn/Database/update"
						modelAttribute="database">
						<div class="form-group col-sm-6">
							<form:hidden path="maDatabase" />
							<form:hidden path="isDelete" />
							<label>Database</label><br>
							<form:errors path="tenDatabase" cssClass="error" />
							<form:input path="tenDatabase" class="form-control round"
								placeholder="Tên database" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-outline-success round btn-min-width mr-1 mb-1"><i class="fa fa-check-square-o"></i>submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
