<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm Vendor</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/QuanLyDuAn/vendor/list"><spring:message code="label.titleVendor" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.addVendor" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong><spring:message code="label.addVendor" /></strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/QuanLyDuAn/vendor/creat"
			modelAttribute="vendor">
			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> 
					<label><spring:message code="label.maVendor" /></label>
				<form:input class="form-control" path="mavd" placeholder="Mã Vendor" />
				<form:errors path="mavd" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label><spring:message code="label.tenVendor" /></label>
				<form:input class="form-control" path="tenvd"
					placeholder="Tên Vendor " />
				<form:errors path="tenvd" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label><spring:message code="label.dcVendor" /></label>
				<form:input class="form-control" path="diachi" placeholder="Địa Chỉ" />
				<form:errors path="diachi" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label><spring:message code="label.emailVendor" /></label>
				<form:input class="form-control" path="email" placeholder="Email" />
				<form:errors path="email" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label><spring:message code="label.sdtVendor" /></label>
				<form:input class="form-control" path="sdt"
					placeholder="Số điện thoại" />
				<form:errors path="sdt" cssStyle="color: red"></form:errors>
			</div>
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success"><spring:message code="label.saveVendor" /></button>
			</div>
		</form:form>
		<c:if test="${message !=null }">
						 ${message }
			</c:if>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
