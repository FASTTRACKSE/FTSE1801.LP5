<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h3 class="content-header-title mb-0">Thêm mới nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/nhiemvu/list-nhiemvu/${idProjects}/1" />'>Danh
									sách nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Thêm mới nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" action="/ffse-fbms/mvpquanliduan/nhiemvu/addnew">
						<div class="form-group col-sm-12">
							<label>Mã Dự Án</label>
							<form:input class="form-control" path="projects.idProject" value="${duAn.idProject}" readonly="true"/>
							
						</div>
						<div class="form-group col-sm-12">
							<label>Tên Dự Án</label>
							<form:input class="form-control" path="projects.nameProject" value="${duAn.nameProject}"  readonly="true"/>
							<form:errors path="projects.nameProject" cssStyle="color: red"></form:errors>

						</div>
						<div class="form-group col-sm-12">
							<label>Mã Nhân Viên</label>
							<form:select path="hoSoNhanVien.maNv" class="form-control">
							 <form:option value="" selected = "selected" disabled = "true"> --Chọn--</form:option>
							   <c:forEach items="${nhanVienList}" var="x">
                              		<option value="${x.maNv}" >(${x.maNv}) ${x.hoTenNv}</option>
                              	 </c:forEach>
                              	 <form:errors path="hoSoNhanVien" cssStyle="color: red"></form:errors>
							</form:select>
							

						</div>
						
						
						<div class="form-group col-sm-12">
							<label >Vai trò</label>
							<p Class="error">${messageRole}</p>
							<form:select path="roles.idRoles" class="form-control">
							   <form:option value="0" label="--- Select ---"/>
							   <form:option value="0" selected = "selected" disabled = "true"> --Chọn--</form:option>
							   <form:options items="${listRoles}" itemValue="idRoles" itemLabel="nameRoles" />
							   <form:errors path="roles" cssStyle="color: red"></form:errors>

							</form:select> 

						</div>

						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
