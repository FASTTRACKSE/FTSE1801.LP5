<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.hoSoBanThan" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.danhSachNhanVien" /></li>
							<sec:authorize
								access="hasRole('ROLE_PNSNV') or hasRole('ROLE_PNSTPP')">
								<li class="breadcrumb-item"><a
									href="<c:url value = "/quanlynhansutt/ho_so/add"/>"><spring:message
											code="label.themNhanVien" /></a></li>
							</sec:authorize>
						</ol>
					</div>
				</div>
			</div>
			<c:if test="${empty add}">
				<style>
i.fa {
	width: 20px;
}
</style>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="dropdown nav-item float-md-right">
						<div role="group" class="btn-group">
							<button id="btnGroupDrop1" type="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="btn btn-outline-primary dropdown-toggle">
								<i class="ft-settings icon-left"></i>
								<spring:message code="label.thongTinKhac" />
							</button>
							<div aria-labelledby="btnGroupDrop1"
								class="dropdown-menu dropdown-menu-right">
								<a href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-id-card-o"></i> <spring:message
										code="label.thongTinHoSo" /></a> <a href="<c:url value = "#"/>"
									class="dropdown-item"><i class="fa fa-graduation-cap"></i>
									<spring:message code="label.thongTinBangCap" /></a> <a
									href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-users"></i> <spring:message
										code="label.thongTinGiaDinh" /></a> <a
									href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-file-code-o"></i> <spring:message
										code="label.thongTinKinhNghiem" /></a> <a
									href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-handshake-o"></i> <spring:message
										code="label.thongTinHopDong" /></a>
								<div class="dropdown-divider"></div>
								<a href="<c:url value = "#"/>"
									class="dropdown-item text-xs-center"><spring:message
										code="label.xemTatCa" /></a>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<div class="content-body">
			<!-- Zero configuration table -->
			<section id="configuration">
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">
									<spring:message code="label.danhSachNhanVien" />
								</h4>
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
												<th><spring:message code="label.maNhanVien" /></th>
												<th><spring:message code="label.anhDaiDien" /></th>
												<th><spring:message code="label.phongBan" /></th>
												<th><spring:message code="label.chucDanh" /></th>
												<th><spring:message code="label.tenNhanVien" /></th>
												<th><spring:message code="label.ngaySinh" /></th>
												<th><spring:message code="label.gioiTinh" /></th>
												<th><spring:message code="label.sdt" /></th>
												<th><spring:message code="label.chucNang" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listHoSo}" var="hsnv">
												<tr>

													<td style='text-align: right;'>${hsnv.maNhanVien}</td>
													<td style='text-align: center;'><img
														src="<c:url value="/uploads/${hsnv.anhDaiDien}" />"
														width="60" height="80"></td>
													<td style='text-align: left;'>${hsnv.phongBan.tenPhongBan}</td>
													<td style='text-align: left;'>${hsnv.chucDanh.tenChucDanh}</td>
													<td style='text-align: left;'>${hsnv.tenNhanVien}</td>
													<td style='text-align: right;'>${hsnv.namSinh}</td>
													<td style='text-align: left;'><c:if test="${hsnv.gioiTinh == 1}">
															<spring:message code="label.nam" />
														</c:if> <c:if test="${hsnv.gioiTinh == 2}">
															<spring:message code="label.nu" />
														</c:if></td>

													<td style='text-align: right;'>${hsnv.soDienThoai}</td>
													<td
														style="letter-spacing: 5px; min-width: 75px; text-align: center !important;">
														<sec:authorize
															access="hasRole('ROLE_PGD') or hasRole('ROLE_PNSNV') or hasRole('ROLE_PNSTPP')">
															<a
																href="<c:url value = "/quanlynhansutt/ho_so/view/${hsnv.maNhanVien}"/>"><i
																class="fa fa-eye"></i></a>
														</sec:authorize> <sec:authorize
															access="hasRole('ROLE_PNSNV') or hasRole('ROLE_PNSTPP')">
															<a
																href="<c:url value = "/quanlynhansutt/ho_so/edit/${hsnv.maNhanVien}"/>"><i
																class="fa fa-pencil"></i></a>
															<a
																href='<c:url value = "/quanlynhansutt/ho_so/delete/${hsnv.maNhanVien}"></c:url>'
																class="fa fa-trash"
																onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></a>
														</sec:authorize>
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
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
