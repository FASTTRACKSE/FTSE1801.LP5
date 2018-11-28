
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style type="text/css">
.table td {
	vertical-align: baseline;
}

th, td {
	padding-left: 1rem !important;
	padding-right: 1rem !important;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.thongTinBangCap" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyHopDong" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.thongTinBangCap" /></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a
						href="<c:url value = "/quanlynhansutt/bang_cap/add_bangcap/${maNhanVien}"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span>
					<spring:message code="label.themMoi" /></a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Zero configuration table -->
			<section id="configuration">
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Datatable</h4>
								<a class="heading-elements-toggle"><i
									class="fa fa-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
										<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block card-dashboard">
									<table id="datatable"
										class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th><spring:message code="label.id" /></th>
												<th><spring:message code="label.maNhanVien" /></th>
												<th><spring:message code="label.tenBangCap" /></th>
												<th><spring:message code="label.loaiBangCap" /></th>
												<th><spring:message code="label.noiCapBang" /></th>
												<th><spring:message code="label.noiCap" /></th>
												<th><spring:message code="label.ngayCap" /></th>
												<th><spring:message code="label.chucNang" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listBangCap}" var="hsnv">
												<tr>
													<td>${hsnv.id}</td>
													<td>${hsnv.hoSoNhanVienTT.maNhanVien}</td>
													<td>${hsnv.tenBangCap}</td>
													<td>${hsnv.loaiBangCap}</td>
													<td>${hsnv.donViCap}</td>
													<td>${hsnv.noiCap}</td>
													<td>${hsnv.ngayCap}</td>
													<td
														style="letter-spacing: 5px; min-width: 75px; text-align: center !important;">
														<a href="<c:url value = "/quanlynhansutt/bang_cap/viewOneBangCap/${hsnv.hoSoNhanVienTT.maNhanVien}"/>">
														   <i class="fa fa-eye"></i>		
														</a> 
														<a href="<c:url value = "/quanlynhansutt/bang_cap/edit_bangcap/${hsnv.id}"/>">
														    <i class="fa fa-pencil"></i>
														</a>
														<a
														  href='<c:url value = "/quanlynhansutt/bang_cap/remove/${hsnv.id}"></c:url>'
														  class="fa fa-trash"
														  onclick="return confirm('Bạn có muốn xóa sinh viên này?');">
														</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!--/ Zero configuration table -->
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
