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
					<strong>Chỉnh Sửa Nghiệp Vụ</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/qlda/domain/update"
			modelAttribute="domain">
			<div class="form-group col-sm-6">
				<label>Mã Nghiệp Vụ</label>
				<form:input class="form-control" path="maNghiepVu" readonly = "true"
					placeholder="Mã nghiệp vụ " />
				  <form:errors path="maNghiepVu" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Nghiệp Vụ</label>
				<form:input class="form-control" path="tenNghiepVu"
					placeholder="Tên nghiệp vụ " />
				  <form:errors path="tenNghiepVu" cssStyle="color: red"></form:errors>
			</div>
			<form:hidden class="form-control" path="is_delete" />

			<div class="col-sm-12 text-center">
				<a class="btn btn-primary"
					href='<c:url value="/qlda/domain/list" ></c:url>'>Trở về</a>
				<button type="submit" class="btn btn-primary">Lưu thông tin</button>
			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
