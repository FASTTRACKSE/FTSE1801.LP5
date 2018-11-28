<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page session="false"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong><spring:message code="label.titleVendor" /></strong>
				</h1>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th><spring:message code="label.maVendor" /></th>
						<th><spring:message code="label.tenVendor" /></th>
						<th><spring:message code="label.dcVendor" /></th>
						<th><spring:message code="label.emailVendor" /></th>
						<th><spring:message code="label.sdtVendor" /></th>
						<th><spring:message code="label.AcVendor" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vd" items="${list}">
						<tr>
							<td>${vd.mavd}</td>
							<td>${vd.tenvd}</td>
							<td>${vd.diachi}</td>
							<td>${vd.email}</td>
							<td>${vd.sdt}</td>
							<td><a href="/ffse-fbms/QuanLyDuAn/vendor/edit/${vd.mavd}"
								data-toggle="tooltip" title="edit">
									<button type="button" class="btn btn-icon btn-outline-warning">
										<i class="fa fa-pencil"></i>
									</button>
							</a> <a href="/ffse-fbms/QuanLyDuAn/vendor/delete/${vd.mavd}">
									<button type="button"
										onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
										class="btn btn-outline-danger btn-icon checkid"
										data-toggle="modal" title="delete" data-target="#danger">
										<i class="fa fa-trash-o"></i>
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="?page=1"><spring:message code="label.firtVendor" /></a></li>
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

			<div class="row"></div>
		</div>
		<div class="col-sm-4">
			<h5>
				<a href="/ffse-fbms/QuanLyDuAn/vendor/add"><strong><spring:message code="label.addVendor" /></strong></a>
			</h5>
			<c:if test="${message !=null }">
						 ${message }
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />