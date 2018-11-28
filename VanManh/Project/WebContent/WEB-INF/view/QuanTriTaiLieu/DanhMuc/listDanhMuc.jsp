<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-9 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0"><spring:message code="label.listDanhMuc" /></h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'><spring:message code="label.Home" /></a></li>
								<li class="breadcrumb-item active"><spring:message code="label.listDanhMuc" /></li>
							</ol>
						</div>
					</div>
				</div>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right" id="add-new">
						<a class="btn btn-primary"
							href='<c:url value = "/QuanTriTaiLieu/DanhMuc/add" />'><span
							data-i18n="" class="ft-plus-square"><spring:message code="label.addNew" /></span></a>
					</div>
				</div>
			</div>
			<!-- End Path -->
			<div class="content-body">
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
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title"><spring:message code="label.listDanhMuc" /></h4>
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
									<div class="table-responsive">
										<table id="datatable"
											class="table table-striped table-bordered dataex-res-constructor">
											<thead>
												<tr>
													<th><spring:message code="label.maDanhMuc" /></th>
													<th><spring:message code="label.tenDanhMuc" /></th>
													<th><spring:message code="label.chucNang" /></th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${not empty list}">
													<c:forEach var="sv" items="${list}">
														<tr>
															<td>${sv.ma_danh_muc}</td>
															<td>${sv.ten_danh_muc}</td>
															<td><a
																href="/ffse-fbms/QuanTriTaiLieu/DanhMuc/edit/${sv.id}"
																data-toggle="tooltip" title="edit">
																	<button type="button"
																		class="btn btn-icon btn-outline-warning">
																		<i class="fa fa-pencil"></i>
																	</button>
															</a> <a
																href="/ffse-fbms/QuanTriTaiLieu/DanhMuc/delete/${sv.id}">
																	<button type="button"
																		onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
																		class="btn btn-outline-danger btn-icon checkid"
																		data-toggle="modal" title="delete"
																		data-target="#danger">
																		<i class="fa fa-trash-o"></i>
																	</button>
															</a></td>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>
										</table>

										<nav aria-label="Page navigation example">
										<ul class="pagination">
											<li class="page-item"><a class="page-link"
												href="?page=1"><spring:message code="label.firtVendor" /></a></li>
											<c:if test="${currentPage > 2}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage-2}">${currentPage-2}</a></li>
											</c:if>
											<c:if test="${currentPage > 1}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage-1}">${currentPage-1}</a></li>
											</c:if>
											<li class="page-item active"><a class="page-link"
												href="?page=${currentPage}">${currentPage}</a></li>
											<c:if test="${currentPage < lastPage}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage+1}">${currentPage+1}</a></li>
											</c:if>
											<c:if test="${currentPage < lastPage - 1}">
												<li class="page-item"><a class="page-link"
													href="?page=${currentPage+2}">${currentPage+2}</a></li>
											</c:if>
											<li class="page-item"><a class="page-link"
												href="?page=${lastPage }"><spring:message code="label.lastVendor" /></a></li>
										</ul>
										</nav>

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
</body>
</html>