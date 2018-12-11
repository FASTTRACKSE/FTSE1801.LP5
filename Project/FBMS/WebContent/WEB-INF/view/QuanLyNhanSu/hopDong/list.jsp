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

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách hợp đồng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách hợp đồng</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhanSu/hopDong/add"/>"
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
							<h4 class="card-title">Thông tin gia đình</h4>
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
														<th>Id</th>
														<th>Mã nhân viên</th>
														<th>Loại hợp đồng</th>
														<th>Ngày ký</th>
														<th>Trạng thái</th>
														<th>Chức năng</th>
													</tr>
												</thead>
												<c:forEach var="list" items="${list}">
													<tr>
														<td>${list.maHopDong}
														<td>${list.maNhanVien.hoDem} ${list.maNhanVien.ten}</td>
														<td>${list.maLoaiHopDong.tenLoaiHopDong}</td>
														<td>${list.ngayKy}</td>
														<td><c:if test="${list.trangThai == 1}">Có hiệu lực</c:if>
															<c:if test="${list.trangThai == 2}">Hết hiệu lực</c:if></td>
														<td><a
															href="<c:url value = "/QuanLyNhanSu/hopDong/viewOne/${list.maHopDong}"/>"><i
																class="fa fa-eye"></i></a><a
															href="<c:url value = "/QuanLyNhanSu/hopDong/edit/${list.maHopDong}"/>"><i
																class="fa fa-pencil"></i></a><a
															href='<c:url value = "/QuanLyNhanSu/hopDong/delete/${list.maHopDong}"></c:url>' class="fa fa-trash"
															onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></a></td>
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