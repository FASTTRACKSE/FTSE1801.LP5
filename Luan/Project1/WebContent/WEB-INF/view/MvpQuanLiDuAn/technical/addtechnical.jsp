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
				<h3 class="content-header-title mb-0"><spring:message code="label.addKT" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item">
							<a href='<c:url value="/mvpquanliduan/technical/list-technical" />'><spring:message code="label.listKT" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.addKT" /></li>
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
					<form:form method="POST" action="addnew">
					<div class="row">
						<div class="form-group col-sm-6">
							<label><spring:message code="label.idKT" /></label><br>
							<p class="error">${messageMa}</p>
							<form:errors path="idTechnical" cssClass="error" />
							<form:input path="idTechnical" class="form-control round"
								placeholder="Mã kĩ thuật" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.nameKT" /></label><br>
							<p class="error">${messageName}</p>
							<form:errors path="nameTechnical" cssClass="error" />
							<form:input path="nameTechnical" class="form-control round"
								placeholder="Tên kĩ thuật" />
						</div>
						</div>
						<div class="row">
						<div class="col-sm-12 text-center">
							<button type="submit"
								class="btn btn-outline-success round btn-min-width mr-1 mb-1">
								<i class="fa fa-check-square-o"></i> <spring:message code="label.submit" />
							</button>
						</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />