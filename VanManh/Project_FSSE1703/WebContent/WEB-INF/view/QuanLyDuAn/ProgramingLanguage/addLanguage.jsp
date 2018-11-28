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
				<h3 class="content-header-title mb-0">Thêm mới ngôn ngữ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/QuanLyDuAn/Language/list">Danh sách Ngôn Ngữ</a></li>
							<li class="breadcrumb-item active">Thêm mới ngôn ngữ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>THÊM MỚI NGÔN NGỮ</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/QuanLyDuAn/Language/creat" modelAttribute="language"> 
			<div class="form-group col-sm-6" >
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					 <label>Mã Ngôn Ngữ</label>
				<form:input class="form-control" path="maNn" 
					placeholder="Mã Ngôn Ngữ" />
				  <form:errors path="maNn" cssStyle="color: red;display:block"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Ngôn Ngữ</label>
				<form:input class="form-control" path="tenNn"
					placeholder="Tên Ngôn Ngữ " />
			 	<form:errors path="tenNn" cssStyle="color: red;display:block"></form:errors> 
			</div>

			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Lưu thông tin</button>
			</div>
		</form:form>
						<c:if test="${message !=null }">
						 ${message }
			</c:if>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
