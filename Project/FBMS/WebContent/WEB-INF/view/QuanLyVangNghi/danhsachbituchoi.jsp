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
					Danh Sách Từ Chối
				</h3>
			</div>
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
			<div>
				<div>
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="soandonmoi">
							Soạn Đơn Mới
					</a>
				</div>

				<div class="container">
					<div class="table-responsive">
						<table class="table table-bordered"
							style="text-align: center; background: white">
							<thead style="background: #D3D3D3">
								<tr>
									<th>Mã Đơn</th>
									<th>Mã Nhân Viên</th>
									<th>Mã Phòng Ban</th>
									<th>Ngày Bắt Đầu</th>
									<th>Ngày Kết Thúc</th>
									<th>Lý Do</th>
									<th>Số Ngày Nghỉ</th>
									<th>Ghi Chú</th>
									<th>Trạng Thái</th>
									<th>Chức Năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="nv" items="${danhsachtuchoi}">
									<tr>
										<td>${nv.idDonXinPhep }</td>
										<td>${nv.maNhanVien.idNhanVien.hoDem}</td>
										<td>${nv.maPhongBan}</td>
										<td>${nv.thoiGianBatDau}</td>
										<td>${nv.ThoiGianKetThuc}</td>
										<td>${nv.idLoaiNghi.maLoaiNghi}</td>
										<td>${nv.soNgayNghi}</td>
										<td>${nv.ghiChu}</td>
										<td>${nv.maTrangThai.maTrangThai}</td>
										<td><h2>
												<a href="delete/${nv.idDonXinPhep }"> <i class='fa fa-trash'
													onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
											</h2>
											<h2>
												<a href="viewTuChoi/${nv.idDonXinPhep }"><i class="icon-eye"></i></a>
											</h2>
											<h2>
												<a href="suanhap/${nv.idDonXinPhep }"> <i class='fa fa-pencil'></i>
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
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=1"
											aria-controls="DataTables_Table_5" class="page-link"><spring:message
													code="label.trangdau" /></a></li>

										<li class="paginate_button page-item previous"
											id="DataTables_Table_5_previous"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" tabindex="0"
											class="page-link"><spring:message code="label.trangtruoc" /></a></li>
									</c:if>

									<c:if test="${currentPage != 1}">
										<li class="paginate_button page-item"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
									</c:if>

									<li class="paginate_button page-item "><a
										href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${currentPage}"
										aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

									<c:if test="${currentPage != lastPage}">
										<li
											class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
										<li class="paginate_button page-item next"
											id="DataTables_Table_5_next"><a
											href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" data-dt-idx="8"
											tabindex="0" class="page-link"><spring:message
													code="label.trangtiep" /></a></li>
									</c:if>

									<li class="paginate_button page-item last"
										id="DataTables_Table_5_last"><a
										href="<%=request.getContextPath()%>/QuanLyVangNghi/danhsachbituchoi?page=${lastPage}"
										aria-controls="DataTables_Table_5" data-dt-idx="9"
										tabindex="0" class="page-link"><spring:message
												code="label.trangcuoi" /></a></li>
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
