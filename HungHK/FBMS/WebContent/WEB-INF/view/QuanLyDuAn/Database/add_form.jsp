<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm database</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/qlda/Database/">Danh sách Database</a></li>
							<li class="breadcrumb-item active">Thêm database</li>
						</ol>
					</div>
				</div>
			</div>
			</div>
			</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>THÊM DATABASE</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/qlda/Database/creat"
			modelAttribute="database">

			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <label>Mã Database</label>
				<form:input class="form-control" path="maDatabase"
					placeholder="Mã Database " />
				<form:errors path="maDatabase" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label>Tên Database</label>
				<form:input class="form-control" path="tenDatabase"
					placeholder="Tên Database " />
				<form:errors path="tenDatabase" cssStyle="color: red"></form:errors>
			</div>
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Lưu thông tin</button>
			</div>
		</form:form>
		<div class="col-sm-4">
			<c:if test="${message !=null }">
						 ${message }
			</c:if>

	</div>
</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
