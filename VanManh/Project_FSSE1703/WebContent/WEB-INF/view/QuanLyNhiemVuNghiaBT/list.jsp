<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
				<h3 class="content-header-title mb-0"><spring:message code="label.danhsachnhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.danhsachnhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhiemVuNghiaBT/create"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span><spring:message code="label.themmoinhiemvu"/></a>
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
					<spring:message code="label.luuthanhcongnhiemvu"/>
				</div>
			</c:if>
			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title"><spring:message code="label.danhsachnhiemvu"/></h4>
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
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="datatable">
									<table
										class="table table-striped table-bordered dataex-res-constructor no-footer dataTable">
										<form:form method="GET">
											<div class="form-group col-sm-10">
												<div class="form-group col-sm-4">
													<label><spring:message code="label.duannhiemvu"/></label> <select
														class="custom-select block round" name="maDuAn"
														id="maDuAn">
														<option value="0" label="<spring:message code="label.tatcanhiemvu"/>" />
														<c:forEach items="${DuAn}" var="ld">
															<option value="${ld.maDuAn}" label="${ld.tenDuAn}" />
														</c:forEach>
													</select>
												</div>
												<div class="form-group col-sm-4">
													<label><spring:message code="label.nguoiduocphancong"/></label> <select
														class="custom-select block round" name="maNhanVien"
														id="maNhanVien">
														<option value="0" label="<spring:message code="label.tatcanhiemvu"/>" />
														<c:forEach items="${NhanVien}" var="ld">
															<option value="${ld.maNhanVien}"
																label="${ld.hoDem} ${ld.ten}" />
														</c:forEach>
													</select>
												</div>
												<div class="form-group col-sm-4">
													<label><spring:message code="label.trangthainhiemvu"/></label> <select
														class="custom-select block round" name="maTrangThai"
														id="maTrangThai">
														<option value="0" label="<spring:message code="label.tatcanhiemvu"/>" />
														<c:forEach items="${TrangThai}" var="ld">
															<option value="${ld.maTrangThai}" label="${ld.trangThai}" />
														</c:forEach>
													</select>
												</div>
											</div>
											<script type="text/javascript">
												maDuAn =
											<%=request.getParameter("maDuAn")%>
												;
												if (maDuAn != 0
														&& maDuAn != null) {
													$("#maDuAn").val(maDuAn);
												}
												maNhanVien =
											<%=request.getParameter("maNhanVien")%>
												;
												if (maNhanVien != 0
														&& maNhanVien != null) {
													$("#maNhanVien").val(
															maNhanVien);
												}
												maTrangThai =
											<%=request.getParameter("maTrangThai")%>
												;
												if (maTrangThai != 0
														&& maTrangThai != null) {
													$("#maTrangThai").val(
															maTrangThai);
												}
											</script>
											<div class="form-group col-sm-2">

												<button class="btn btn-success block round"
													style="margin-top: 25px">
													<i class="ft-search"></i><spring:message code="label.timkiemnhiemvu"/>
												</button>
											</div>
										</form:form>
										<thead>
											<tr>
												<th><spring:message code="label.duannhiemvu"/></th>
												<th><spring:message code="label.tencongviec"/></th>
												<th><spring:message code="label.loaicongviecnhiemvu"/></th>
												<th><spring:message code="label.nguoiduocphancong"/></th>
												<th><spring:message code="label.trangthainhiemvu"/></th>
												<th><spring:message code="label.tuychonnhiemvu"/></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="cv" items="${listNhiemVu}">
												<tr>
													<td>${cv.duAn.tenDuAn}</td>
													<td>${cv.tenCongViec}</td>
													<td>${cv.maCongViec.loaiCongViec}</td>
													<td>${cv.phanCong.hoDem}${cv.phanCong.ten}</td>
													<td>${cv.maTrangThai.trangThai}</td>
													<td style="letter-spacing: 5px"><a
														href="/ffse-fbms/QuanLyNhiemVuNghiaBT/view/${cv.ID}"><i
															class='fa fa-eye'></i></a> 
															
															<a
														href="/ffse-fbms/QuanLyNhiemVuNghiaBT/edit/${cv.ID}"><i
															class='fa fa-pencil'></i></a>
																<sec:authorize access="hasRole('ROLE_PGD') or hasRole('ROLE_PNSTPP') or hasRole('ROLE_PDATPP') or hasRole('ROLE_PDTTPP') or hasRole('ROLE_PITTPP') or hasRole('ROLE_PKTTPP')"> <a
														href="/ffse-fbms/QuanLyNhiemVuNghiaBT/delete/${cv.ID}"><i
															class='fa fa-trash'
															onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
															</sec:authorize>
													</td>
											</c:forEach>
										</tbody>
									</table>
									<c:set scope="request" var="lastPage" value="${lastPage}" />
									<%
										String query = "&maDuAn=" + request.getParameter("maDuAn") + "&maNhanVien="
												+ request.getParameter("maNhanVien") + "&maTrangThai=" + request.getParameter("maTrangThai");
										if (request.getParameter("maDuAn") == null) {
											query = "";
										}
									%>
								</div>
							</div>
						</div>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="?page=1<%=query%>"><spring:message code="label.trangtruocnhiemvu"/></a></li>
								<c:if test="${currentPage > 2}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage-2}<%=query%>">${currentPage-2}</a></li>
								</c:if>
								<c:if test="${currentPage > 1}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage-1}<%=query%>">${currentPage-1}</a></li>
								</c:if>
								<li class="page-item active"><a class="page-link"
									href="?page=${currentPage}<%=query%>">${currentPage}</a></li>
								<c:if test="${currentPage < lastPage}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage+1}<%=query%>">${currentPage+1}</a></li>
								</c:if>
								<c:if test="${currentPage < lastPage - 1}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage+2}<%=query%>">${currentPage+2}</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="?page=${lastPage }<%=query%>"><spring:message code="label.tragsaunhiemvu"/></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
