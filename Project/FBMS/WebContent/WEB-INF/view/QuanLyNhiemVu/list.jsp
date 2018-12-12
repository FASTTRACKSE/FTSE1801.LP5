<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
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
					<spring:message code="label.QuanLyNhiemVu.DanhSachNhiemVu" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.QuanLyNhiemVu.DanhSachNhiemVu" /></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhiemVu/add"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> <spring:message
							code="button.ThemMoi" /></a>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageError}
				</div>
			</c:if>
			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="modal fade" id="confirm-delete" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">
											<spring:message code="message.deleteinform" />
										</h4>
									</div>

									<div class="modal-body">
										<p>
											<spring:message code="message.deleteinform" />
										</p>
										<p class="debug-url"></p>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">
											<spring:message code="message.QuayLai" />
										</button>
										<a class="btn btn-danger btn-ok"><spring:message
												code="message.Xoa" /></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">
								<spring:message code="label.QuanLyNhiemVu.DanhSachNhiemVu" />
							</h4>
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
						<div class="card-block card-dashboard">
							<div class="table-responsive">
								<div id="datatable_wrapper"
									class="dataTables_wrapper form-inline dt-bootstrap4 no-footer">
									<div class="row">
										<div class="col-md-6">
											<div class="dataTables_length" id="datatable_length">
												<label>Show <select name="datatable_length"
													aria-controls="datatable" class="form-control input-sm"><option
															value="${size}">1</option>
														<option value="${size}">2</option>
														<option value="${size}">3</option>
														<option value="${size}">4</option></select> entries
												</label>
											</div>
										</div>
										<div class="col-md-6">
											<div id="datatable_filter" class="dataTables_filter">
												<label>Search:<input type="search"
													class="form-control input-sm" placeholder=""
													aria-controls="datatable"></label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<table id="datatable"
												class="table table-striped table-bordered dataex-res-constructor no-footer dataTable"
												role="grid" aria-describedby="datatable_info"
												style="width: 1013px;">
												<thead>
													<tr role="row">
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã nhiệm vụ: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.MaNhiemVu" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Dự án: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.DuAn" /></th>
														<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Loại: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending"><spring:message
																code="database.QuanLyNhiemVu.LoaiCongViec" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên công việc: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.TenCongViec" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mô tả: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.MoTa" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Thời gian bắt đầu: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.ThoiGianBatDau" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Thời gian kết thúc: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.ThoiGianKetThuc" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Phòng ban: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.PhongBan" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Nhân viên: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.NhanVien" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Vai trò: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.VaiTro" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Thời gian dự kiến hoàn thành: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.ThoiGianDuKienHoanThanh" /></th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Trạng thái: activate to sort column ascending"
															style="width: 363px;"><spring:message
																code="database.QuanLyNhiemVu.TrangThai" /></th>
														<th class="sorting" tabindex="0" aria-controls="datatable"
															rowspan="1" colspan="1"
															aria-label=": activate to sort column ascending"
															style="width: 98px;"></th>
													</tr>
												</thead>
												<c:forEach var="sv" items="${list}">
													<tr>
														<td>${sv.id}</td>
														<td>${sv.maDuAn}</td>
														<td>${sv.idLoaiCongViec.loaiCongViec}</td>
														<td>${sv.tenCongViec}</td>
														<td>${sv.moTa}</td>
														<td>${sv.thoiGianBatDau}</td>
														<td>${sv.thoiGianKetThuc}</td>
														<td>${sv.idPhongBan.tenPhongBan}</td>
														<td>${sv.idNhanVien.hoDem}${sv.idNhanVien.ten}</td>
														<td>${sv.maVaiTro}</td>
														<td>${sv.thoiGianDuKienHoanThanh}</td>
														<td>${sv.idTrangThai.trangThai}</td>
														<td><a
															href="<c:url value="/QuanLyNhiemVu/view/${sv.id}"/>"><i
																class="fa fa-eye"></i></a><a
															href="<c:url value="/QuanLyNhiemVu/edit/${sv.id}"/>"><i
																class="fa fa-pencil"></i></a><a href="javascript:void(0);"
															data-toggle="modal" data-target="#confirm-delete"
															data-href="<c:url value="/QuanLyNhiemVu/delete/${sv.id}"/>"><i
																class="fa fa-trash"></i></a></td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-md-5">
											<div class="dataTables_info" id="datatable_info"
												role="status" aria-live="polite">Showing 1 to 10 of 10
												entries</div>
										</div>
										<div class="col-md-7">
											<div class="dataTables_paginate paging_simple_numbers"
												id="datatable_paginate">
												<ul class="pagination">
													<c:choose>
														<c:when test="${page != 1}">
															<li class="paginate_button page-item previous enable"
																id="datatable_previous"><a
																href="<c:url value="/QuanLyNhiemVu/${page-1}"/>"
																aria-controls="datatable" tabindex="0" class="page-link">Previous</a></li>
														</c:when>
														<c:otherwise>
															<li class="paginate_button page-item previous disabled"
																id="datatable_previous"><a
																href="<c:url value="/QuanLyNhiemVu/${page-1}"/>"
																aria-controls="datatable" tabindex="0" class="page-link">Previous</a></li>
														</c:otherwise>
													</c:choose>
													<c:forEach begin="1" end="${total}" var="i">
														<c:choose>
															<c:when test="${size eq i}">
																<li class="paginate_button page-item enable"><a
																	href="<c:url value="/QuanLyNhiemVu/${i}"/>"
																	aria-controls="datatable" data-dt-idx="1" tabindex="0"
																	class="page-link">${i}</a></li>
															</c:when>
															<c:otherwise>
																<li class="paginate_button page-item enable"><a
																	href="<c:url value="/QuanLyNhiemVu/${i}"/>"
																	aria-controls="datatable" data-dt-idx="1" tabindex="0"
																	class="page-link">${i}</a></li>
															</c:otherwise>
														</c:choose>
													</c:forEach>
													<c:choose>
														<c:when test="${page lt total}">
															<li class="paginate_button page-item next enable"
																id="datatable_next"><a
																href="<c:url value="/QuanLyNhiemVu/${page+1}"/>"
																aria-controls="datatable" tabindex="2" class="page-link">Next</a></li>
														</c:when>
														<c:otherwise>
															<li class="paginate_button page-item next disabled"
																id="datatable_next"><a
																href="<c:url value="/QuanLyNhiemVu/${page+1}"/>"
																aria-controls="datatable" tabindex="2" class="page-link">Next</a></li>
														</c:otherwise>
													</c:choose>
												</ul>
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
</div>
<script type="text/javascript">
	window.onload = function() {
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
	}
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />