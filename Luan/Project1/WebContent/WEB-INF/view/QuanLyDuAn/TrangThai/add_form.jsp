<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>THÊM TRẠNG THÁI</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="save" modelAttribute="trangthai">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="form-group col-sm-6">
				<label>Mã Trạng Thái</label>
				<form:input class="form-control" path="maTrangThai"
					placeholder="Mã trạng thái " />
				  <form:errors path="maTrangThai" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Trạng Thái</label>
				<form:input class="form-control" path="tenTrangThai"
					placeholder="Tên trạng thái " />
				  <form:errors path="tenTrangThai" cssStyle="color: red"></form:errors>
			</div>
			
			<div class="form-group col-sm-6">
			
				<form:hidden class="form-control" path="is_delete" value="0" />
				<%--  <form:errors path="email" cssStyle="color: red"></form:errors> --%>
			</div>


			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Lưu thông tin</button>
			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
