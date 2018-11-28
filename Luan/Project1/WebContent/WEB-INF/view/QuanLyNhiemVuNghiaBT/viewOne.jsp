<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.card-block input {
	border: 0;
	border-radius: 0;
}

.card-block .table td {
	padding-left: 0px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.danhsachnhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVuNghiaBT/" />'><spring:message code="label.danhsachnhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.thongtinnhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title"><spring:message code="label.thongtinnhiemvu"/></h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="form-group col-sm-6">
								<label><spring:message code="label.duannhiemvu"/></label> 
									<input class="form-control round" value="${list.duAn.tenDuAn}" readonly /> 
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tencongviec"/></label> 
								<input class="form-control round" value="${list.tenCongViec}" readonly /> 
						</div>
						<div class="form-group col-sm-6">
							<div class="form-group col-sm-6">
								<label><spring:message code="label.loaicongviecnhiemvu"/></label> 
									<input class="form-control round" value="${list.maCongViec.loaiCongViec}" readonly /> 
							</div>
							<div class="form-group col-sm-6">
								<label><spring:message code="label.trangthainhiemvu"/></label> 
									<input class="form-control round" value="${list.maTrangThai.trangThai}" readonly />
							</div>
						</div>
						<div class="form-group col-sm-6">		
							<div class="form-group col-sm-6">
								<label><spring:message code="label.tgbatdau"/></label> 
									<input class="form-control round" type="date" value="${list.tgBatDau}" readonly /> 
							</div>
							<div class="form-group col-sm-6">
								<label><spring:message code="label.tgketthuc"/></label> 
									<input class="form-control round" type="date" value="${list.tgKetThuc}" readonly /> 
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.nguoiduocphancong"/></label> 
								<input class="form-control round" value="${list.phanCong.hoDem} ${list.phanCong.ten}" readonly /> 
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tgdukienhoanthanh"/></label>
							<div class="input-group"> 
								<input class="form-control round" value="${list.tgDuKien}" readonly />
								<span class="input-group-addon round"><spring:message code="label.gionhiemvu"/></span> 
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.motanhiemvu"/></label>
								<textarea class="form-control round" readonly>${list.moTa}</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
