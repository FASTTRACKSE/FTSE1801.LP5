<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/nhiemvu/list-nhiemvu/${nhiemVu.projects.idProject}/1" />'>Danh
									sách nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Sửa nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" action="/ffse-fbms/mvpquanliduan/nhiemvu/update" modelAttribute="nhiemVu">
						<form:hidden path="id" />
						<div class="form-group col-sm-12">
							<label>Mã Dự Án</label>
							<form:input class="form-control" path="projects.idProject" readonly="true" value="${duAn.idProject}"/>
						</div>
						<div class="form-group col-sm-12">
							<label>Tên Dự Án</label>
							<form:input class="form-control" path="projects.nameProject"  readonly="true" value="${duAn.nameProject}" />
							

						</div>
						<div class="form-group col-sm-12">
							<label>Mã Nhân Viên</label>
							<form:hidden path="hoSoNhanVien.maNv" value="${nhiemVu.hoSoNhanVien.maNv }"/>
							<form:select path="hoSoNhanVien.maNv" id="maNhanVien" class="form-control" disabled="true">
							   <form:option value="0" label="--- Select ---"/>
							   <c:forEach items="${nhanVienList}" var="x">
                              		<option value="${x.maNv}" >(${x.maNv}) ${x.hoTenNv}</option>
                              	 </c:forEach>
							</form:select>
							

						</div>
						
						
						<div class="form-group col-sm-12">
							<label>Vai trò</label>
							<form:select path="roles.idRoles" class="form-control">
							   <form:option value="0" label="--- Select ---"/>
							   <form:options items="${listRoles}" itemValue="idRoles" itemLabel="nameRoles" />
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
<script>
window.onload = function () { 
	maNhanVien = "${nhiemVu.hoSoNhanVien.maNv}";
	while (maNhanVien.length < 5) {
		maNhanVien = "0" + maNhanVien;	
	}
	console.log(maNhanVien);
	$("#maNhanVien").val(maNhanVien);
}
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
