<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh sách chức danh</a></li>
							<li class="breadcrumb-item active">Thêm mới nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="chucDanh" action="">
						<div class="form-group col-sm-6">
						  	<label>Mã phòng ban</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã chức danh</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Họ đệm</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tên</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Ảnh đại diện</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Năm sinh</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Giới tính</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tình trạng hôn nhân</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Quê quán</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Dân tộc</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Nơi tạm trú</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Số điện thoại</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Email</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Số CMND</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Nơi cấp</label>
						  	<form:input class="form-control" path="tenChucDanh" placeholder="Tên chức danh" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Ngày cấp</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã trạng thái</label>
						  	<form:input class="form-control" path="maChucDanh" placeholder="Mã chức danh" />
						  	<form:errors path="maChucDanh" cssClass="error" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
