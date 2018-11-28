
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<spring:message code="label.thongTinGiaDinh" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quanlynhansutt/ho_so/"/>"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/hop_dong/" />'><spring:message
										code="label.thongTinHopDong" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.thongTinGiaDinh" /></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<sec:authorize access="hasRole('ROLE_PNSTPP')">
						<a
							href="<c:url value = "/quanlynhansutt/gia_dinh/add_giadinh/${maNhanVien}"/>"
							class="btn btn-primary"><span class="fa fa-plus"></span> <spring:message
								code="label.themMoi" /></a>
					</sec:authorize>
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

												<th><spring:message code="label.hoTen" /></th>
												<th><spring:message code="label.queQuan" /></th>
												<th><spring:message code="label.ngaySinh" /></th>
												<th><spring:message code="label.gioiTinh" /></th>
												<th><spring:message code="label.dienThoai" /></th>
												<th><spring:message code="label.quanHe" /></th>
												<th><spring:message code="label.chucNang" /></th>
											</tr>
										</thead>
										<tbody>
											<sec:authorize
												access="hasRole('ROLE_PNSTPP') or hasRole('ROLE_PGD')">
												<c:forEach items="${viewOne}" var="ttgd">
													<tr>
														<td>${ttgd.hoTen}</td>
														<td>${ttgd.queQuan}</td>
														<td>${ttgd.namSinh}</td>
														<td><c:if test="${ttgd.gioiTinh == 1}">
																<spring:message code="label.nam" />
															</c:if> <c:if test="${ttgd.gioiTinh == 2}">
																<spring:message code="label.nu" />
															</c:if></td>
														<td>${ttgd.soDienThoai}</td>
														<td>${ttgd.quanHe}</td>
														<td
															style="letter-spacing: 5px; min-width: 75px; text-align: center !important;">
															<a href="<c:url value = "#"/>"><i class="fa fa-eye"></i></a>
															<sec:authorize access="hasRole('ROLE_PNSTPP')">
																<a
																	href="<c:url value = "/quanlynhansutt/gia_dinh/edit_giadinh/${ttgd.id}"/>"><i
																	class="fa fa-pencil"></i> </a>
																<a
																	href='<c:url value = "/quanlynhansutt/gia_dinh/remove/${ttgd.id}"></c:url>'
																	class="fa fa-trash"
																	onclick="return confirm('Bạn có muốn xóa sinh viên này?');">
																</a>
															</sec:authorize>
														</td>
													</tr>
												</c:forEach>
											</sec:authorize>
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
