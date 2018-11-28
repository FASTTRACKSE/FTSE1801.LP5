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
		<div  class="col-md-6"></div>
		<div class="col-md-6">
			<h3 class="content-header-title mb-0"><spring:message code="label.danhsachngaynghi"/> </h3>
		</div>
		</div>
			<div>
			<div class="container">
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th><spring:message code="label.maNhanVien"/></th>
					<th><spring:message code="label.songaydanghi"/></th>
					<th><spring:message code="label.songayconlai"/></th>
		
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nn" items="${ngaynghiphep}" varStatus="count"   >
                    <tr> 
                     
					<td>${nn.maNhanVien}</td>
					<td>${nn.soNgayDaNghi}</td>
					<td>${nn.soNgayConLai}</td>
					
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
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=1"
													aria-controls="DataTables_Table_5" class="page-link"><spring:message code="label.trangdau"/></a></li>

												<li class="paginate_button page-item previous"
													id="DataTables_Table_5_previous"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" tabindex="0"
													class="page-link"><spring:message code="label.trangtruoc"/></a></li>
											</c:if>

											<c:if test="${currentPage != 1}">
												<li class="paginate_button page-item"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
											</c:if>

											<li class="paginate_button page-item "><a
												href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${currentPage}"
												aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

											<c:if test="${currentPage != lastPage}">
												<li
													class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
												<li class="paginate_button page-item next"
													id="DataTables_Table_5_next"><a
													href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" data-dt-idx="8"
													tabindex="0" class="page-link"><spring:message code="label.trangtiep"/></a></li>
											</c:if>

											<li class="paginate_button page-item last"
												id="DataTables_Table_5_last"><a
												href="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/ngaynghiphep?page=${lastPage}"
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
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
