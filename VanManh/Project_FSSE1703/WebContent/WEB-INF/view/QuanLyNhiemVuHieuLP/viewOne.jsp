<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
								href='<c:url value="/HieuLP/" />'><spring:message code="label.danhsachnhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.thongtinnhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		
		
		
		
		<div class="content-body">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h4 class="content-header-title mb-0" style="margin-left: 450px"><b><spring:message code="label.thongtinnhiemvu"/></b></h4>
							<hr>
						<div class="content-body">
							<div class="main-content">
								<div class="row">
										<div class="form-group col-sm-6">
											<label><spring:message code="label.duannhiemvu"/></label>
											 <input class="form-control"value="${nv.duAn.tenDuan}" readonly />
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.tencongviec"/></label>
											 <input class="form-control" value="${nv.tenCongviec}" readonly /> 
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.loaicongviecnhiemvu"/></label>
										 <input class="form-control" value="${nv.idLoaiCongviec.loaiCongviec}" readonly />
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.trangthainhiemvu"/></label>
											<input class="form-control" value="${nv.idLoaiTrangthai.loaiTrangthai}" readonly />
										</div>
										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgbatdau"/></label>
											 <input class="form-control" value="${nv.tgBatdau}" readonly /> 
										</div>
										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgketthuc"/></label>
											 <input class="form-control" value="${nv.tgKetthuc}" readonly /> 
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.nguoiduocphancong"/></label>
												<input class="form-control" value="${nv.nhanVien.hoDem} ${nv.nhanVien.ten}" readonly />
										</div>
										<div class="form-group col-sm-12">
											<label><spring:message code="label.motanhiemvu"/></label>
											 <input class="form-control" value="${nv.moTa}" readonly /> 
											 
										</div>


										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgdukienhoanthanh"/></label>
											<div class="input-group">
												<input class="form-control" value="${nv.tgDukienhoanthanh}" readonly />
													<span class="input-group-addon"><spring:message code="label.gionhiemvu"/></span>
											</div>

										</div>

									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
