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
			<div><a  class="btn btn-success" href="donxinphep003">  <spring:message code="label.soandonmoi"/>  </a></div>
		<div class="col-md-5"></div>
			<h3 class="content-header-title mb-0"><spring:message code="label.danhsachnhap"/></h3>
		</div>
		
			<div>
			<div class="container">
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
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
							<thead>
				<tr>
					<th ><spring:message code="label.madon"/></th>
					<th ><spring:message code="label.maNhanVien"/></th>
					<th >Ho Và Tên</th>
					<th >Phòng Ban</th>
					<th ><spring:message code="label.ngaybatdau"/></th>
					<th ><spring:message code="label.ngayketthuc"/></th>
					<th ><spring:message code="label.lydo"/></th>
					<th ><spring:message code="label.ghichunhanvien"/></th>
					<th ><spring:message code="label.ghichutruongphong"/></th>
					<th ><spring:message code="label.trangThai"/></th>
					<th><spring:message code="label.chucnang"/></th>
					
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nv" items="${danhsachnhap003}">
					<tr>
					<td>${nv.id -1}</td>
					<td>${nv.ngayNghi.maNhanVien }</td>
					<td>${nv.hoDem }</td>
					<td>${nv.maPhongBan }</td>
					<td>${nv.ngayBatDau}</td>
					<td>${nv.ngayKetThuc}</td>
					 <td>${nv.lyDo.lyDo}</td> 
					<td>${nv.ghiChu}</td>
					<td>${nv.ghiChuTruongPhong}</td>
				      <td>${nv.trangThai.trangThai}</td>
					<td><a  href="suadonnhap/${nv.id }"><button class="btn btn-success">
									<spring:message code="label.sua"/></button></a>  <a href="delete/${nv.id }"><button class="btn btn-danger"
									onclick="return confirm('Bạn có muốn xóa sinh viên này?');"><spring:message code="label.xoa"/></button></a>
					</td>
						</tr>
				</c:forEach>
				</tbody>
		</table>
		<div class="dataTables_paginate paging_full_numbers"
										id="DataTables_Table_5_paginate">
										<ul class="pagination">
											<c:if test="${currentPage != 1}">
												<li class="paginate_button page-item first"
													id="DataTables_Table_5_first"
													${currentPage == 1 ? 'd-none' : ''}><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=1"
													aria-controls="DataTables_Table_5" class="page-link"><spring:message code="label.trangdau"/></a></li>

												<li class="paginate_button page-item previous"
													id="DataTables_Table_5_previous"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" tabindex="0"
													class="page-link"><spring:message code="label.trangtruoc"/></a></li>
											</c:if>

											<c:if test="${currentPage != 1}">
												<li class="paginate_button page-item"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
											</c:if>

											<li class="paginate_button page-item "><a
												href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${currentPage}"
												aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

											<c:if test="${currentPage != lastPage}">
												<li
													class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
												<li class="paginate_button page-item next"
													id="DataTables_Table_5_next"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" data-dt-idx="8"
													tabindex="0" class="page-link"><spring:message code="label.trangtiep"/></a></li>
											</c:if>

											<li class="paginate_button page-item last"
												id="DataTables_Table_5_last"><a
												href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/danhsachnhap003?page=${lastPage}"
												aria-controls="DataTables_Table_5" data-dt-idx="9"
												tabindex="0" class="page-link"><spring:message code="label.trangcuoi"/></a></li>
										</ul>
									</div>
								</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<script type="text/javascript">
window.setTimeout(function() {
	$(".alert").fadeTo(500, 0).slideUp(500, function() {
		$(this).remove();
	});	
}, 2500);
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />