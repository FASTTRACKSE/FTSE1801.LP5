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
					<strong>THÊM Khách Hàng</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/qlda/khachhang/update/" modelAttribute="khachhang">
			<div class="form-group col-sm-6"> 
				<label>Mã Khách Hàng</label>
				<form:input class="form-control" path="makh" readonly = "true"
					placeholder="Mã khách hàng " />
				  <form:errors path="makh" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Khách Hàng</label>
				<form:input class="form-control" path="tenkh"
					placeholder="Tên khách hàng " />
			  <form:errors path="tenkh" cssStyle="color: red"></form:errors>
			</div>
			
			<div class="form-group col-sm-6">
				<label>Địa Chỉ</label>
				<form:input class="form-control" path="diachi"
					placeholder="địa chỉ" />
				  <form:errors path="diachi" cssStyle="color: red"></form:errors> 
			</div>
			
			<div class="form-group col-sm-6">
				<label>Số Điện Thoại</label>
				<form:input class="form-control" path="sdt"
					placeholder="số điện thoại " />
				 <form:errors path="sdt" cssStyle="color: red"></form:errors>
			</div>
			
			<div class="form-group col-sm-6">
				<label>Email</label>
				<form:input class="form-control" path="email"
					placeholder="email
					 " />
				 <form:errors path="email" cssStyle="color: red"></form:errors>
			</div>
			
			<div class="form-group col-sm-6">
			
				<form:hidden class="form-control" path="is_delete" value="0" />
				<%--  <form:errors path="email" cssStyle="color: red"></form:errors> --%>
			</div>
			<div class="col-sm-12 text-center">
			<a class="btn btn-primary" href='<c:url value="/qlda/khachhang/list" ></c:url>' >Trở về</a>
				<button type="submit" class="btn btn-primary">Lưu thông tin</button>
			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
