<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
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
				<h3 class="content-header-title mb-0">Danh sách nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanTriHeThong/chuc_danh/add"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
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
						<div class="card-header">
							<h4 class="card-title">Danh sách nhiệm vụ</h4>
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
								<div class="modal fade" id="confirm-delete" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">

											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title" id="myModalLabel">Bạn có chắc
													muốn xóa</h4>
											</div>

											<div class="modal-body">
												<p>Bạn có chắc muốn xóa</p>
												<p class="debug-url"></p>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Quay lại</button>
												<a class="btn btn-danger btn-ok">Xóa</a>
											</div>
										</div>
									</div>
								</div>
								<div id="datatable_wrapper"
									class="dataTables_wrapper form-inline dt-bootstrap4 no-footer">
									<div class="row">
										<div class="col-md-6">
											<div class="dataTables_length" id="datatable_length">
												<label>Show <select name="datatable_length"
													aria-controls="datatable" class="form-control input-sm"><option
															value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option></select> entries
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
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">id</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Dự án</th>
														<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên phòng ban: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Loại
															công việc</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Tên công việc</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Mô tả</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Thời gian bắt đầu</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Thời gian kết thúc</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Phòng ban</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Nhân viên</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Vai trò</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Thời gian dự kiến hoàn thành</th>
														<th class="sorting_desc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã phòng ban: activate to sort column ascending"
															style="width: 363px;">Trạng thái</th>
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
														<td>${sv.idLoaiCongVien.loaiCongViec}</td>
														<td>${sv.tenCongViec}</td>
														<td>${sv.moTa}</td>
														<td>${sv.thoiGianBatDau}</td>
														<td>${sv.thoiGianKetThuc}</td>
														<td>${sv.idPhongBan.tenPhongBan}</td>
														<td>${sv.idNhanVien.maNhanVien}</td>
														<td>${sv.maVaiTro}</td>
														<td>${sv.thoiGianDuKienHoanThanh}</td>
														<td>${sv.idTrangThai.trangThai}</td>
														<td><a
															href="/ffse-fbms/QuanTriHeThong/phong_ban/view/PDA"><i
																class="fa fa-eye"></i></a><a
															href="/ffse-fbms/QuanTriHeThong/phong_ban/edit/PDA"><i
																class="fa fa-pencil"></i></a><a href="javascript:void(0);"
															data-toggle="modal" data-target="#confirm-delete"
															data-href="/ffse-fbms/QuanTriHeThong/phong_ban/delete/PDA"><i
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
													<li class="paginate_button page-item previous disabled"
														id="datatable_previous"><a href="#"
														aria-controls="datatable" data-dt-idx="0" tabindex="0"
														class="page-link">Previous</a></li>
													<li class="paginate_button page-item active"><a
														href="#" aria-controls="datatable" data-dt-idx="1"
														tabindex="0" class="page-link">1</a></li>
													<li class="paginate_button page-item next disabled"
														id="datatable_next"><a href="#"
														aria-controls="datatable" data-dt-idx="2" tabindex="0"
														class="page-link">Next</a></li>
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
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />