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
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách tài liệu</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách tài liệu</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanTriTaiLieu/tai_lieu/addTL"/>"
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


						<div class="modal fade" id="confirm-delete" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
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

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Danh sách tài liệu</h4>
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
															aria-label="id: activate to sort column ascending"
															style="width: 363px;">ID</th>
														<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mã tài liệu: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Mã Tài Liệu</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên danh mục: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Tên Danh Mục</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="icon: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Icon</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên tài liệu: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Tên Tài Liệu</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên phòng ban: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Tên Phòng Ban</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Mô tả tài liệu: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Mô Tả Tài Liệu</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Link tài liệu: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Link Tài Liệu</th>
															<th class="sorting_asc" tabindex="0"
															aria-controls="datatable" rowspan="1" colspan="1"
															aria-label="Tên trạng thái: activate to sort column descending"
															style="width: 376px;" aria-sort="ascending">Tên Trạng Thái</th>
														<th class="sorting" tabindex="0" aria-controls="datatable"
															rowspan="1" colspan="1"
															aria-label=": activate to sort column ascending"
															style="width: 98px;"></th>
													</tr>
												</thead>
												<c:forEach var="tl" items="${taiLieu}">
													<tr>
														<td>${tl.taiLieu}</td>
														<td>${tl.maTaiLieu}</td>
														<td>${tl.danhMucTaiLieu.tenDanhMuc}</td>
														<td><img
															src='<c:url value="/uploads/quanTriTaiLieu/fileIcon/${tl.iconTaiLieu.maIcon}/${tl.iconTaiLieu.tenIcon}"/>'
															style="width: 60px" height="60px"></td>
														<td>${tl.tenTaiLieu}</td>
														<td>${tl.phongBan.tenPhongBan}</td>
														<td>${tl.moTaTaiLieu}</td>
														<td>${tl.linkTaiLieu}</td>
														<td>${tl.trangThaiTaiLieu.tenTrangThai}</td>
														<td><a
															href="/FBMS/QuanTriTaiLieu/trang_thai/view/maTrangThai"><i
																class="fa fa-eye"></i></a>&nbsp;<a
															href="/FBMS/QuanTriTaiLieu/trang_thai/editTT/${tt.maTrangThai}"><i
																class="fa fa-pencil"></i></a>&nbsp;<a href="javascript:void(0);"
															data-toggle="modal" data-target="#confirm-delete"
															data-href="/FBMS/QuanTriTaiLieu/trang_thai/deleteTT/${tt.maTrangThai}"><i
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
														id="datatable_previous"><a href="<c:url value = "/QuanTriTaiLieu/danh_muc/${page-1}"/>"
														aria-controls="datatable" data-dt-idx="0" tabindex="0"
														class="page-link">Previous</a></li>
												 </c:when>
												 <c:otherwise>
												 <li class="paginate_button page-item previous disabled"
														id="datatable_previous"><a href="<c:url value = "/QuanTriTaiLieu/danh_muc/${page-1}"/>"
														aria-controls="datatable" data-dt-idx="0" tabindex="0"
														class="page-link">Previous</a></li>
												 </c:otherwise>
												</c:choose>
												
												<c:forEach var="i" begin="${start}" end="${end}">
												   <li class="paginate_button page-item previous enable"
														id="datatable_previous"><a href="<c:url value = "/QuanTriTaiLieu/danh_muc/${i}"/>"
														aria-controls="datatable" data-dt-idx="0" tabindex="0"
														class="page-link">${i}</a></li>
												</c:forEach>
													
													<c:choose>
												 <c:when test="${page < pages}">
												 <li class="paginate_button page-item next enable"
														id="datatable_next"><a href="<c:url value = "/QuanTriTaiLieu/danh_muc/${page+1}"/>"
														aria-controls="datatable" data-dt-idx="2" tabindex="0"
														class="page-link">Next</a></li>
												 </c:when>
												 <c:otherwise>
												 <li class="paginate_button page-item next disabled"
														id="datatable_next"><a href="<c:url value = "/QuanTriTaiLieu/danh_muc/${page+1}"/>"
														aria-controls="datatable" data-dt-idx="2" tabindex="0"
														class="page-link">Next</a></li>
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