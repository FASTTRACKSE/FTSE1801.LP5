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
					<spring:message code="label.danhsachnhap" />
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
				<c:if test="${messageError ne null}">
					<div class="alert alert-danger alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${messageError}
					</div>
				</c:if>
			</div>
			<!-- End Show message -->
			<div>
				<div>
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="soandonmoi">
							<spring:message code="label.soandonmoi" />
					</a>
				</div>

				<div class="container">
					<div class="table-responsive">
						<table class="table table-bordered"
							style="text-align: center; background: white">
							<thead style="background: #D3D3D3">
								<tr>
									<th><spring:message code="label.madon" /></th>
									<th><spring:message code="label.maNhanVien" /></th>
									<th><spring:message code="label.hoTen" /></th>
									<th><spring:message code="label.phongBan" /></th>
									<th><spring:message code="label.ngaybatdau" /></th>
									<th><spring:message code="label.ngayketthuc" /></th>
									<th><spring:message code="label.lydo" /></th>
									<th><spring:message code="label.ghichunhanvien" /></th>
									<th><spring:message code="label.ghichutruongphong" /></th>
									<th><spring:message code="label.trangThai" /></th>
									<th><spring:message code="label.chucnang" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="nv" items="${danhsachnhap}">
									<tr>
										<td>${nv.id}</td>
										<td>${nv.ngayNghi.maNhanVien}</td>
										<td>${nv.tenNhanVien}</td>
										<td>${nv.maPhongBan}</td>
										<td>${nv.ngayBatDau}</td>
										<td>${nv.ngayKetThuc}</td>
										<td>${nv.lyDo.lyDo}</td>
										<td>${nv.ghiChu}</td>
										<td>${nv.ghiChuTruongPhong}</td>
										<td>${nv.trangThai.trangThai}</td>
										<td><h2>
												<a href="delete/${nv.id }"> <i class='fa fa-trash'
													onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
											</h2>
											<h2>
												<a href="viewNhap/${nv.id }"><i class="icon-eye"></i></a>
											</h2>
											<h2>
												<a href="suanhap/${nv.id }"> <i class='fa fa-pencil'></i>
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
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=1"
											aria-controls="DataTables_Table_5" class="page-link"><spring:message
													code="label.trangdau" /></a></li>

										<li class="paginate_button page-item previous"
											id="DataTables_Table_5_previous"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" tabindex="0"
											class="page-link"><spring:message code="label.trangtruoc" /></a></li>
									</c:if>

									<c:if test="${currentPage != 1}">
										<li class="paginate_button page-item"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
									</c:if>

									<li class="paginate_button page-item "><a
										href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${currentPage}"
										aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

									<c:if test="${currentPage != lastPage}">
										<li
											class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
										<li class="paginate_button page-item next"
											id="DataTables_Table_5_next"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" data-dt-idx="8"
											tabindex="0" class="page-link"><spring:message
													code="label.trangtiep" /></a></li>
									</c:if>

									<li class="paginate_button page-item last"
										id="DataTables_Table_5_last"><a
										href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachnhap?page=${lastPage}"
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
<script>
	function canhbao() {
		return confirm("Bạn Có Chắc Muốn Xóa Không?");
	}
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
