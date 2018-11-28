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
					<spring:message code="label.danhsachtrangthai" />
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
							<spring:message code="label.themMoi" />
					</a>
				</div>
				<div class="container">
					<div class="table-responsive">
						<table class="table table-bordered"
							style="text-align: center; background: white">
							<thead style="background: #D3D3D3">
								<tr>
									<th><spring:message code="label.madon" /></th>
									<th><spring:message code="label.matrangthai" /></th>
									<th><spring:message code="label.tentrangthai" /></th>
									<th><spring:message code="label.chucnang" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="nn" items="${danhsachtrangthai}" >
									<tr>
										<th scope="row">${nn.id}</th>
										<td>${nn.maTrangThai}</td>
										<td>${nn.trangThai}</td>
									
										<td><h2>
												<a href="deleteStatus/${nn.id}"> <i class='fa fa-trash'
													onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
											</h2>
											<h2>
												<a href="viewTrangThai/${nn.id}"><i class="icon-eye"></i></a>
											</h2>
											<h2>
												<a href="suatrangthai/${nn.id}"> <i class='fa fa-pencil'></i>
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
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=1"
											aria-controls="DataTables_Table_5" class="page-link"><spring:message
													code="label.trangdau" /></a></li>

										<li class="paginate_button page-item previous"
											id="DataTables_Table_5_previous"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" tabindex="0"
											class="page-link"><spring:message code="label.trangtruoc" /></a></li>
									</c:if>

									<c:if test="${currentPage != 1}">
										<li class="paginate_button page-item"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${currentPage-1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
									</c:if>

									<li class="paginate_button page-item "><a
										href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${currentPage}"
										aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

									<c:if test="${currentPage != lastPage}">
										<li
											class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
										<li class="paginate_button page-item next"
											id="DataTables_Table_5_next"><a
											href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${currentPage+1}"
											aria-controls="DataTables_Table_5" data-dt-idx="8"
											tabindex="0" class="page-link"><spring:message
													code="label.trangtiep" /></a></li>
									</c:if>

									<li class="paginate_button page-item last"
										id="DataTables_Table_5_last"><a
										href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachtrangthai?page=${lastPage}"
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
