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
			<h3 class="content-header-title mb-0"><spring:message code="label.danhsachchoduyet"/></h3>
		</div>
	
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
			</div>
			<!-- End Show message -->
		
        <div class="container">
			<div class="col-md-4"></div>
			<div class="col-md-8">
			<div class="col-md-6">
			<form method="GET" action="">
						<div class="col-md-6">
							<div class="form-group">
								<spring:message code="label.maNhanVien" />
								<select name="manhanvien" class="form-control form-control-sm"
									id="manhanvien">
									<option value="0" selected="selected">--
										<spring:message code="label.tatCa" />--
									</option>
									<c:forEach items="${ngaynghi}" var="nn">
										<option value="${nn.maNhanVien}"
											<c:if test="${maNhaViens == nn.maNhanVien }"> selected="selected"</c:if>>${nn.maNhanVien}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-3">
							<label></label>
							<button type="submit" class="btn mr-1 mb-1 btn-success btn-sm">
								<i class="fa fa-search"></i>
								<spring:message code="label.tim" />
							</button>
						</div>
						<script type="text/javascript">
							NhanVien =
						<%=request.getParameter("manhanvien")%>
							;
							if (manhanvien != 0 && manhanvien != null) {
								$("#manhanvien").val(manhanvien);
							}
						</script>
					</form>
							</div>
						<div class="col-md-6">
						<form method="GET" action="">
							<div class="col-md-6">
							<div class="form-group">
								<spring:message code="label.phongBan"/><select name="maphongban"
									class="form-control form-control-sm" id="maphongban">
									<option value="0" selected="selected">--<spring:message code="label.tatCa" />--</option>
									<c:forEach items="${phongban}" var="pb">
										<option value="${pb.maPhongBan}"
										<c:if test="${maphongbans == pb.maPhongBan }"> selected="selected"</c:if>
										>${pb.maPhongBan}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-6" style="margin-top: 20px">
							<label></label>
							<button type="submit" class="btn mr-1 mb-1 btn-success btn-sm">
								<i class="fa fa-search"></i><spring:message code="label.tim"/>
							</button></div> 
						<script type="text/javascript">
							
							PhongBan = 
								<%=request.getParameter("maphongban")%>
							;
							if (maphongban != 0 && maphongban != null) {
								$("#maphongban").val(maphongban);
							}
							</script>
								</form>
								</div>
								</div>
			    <div class="table-responsive">
						<table class="table table-bordered"
						style="text-align: center; background: white">
							<thead style="background: #D3D3D3">
				<tr>
					<th ><spring:message code="label.madon"/></th>
					<th ><spring:message code="label.maNhanVien"/></th>
					<th ><spring:message code="label.hoTen"/></th>
					<th ><spring:message code="label.phongBan"/></th>
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
			<c:forEach var="nv" items="${danhsachcho}">
					<tr>
					<td>${nv.id -1}</td>
					<td>${nv.ngayNghi.maNhanVien}</td>
					<td>${nv.tenNhanVien}</td>
					<td>${nv.maPhongBan}</td>
					<td>${nv.ngayBatDau}</td>
					<td>${nv.ngayKetThuc}</td>
					<td>${nv.lyDo.lyDo}</td>
					<td>${nv.ghiChu}</td>
					<td>${nv.ghiChuTruongPhong}</td>
					<td>${nv.trangThai.trangThai}</td>
					<td><h2><a  href="viewChoDuyet/${nv.id }"><i class="icon-eye"></i></a></h2> 
						<h2><a  href="suachoduyet/${nv.id}"> <i class='fa fa-pencil'></i> </a></h2>
						
					</td>
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
													href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=1"
													aria-controls="DataTables_Table_5" class="page-link"><spring:message code="label.trangdau"/></a></li>

												<li class="paginate_button page-item previous"
													id="DataTables_Table_5_previous"><a
													href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" tabindex="0"
													class="page-link"><spring:message code="label.trangtruoc"/></a></li>
											</c:if>

											<c:if test="${currentPage != 1}">
												<li class="paginate_button page-item"><a
													href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${currentPage-1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage-1}</a></li>
											</c:if>

											<li class="paginate_button page-item "><a
												href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${currentPage}"
												aria-controls="DataTables_Table_5" class="page-link">${currentPage}</a></li>

											<c:if test="${currentPage != lastPage}">
												<li
													class="paginate_button page-item ${currentPage == lastPage ? 'd-none' : ''}"><a
													href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" class="page-link">${currentPage+1}</a></li>
												<li class="paginate_button page-item next"
													id="DataTables_Table_5_next"><a
													href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${currentPage+1}"
													aria-controls="DataTables_Table_5" data-dt-idx="8"
													tabindex="0" class="page-link"><spring:message code="label.trangtiep"/></a></li>
											</c:if>

											<li class="paginate_button page-item last"
												id="DataTables_Table_5_last"><a
												href="<%=request.getContextPath()%>/Quanlyvangnghi1703004/danhsachcho?page=${lastPage}"
												aria-controls="DataTables_Table_5" data-dt-idx="9"
												tabindex="0" class="page-link"><spring:message code="label.trangcuoi"/></a></li>
										</ul>
									</div>
								</div>
		</div>
		</div>
		</div>
		</div>
	

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
