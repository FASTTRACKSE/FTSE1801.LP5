
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
					<spring:message code="label.danhSachHopDong" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quanlynhansutt/ho_so/"/>"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyHopDong" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.danhSachHopDong" /></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a
						href="<c:url value = "/quanlynhansutt/hop_dong/add_hopdong/${maNhanVien}"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> <spring:message
							code="label.themMoi" /></a>
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
								<p>
								<div class="col-md-4">
									<form method="GET" action="">
										<div class="col-md-6">
											<div class="form-group">
												<spring:message code="label.maNhanVien" />
												<select name="maphongban"
													class="form-control form-control-sm" id="maphongban">
													<option value="0" selected="selected">--
														<spring:message code="label.tatCa" />--
													</option>
													<c:forEach items="${phongban}" var="nn">
														<option value="${nn.maPhongBan}"
															<c:if test="${maPhongBans == nn.maPhongBan }"> selected="selected"</c:if>>${nn.maPhongBan}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-6" style="margin-top: 20px">
											<label></label>
											<button type="submit"
												class="btn mr-1 mb-1 btn-success btn-sm">
												<i class="fa fa-search"></i>
												<spring:message code="label.tim" />
											</button>
										</div>
										<script type="text/javascript">
											NhanVien =
										<%=request.getParameter("maphongban")%>
											;
											if (maphongban != 0
													&& maphongban != null) {
												$("#maphongban")
														.val(maphongban);
											}
										</script>
									</form>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block card-dashboard">
									<table id="datatable"
										class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th><spring:message code="label.maHopDong" /></th>
												<th><spring:message code="label.maNhanVien" /></th>
												<th><spring:message code="label.tenHopDong" /></th>
												<th><spring:message code="label.luongThang13" /></th>
												<th><spring:message code="label.soNgayPhep" /></th>
												<th><spring:message code="label.ngayKy" /></th>
												<th><spring:message code="label.hopDongTuNgay" /></th>
												<th><spring:message code="label.hopDongDenNgay" /></th>
												<th><spring:message code="label.trangThai" /></th>
												<th><spring:message code="label.chucNang" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listHopDong}" var="hshd">
												<tr>
													<td>${hshd.maHopDong}</td>
													<td>${hshd.hoSoNhanVienTT.maNhanVien}</td>
													<td>${hshd.loaiHopDong.tenHopDong}</td>
													<td><c:if test="${hshd.luongThang13 == 1}">
															<spring:message code="label.co" />
														</c:if> <c:if test="${hshd.luongThang13 == 2}">
															<spring:message code="label.khong" />
														</c:if></td>
													<td>${hshd.soNgayPhep}</td>
													<td>${hshd.ngayKy}</td>
													<td>${hshd.hopDongTuNgay}</td>
													<td>${hshd.hopDongDenNgay}</td>
													<td><c:if test="${hshd.trangThai == 1}">
															<spring:message code="label.conHopDong" />
														</c:if> <c:if test="${hshd.trangThai == 2}">
															<spring:message code="label.hetHopDong" />
														</c:if></td>
													<td
														style="letter-spacing: 5px; min-width: 75px; text-align: center !important;">
														<a
														href="<c:url value = "/quanlynhansutt/hop_dong/viewOneHopDong/${hshd.hoSoNhanVienTT.maNhanVien}"/>"><i
															class="fa fa-eye"></i></a> <a
														href="<c:url value = "/quanlynhansutt/hop_dong/edit_hopdong/${hshd.maHopDong}"/>"><i
															class="fa fa-pencil"></i></a> <%-- <a href="<c:url value = ""/>"><i class="fa fa-trash"></i></a> --%>
														<a
														href='<c:url value = "/quanlynhansutt/hop_dong/remove/${hshd.maHopDong}"></c:url>'
														class="fa fa-trash"
														onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></a>

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
