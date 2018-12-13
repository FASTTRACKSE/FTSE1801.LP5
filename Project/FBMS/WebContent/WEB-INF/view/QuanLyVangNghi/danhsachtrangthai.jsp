<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div>
				<div class="col-md-5"></div>
				<h3 class="content-header-title mb-0">
					Danh Sách Trạng Thái
				</h3>
			</div>
			<div class="continer">

				<!-- Show message -->
				<c:if test="${messageSuccess ne null}">
					<div class="alert alert-success  btn-min-width mr-1 mb-1"
						role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${messageSuccess}
					</div>
				</c:if>
			</div>

			<div>
				<div>
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="createstatus">
							Thêm Mới
					</a>
				</div>
				<div class="container">
					<div class="table-responsive">
						<table class="table table-bordered"
							style="text-align: center; background: white">
							<thead style="background: #D3D3D3">
								<tr>
									<th>Mã Trang Thái</th>
									<th>Tên Trạng Thái</th>
									<th>Chức Năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="nn" items="${danhsachtrangthai}" >
									<tr>
										<th scope="row">${nn.maTrangThai}</th>
										<td>${nn.tenTrangThai}</td>
									
										<td><h2>
												<a href="deleteStatus/${nn.maTrangThai}"> <i class='fa fa-trash'
													onclick="return confirm('Bạn có muốn xóa trạng thái này?');"></i></a>
											</h2>
											<h2>
												<a href="viewTrangThai/${nn.maTrangThai}"><i class="icon-eye"></i></a>
											</h2>
											<h2>
												<a href="suatrangthai/${nn.maTrangThai}"> <i class='fa fa-pencil'></i>
												</a>
											</h2></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-7">
							<div class="dataTables_paginate paging_full_numbers"
								id="DataTables_Table_5_paginate">
								<ul class="pagination">
									<c:if test="${currentPage != 1}">
										<li class="paginate_button page-item first"
											id="DataTables_Table_5_first"
											${currentPage == 1 ? 'd-none' : ''}><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=1"
											aria-controls="DataTables_Table_5" class="page-link">Trang Đầu</a></li>

										<li class="paginate_button page-item previous"
											id="DataTables_Table_5_previous"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" tabindex="0"
											class="page-link">Trang Trước</a></li>
									</c:if>

									<c:if test="${currentPage != 1}">
										<li class="paginate_button page-item"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
									</c:if>

									<li class="paginate_button page-item "><a
										href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${currentPage}"
										aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

									<c:if test="${currentPage != lastPage}">
										<li
											class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
										<li class="paginate_button page-item next"
											id="DataTables_Table_5_next"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" data-dt-idx="8"
											tabindex="0" class="page-link">Trang Tiếp</a></li>
									</c:if>

									<li class="paginate_button page-item last"
										id="DataTables_Table_5_last"><a
										href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachtrangthai?page=${lastPage}"
										aria-controls="DataTables_Table_5" data-dt-idx="9"
										tabindex="0" class="page-link">Trang Cuối</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
